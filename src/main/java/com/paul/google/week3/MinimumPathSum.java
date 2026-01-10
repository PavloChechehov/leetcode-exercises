package com.paul.google.week3;


/**
 * <a href="https://leetcode.com/problems/minimum-path-sum/description/">64. Minimum Path Sum</a>
 */
public class MinimumPathSum {

    // 1 3 1
    // 1 5 1
    // 4 2 1
        /*
        1->4->5|
        2->7  6|
        6->8  7|
        */

    //O(m * n)


//used extra dp adjacency matrix
    /*
    public int minPathSum(int[][] grid) {
        //O(m * n)
        int rowLength = grid.length;
        int columnLength = grid[0].length;

        int[][] dp = new int[rowLength][columnLength];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < rowLength; i++) {
            for(int j = 0; j < columnLength; j++) {
                if (i == 0 && j != 0) dp[i][j] = dp[i][j - 1] + grid[i][j];
                if (i != 0 && j == 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
                if (i != 0 && j != 0) dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1])  + grid[i][j];
            }
        }

        return dp[rowLength - 1][columnLength - 1];
    }*/

    /* public int minPathSum(int[][] grid) {
        //O(m * n)
        int rowLength = grid.length;
        int columnLength = grid[0].length;

        int[][] dp = new int[rowLength][columnLength];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < rowLength; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < columnLength; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for(int i = 1; i < rowLength; i++) {
            for(int j = 1; j < columnLength; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1])  + grid[i][j];
            }
        }

        return dp[rowLength - 1][columnLength - 1];
    }*/

    //final solution
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;


        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }
}
