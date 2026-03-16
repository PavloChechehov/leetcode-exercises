package com.paul.blind75;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/word-pattern/">290. Word Pattern</a>
 */
public class WordPattern {

    public static void main(String[] args) {
        boolean res = wordPattern("abba", "dog dog dog dog");
        System.out.println(res);
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (words.length != pattern.length())
            return false;

        Map<Character, String> map = new HashMap<>();

        int i = 0;

        char[] patterns = pattern.toCharArray();

        for (char c : patterns) {
            //abba

            String currWord = words[i];

            if (map.containsKey(c)) {

                String word = map.get(c);
                if (!Objects.equals(word, currWord)) {
                    return false;
                }

            } else {

                if (map.containsValue(currWord)) {
                    return false;
                }

                map.put(c, currWord);
            }
            i++;

        }

        return true;
    }
}
