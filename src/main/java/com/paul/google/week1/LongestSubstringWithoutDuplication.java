package com.paul.google.week1;

import java.util.HashSet;
import java.util.Set;


/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">LeetCode 3: Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutDuplication {

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = "bbbbb";
        String s2 = "pwwkew";

        int res = lengthOfLongestSubstring(s);
        System.out.println(res);

    }

    // approach 2: two pointers/sliding window
    public static int lengthOfLongestSubstring(String s) {
        //abc abc bb

        Set<Character> letters = new HashSet<>();
        int maxLength = 0;
        int res = 0;
        char[] chars = s.toCharArray();
        int l = 0;
        int r = 0;


        while (l <= r && r < s.length()) {


            if (letters.contains(chars[r])) {
                letters.remove(chars[l]);
                maxLength--;
                l++;
            } else {
                letters.add(chars[r]);
                r++;
                maxLength++;
            }

            //or this one:
            //res = Math.max(r - l, res);
            res = Math.max(maxLength, res);
        }

        return res;

    }




/* incorrect solution
    public static int lengthOfLongestSubstring(String s) {
        //abc abc bb

        Set<Character> letters = new HashSet<>();
        int maxLength = 0;
        int res = 0;
        char[] chars = s.toCharArray();

        for (char ch : chars) {

            if (letters.contains(ch)) {
                res = Math.max(maxLength, res);
                maxLength = 0;
                letters.clear();
            } else {
                maxLength++;
                letters.add(ch);
            }

        }


        return res;

    }
*/
}
