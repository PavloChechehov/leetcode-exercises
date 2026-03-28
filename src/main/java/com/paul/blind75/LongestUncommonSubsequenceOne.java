package com.paul.blind75;

/**
 * <a href="https://leetcode.com/problems/longest-uncommon-subsequence-i/description/">521. Longest Uncommon Subsequence I</a>
 */
public class LongestUncommonSubsequenceOne {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;

        int la = a.length();
        int lb = b.length();
        int p1 = 0;
        int p2 = 0;
        int count = 0;

        while(p1 < la && p2 < lb) {
            if(a.charAt(p1) == b.charAt(p2)) {
                count++;
            }

            p1++;
            p2++;
        }



        int min = Math.min(a.length(), b.length());

        if (count <= min) {
            return Math.max(a.length(), b.length());
        } else {
            return -1;
        }

    }
}
