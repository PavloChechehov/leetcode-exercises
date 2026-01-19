package com.paul.google.week3;

import java.util.Arrays;
import java.util.Random;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/description/">11. Container With Most Water</a>
 */
public class ContainerWithMostWater {

    private static final Random random = new Random();

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            int[] arr = new int[random.nextInt(10)];

            for (int j = 0; j < arr.length; j++) {
                arr[j] = random.nextInt(10);
            }

            int res1 = bruteForce(arr);
            int res2 = maxArea(arr);

            String arrString = Arrays.toString(arr);
            if (res2 == res1) {
                System.out.println("Correct result: " + arrString);
            }

            if (res2 != res1) {
                System.out.println("Incorrect result: " + arrString);
                System.out.println("res1 = " + res1);
                System.out.println("res2 = " + res2);
                throw new RuntimeException("Bad result");
            }
        }

    }
    // two pointers solution to find the max area of water
    public static int maxArea(int[] height) {
        int len = height.length;
        int l = 0;
        int r = len - 1;
        int max = -1;

        while (l < r) {
            // calculate the area;

            int left = height[l];
            int right = height[r];

            int currArea = Math.min(left, right) * (r - l);

            if (left >= right) {
                r--;
            } else {
                l++;
            }

            max = Math.max(currArea, max);

        }

        return max;
    }

    public static int bruteForce(int[] height) {
        // x1 -> x2 is max
        // height of max(x1) and before max(x2)


        int len = height.length;
        int max = -1;
        for (int i = 0; i < len - 1; i++) {

            int currHeight = height[i];

            for (int j = i + 1; j < len; j++) {

                int area = (j - i) * Math.min(currHeight, height[j]);
                max = Math.max(area, max);

            }

        }

        return max;
    }
}
