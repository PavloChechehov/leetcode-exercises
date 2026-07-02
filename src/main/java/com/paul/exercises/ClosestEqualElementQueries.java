package com.paul.exercises;

import java.util.ArrayList;
import java.util.List;

public class ClosestEqualElementQueries {

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 4, 1, 3, 2};
        int[] queries = {0, 3, 5};
        List<Integer> res = solveQueries(nums, queries);
        System.out.println(res);
    }

    public static List<Integer> solveQueries(int[] nums, int[] queries) {

        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {

            int index = queries[i];
            int v1 = nums[index];

            int min = Integer.MAX_VALUE;

            for (int k = index; k < n + index; k++) {
                int j = k % n;

                int v2 = nums[j];

                if (v1 == v2 && index != j) {
                    int diff = Math.abs(index - j);
                    int dist = Math.min(diff, n - diff);
                    min = Math.min(min, dist);
                }
            }

            if (min == Integer.MAX_VALUE) {
                list.add(-1);
            } else {
                list.add(min);
            }

        }

        return list;
    }


}
