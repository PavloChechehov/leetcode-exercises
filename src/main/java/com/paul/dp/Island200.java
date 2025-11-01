package com.paul.dp;

/**
 * Number of islands <a href="https://leetcode.com/problems/number-of-islands/">link</a>
 */
public class Island200 {
    public static void main(String[] args) {
        Island200 island200 = new Island200();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int res = island200.numIslands(grid);
        System.out.println(res);
    }

    private int numRows;
    private int numCols;

    private int numIslands(char[][] grid) {
        numRows = grid.length;
        numCols = grid[0].length;
        int counter = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == '1') {
                    depthFirstSearch(i, j, grid);
                    counter++;
                }
            }
        }


        return counter;

    }

    private void depthFirstSearch(int row, int col, char[][] grid) {

        grid[row][col] = '0';

        int[] directions = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int neighborRow = row + directions[k];
            int neighborCol = col + directions[k + 1];


            if (neighborRow >= 0
                    && neighborRow < numRows
                    && neighborCol >= 0
                    && neighborCol < numCols
                    && grid[neighborRow][neighborCol] == '1') {
                depthFirstSearch(neighborRow, neighborCol, grid);
            }

        }
    }

}
