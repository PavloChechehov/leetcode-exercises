package com.paul.google.week3;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/description/">300. Longest Increasing Subsequence</a>
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }


    public static int lengthOfLIS(int[] nums) {
        //10,9,2,5,3,7,101,18
        // 1,1,1,2,2,3,4,2

        int n = nums.length;

        // dp[i] stores the length of the longest increasing subsequence ending at index i
        int[] dp = new int[n];

        // Initialize all positions with 1 (each element is a subsequence of length 1)
        Arrays.fill(dp, 1);

        // Track the maximum length found so far
        int maxLength = 1;

        for(int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
