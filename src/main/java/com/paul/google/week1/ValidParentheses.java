package com.paul.google.week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/">20. Valid Parentheses</a>
 */
public class ValidParentheses {

    public static void main(String[] args) {

        String s = "([])";
        boolean isValidParentheses = isValid(s);
        System.out.println(isValidParentheses);

    }


    public static boolean isValid(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }

        Map<Character, Character> parentheses = new HashMap<>();

        parentheses.put(']', '[');
        parentheses.put(')', '(');
        parentheses.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (parentheses.containsKey(ch)) {
                if (stack.isEmpty() || !stack.pop().equals(parentheses.get(ch))) {
                    return false;
                }
            } else {
                stack.add(ch);
            }
        }

        return stack.isEmpty();
    }
}
