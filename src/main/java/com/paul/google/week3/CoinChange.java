package com.paul.google.week3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/coin-change/description/">322. Coin Change</a>
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        int amount = 11;
        int res = coinChange(nums, amount);
        System.out.println(res);
    }


    //1. recursive dfs approach with memoization
/*    private int len;
    public int coinChange(int[] coins, int amount) {
        // 1,2,5
        // 5 + 5 + 1
        // 5 -> [1,2,5] + 5 -> 1
        len = coins.length;
        Map<Integer, Integer> memo = new HashMap<>();
        int res = coinChangeHelper(coins, amount, memo);

        return res == Integer.MAX_VALUE? -1: res;

    }


    private int coinChangeHelper(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (memo.containsKey(amount)) return memo.get(amount);

        int min = Integer.MAX_VALUE;
        for(int i = len - 1; i >= 0; i--) {
            int res = coinChangeHelper(coins, amount - coins[i], memo);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        }

        memo.put(amount, min);

        return min;
    }*/


    //2. iterative approach
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // acts as "infinity"

        dp[0] = 0;

        //time complexity O(amount * len(coins))
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
