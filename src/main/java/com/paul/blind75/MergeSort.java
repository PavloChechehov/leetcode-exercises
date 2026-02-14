package com.paul.blind75;

/**
 * <a href="https://leetcode.com/problems/sort-an-array/description/">912. Sort an Array</a>
 * I use the MergeSort implementation
 */
public class MergeSort {

    public int[] sortArray(int[] nums) {
        if (nums.length == 1) return nums;

        int n = nums.length;

        int mid = n / 2;

        int[] left = new int[mid];
        System.arraycopy(nums, 0, left, 0, mid);

        int[] right = new int[n - mid];
        System.arraycopy(nums, mid, right, 0, n - mid);

        int[] resLeft = sortArray(left);
        int[] resRight = sortArray(right);

        int l = 0;
        int r = 0;

        int[] res = new int[n];
        int i = 0;

        while (l < resLeft.length && r < resRight.length) {
            if (resLeft[l] < resRight[r]) {
                res[i] = resLeft[l++];
            } else {
                res[i] = resRight[r++];
            }
            i++;
        }

        while (l < resLeft.length) {
            res[i++] = resLeft[l++];
        }

        while (r < resRight.length) {
            res[i++] = resRight[r++];
        }

        return res;
    }
}
