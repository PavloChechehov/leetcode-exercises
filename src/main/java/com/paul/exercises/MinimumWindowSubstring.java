package com.paul.exercises;

import java.util.ArrayList;
import java.util.List;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        char a = 'a';
        char c = 'C';

        String s = "a";
        String t = "a";

        String res = minWindow(s, t);
        System.out.println(res);

    }

    public static String minWindow(String s, String t) {
        // cdbaebaecd
        // abc

        int[] letters = new int[52];
        int count = 0;
        int strLen = s.length();
        int checkLen = t.length();

        int l = 0;
        int r = 0;

        List<String> list = new ArrayList<>();

        while (r < strLen) {

            char c = s.charAt(r);
            if (t.indexOf(c) != -1) {

                int letCount = letters[c - 'A'];
                if (letCount == 0) {
                    count++;
                }

                letters[c - 'A']++;
            }

            if (count == checkLen) {
                list.add(s.substring(l, r + 1));

                while (l < strLen) {

                    char lChar = s.charAt(l);
                    int leftCount = letters[lChar - 'A'];

                    if (leftCount == 0) {
                        break;
                    }

                    letters[lChar - 'A']--;
                    l++;
                }
            }

            r++;
        }

        list.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return Integer.compare(o1.length(), o2.length());
            }
            return o1.compareTo(o2);
        });

        return list.get(0);
    }

}
