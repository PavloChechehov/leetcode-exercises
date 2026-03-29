package com.paul.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/description/">438. Find All Anagrams in a String</a>
 */
public class FindAllAnagramsString {

    public List<Integer> findAnagrams(String original, String check) {
        //cbaebabacd
        //abc
        int l = check.length();
        int n = original.length();



        int[] letters = new int[26];
        int[] originals = new int[26];


        for(char c: check.toCharArray()) {
            letters[c - 'a'] += 1;
        }

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < Math.min(n, l); i++) {
            originals[original.charAt(i) - 'a'] += 1;
        }

        for(int i = l; i < n; i++) {
            if (Arrays.equals(originals, letters)) {
                res.add(i - l);
            }
            originals[original.charAt(i) - 'a'] += 1;
            originals[original.charAt(i - l) - 'a'] -= 1;

        }

        if (Arrays.equals(originals, letters)) {
            res.add(n - l);
        }

        return res;
    }
}
