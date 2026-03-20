package com.paul.blind75;

/**
 * <a href="https://leetcode.com/problems/arranging-coins/description/">441. Arranging Coins</a>
 */
public class CoinsStairs {



    public int arrangeCoins(int n) {
        //sum = n * (n + 1)/2;

        long l = 0;
        long r = n;

        long res = 1;

        while (l <= r) {

            long mid = l + (r - l)/2;

            long sum = mid * (mid + 1) / 2;
            if(sum <= n) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }


        return (int) res;
    }
}
