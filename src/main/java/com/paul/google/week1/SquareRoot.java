package com.paul.google.week1;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(squareRoot(2));
    }

    //1.41421356237
    //1.4142135614529252
    public static double squareRoot(int n) {
        if (n == 0) return 0;
        double l = 0;
        double r = n;

        double res = -1;

        while (r - l >= 0.000000001) {

            double mid = l + (r - l) / 2;

            if (mid == n / mid) {
                return mid;
            } else if (mid < n / mid) {
                res = mid;
                l = mid;
            } else {
                r = mid;
            }
        }

        return res;

    }
}
