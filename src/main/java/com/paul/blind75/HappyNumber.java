package com.paul.blind75;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/happy-number/description/">202. Happy Number</a>
 */
public class HappyNumber {

    public static void main(String[] args) {
//        int n = 19;
        int n = 2;
        boolean res = isHappy(n);
        System.out.println(res);
    }


    public static boolean isHappy(int n) {
        //19
        //19%10 = 10
        //19/10 = 1
        //1/10 = 1 = 0
        Set<Integer> duplicates = new HashSet<>();

        int temp = n;
        int sum = 0;

        while (true) {

            while (temp != 0) {
                int mod = temp % 10;
                sum += mod * mod;
                temp /= 10;
            }

            if (sum == 1) break;
            if (duplicates.contains(sum)) {
                break;
            } else {
                duplicates.add(sum);
            }

            temp = sum;
            sum = 0;

        }


        return sum == 1;
    }
}
