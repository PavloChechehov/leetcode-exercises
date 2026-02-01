package com.paul.google.week4;

public class RepeatedSubstringPattern {

    public static void main(String[] args) {

        System.out.println("Aa".hashCode() == "BB".hashCode());

//        boolean res = repeatedSubstringPattern("ababa");
//        System.out.println(res);
    }


    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();


        int k = 2;
        while (n / k > 0) {

            n /= k;
            int i = 0;
            for (; i + n < s.length(); i++) {
                if (s.charAt(i) != s.charAt(i + n))
                    break;
            }


            if (i + n == s.length()) {
                return true;
            }

            n = s.length();
            k++;
        }

        return false;
    }
}
