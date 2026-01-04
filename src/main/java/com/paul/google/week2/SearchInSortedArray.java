package com.paul.google.week2;


/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/description/">33. Search in Rotated Sorted Array</a>
 */
public class SearchInSortedArray {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int res = search(arr, target);
        System.out.println(res);

    }

    public static int search(int[] nums, int target) {
        // 0
        // 3, 4, 5, 6, 7, 0, 1, 2
        // nums[mid] <= nums[nums.length - 1]

        // 2
        // 1, 2, 3, 4, 5
        int l = 0;
        int r = nums.length - 1;
        int res = -1;

        while(l <= r) {

            int mid = l + (r - l)/2;

            if(nums[mid] == target) return mid;



            if(nums[mid] >= nums[l]) {
                // 6 < 0 && 1 <= 2
                if(target < nums[mid] && nums[l] <= target) {
                    r = mid - 1;
                    // 4 < 2 && 1 <= 2
                    // if (nums[mid] > target && nums[l] > target)
                } else {
                    l = mid + 1;
                }

            } else {
                // mid (4 < 5 < 6
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }

            }


        }


        return res;
    }
}
