package com.paul.google.week4;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * <a href="https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/">Number of Students Unable to Eat Lunch</a>
 */
public class NumberStudentsEatLunch {


    public int countStudents(int[] students, int[] sandwiches) {
        //students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
        // 1,1,1
        // 0,1,1
        // 0,1,0,1
        // 0,0,1,0,1

        //1
        //1

        //O(n^2)

        Deque<Integer> studentQueue = new ArrayDeque<>();

        for (int i : students) {
            studentQueue.add(i);
        }

        int s = 0;
        int k = 0;
        int len = sandwiches.length;

        while (s < len) {

            int st = studentQueue.removeFirst();
            int sandwich = sandwiches[s];

            if (st == sandwich) {
                k = 0;
                s++;
            } else {
                k++;
                studentQueue.add(st);
            }

            if (k == studentQueue.size()) {
                break;
            }

        }

        return studentQueue.size();
    }
}
