package com.paul.blind75;

/**
 * <a href="https://leetcode.com/problems/power-of-four/description/">342. Power of Four</a>
 */

public class PowerOfFour {

    public static void main(String[] args) {
        int n = 256;
        System.out.println(isPowerOfFour(n));
    }


    public static boolean isPowerOfFour(int n) {

        int curr = 1;
        while (curr > 0) {

            if (curr == n)
                return true;
            if (curr > n)
                return false;

            curr = curr << 2;
        }

        return false;
    }
}
