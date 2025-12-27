package com.paul.google.week1;


/**
 * <a href="https://leetcode.com/problems/binary-search/">LeetCode 704: Binary Search</a>
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 5, 5, 5, 9, 12};
        int target = 5;


        int res = search(nums, target);
        System.out.println(res);
    }


    public static int search(int[] nums, int target) {
        //-1, 0, 3, 5, 9, 12
        int res = -1;

        int l = 0;
        int r = nums.length - 1;


        while (l <= r) {

            int mid = l + (r - l) / 2; // (l + r) / 2

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }
}
