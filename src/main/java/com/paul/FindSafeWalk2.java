package com.paul;

import java.util.List;

public class FindSafeWalk2 {

        private int[][] matrix;

        private  final int[][] DIRECTIONS = {
                {-1, 0}, // up
                {1, 0},  // down
                {0, -1}, // left
                {0, 1}   // right
        };

        private int n;
        private int m;


        public boolean findSafeWalk(List<List<Integer>> listList, int health) {
            int[][] grid = listList.stream()
                    .map(row -> row.stream()
                            .mapToInt(Integer::intValue)
                            .toArray())
                    .toArray(int[][]::new);

            int x = 0;
            int y = 0;

            n = grid.length;
            m = grid[0].length;
            matrix = new int[n][m];

            return dfs(grid, x, y, health);
        }

        private boolean dfs(int[][] grid, int x, int y, int health) {

            if (!isValid(x, y)) return false;
            if (matrix[x][y] == 1) return false;

            health -= grid[x][y];
            if (health < 0) return false;

            if (isTarget(x, y)) return true;

            matrix[x][y] = 1;

            for (int[] dir : DIRECTIONS) {
                if (dfs(grid, x + dir[0], y + dir[1], health)) {
                    matrix[x][y] = 0;
                    return true;
                }
            }

            matrix[x][y] = 0;
            return false;
        }

        private boolean isValid(int x, int y) {
            return x >= 0 && x < n && y >= 0 && y < m;
        }

        private boolean isTarget(int x, int y) {
            return x == n - 1 && y == m - 1;
        }
}
