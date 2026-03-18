package com.paul.blind75;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/longest-palindrome/description/">409. Longest Palindrome</a>
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "ccc";
        int res = longestPalindrome(s);
        System.out.println(res);
    }


    public static int longestPalindrome(String s) {
        int n = s.length();

        if (n == 1)
            return 1;

        char[] letters = s.toCharArray();
        Arrays.sort(letters);

        // Map<Character, Integer> map = new TreeMap<>()
        List<Letter> list = new ArrayList<>();

        int k = 0;
        for (int i = 1; i < n; i++) {
            if (letters[i - 1] != letters[i]) {
                list.add(new Letter(letters[i - 1], i - k));
                k = i;
            }
        }


        list.add(new Letter(letters[n - 1], n - k));

        int count = 0;

        for (Letter letter : list) {
            if (letter.count() % 2 == 1) {
                count++;
                break;
            }
        }

        for (Letter letter : list) {

            if (letter.count() % 2 == 0) {
                count += letter.count();
            } else {
                count += letter.count() - 1;
            }
        }


        return count;    }
}

record Letter(char ch, int count) {

}

