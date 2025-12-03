package com.paul.atlassian.lru;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ConcurrentLRUCache {

    // two direction linked list
    private class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // key - int, value - node?
    private Node sentinel = new Node();
    private Map<Integer, Node> map;
    private int capacity;

    public ConcurrentLRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.sentinel.prev = sentinel;
        this.sentinel.next = sentinel;
    }

    //O(1)
    public int get(int key) {
        lock.lock();
        try {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }

            delete(node);
            add(node);

            return node.value;

        } finally {
            lock.unlock();
        }

    }

    public Integer peekLeastRecentlyUsed() {
        // your implementation

        if (!map.isEmpty()) {
            return sentinel.prev.value;
        }

        throw new NoSuchElementException("LRUCache is empty");
    }


    //O(1)
    public void put(int key, int value) {
        lock.lock();
        try {
            Node node = map.get(key);
            if (node != null) {
                delete(node);
                add(node);
                node.value = value;
                return;
            }

            if (map.size() == capacity) {
                map.remove(sentinel.prev.key);
                delete(sentinel.prev);
            }

            node = new Node(key, value);
            map.put(key, node);
            add(node);
        } finally {
            lock.unlock();
        }
    }

    private void add(Node node) {

        // sentinel -> newNode ->  prev.head.next ->  next
        Node head = sentinel.next;

        sentinel.next = node;
        node.prev = sentinel;

        head.prev = node;
        node.next = head;
    }

    private void delete(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }


    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ConcurrentLRUCache lruCache = new ConcurrentLRUCache(3);

//        lruCache.put(1, 2);
//        lruCache.put(2, 3);
//        lruCache.put(1, 5);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(2));

        System.out.println(lruCache.peekLeastRecentlyUsed());
    }

}
