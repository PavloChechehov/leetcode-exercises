package com.paul.google.week1;

public class LinkedListCycle {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        // 1 -> 2 -> 3 -> 4
        // 1    2
        //      2    3    4
        // 1    2

        if (head == null) {
            return false;
        }

        //this is the slower jumper
        ListNode slow = head;
        //this is a faster jumper
        ListNode fast = head.next;

        while (true) {

            //find cycle
            if (slow == fast) {
                return true;
            }

            slow = slow.next;

            if (fast != null && fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;

            }
        }
    }

}
