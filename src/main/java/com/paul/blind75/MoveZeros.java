package com.paul.blind75;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/description/">283. Move Zeroes</a>
 */
public class MoveZeros {


    public static void main(String[] args) {
//        int[] nums = {1,0};
//        int[] nums = {0,1,0,3,12};
        int[] nums = {1, 3, 0, 0, 0, 0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {

        //  Input: nums = [0,1,0,3,12]
        // Output: [1,3,12,0,0]

        //2 pointers
        int l = 0;

        int n = nums.length;
        if (n == 1) return;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != 0) {
                if (l != r) {
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                }
                l++;
            }
        }


        // return nums;
    }
}
