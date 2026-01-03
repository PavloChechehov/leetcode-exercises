package com.paul.google.week2;

/**
 * <a href="https://leetcode.com/problems/search-insert-position/description/">35. Search Insert Position</a>
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 9;
        int res = searchInsert(nums, target);
        System.out.println(res);
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums[nums.length - 1] < target ) {
            return nums.length;
        }


        int res = -1;

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid - 1;
            }

        }



        return res;
    }
}
