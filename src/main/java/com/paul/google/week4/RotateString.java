package com.paul.google.week4;

public class RotateString {

    public static void main(String[] args) {
//        boolean res = rotateString("defdefdefabcabc", "defdefabcabcdef");
        boolean res = rotateString("abcde", "bcdea");
        System.out.println(res);
    }


    public static boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        int n = s.length();

        for (int i = 0; i < n; i++) {

            int counter = 0;

            for (int j = 0; counter < n; j++) {
                char chInS = s.charAt((i + j) % n);
                char chInGoal = goal.charAt(j % n);
                if (chInS != chInGoal) break;

                counter++;
            }

            if (counter == n) return true;
        }

        return false;
    }
}
