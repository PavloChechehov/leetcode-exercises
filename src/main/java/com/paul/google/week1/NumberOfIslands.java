package com.paul.google.week1;


/**
 * <a href="https://leetcode.com/problems/number-of-islands/description/">LeetCode 200. Number of Islands</a>
 */
public class NumberOfIslands {

    private static final char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
    };

    public static void main(String[] args) {


        int res = numIslands();
        System.out.println(res);
    }


    public static int numIslands() {

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    res++;
                    grid[i][j] = '0';   // mark starting cell
                    dfsHelper(i, j);
                }
            }

        }
        return res;
    }

    private static void dfsHelper(int i, int j) {
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        for (int[] direction : directions) {

            int newPosI = i + direction[0];
            int newPosJ = j + direction[1];

            if (newPosI >= 0 && newPosJ >= 0
                    && newPosI < grid.length
                    && newPosJ < grid[0].length
                    && grid[newPosI][newPosJ] == '1') {

                grid[newPosI][newPosJ] = '0'; // mark visited
                dfsHelper(newPosI, newPosJ);
            }
        }

    }
}
