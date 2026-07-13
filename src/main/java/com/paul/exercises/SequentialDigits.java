package com.paul.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/sequential-digits/description/?envType=daily-question&envId=2026-07-13">1291. Sequential Digits</a>
 *
 */
public class SequentialDigits {


    public static void main(String[] args) {
        int low = 100;
        int high = 300;
        List<Integer> res = sequentialDigits(low, high);
        System.out.println(res);
    }


    public static List<Integer> sequentialDigits(int low, int high) {

        List<Integer> list = List.of(12, 123, 1234, 12345, 123456, 1234567, 12345678, 123456789);
        List<Integer> incr = List.of(11, 111, 1111, 11111, 111111, 1111111, 11111111, 111111111);

        List<Integer> res = new ArrayList<>();

        int index = 0;

        for (Integer elem : list) {

            Integer inc = incr.get(index);

            for (int i = elem; i % 10 != 0; i += inc) {

                if (i < low) {
                    continue;
                }

                if (i > high) {
                    return res;
                }

                res.add(i);
            }

            index++;
        }

        return res;
    }
}
