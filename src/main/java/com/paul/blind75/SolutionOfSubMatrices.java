package com.paul.blind75;

/**
 * <a href="https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/">3212. Count Submatrices With Equal Frequency of X and Y</a>
 *
 */
public class SolutionOfSubMatrices {

    public static void main(String[] args) {
        char[][] grid = {{'X', 'Y', '.' }, {'Y', '.', '.' }};
//        char[][] grid = {{'X', 'X'}, {'X', 'Y'}};

        int res = numberOfSubmatrices(grid);
        System.out.println(res);
    }

    public static int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length + 1;
        int cols = grid[0].length + 1;

        int[][] dp = new int[rows][cols];
        int[][] matrix = new int[rows][cols];
        int count = 0;

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {

                char c = grid[i - 1][j - 1];

                int val = (c == 'X') ? 1 : (c == 'Y') ? -1 : 0;
                int isX = (c == 'X') ? 1 : 0;

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + val;

                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1] + isX;

                if (dp[i][j] == 0 && matrix[i][j] > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
