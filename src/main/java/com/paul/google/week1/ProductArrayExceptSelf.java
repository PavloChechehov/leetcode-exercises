package com.paul.google.week1;

import java.util.Arrays;

/**
 * <a href="http://leetcode.com/problems/product-of-array-except-self/description/">238. Product of Array Except Self</a>
 */

public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }


    //answer[i] = product of nums[0 … i-1] * product of nums[i+1 … n-1]
    public static int[] productExceptSelf(int[] nums) {

        int length = nums.length;
        int[] answer = new int[length];

        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;

        for (int i = length - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }
}
