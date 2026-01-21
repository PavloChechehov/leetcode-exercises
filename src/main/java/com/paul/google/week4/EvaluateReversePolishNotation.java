package com.paul.google.week4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/description/">Evaluate Reverse Polish Notation</a>
 */
public class EvaluateReversePolishNotation {

    private static final Map<String, BinaryOperator<Integer>> operations = new HashMap<>();

    static {
        operations.put("+", (a,b) -> a + b);
        operations.put("-", (a,b) -> b - a);
        operations.put("/", (a,b) -> b / a);
        operations.put("*", (a,b) -> a * b);
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(String t: tokens) {

            if (operations.containsKey(t)) {

                Integer a = stack.pop();
                Integer b = stack.pop();
                Integer res = operations.get(t).apply(a, b);
                stack.add(res);

            } else {
                stack.add(Integer.valueOf(t));
            }

        }


        return stack.pop();
    }
}
