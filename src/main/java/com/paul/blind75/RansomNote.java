package com.paul.blind75;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/ransom-note/description/">383. Ransom Note</a>
 */
public class RansomNote {
    public static void main(String[] args) {
        boolean res = canConstruct("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj");
        System.out.println(res);
    }

    //2 pointers, complexity O(n * log(n))
    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] magazineChars = magazine.toCharArray();
        char[] ransomNoteChars = ransomNote.toCharArray();

        int len1 = ransomNote.length();
        int len2 = magazine.length();

        //n * log(n)
        Arrays.sort(magazineChars);
        Arrays.sort(ransomNoteChars);

        int r = 0;
        int m = 0;


        while(r < len1 && m < len2) {

            if (ransomNoteChars[r] == magazineChars[m]) {
                r++;
                m++;

            } else {

                if (ransomNoteChars[r] > magazineChars[m] || (m + 1 < len2 && magazineChars[m] == magazineChars[m + 1])) {
                    m++;
                } else {
                    return false;
                }

            }
        }

        return r == len1;
    }
}
