package com.paul.contest53;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/description/">1878. Get Biggest Three Rhombus Sums in a Grid</a>
 */
public class GetBiggestThreeRhombusSumsGrid {



    public static void main(String[] args) {
        GetBiggestThreeRhombusSumsGrid problem = new GetBiggestThreeRhombusSumsGrid();
//        int[][] grid = {{3, 4, 5, 1, 3},
//                {3, 3, 4, 2, 3},
//                {20, 30, 200, 40, 10},
//                {1, 5, 5, 4, 1},
//                {4, 3, 2, 2, 5}};

        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] res = problem.getBiggestThree(grid);
        System.out.println(Arrays.toString(res));
    }

    private final int[][] directions = { { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 } };
    private final TreeSet<Integer> queue = new TreeSet<>(Comparator.reverseOrder());
    private int n;
    private int m;
    private int[][] matrix;

    public int[] getBiggestThree(int[][] grid) {

        n = grid.length;
        m = grid[0].length;

        matrix = grid;
        int maxLen = (Math.min(n, m) + 1) / 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                queue.add(grid[i][j]);
                for (int k = 1; k <= maxLen; k++) {
                    buildRhombus(i, j, k);
                }
            }
        }

        int len = Math.min(3, queue.size());
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = queue.pollFirst();
        }

        return res;
    }

    private void buildRhombus(int i, int j, int max) {
        int sum = 0;

        for (int[] dir : directions) {

            for (int k = 0; k < max; k++) {
                int newI = i + dir[0];
                int newJ = j + dir[1];

                if (newI < 0 || newJ < 0 || newI >= n || newJ >= m)
                    return;

                sum += matrix[newI][newJ];

                i = newI;
                j = newJ;
            }
        }

        queue.add(sum);
    }
}
