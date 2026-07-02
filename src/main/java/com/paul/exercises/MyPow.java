package com.paul.exercises;

public class MyPow {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        double res = myPow(-1.00000, Integer.MIN_VALUE);
        System.out.println(res);
    }

    public static double myPow(double x, int n) {
        double res = 1;

        if (x == 1 || x == -1) return x;

        if (n == Integer.MIN_VALUE) {
            n += 1;
        }

        for (int i = 0; i < Math.abs(n); i++) {

            if (n < 0) {
                res /= x;
            } else {
                res *= x;
            }

//            if (res == 0d) return res;

        }

        return res;
    }
}
