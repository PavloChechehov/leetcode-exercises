package com.paul.google.week3;

/**
 * <a href="https://leetcode.com/problems/house-robber/description/">198. House Robber</a>
 */
public class HouseRobber {

    public int rob(int[] nums) {
        //
        // nums[1,2,3,1]
        // 1,2,3+1,2+1


        //2,7,9,3,1
        //2,7,9+2,3+7,9+2+1


        // 2,5,1,3,6,7,4
        // 2,5,1+2,3+5,6+5
        int len = nums.length;
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[len];

        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];

        for(int i = 3; i < len; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];

        }

        int max = Math.max(dp[len - 1], dp[len - 2]);
        return max;
    }
}
