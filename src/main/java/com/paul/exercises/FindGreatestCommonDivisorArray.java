package com.paul.exercises;


import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/find-greatest-common-divisor-of-array/description/?envType=daily-question&envId=2026-07-21">1979. Find Greatest Common Divisor of Array</a>
 */

public class FindGreatestCommonDivisorArray {

    public static void main(String[] args) {
        int[] nums = {6, 8, 14, 24};
        int res = findGCD(nums);// 6
        System.out.println(res);
    }

    public static int findGCD(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int small = nums[0];
        int great = nums[n - 1];
        int k = great;

        for (; k >= small; k--) {
            if (small % k == 0 && great % k == 0) return k;
        }

        return k;
    }
}
