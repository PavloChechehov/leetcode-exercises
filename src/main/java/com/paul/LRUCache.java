package com.paul;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation <a href="https://leetcode.com/problems/lru-cache/description/">Leetcode LRU cache problem</a>
 */
class LRUCache {

    class Node {
        int value;
        int key;
        Node next;
        Node prev;
    }

    int capacity;
    Node sentinel = new Node();
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.sentinel.prev = sentinel;
        this.sentinel.next = sentinel;
    }

    public int get(int key) {
        Node n = map.get(key);
        int res = -1;
        if (n != null) {
            res = n.value;
            remove(n);
            add(n);
        }

        return res;
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if (n != null) {
            remove(n);
            add(n);
            n.value = value;
            return;
        }

        if(map.size() == capacity) {
            map.remove(sentinel.prev.key);
            remove(sentinel.prev);
        }


        n = new Node();
        n.key = key;
        n.value = value;
        map.put(key, n);
        add(n);
    }

    public void add(Node n) {
        Node head = sentinel.next;
        sentinel.next = n;
        n.prev = sentinel;
        head.prev = n;
        n.next = head;
    }

    public void remove(Node n) {
        Node next = n.next;
        Node prev = n.prev;
        prev.next = next;
        next.prev = prev;

    }
}
