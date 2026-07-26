package com.paul.exercises;


/**
 * <a href="https://leetcode.com/problems/maximum-product-of-three-numbers/description/?envType=daily-question&envId=2026-07-26">628. Maximum Product of Three Numbers</a>
 */
public class MaximumProductThreeNumbers {


    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for(int n: nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if(n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
        }

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;

        for(int n: nums) {
            if (min1 > n) {
                min3 = min2;
                min2 = min1;
                min1 = n;
            } else if(min2 > n) {
                min3 = min2;
                min2 = n;
            } else if (min3 > n) {
                min3 = n;
            }
        }

        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
