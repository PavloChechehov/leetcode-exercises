package com.paul.blind75;


/**
 * <a href="https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/description/">3070. Count Submatrices with Top-Left Element and Sum Less Than k</a>
 */
public class SumMatrices {

    public static void main(String[] args) {
//        int[][] grid = {
//                {7, 6, 3},
//                {6, 6, 1}
//        };
        int[][] grid = {
                {7, 2, 9},
                {1, 5, 0},
                {2, 6, 6}
        };
        int res = countSubmatrices(grid, 20);
        System.out.println(res);
    }

    // complexity O(n * m), using 2D prefix sums to efficiently calculate submatrix sums starting from the top-left corner.
    public static int countSubmatrices(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows + 1][cols + 1];

        int count = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + grid[i - 1][j - 1] - dp[i - 1][j - 1];

                if (dp[i][j] <= k) {
                    count++;
                }

            }
        }

        return count;
    }
}
