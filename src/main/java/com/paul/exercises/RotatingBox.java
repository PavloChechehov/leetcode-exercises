package com.paul.exercises;

import java.util.Arrays;

public class RotatingBox {

    public static void main(String[] args) {
//        char[][] boxGrid = {{'#', '.', '*', '.'},
//                {'#', '#', '*', '.'}};
        char[][] boxGrid = {{'#', '.', '#'}};
        char[][] res = rotateTheBox(boxGrid);
        System.out.println(Arrays.deepToString(res));
        System.out.println("[[\"#\",\".\"],[\"#\",\"#\"],[\"*\",\"*\"],[\".\",\".\"]]");
    }

    public static char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;

        char[][] ans = new char[m][n];


        for(int i = 0; i < n; i++) {

            int p1 = m - 1;
            int p2 = m - 1;

            while (p1 >= 0) {
                if (boxGrid[i][p1] == '#' && boxGrid[i][p2] == '.') {
                    boxGrid[i][p1] = '.';
                    boxGrid[i][p2] = '#';
                    p1--;
                    p2--;
                    continue;
                }

                if (boxGrid[i][p2] == '#' && boxGrid[i][p1] == '.') {
                    p2--;
                }

                if (boxGrid[i][p1] == '*') {
                    p1--;
                    p2 = p1;
                } else {
                    p1--;
                }
            }
        }

        System.out.println(Arrays.deepEquals(ans, boxGrid));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[j][n - 1 - i] = boxGrid[i][j];
            }
        }

        return ans;
    }
}
