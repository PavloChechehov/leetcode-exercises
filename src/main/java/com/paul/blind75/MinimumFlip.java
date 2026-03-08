package com.paul.blind75;

public class MinimumFlip {

    public static void main(String[] args) {
        String s = "111000";
        int res = minFlips(s);
        System.out.println(res);
    }

    public static int minFlips(String s) {
        int n = s.length();
        String doubled = s + s;

        int res = Integer.MAX_VALUE;
        int diff1 = 0;
        int diff2 = 0;

        for (int i = 0; i < doubled.length(); i++) {

            diff1 = getDiff(i, '0', '1', doubled, diff1, n);
            diff2 = getDiff(i, '1', '0', doubled, diff2, n);

            if (i >= n - 1) {
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }

        return res;
    }


    private static int getDiff(int i, char x, char x1, String doubled, int diff, int n) {
        char expected1 = (i % 2 == 0) ? x : x1;
        if (doubled.charAt(i) != expected1) {
            diff++;
        }

        if (i >= n) {
            char prevExpected = ((i - n) % 2 == 0) ? x : x1;
            if (doubled.charAt(i - n) != prevExpected) {
                diff--;
            }
        }

        return diff;
    }


}
