package com.paul.blind75;

/**
 * <a href="https://leetcode.com/problems/longest-uncommon-subsequence-i/description/">521. Longest Uncommon Subsequence I</a>
 */
public class LongestUncommonSubsequenceOne {

    public static void main(String[] args) {
        String a = "aaa";
        String b = "aaa";

        int res = findLUSlength(a, b);
        System.out.println(res);
    }

    // this is a solution,
    public static int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        } else {
            return Math.max(a.length(), b.length());
        }
    }
}
