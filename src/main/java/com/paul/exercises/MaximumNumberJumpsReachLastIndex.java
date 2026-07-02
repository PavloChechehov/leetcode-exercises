package com.paul.exercises;

import java.util.Arrays;

public class MaximumNumberJumpsReachLastIndex {
    public static void main(String[] args) {
//        int[] nums = {1, 3, 6, 4, 1, 2};
        int[] nums = {0, 2, 1, 3};
        int target = 1;
        int res = maximumJumps(nums, target);
        System.out.println(res);
    }

    public static int maximumJumps(int[] nums, int target) {
        //1,3,6,4,1,2
        //target 2
        //- 2 <=  1 - 3  <= 2
        //- 2 <=  3 - 4  <= 2
        //- 2 <=  4 - 2  <= 2
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int negTarget = -1 * target;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                int curr = nums[i] - nums[j];

                if (negTarget <= curr && curr <= target) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    max = Math.max(max, dp[j]);
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[0] == 0 || dp[n - 1] == 0 ? -1 : max;
    }
}
