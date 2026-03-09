package com.paul.blind75;

public class ExcelSheetToInt {


    public static void main(String[] args) {
//        String s = "AB";
        String s = "ZY";
        int res = titleToNumber(s);
        System.out.println(res);
    }


    public static int titleToNumber(String columnTitle) {
        char[] columns = columnTitle.toCharArray();
        int n = columns.length;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            char c = columns[i];
            int temp = c - 64;
            sum = sum * 26 + temp;
        }

        return sum;
    }
}
