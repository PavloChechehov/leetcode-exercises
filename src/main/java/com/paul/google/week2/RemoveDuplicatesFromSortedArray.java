package com.paul.google.week2;

import com.paul.google.week1.ListNode;


/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/">83. Remove Duplicates from Sorted List</a>
 */
public class RemoveDuplicatesFromSortedArray {

    public ListNode deleteDuplicates(ListNode head) {
        //1 -> 1 -> 2
        //1

        // 1 -> 1 -> 1 -> 2

        if (head == null) return null;

        ListNode curr = head;
        ListNode dummy = new ListNode(0, curr);

        while (curr != null) {

            ListNode temp = curr.next;
            while (temp != null && temp.val == curr.val) {
                temp = temp.next;
            }

            curr.next = temp;
            curr = curr.next;
        }


        return dummy.next;
    }
}

