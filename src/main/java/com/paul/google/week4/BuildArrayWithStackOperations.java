package com.paul.google.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/build-an-array-with-stack-operations/description">Q1. Build an Array With Stack Operations</a>
 *
 */
public class BuildArrayWithStackOperations {
    public static void main(String[] args) {
        int[] arr = {1, 3};
        int n = 3;
        List<String> res = buildArray(arr, n);
        System.out.println(res);
    }

    private static final String PUSH = "Push";
    private static final String POP = "Pop";

    public static List<String> buildArray(int[] target, int n) {
        // 1, 3
        // push, push, pop, push

        // 1 -> push
        // 2 -> push
        // if 3 == 2 no pop, yes - next
        // 3 -> push if 3 == 3 - yes - next, finish
        // 1,4
        // 1-> push
        // 2 -> push
        // 3 -> push
        // 4 == 4 && prev(3) !=

        int len = target[target.length - 1];
        int k = 0;
        List<String> res = new ArrayList<>();

        // [1,3]
        // ["Push","Push","Pop","Push"]
        for(int i = 1; i <= len; i++) {
            res.add(PUSH);

            if (target[k] == i) {
                k++;
            } else {
                res.add(POP);
            }
        }

        return res;

    }
}
