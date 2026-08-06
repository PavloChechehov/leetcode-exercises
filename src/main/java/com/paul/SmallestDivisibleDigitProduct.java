package com.paul;


/**
 * <a href="https://leetcode.com/problems/smallest-divisible-digit-product-i/?envType=daily-question&envId=2026-08-06">3345. Smallest Divisible Digit Product I</a>
 */
public class SmallestDivisibleDigitProduct {


    public static void main(String[] args) {
        int res = smallestNumber(15, 3);
        System.out.println(res);
    }


    public static int smallestNumber(int n, int t) {

        if (n <= 10 && n % t == 0) return n;

        for (int i = n; i <= 100; i++) {

            int sum = 1;
            int temp = i;

            while (temp != 0) {
                sum *= temp % 10;
                temp /= 10;
            }

            if (sum % t == 0) return i;

        }

        return 100;
    }
}
