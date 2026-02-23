package com.paul.blind75;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/removing-stars-from-a-string/description/">2390. Removing Stars From a String</a>
 */
public class RemoveStars {

    public static void main(String[] args) {
        String s = "leet**cod*e";
        String res = removeStars(s);
        System.out.println(res);
    }


    public static String removeStars(String s) {


        Stack<Character> chars = new Stack<>();

        char[] letters = s.toCharArray();
        int n = s.length() - 1;

        int counter = 0;

        for(int i = n; i >= 0; i--) {

            if (counter == 0) {
                char ch = letters[i];
                if (ch == '*') {
                    counter++;
                } else {
                    chars.add(letters[i]);
                }
            } else if (letters[i] != '*') {
                counter--;
            } else {
                counter++;
            }


        }
        StringBuilder sb = new StringBuilder();
        while(!chars.isEmpty()) {
            sb.append(chars.pop());
        }


        return sb.toString();
    }
}
