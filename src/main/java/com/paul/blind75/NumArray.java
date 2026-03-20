package com.paul.blind75;

/**
 * <a href="https://leetcode.com/problems/range-sum-query-immutable/description/">303. Range Sum Query - Immutable</a>
 *
 */
public class NumArray {


    private final int[] nums;
    private final int[] prefixSums;

    public NumArray(int[] nums) {
        this.nums = nums;
        prefixSums = new int[nums.length + 1];

        for(int i = 1; i < prefixSums.length; i++) {

            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSums[right + 1] - prefixSums[left];
    }
}
