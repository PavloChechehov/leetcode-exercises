package com.paul.blind75;

import com.paul.google.week1.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/insertion-sort-list/description/">147. Insertion Sort List</a>
 */
public class InsertionSortList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
        public ListNode insertionSortList(ListNode head) {
            List<Integer> list = new ArrayList<>();


            while (head != null) {
                list.add(head.val);
                head = head.next;
            }


            for(int i = 1; i < list.size(); i++) {
                int curr = list.get(i);

                int k = i;

                while (k > 0) {
                    if (list.get(k) < list.get(k - 1)) {

                        int temp = list.get(k);
                        list.set(k, list.get(k - 1));
                        list.set(k - 1, temp);
                        k--;
                    } else {
                        break;
                    }
                }
            }

            ListNode res = new ListNode();
            ListNode dummy = res;
            for(int elem: list){
                res.next = new ListNode(elem);
                res = res.next;
            }


            return dummy.next;
        }
}
