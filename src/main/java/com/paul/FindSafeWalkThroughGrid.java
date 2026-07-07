package com.paul;


import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/find-a-safe-walk-through-a-grid/description/">3286. Find a Safe Walk Through a Grid</a>
 */
public class FindSafeWalkThroughGrid {


    private static final int[][] DIRECTIONS = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
    };
    private static int n;
    private static int m;

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0}
        };

        int health = 1;

        boolean res = findSafeWalk(grid, health);

        System.out.println(res);
    }
    private static int[][] matrix;
    public static boolean findSafeWalk(int[][] grid, int health) {
        int x = 0;
        int y = 0;

        n = grid.length;
        m = grid[0].length;
        matrix = new int[n][m];

        return dfs(grid, x, y, health);
    }

    private static boolean dfs(int[][] grid, int x, int y, int health) {
        // boundary + visited
        if (x < 0 || x >= n || y < 0 || y >= m) return false;
        if (matrix[x][y] == 1) return false;

        // consume health at current cell
        health -= grid[x][y];
        if (health < 0) return false;

        // success condition
        if (x == n - 1 && y == m - 1) return true;

        matrix[x][y] = 1;

        for (int[] dir : DIRECTIONS) {

            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (dfs(grid, nextX, nextY, health)) {
                matrix[x][y] = 0;
                return true;
            }
        }

        matrix[x][y] = 0;
        return false;
    }


}
