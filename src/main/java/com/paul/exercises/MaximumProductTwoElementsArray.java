package com.paul.exercises;

/**
 * <a href="https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/?envType=daily-question&envId=2026-07-27">1464. Maximum Product of Two Elements in an Array</a>
 */
public class MaximumProductTwoElementsArray {


    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 5};
        int res = maxProduct(nums);
        System.out.println(res);
    }


    public static int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;

        for(int n: nums) {
            if (n > max1) {
                max2 = max1;
                max1 = n;
            } else if(n > max2) {
                max2 = n;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}
