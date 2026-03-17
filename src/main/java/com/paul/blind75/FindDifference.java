package com.paul.blind75;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/find-the-difference/description/">389. Find the Difference</a>
 */
public class FindDifference {

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        char diff = findTheDifference(s, t);
        System.out.println(diff);
    }

    //Time complexity O(n * log(n))
    public static char findTheDifference(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        int n = s.length();

        int i = 0;
        for(; i < n; i++) {
            if (sChar[i] != tChar[i]) {
                return tChar[i];
            }
        }

        return tChar[i];
    }
}
