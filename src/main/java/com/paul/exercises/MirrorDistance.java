package com.paul.exercises;

public class MirrorDistance {

    public static void main(String[] args) {
        int res = mirrorDistance(25);
        System.out.println(res);
    }


    public static int mirrorDistance(int n) {
        return Math.abs(n - reverseInt(n));
    }

    public static int reverseInt(int input) {
        int reverse = 0;

        while (input != 0) {
            reverse = reverse * 10 + input % 10;
            input = input / 10;
        }


        return reverse;
    }

}
