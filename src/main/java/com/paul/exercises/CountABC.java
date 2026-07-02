package com.paul.exercises;

import java.util.HashMap;
import java.util.Map;

public class CountABC {

    public static void main(String[] args) {
        String s = "abcabc";
        int res = numberOfSubstrings(s);
        System.out.println(res);
    }


    public static int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int n = s.length();
        int count = 0;

        int l = 0;
        int r = 0;

        while (r < n) {

            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() == 3) {
                count += n - r;

                char left = s.charAt(l++);
                map.put(left, map.get(left) - 1);

                if (map.get(left) == 0) {
                    map.remove(left);
                }
            }

            r++;

        }

        return count;
    }
}
