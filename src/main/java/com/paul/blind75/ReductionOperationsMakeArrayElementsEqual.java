package com.paul.blind75;


import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/description/">1887. Reduction Operations to Make the Array Elements Equal</a>
 */
public class ReductionOperationsMakeArrayElementsEqual {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};
        int res = reductionOperations(nums);
        System.out.println(res == 4);

    }

    public static int reductionOperations(int[] nums) {
        //1,1,2,2,3
        //1,1,2,2,2
        //1,1,1,2,2
        //1,1,1,1,2
        //1,1,1,1,1

        Arrays.sort(nums);

        int n = nums.length;
        int count = 0;
        for (int i = n - 1; i > 0; i--) {

            if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                // Arrays.fill(nums, i, n, nums[i - 1]);
                count += n - i;
            }
        }

        return count;
    }
}
