package com.paul.google.week3;


import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/unique-paths/description/">62. Unique Paths</a>
 */
public class UniquePaths {

    public static void main(String[] args) {
        int res = uniquePaths(3, 2);
        System.out.println(res);
    }

    public static int uniquePaths(int m, int n) {
        /* m = 3, n = 2
        1 1
        2 3
        2 3

        start position, need to initialize the first row and column with 1;
        1 1
        1 0
        1 0
        */

        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

}
