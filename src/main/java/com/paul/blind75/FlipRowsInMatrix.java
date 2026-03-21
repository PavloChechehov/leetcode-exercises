package com.paul.blind75;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/flip-square-submatrix-vertically/description/">3643. Flip Square Submatrix Vertically</a>
 */
public class FlipRowsInMatrix {

    public static void main(String[] args) {
        int[][] grid = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int x = 1;
        int y = 0;
        int k = 3;
        int[][] res = reverseSubmatrix(grid, x, y, k);

        System.out.println(Arrays.deepToString(res));
    }


    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        int lastX = x + k - 1;
        int lastY = y + k;

        for(int i = x; i < lastX; i++) {

            for(int j = y; j < lastY; j++) {

                int temp = grid[i][j];

                grid[i][j] = grid[lastX][j];

                grid[lastX][j] = temp;

            }

            lastX--;
        }


        return grid;
    }
}
