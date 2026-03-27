package com.paul.blind75;

public class MaximumNonNegativeProductMatrix {


    public static void main(String[] args) {
//        int[][] grid = {{1, 3}, {0, -4}};
//        int[][] grid = {{-1,-2,-3},{-2,-3,-3},{-3,-3,-2}};
        int[][] grid = {{1,-2,1},{1,-2,1},{3,-4,1}};
        int res = maxProductPath(grid);
        System.out.println(res);

    }


    public static int maxProductPath(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        long[][] max = new long[rows][cols];
        long[][] min = new long[rows][cols];

        max[0][0] = min[0][0] = grid[0][0];

        for (int j = 1; j < cols; j++) {
            max[0][j] = max[0][j - 1] * grid[0][j];
            min[0][j] = max[0][j];
        }

        for (int i = 1; i < rows; i++) {
            max[i][0] = max[i - 1][0] * grid[i][0];
            min[i][0] = max[i][0];
        }


        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {

                long val = grid[i][j];

                long maxTop = max[i - 1][j];
                long minTop = min[i - 1][j];
                long maxLeft = max[i][j - 1];
                long minLeft = min[i][j - 1];

                if (val >= 0) {
                    max[i][j] = Math.max(maxTop, maxLeft) * val;
                    min[i][j] = Math.min(minTop, minLeft) * val;
                } else {
                    max[i][j] = Math.min(minTop, minLeft) * val;
                    min[i][j] = Math.max(maxTop, maxLeft) * val;
                }

            }
        }

        long result = max[rows - 1][cols - 1];


        return result < 0 ? -1: (int) (result % 1_000_000_007);
    }
}
