package com.paul.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;


/**
 * <a href="https://leetcode.com/problems/shift-2d-grid/description/?envType=daily-question&envId=2026-07-20">1260. Shift 2D Grid</a>
 */
public class ShiftGrid {

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 5;

        List<List<Integer>> res = shiftGrid(grid, k);
        System.out.println(res);
    }



    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[] arr = new int[n * m];

        int length = arr.length;
        int step = k % length;
        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                arr[(i * m + j + step) % length] = grid[i][j];
            }
        }


        List<List<Integer>> answer = new ArrayList<>();

        int index = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>(m);
            for (int j = 0; j < m; j++) {
                row.add(arr[index++]);
            }
            answer.add(row);
        }

        return answer;
    }

/*
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        //[1,2,3], [4,5,6]
        // n = 2
        // m = 1



        int row = 0;
        int col = 0;

        int n = grid.length;
        int m = grid[0].length;

        int len = k % (n * m);
        int mid = (n * m) % k;



        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int i1 = i + 1;
                int j1 = j + 1;
                if (i1 * j1 < mid) {
                    int curr = grid[i][j];
                    ans[mid % i1][mid % j1] = curr;
                } else {
                    break;
                }

            }

        }

        int start = mid % n % m;

        for (int i = mid % n; i < n; i++) {
            for (int j = start; j < m; j++) {


                grid[i][j] = ans[len % i][len % j];
            }
        }

        return Arrays.stream(grid)
                .map(arr -> Arrays.stream(arr)
                        .boxed()
                        .toList())
                .toList();

    }
*/
}
