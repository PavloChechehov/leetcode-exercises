package com.paul.exercises;

import java.util.Arrays;

public class Matrix {

    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        System.out.println(Arrays.deepToString(res));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i = 1;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int count = 0;
        int x = 0;
        int y = 0;

        while (matrix[x][y] == 0) {


            matrix[x][y] = i++;



            if ((x == n - 1 && y == 0)
                    || (x == n - 1 && y == n - 1)
                    || (x == 0 && y == n - 1)) {
                count++;
            }

            int[] d = directions[count % 3];
            x += d[0];
            y += d[1];

            if (matrix[x][y] != 0) {
                count++;
            }

        }


        return matrix;

    }
}
