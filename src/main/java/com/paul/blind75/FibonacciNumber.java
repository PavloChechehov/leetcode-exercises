package com.paul.blind75;


/**
 * <a href="https://leetcode.com/problems/fibonacci-number/description/">Fibonacci Number</a>
 */
public class FibonacciNumber {


    public static void main(String[] args) {
        int res = fib(8);
        System.out.println(res);
    }

    public static int fib(int n) {
        if (n == 0) return 0;

        int a = 1;
        int b = 1;

        n = n - 1;

        int temp;

        for (int i = 0; i < n; i++) {
            temp = b;
            b = a + b;
            a = temp;
        }

        return a;
    }


}
