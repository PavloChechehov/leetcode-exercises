package com.paul.google.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/3sum/description/">LeetCode 15: 3Sum</a>
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return List.of();
        }

        int target = 0;

        //-1, 0, 1, 2, -1, -4
        //1. sort
        Arrays.sort(nums);

        //2.

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int r = nums.length - 1;
            int l = i + 1;

            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];

                if (sum == target) {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    r--;

                    while (nums[l] == nums[l - 1] && l < r) l++;
                    while (nums[r] == nums[r + 1] && l < r) r--;


                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }


            }
        }
        return res;
    }
}
