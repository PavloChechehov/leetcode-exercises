package com.paul.blind75;

import java.util.HashSet;
import java.util.Set;

public class CheckStringsCanMadeEqualWithOperations2 {

    public static void main(String[] args) {
        String s1 = "abcdba";
        String s2 = "cabdab";

        boolean res = checkStrings(s1, s2);
        System.out.println(res);
    }


    public static boolean checkStrings(String s1, String s2) {
        if (s1.equals(s2)) return true;

//        String curr = s1;

        Set<String> set = new HashSet<>();
        set.add(s1);

        int n = s1.length();

        while (true) {

            for (int i = 0; i < n - 1; i++) {

                char[] temp = s1.toCharArray();
                /*
                    "cbadba".
                    "cbbdaa".
                    "cabdab"
                */


                for (int j = i + 1; j < n; j++) {

                    if ((j - i) % 2 == 1) continue;

                    //swap
                    if (temp[j] == s2.charAt(i)) {

                        char c = temp[i];
                        temp[i] = temp[j];
                        temp[j] = c;
                    }

                    s1 = new String(temp);

                }


                if (set.contains(s1)) {
                    return false;
                }
                if (s1.equals(s2)) return true;
                set.add(s1);
            }
        }
    }
}
