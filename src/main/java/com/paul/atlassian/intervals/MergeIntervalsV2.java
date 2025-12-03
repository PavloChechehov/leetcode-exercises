package com.paul.atlassian.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervalsV2 {
    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);

        for (int[] interval : intervals) {

            if (interval[0] <= current[1]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                current = interval;
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
//        List<int[]> intervals = List.of(new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18});
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = mergeIntervals(intervals);
        List<String> result = Arrays.stream(res)
                .map(interval -> Arrays.stream(interval)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining("->"))
                )
                .toList();


        System.out.println(result);
    }
}
