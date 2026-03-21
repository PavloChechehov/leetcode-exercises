package com.paul.blind75;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/assign-cookies/description/">455. Assign Cookies</a>
 */
public class AssignCookies {


    //2 pointers approach, complexity O(max(s.length, g.length))
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0;
        int r = 0;

        // g = [1,1,2,3],
        // l ->
        // s = [2,2]
        // r ->

        int gl = g.length;
        int sl = s.length;
        int count = 0;

        while (l < gl && r < sl) {

            if (g[l] <= s[r]) {
                count++;
                r++;
                l++;
            } else {
                r++;
            }
        }

        return count;
    }
}
