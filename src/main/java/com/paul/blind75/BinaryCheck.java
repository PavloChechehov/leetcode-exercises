package com.paul.blind75;

import java.util.Arrays;


/**
 * <a href="https://leetcode.com/problems/find-unique-binary-string/description/">1980. Find Unique Binary String</a>
 */
public class BinaryCheck {

    public static void main(String[] args) {
        String[] binaries = {"00", "01"};

        String res = findDifferentBinaryString(binaries);
        System.out.println(res);
    }


    public static String findDifferentBinaryString(String[] nums) {
        if (nums.length == 0) return "0";

        int n = nums.length;
        int len = nums[0].length();

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            String binary = Integer.toBinaryString(i);

            while (binary.length() != len) binary = "0" + binary;

            if (!binary.equals(nums[i])) {
                return binary;
            }
        }


        String binary = Integer.toBinaryString(n);
        while (binary.length() != len) binary = "0" + binary;

        return binary;
    }
}
