package com.paul.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-absolute-difference/description/">1200. Minimum Absolute Difference</a>
 */
public class MinimumAbsoluteDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        //find min dist O(n)
        //sort the arr O(n * log(n))

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        int n = arr.length;

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 1; i < n; i++) {
            int maybeMin = arr[i] - arr[i - 1];
            if (maybeMin < min) {
                res = new ArrayList<>();
                min = maybeMin;
            }

            if (maybeMin == min) {
                res.add(List.of(arr[i - 1], arr[i]));
            }

            // min = Math.min(arr[i] - arr[i - 1], min);
        }

        // for(int i = 1; i < n; i++) {
        //     if (arr[i] - arr[i - 1] == min) {
        //         res.add(List.of(arr[i - 1], arr[i]));
        //     }
        // }

        return res;
    }
}
