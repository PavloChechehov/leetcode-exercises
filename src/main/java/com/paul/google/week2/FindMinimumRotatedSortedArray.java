package com.paul.google.week2;

import java.util.List;


/**
 * Similar leetcode problem:
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">153. Find Minimum in Rotated Sorted Array</a>
 */
public class FindMinimumRotatedSortedArray {


    public static void main(String[] args) {
        List<Integer> arr = List.of(20, 30, 40, 50, 10);

        int res = findMinRotated(arr);
        System.out.println(res);

    }


    public static int findMinRotated(List<Integer> arr) {

        int l = 0;
        int size = arr.size();
        int r = size - 1;
        int res = -1;

        //30, 40, 50, 10, 20
        while (l <= r && r < size) {

            int mid = l + (r - l) / 2;

            if (arr.get(mid) <= arr.getLast()) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }


        }

        return res;
    }
}
