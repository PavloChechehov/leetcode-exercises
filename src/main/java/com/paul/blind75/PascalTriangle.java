package com.paul.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * <a href="https://leetcode.com/problems/pascals-triangle-ii/description/">119. Pascal's Triangle II</a>
 */
class PascalTriangle {

    public static void main(String[] args) {

        int rowIndex = 3;
        List<Integer> res = getRow(rowIndex);
        System.out.println(res);

    }


    public static List<Integer> getRow(int rowIndex) {
        int rowLength = rowIndex + 1;

        int[][] mat = new int[rowLength][rowLength];

        for (int[] r : mat) {
            Arrays.fill(r, 1);
        }

        for(int i = 1; i < rowLength; i++) {
            for(int j = 1; j < rowLength - i; j++) {
                mat[i][j] = mat[i - 1][j] + mat[i][j - 1];
            }
        }

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < rowLength; i++) {
            res.add(mat[rowIndex - i][i]);
        }

        return res;
    }
}
