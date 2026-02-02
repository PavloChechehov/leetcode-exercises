package com.paul.google.week4;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/copy-list-with-random-pointer">138. Copy List with Random Pointer</a>
 */
public class CopyListWithRandomPointer {
    public static void main(String[] args) {

    }

    //approach 1
    /*public Node copyRandomList(Node head) {

        Node dummy = head;
        Map<Node, Node> copyNodes = new HashMap<>();

        while (head != null) {
            Node next = new Node(head.val);
            next.next = head.next;
            next.random = head.random;
            copyNodes.put(head, next);

            head = head.next;
        }

        for (Map.Entry<Node, Node> e : copyNodes.entrySet()) {

            Node val = e.getValue();

            Node next = copyNodes.get(val.next);
            Node random = copyNodes.get(val.random);

            val.next = next;
            val.random = random;
        }

        return copyNodes.get(dummy);

    }*/

    //approach2: a little bit elegant with gemini helps
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> copyNodes = new HashMap<>();

        Node dummy = head;

        while(dummy != null) {
            copyNodes.put(dummy, new Node(dummy.val));
            dummy = dummy.next;
        }

        dummy = head;
        while(dummy != null) {
            Node node = copyNodes.get(dummy);

            node.next = copyNodes.get(dummy.next);
            node.random = copyNodes.get(dummy.random);
            dummy = dummy.next;
        }

        return copyNodes.get(head);

    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
