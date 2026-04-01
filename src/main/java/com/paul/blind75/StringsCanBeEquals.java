package com.paul.blind75;

public class StringsCanBeEquals {

    public static void main(String[] args) {
        String s1 = "zzon";
        String s2 = "zozn";

        boolean res = canBeEqual(s1, s2);
        System.out.println(res);
    }

    public static boolean canBeEqual(String s1, String s2) {
        //abcd
        //cdab

        char[] s1a = s1.toCharArray();
        char[] s2a = s2.toCharArray();

        int s1l = s1.length();
        int s2l = s2.length();
        int count = 2;

        for (int i = 0; i < s1l; i++) {

            int j = i;
            for (; j < s2l; j++) {
                if (s1a[i] == s2a[j]) break;
            }

            if (i != j && j < s2l) {
                char temp = s1a[i];
                s1a[i] = s1a[j];
                s1a[j] = temp;
                count--;
            }

            if (count == 0) break;
        }

        String newS1 = new String(s1a);

        return newS1.equals(s2) && count == 0;
    }
}
