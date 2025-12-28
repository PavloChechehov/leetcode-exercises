package com.paul.google.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/subarray-sum-equals-k/description/">LeetCode 560: Subarray Sum Equals K</a>
 */
public class SubArraySum {
    public static void main(String[] args) {

//        int[] nums = {1, 1, 1};
        int[] nums = {1, 2, 3};
        int k = 2;

        int res = subarraySum(nums, k);
        System.out.println(res);

    }

    //approach 3: optimal O(n)
    public static int subarraySum(int[] nums, int k) {
        int[] prefixSums = new int[nums.length + 1];

        for (int i = 1; i < prefixSums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }

        int res = 0;

        Map<Integer, Integer> prefixCount = new HashMap<>();
        // Base case
        prefixCount.put(0, 1);

        for (int prefixSum : prefixSums) {
            res += prefixCount.getOrDefault(prefixSum - k, 0);

            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }

        return res;
    }


    //approach 2: correct, but brute force O(n^2)
/*
    public static int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int res = 0;

        for (int i = 0; i < prefixSum.length - 1; i++) {
            for (int j = i + 1; j < prefixSum.length; j++) {
                if (prefixSum[j] - prefixSum[i] == k) {
                    res++;
                }
            }
        }

        return res;
    }
*/




    //approach 1: incorrect logic
/*
    public static int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int res = 0;

        int l = 0;
        int r = 0;


        while (l <= r && r < prefixSum.length) {


            int target = prefixSum[r] - prefixSum[l];


            if (target == k) {
                res++;
                r++;
                l++;
            } else if (target > k) {
                l++;
            } else {
                r++;
            }

        }

        return res;
    }
*/
}
