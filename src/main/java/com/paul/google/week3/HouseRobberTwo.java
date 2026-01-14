package com.paul.google.week3;


/**
 * <a href="https://leetcode.com/problems/house-robber-ii/description/">213. House Robber II</a>
 */
public class HouseRobberTwo {


    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(robHelper(nums, 0, n - 2), robHelper(nums, 1, n - 1));
    }

    private int robHelper(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0;

        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
