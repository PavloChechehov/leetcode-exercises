package com.paul.blind75;

public class CountSubMatricesXY {


    public static void main(String[] args) {
        char[][] grid = {{'X', 'Y', '.' }, {'Y', '.', '.' }};
//        char[][] grid = {{'X', 'X'}, {'X', 'Y'}};

        int res = numberOfSubmatrices(grid);
        System.out.println(res);
    }


    public static int numberOfSubmatrices(char[][] grid) {
//        if (grid[0][0] != 'X')
//            return 0;
        //"X","Y","."
        //"Y",".","."


        int rows = grid.length + 1;
        int cols = grid[0].length + 1;

        int[][] dp = new int[rows][cols];
        int count = 0;

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {

                char c = grid[i - 1][j - 1];
                dp[i][j] = c == 'X' ? 1 : c == 'Y' ? -1 : 0;
            }
        }

        int[][] matrix = new int[rows][cols];

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {

                matrix[i][j] = matrix[i - 1][j]
                        + matrix[i][j - 1]
                        - matrix[i - 1][j - 1];

                if (matrix[i][j] == 0 && grid[i - 1][j - 1] != '.')
                    count++;
            }
        }

        return count;
    }
}
