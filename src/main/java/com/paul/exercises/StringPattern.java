package com.paul.exercises;


//1967. Number of Strings That Appear as Substrings in Word
//https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/description/?envType=daily-question&envId=2026-06-29
public class StringPattern {


    public static void main(String[] args) {
        String[] patterns = {"a","b","c"};
        String word = "aaaabbbb";
        int res = numOfStrings(patterns, word);
        System.out.println(res);
    }

    public static int numOfStrings(String[] patterns, String word) {

        int n = patterns.length;
        int len = word.length();
        int res = 0;

        for (String s : patterns) {

            int min = Math.min(s.length(), len);
            // bc
            // abc
            for (int i = 0; i < word.length(); i++) {
                int k = 0;
                while (k < s.length() && word.charAt(i + k) == s.charAt(k)) {
                    k++;
                }

                if (k == s.length()) {
                    res++;
                    break;
                }
            }

        }

        return res;
    }
}
