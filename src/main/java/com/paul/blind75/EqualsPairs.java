package com.paul.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/equal-row-and-column-pairs/description/">2352. Equal Row and Column Pairs</a>
 *
 */
public class EqualsPairs {


    public static void main(String[] args) {
        int[][] grid = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        int res = equalPairs(grid);
        System.out.println(res);

    }

    public static int equalPairs(int[][] grid) {
        int count = 0;

        int n = grid.length;



        List<int[]> rows = new ArrayList<>();

        //Collections.addAll(rows, grid);
        for(int[] row: grid) {
            rows.add(row);
        }

        List<int[]> cols = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int[] col = new int[n];

            for(int j = 0; j < n; j++) {

                col[j] = grid[j][i];
            }

            cols.add(col);
        }

        for (int[] col : cols) {

            for (int[] row : rows) {
                if (Arrays.equals(row, col)) {
                    count++;
                }
            }
        }


        return count;
    }


    //        for (int i = 0; i < n; i++) {
//
//            int col = 0;
//            int eqCount = 0;
//
//            for (; col < n; col++) {
//
//                for (int j = 0; j < n; j++) {
//
//                    int rowElem = grid[i][j];
//                    int colElem = grid[j][col];
//
//                    if (rowElem == colElem) {
//                        eqCount++;
//                    } else {
//                        break;
//                    }
//                }
//
//                if (eqCount == n) {
//                    count++;
//                }
//            }
//
//        }
}
