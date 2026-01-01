package com.paul.google.week2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * This problem is a classic Monotonic Stack problem.
 * <a href="https://leetcode.com/problems/daily-temperatures/description/">739. Daily Temperatures</a>
 */
public class DailyTemperatures {

    public static void main(String[] args) {

        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] res = dailyTemperatures(nums);
        // [1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(res));

    }



    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        // Stack holds indices of days
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Resolve all previous days that are colder than today
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDayIndex = stack.pop();
                res[prevDayIndex] = i - prevDayIndex;
            }

            // This day is now waiting for a warmer day
            stack.push(i);
        }

        // Remaining indices in stack have no warmer day → res already 0
        return res;
    }



    //Time complexity is O(n²), so it exceeds the constraints with the data where temperatures.length >= 10^5
/*    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];


        for (int i = 0; i < length - 1; i++) {

            int curr = temperatures[i];
            int count = 0;

            int j = i + 1;
            for (; j < length; j++) {
                count++;
                if (temperatures[j] > curr) {
                    break;
                }
            }

            if (j == length) {
                res[i] = 0;
            } else {
                res[i] = count;
            }


        }

        return res;
    }*/
}
