package com.paul.blind75;

/**
 * <a href="https://leetcode.com/problems/valid-perfect-square/description/">367. Valid Perfect Square</a>
 */
public class ValidPerfectSquare {

    public static void main(String[] args) {
        boolean isPerfectSquare = isPerfectSquare(14);
        System.out.println(isPerfectSquare);
    }


    //Binary search
    //complexity O(log (n))
    public static boolean isPerfectSquare(int num) {
        long l = 0;
        long r = num + 1;

        while(l <= r) {
            long mid = l + (r - l)/2;

            long mult = mid * mid;

            if (mult == num) return true;

            if (mult > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}
