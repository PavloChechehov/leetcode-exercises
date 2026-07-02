package com.paul.exercises;

import java.util.HashMap;
import java.util.Map;

public class CheckNumber {

    public static void main(String[] args) {
        String num = "1210";
        boolean res = digitCount(num);
        System.out.println(res);
    }


    public static boolean digitCount(String num) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < num.length(); i++) {
            map.put(num.charAt(i), map.getOrDefault(num.charAt(i), 0) + 1);
        }

//        Input: num = "1210"
//        Output: true
//        Explanation:
//        num[0] = '1'. The digit 0 occurs once in num.
//        num[1] = '2'. The digit 1 occurs twice in num.
//        num[2] = '1'. The digit 2 occurs once in num.
//        num[3] = '0'. The digit 3 occurs zero times in num.

        for (int i = 0; i < num.length(); i++) {
            char count = num.charAt(i);

            Integer sum = map.get((char) (i + '0'));


            if (sum == null && count != '0') {
                return false;
            } else if (sum == null && count == '0') {
                continue;
            } else if ((int) count - '0' != sum) {
                return false;
            }


        }

        return true;
    }
}
