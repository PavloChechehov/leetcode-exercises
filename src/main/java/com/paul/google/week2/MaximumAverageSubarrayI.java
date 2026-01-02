package com.paul.google.week2;


/**
 *
 * <a href="https://leetcode.com/problems/maximum-average-subarray-i/description/">643. Maximum Average Subarray I</a>
 */
public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double res = findMaxAverage(nums, k);
        //res should be 12.75000
        System.out.println(res);
    }



    public static double findMaxAverage(int[] nums, int k) {

        int length = nums.length;
        int sum = 0;
        double max = Integer.MIN_VALUE;

        //1, 12, -5, -6, 50, 3
        for (int i = 0; i < length; i++) {
            sum += nums[i];

            if (i + 1 >= k) {
                max = Math.max(max, (double) sum / k);
                sum -= nums[i + 1 - k];
            }
        }

        return max;
    }
}
