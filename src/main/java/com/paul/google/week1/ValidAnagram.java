package com.paul.google.week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * <a href="https://leetcode.com/problems/valid-anagram/description/">LeetCode 242: Valid Anagram</a>
 *
 * */
public class ValidAnagram {


    public static void main(String[] args) {
//        String s = "anagram";
        String s = "rat";
//        String t = "nagaram";
        String t = "car";
        boolean res = isAnagram(s, t);
        System.out.println(res);
    }



    //solution 2: using the HashMap data structure
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> letters = new HashMap<>();

        for (char ch : s.toCharArray()) {
            letters.put(ch, letters.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {

            /*
                if (letters.containsKey(ch) && letters.get(ch) == 0) {
                    letters.remove(ch);
                }

                if (letters.containsKey(ch)) {
                    letters.put(ch, letters.get(ch) - 1);
                } else {
                    return false;
            }*/

            if (letters.containsKey(ch)) {

                if (letters.get(ch) == 1) {
                    letters.remove(ch);
                } else {
                    letters.put(ch, letters.get(ch) - 1);
                }

            } else {
                return false;
            }


        }


        return true;
    }

    //solution 1: This is straightforward approach.
    /*public static boolean isAnagram(String s, String t) {

        char[] char1 = s.toCharArray();
        Arrays.sort(char1);


        char[] char2 = t.toCharArray();
        Arrays.sort(char2);


        return Arrays.equals(char1, char2);
    }*/
}
