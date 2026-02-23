package com.paul.blind75;


/**
 * <a href="https://leetcode.com/problems/find-pivot-index/description/">724. Find Pivot Index</a>
 *
 */
public class PivotIndex {

    public static void main(String[] args) {
//        int[] nums = {1, 7, 3, 6, 5, 6};
        int[] nums = {1,2,3};
        int res = pivotIndex(nums);
        System.out.println(res);
    }

    public static int pivotIndex(int[] nums) {
        int n = nums.length;

        int[] leftSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            leftSum[i] = nums[i - 1] + leftSum[i - 1];
        }

        int sum = 0;
        int res = -1;

        for (int i = n - 1; i >= 0; i--) {

            if (leftSum[i] == sum) {
                res = i;
            }

            sum += nums[i];

        }

        return res;
    }
}
