package com.paul.exercises;

import java.util.Arrays;

//https://leetcode.com/problems/determine-if-two-strings-are-close/?envType=study-plan-v2&envId=leetcode-75
public class CloseStrings {

    public static void main(String[] args) {
        String s1 = "abbzzca";
        String s2 = "babzzcz";

        boolean res = closeStrings(s1, s2);
        System.out.println(res);
    }

    public static boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }

        // Same set of characters
        for (int i = 0; i < 26; i++) {

            if (freq1[i] == 0 && freq2[i] != 0) {
                return false;
            }
        }

         Arrays.sort(freq1);
         Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }
}
