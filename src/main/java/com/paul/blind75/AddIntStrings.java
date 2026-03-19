package com.paul.blind75;


/**
 * <a href="https://leetcode.com/problems/add-strings/description/">415. Add Strings</a>
 */
public class AddIntStrings {

    public static void main(String[] args) {
        String first = "9";
        String second = "99";
        String res = addStrings(first, second);
        System.out.println(res);

    }

    public static String addStrings(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        // 11
        //123

        int prev = 0;
        StringBuilder sb = new StringBuilder();

        while (n1 >= 0 && n2 >= 0) {

            int first = num1.charAt(n1) - '0';
            int second = num2.charAt(n2) - '0';

            int sum = first + second + prev;

            if (sum > 9) {
                sum = sum % 10;
                prev = 1;
            } else {
                prev = 0;

            }

            sb.insert(0, sum);

            n1--;
            n2--;
        }

        if (n1 >= 0) {

            while (n1 >= 0) {
                int value = num1.charAt(n1) - '0' + prev;
                if (value > 9) {
                    value = value % 10;
                    prev = 1;
                } else {
                    prev = 0;

                }
                sb.insert(0, value);
                n1--;
            }


        } else if (n2 >= 0) {

            while (n2 >= 0) {
                int value = num2.charAt(n2) - '0' + prev;
                if (value > 9) {
                    value = value % 10;
                    prev = 1;
                } else {
                    prev = 0;

                }
                sb.insert(0, value);
                n2--;
            }
        }

        if (prev == 1) {
            sb.insert(0, prev);
        }


        return sb.toString();
    }
}
