package com.paul.blind75;


import java.util.Arrays;


/**
 * <a href="https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/">1886. Determine Whether Matrix Can Be Obtained By Rotation</a>
 */
public class CheckEqualsMatrixIfRotateByClockwise {


    //complexity O(n^2)
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        for (int k = 0; k < 4; k++) {

            if (Arrays.deepEquals(mat, target)) {
                return true;
            }

            rotate(mat, n);
        }

        return false;
    }

    private static void rotate(int[][] mat, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = n - 1;

            while (l < r) {
                int temp = mat[i][l];
                mat[i][l] = mat[i][r];
                mat[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}
