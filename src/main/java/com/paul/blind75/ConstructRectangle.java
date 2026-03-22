package com.paul.blind75;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/construct-the-rectangle/description/">492. Construct the Rectangle</a>
 */
public class ConstructRectangle {

    public static void main(String[] args) {
        int n = 122122;
        int[] res = constructRectangle(n);
        System.out.println(Arrays.toString(res));
    }

    public static int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);

        while (area % w != 0) {
            w--;
        }

        return new int[]{area / w, w};
    }
}
