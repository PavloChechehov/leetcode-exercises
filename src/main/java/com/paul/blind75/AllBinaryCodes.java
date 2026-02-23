package com.paul.blind75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 *
 * <a href="https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/">1461. Check If a String Contains All Binary Codes of Size K</a>
 */

public class AllBinaryCodes {


    public static void main(String[] args) {
        String s = "1011100";
        int k = 3;
        boolean res = hasAllCodes(s, k);
        System.out.println(res);
    }


    public static boolean hasAllCodes(String s, int k) {

        if (s.length() < k) return false;


        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            seen.add(s.substring(i, i + k));
        }

        for (int i = 0; i < (1 << k); i++) {
            String binary = String.format("%" + k + "s",
                            Integer.toBinaryString(i))
                    .replace(' ', '0');

            if(!seen.contains(binary)) return false;
        }

        return true;
    }

    //solution 1 incorrect
    /*public static boolean hasAllCodes(String s, int k) {
        List<String> binaryCodes = new ArrayList<>();


        if (k == 1) {

            binaryCodes.add("0");
            binaryCodes.add("1");

        } else if (k == 2) {

            binaryCodes.add("00");
            binaryCodes.add("01");
            binaryCodes.add("10");
            binaryCodes.add("11");

        } else {

            int i = 4;

            while (true) {

                String binary = Integer.toBinaryString(i++);

                if (binary.length() == k) {

                    binaryCodes.add(binary);

                } else if (binary.length() > k) {
                    break;
                }
            }

            System.out.println(binaryCodes);
        }

        for (String code : binaryCodes) {

            if (!s.contains(code))
                return false;

        }

        return true;
    }*/
}
