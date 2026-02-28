package com.paul.blind75;

/**
 * <a href="https://leetcode.com/problems/palindrome-number/description/">9. Palindrome Number</a>
 */
public class PalindromeProblem {

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);


        int l = 0;
        int r = s.length() - 1;

        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;

            l++;
            r--;

        }

        return true;
    }
}
