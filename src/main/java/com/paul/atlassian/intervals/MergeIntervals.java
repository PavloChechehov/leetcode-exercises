package com.paul.atlassian.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeIntervals {
    public static void main(String[] args) {

        System.out.println("Hello world");
//        intervals = [[1,3],[2,6],[8,10],[15,18]]
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        MergeIntervals mi = new MergeIntervals();
        int[][] res = mi.merge(intervals);

        System.out.println();
    }

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) return new int[0][];

        List<Interval> list = new ArrayList<>();

        for (int[] interval : intervals) {
            list.add(new Interval(interval[0], +1));
            list.add(new Interval(interval[1], -1));
        }

        list.sort((a,b) -> {
            if (a.pos != b.pos) return Integer.compare(a.pos, b.pos);
            return Integer.compare(b.startExit, a.startExit);
        });

        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Interval curr : list) {
            min = Math.min(min, curr.pos);
            counter += curr.startExit();

            if (counter == 0) {
                max = Math.max(max, curr.pos());
                map.put(min, max);
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
            } else {
                max = Math.max(max, curr.pos());
            }


        }


        int[][] arr = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())           // ensure correct interval order
                .map(e -> new int[]{e.getKey(), e.getValue()})
                .peek(a -> System.out.println(Arrays.toString(a)))
                .toArray(int[][]::new);

        return arr;
    }

    record Interval(int pos, int startExit) {

    }
}
