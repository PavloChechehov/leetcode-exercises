package com.paul.exercises;

import java.util.Arrays;

public class XORMultiplicationQueries {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1};
        int[] nums = {780};
//        int[][] queries = {{0, 2, 1, 4}};
        int[][] queries = {
                {0, 0, 1, 13},
                {0, 0, 1, 17},
                {0, 0, 1, 9},
                {0, 0, 1, 18},
                {0, 0, 1, 16},
                {0, 0, 1, 6},
                {0, 0, 1, 4},
                {0, 0, 1, 11},
                {0, 0, 1, 7},
                {0, 0, 1, 18},
                {0, 0, 1, 8},
                {0, 0, 1, 15},
                {0, 0, 1, 12}};

        int res = xorAfterQueries(nums, queries);
        System.out.println(res);
    }

//        0, [10140]
//        1, [172380]
//        2, [1551420]
//        3, [27925560]
//        4, [446808960]
//        5, [-614113529]
//        6, [838513173]
//        7, [633710311]
//        8, [141004881]
//        9, [-756879431]
//        10, [-760068145]
//        11, [483879706]
//        12, [511589169]

    public static int xorAfterQueries(int[] nums, int[][] queries) {

        int mod = 1_000_000_007;

        for(int[] q: queries) {

            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            for (int i = l; i <= r; i = i + k) {

//                for(int idx = 0; idx < nums.length; idx++ ) {
                    nums[i] = (nums[i] * v) % mod;
//                }
            }

        }

        System.out.println(Arrays.toString(nums));

        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            res = (res ^ nums[i]);
        }

        return res;
    }
}
