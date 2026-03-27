package com.paul.blind75;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/description/">2946. Matrix Similarity After Cyclic Shifts</a>
 *
 */
public class MatrixSimilarityAfterCyclicShifts {


    public boolean areSimilar(int[][] mat, int k) {
        int cols = mat[0].length;

        for (int[] row: mat) {

            int[] curr = new int[cols];

            for(int i = 0; i < cols; i++) {

                curr[i] = row[(i + k) % cols];
            }


            if (!Arrays.equals(row, curr)) return false;

        }


        return true;
    }

}
