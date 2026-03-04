package com.paul.blind75;

/**
 * <a href="https://leetcode.com/problems/add-binary/description/">67. Add Binary</a>
 */
public class BinarySum {


    public static void main(String[] args) {

        String a = "1";
        String b = "111";

        String res = addBinary(a, b);
        System.out.println(res);

    }



    public static String addBinary(String a, String b) {
        // 1010
        // 1011
        //10101


        int p1 = a.length() - 1;
        int p2 = b.length() - 1;

        StringBuilder sb = new StringBuilder();
        int prev = 0;

        while (p1 >= 0 && p2 >= 0) {
            int v1 = a.charAt(p1) == '0' ? 0 : 1;
            int v2 = b.charAt(p2) == '0' ? 0 : 1;

            int sum = v1 + v2 + prev;

            if (sum == 0) {
                sb.insert(0, "0");
                prev = 0;
            } else if (sum == 1) {
                sb.insert(0, "1");
                prev = 0;
            } else if (sum == 2) {
                sb.insert(0, "0");
                prev = 1;
            } else {
                sb.insert(0, "1");
                prev = 1;
            }
            p1--;
            p2--;

        }

        while (p1 >= 0) {
            int v1 = a.charAt(p1) == '0' ? 0 : 1;
            int sum = v1 + prev;

            if (sum == 0) {
                sb.insert(0, "0");
                prev = 0;
            } else if (sum == 1) {
                sb.insert(0, "1");
                prev = 0;
            } else {
                sb.insert(0, "0");
                prev = 1;
            }
            p1--;
        }

        while (p2 >= 0) {
            int v2 = b.charAt(p2) == '0' ? 0 : 1;
            int sum = v2 + prev;

            if (sum == 0) {
                sb.insert(0, "0");
                prev = 0;
            } else if (sum == 1) {
                sb.insert(0, "1");
                prev = 0;
            } else {
                sb.insert(0, "0");
                prev = 1;
            }
            p2--;
        }

        if (prev != 0) {
            sb.insert(0, "1");
        }

        return sb.toString();
    }
}
