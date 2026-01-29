package com.paul.google.week4;

/**
 * <a href="https://leetcode.com/problems/detect-capital/description/">Detect Capital</a>
 */
public class DetectCapital {

    public boolean detectCapitalUse(String word) {

        if (word.length() == 1) return true;

        //uSA -> false
        //leetcode -> true
        //Google ->
        //

        if (word.toLowerCase().equals(word)) return true;
        if (word.toUpperCase().equals(word)) return true;

        for(int i = 1; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(Character.isUpperCase(ch)) return false;
        }

        return true;
    }
}
