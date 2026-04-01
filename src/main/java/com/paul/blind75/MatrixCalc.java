package com.paul.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixCalc {


    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 0, 1, 1},
//                {1, 1, 0, 1},
//                {1, 0, 1, 1},
//                {0, 1, 1, 1}
//        };

        int[][] matrix = {
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 1},
        };

        int[][] result = buildHeights(matrix);

        int res = calculateMatrix(result);

        System.out.println(res);

    }

    private static int[][] buildHeights(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] height = new int[rows][cols];

        for (int j = 0; j < cols; j++) {
            height[0][j] = matrix[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    height[i][j] = height[i - 1][j] + 1;
                }
            }
        }

        return height;
    }

    private static int calculateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int max = 0;

        for (int[] row : matrix) {
            int[] copyRow = row.clone();

            Arrays.sort(copyRow);

            for (int j = cols - 1; j >= 0; j--) {
                int height = copyRow[j];
                int width = cols - j;

                int area = height * width;
                max = Math.max(max, area);
            }
        }

        return max;
    }

}
