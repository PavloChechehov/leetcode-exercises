package com.paul.blind75;

/**
 * <a href="https://leetcode.com/problems/add-digits/description/">258. Add Digits</a>
 */
public class AddDigits {

    public static void main(String[] args) {
        int n = 38;
        int res = addDigits(n);
        System.out.println(res == 2);
    }

    public static int addDigits(int num) {
        //38
        int curr = num;

        while(curr > 9) {

            int sum = 0;

            while(curr != 0) {
                sum += curr % 10;
                curr /= 10;
            }

            curr = sum;
        }

        return curr;
    }
}
