package com.paul.exercises;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/remove-covered-intervals/description/?envType=daily-question&envId=2026-07-06">1288. Remove Covered Intervals</a>
 */
public class RemoveCoveredIntervals {

    public static void main(String[] args) {

//        int[][] arr = {{1, 4}, {3, 6}, {2, 8}};
//        int[][] arr = {{34335, 39239}, {15875, 91969}, {29673, 66453}, {53548, 69161}, {40618, 93111}};
        int[][] arr = {{1,10}, {2,9}, {3,8}};

        int res = removeCoveredIntervals(arr);
        System.out.println(res);

    }


    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> {
            if (a1[0] != a2[0]) {
                return Integer.compare(a1[0], a2[0]);
            }
            return Integer.compare(a2[1], a1[1]);
        });

        int n = intervals.length;

        int res = n;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int[] curr = intervals[i];
            if (curr[1] > max) {
                for (int j = i + 1; j < n; j++) {
                    int[] next = intervals[j];
                    if (curr[0] <= next[0] && curr[1] >= next[1]) {
                        res--;
                    }
                }

                max = curr[1];
            }
        }

        return res;
    }
}
