package com.paul.google.week1;


/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/description/">206. Reverse Linked List</a>
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode reversedList = reverseList(head);
        System.out.println(reversedList);
    }

    public static ListNode reverseList(ListNode head) {
        // head -> next1 -> next2
        //  1 -> 2 -> 3
        // <- 1 <- 2 <- 3

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            //this is another curr, now it is ListNode next;
            curr = next;

        }

        return prev;

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
