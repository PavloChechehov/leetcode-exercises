package com.paul.exercises;

import java.util.Map;

public class ValidPath {
    static char UP = 'U';
    static char DOWN = 'D';
    static char LEFT = 'L';
    static char RIGHT = 'R';

    static final Map<Character, Character> connections = Map.of(
            UP, DOWN,
            DOWN, UP,
            LEFT, RIGHT,
            RIGHT, LEFT
    );


    static final Map<Integer, char[]> paths = Map.of(
            1, new char[]{LEFT, RIGHT},
            2, new char[]{UP, DOWN},
            3, new char[]{LEFT, DOWN},
            4, new char[]{RIGHT, DOWN},
            5, new char[]{LEFT, UP},
            6, new char[]{UP, RIGHT}
    );

    static final Map<Character, int[]> directions = Map.of(
            UP, new int[]{-1, 0},
            DOWN, new int[]{1, 0},
            LEFT, new int[]{0, -1},
            RIGHT, new int[]{0, 1}
    );

    public static void main(String[] args) {
        int[][] grid = {{4, 1}, {6, 1}};

        boolean res = hasValidPath(grid);
        System.out.println(res);
    }


    public static boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        return dfs(0, 0, grid, visited);
    }

    private static boolean dfs(int i, int j,
                               int[][] grid,
                               boolean[][] visited) {

        int n = grid.length;
        int m = grid[0].length;

        if (i == n - 1 && j == m - 1) return true;

        visited[i][j] = true;

        int curr = grid[i][j];
        char[] currPaths = paths.get(curr);

        for (char dir : currPaths) {

            int[] move = directions.get(dir);
            int ni = i + move[0];
            int nj = j + move[1];

            if (ni < 0 || nj < 0 || ni >= n || nj >= m || visited[ni][nj]) {
                continue;
            }

            int next = grid[ni][nj];
            char[] nextPaths = paths.get(next);

            boolean valid = false;
            for (char nextDir : nextPaths) {
                if (connections.get(nextDir) == dir) {
                    valid = true;
                    break;
                }
            }

            if (!valid) continue;

            if (dfs(ni, nj, grid, visited)) {
                return true;
            }
        }

        return false;

    }

}
