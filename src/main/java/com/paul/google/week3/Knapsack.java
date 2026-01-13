package com.paul.google.week3;

import java.util.List;

/**
 * <a href="https://algo.monster/problems/knapsack_intro">Knapsack intro</a>
 */
public class Knapsack {

    public static void main(String[] args) {
        /*
        weights = [3, 4, 7]
        values = [4, 5, 8]
        max_weight = 7
        * */
        List<Integer> weights = List.of(3, 4, 7);
        List<Integer> values = List.of(4, 5, 8);
        int maxWeight = 7;
        int res = knapsack(weights, values, maxWeight);
        System.out.println(res == 9);
    }


    /**
     * bottom up solution
     */
    public static int knapsack(List<Integer> weights, List<Integer> values, int maxWeight) {
        int n = weights.size();
        int[][] dp = new int[n][maxWeight + 1];

        // Base case: first item
        for (int w = 0; w <= maxWeight; w++) {
            if (w >= weights.get(0)) {
                dp[0][w] = values.get(0);
            }
        }

        // Build DP table
        for (int i = 1; i < n; i++) {
            int currWeight = weights.get(i);
            int currValue = values.get(i);

            for (int w = 0; w <= maxWeight; w++) {
                // Exclude item
                dp[i][w] = dp[i - 1][w];

                // Include item if possible
                if (w >= currWeight) {
                    dp[i][w] = Math.max(dp[i][w], currValue + dp[i - 1][w - currWeight]
                    );
                }
            }
        }

        return dp[n - 1][maxWeight];
    }

}
