package com.paul.exercises;

/**
 * <a href="https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/description/?envType=daily-question&envId=2026-07-07">3754. Concatenate Non-Zero Digits and Multiply by Sum I</a>
 */
public class ConcatenateNonZeroDigitsMultiplySum {


    public static void main(String[] args) {
        int n = 10203004;
        long res = sumAndMultiply(n);
        System.out.println(res);
    }

    public static long sumAndMultiply(int n) {
        int sum = 0;
        int curr = n;
        int k = 1;
        long newV = 0;

        while (curr != 0) {

            int num = curr % 10;
            curr /= 10;

            if (num != 0) {
                sum += num;
                newV += (long) k * num;
                k *= 10;
            }
        }

        return newV * sum;
    }
}
