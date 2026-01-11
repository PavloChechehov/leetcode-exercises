package com.paul.google.week3;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs/description/">746. Min Cost Climbing Stairs</a>
 */
public class MinCostClimbingStairs {

    //dfs + memoization
/*    public int minCostClimbingStairs(int[] cost) {
        //     [1, 2, 1, 2, 1]
        //dp = [0, 0, 1, 2, 2, 3]
        // 10 15 20
        // 10
        // dp[i] = Math.min(cost.get(i), cost.get(i + 1))

        Map<Integer, Integer> memo = new HashMap<>();
        int res = Math.min(dfs(cost, 0, 0, memo), dfs(cost, 1, 0, memo));
        return res;
    }

    private int dfs(int[] cost, int position, int sum, Map<Integer, Integer> memo) {
        if(memo.containsKey(position)) return memo.get(position);

        if (position >= cost.length) {
            return 0;
        }

        int res1 = dfs(cost, position + 1, sum, memo);
        int res2 = dfs(cost, position + 2, sum, memo);
        int res = cost[position] + Math.min(res1, res2);

        memo.put(position, res);

        return res;
    }*/

    public int minCostClimbingStairs(int[] cost) {
        //     [1, 2, 1, 2, 1]
        //dp = [0, 0, 1, 2, 2, 3]
        // 10 15 20
        // 10
        // dp[i] = Math.min(cost.get(i), cost.get(i + 1))

        int n = cost.length;
        int [] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i - 1], dp[i-2] + cost[i - 2]);
        }

        return dp[n];
    }
}
