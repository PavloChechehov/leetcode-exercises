package com.paul.blind75;

/**
 * <a href="https://leetcode.com/problems/binary-gap/description/">868. Binary Gap</a>
 */
public class BinaryGap {

    public static void main(String[] args) {
        int n = 150;
        int res = binaryGap(n);
        System.out.println(res);
    }


    public static int binaryGap(int n) {
        String binary = Integer.toBinaryString(n);

        int l = 0;
        int r = 0;
        int len = binary.length();
        int max = 0;

        //1 1 1 1 0
        //        r
        //        l
        while(l <= r && r < len) {
            if(l == r || binary.charAt(r) == '0') {
                r++;
            }

            if(binary.charAt(l) == '0') {
                l++;
            }

            if(r < len && binary.charAt(r) == '1' && binary.charAt(l) == '1') {
                max = Math.max(r - l, max);
                l++;
                r++;
            }


        }

        return max;

    }
}
