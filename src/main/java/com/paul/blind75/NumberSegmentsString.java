package com.paul.blind75;

/**
 * <a href="https://leetcode.com/problems/number-of-segments-in-a-string/description/">Number of Segments in a String</a>
 *
 */
public class NumberSegmentsString {
    public static void main(String[] args) {
//        String s = "Hello, my name is John";
        String s = ". . . / , , , adf asd        asf";
        int res = countSegments(s);
        System.out.println(res);
    }


    public static int countSegments(String s) {

        if (s == null || s.isEmpty()) return 0;
        String[] arr = s.split(" ");
        int count = 0;

        for (String v : arr) {
            if (!v.isEmpty()) count++;
        }

        return count;
    }

}
