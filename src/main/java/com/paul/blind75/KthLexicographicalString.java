package com.paul.blind75;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * <a href="https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/">1415. The k-th Lexicographical String of All Happy Strings of Length n</a>
 */
public class KthLexicographicalString {

    private final char[] chars = {'a', 'b', 'c'};

    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        build(n, "", list);

        return list.size() >= k ? list.get(k - 1) : "";
    }


    //dfs
    private void build(int n, String s, List<String> list) {
        if (n == 0) {
            list.add(s);
            return;
        }

        for (char c : chars) {
            if (s.isEmpty()) {
                build(n - 1, String.valueOf(c), list);

            } else if (s.charAt(s.length() - 1) != c) {
                build(n - 1, s + c, list);
            }
        }
    }
}
