package com.paul.blind75;

public class Solution {

    public static void main(String[] args) {
        String s = "1";

        boolean res = checkOnesSegment(s);
        System.out.println(res);
    }


    public static boolean checkOnesSegment(String s) {
        int l = 0;
        int r = 1;

        int n = s.length();

        if (n == 1) return false;
        int res = 0;
        //1001
        while (l <= r && r < n) {

//&&
            if (s.charAt(r) == '1') {
                r++;
            } else {
                r++;
                l = r;
            }

            if (r < n) {
                res = Math.max(r - l + 1, res);

            }


        }


        return res > 1;
    }
}
