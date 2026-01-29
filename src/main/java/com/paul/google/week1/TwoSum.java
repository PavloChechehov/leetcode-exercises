package com.paul.google.week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 <a href="https://leetcode.com/problems/two-sum/description/">Leetcode 1: Two Sum</a>
 */

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {11, 2, 15, 1, 5, 4, 2, 7};
        int target = 9;

        int[] res = twoSum(nums, target);

        System.out.println(Arrays.toString(res));
    }

    public static int[] twoSum(int[] nums, int target) {

        //11, 2, 7, 15 is O(n * log(n))
        // 2, 7, 11, 15
        // target is  9
        // n * n = n ^ 2
        // for outer
        //      for inner

        //target - n == ? check if this element is already in the map if not put the n to the map
        // O(n)


        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int elem = target - nums[i];

            if (map.containsKey(elem)) {
                return new int[]{map.get(elem), i};
            } else {
                map.put(nums[i], i);
            }

        }

        return null;
    }
}
