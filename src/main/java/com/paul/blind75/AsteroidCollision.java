package com.paul.blind75;

import java.util.Arrays;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/asteroid-collision/description/">735. Asteroid Collision</a>
 */
public class AsteroidCollision {

    public static void main(String[] args) {
        int[] nums = {-2, 2, -1, -2};
        int[] res = asteroidCollision(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        //-1,-2,6,2,3,5 == -1,-2,6,2,3,5
        //4,2,1,-10 == -10
        //1,-2,3,-5 =

        //3,5,-6,2,-1,4

        Stack<Integer> rightAsteroids = new Stack<>();
        Stack<Integer> leftAsteroids = new Stack<>();
        int n = asteroids.length;
        Integer prev = null;

        for (int i = n - 1; i >= 0; i--) {

            int a = asteroids[i];

            //-2,2,-1,-2
            if (a >= 0) {

                if (leftAsteroids.isEmpty()) {
                    rightAsteroids.add(a);
                } else {

                    while (!leftAsteroids.isEmpty()) {
                        int leftAbs = Math.abs(leftAsteroids.peek());

                        if (a > leftAbs) {
                            leftAsteroids.pop();
                        } else {
                            break;
                        }

                    }

                    if (leftAsteroids.isEmpty()) {
                        rightAsteroids.add(a);
                    } else if (a == Math.abs(leftAsteroids.peek())) {
                        leftAsteroids.pop();
                    }
                }
            } else {
                leftAsteroids.add(a);
            }

        }

        int[] res = new int[leftAsteroids.size() + rightAsteroids.size()];

        int i = 0;

        while (!leftAsteroids.isEmpty()) {
            res[i++] = leftAsteroids.pop();
        }

        while (!rightAsteroids.isEmpty()) {
            res[i++] = rightAsteroids.pop();
        }

        // Arrays.sort(res);
        return res;
    }
}
