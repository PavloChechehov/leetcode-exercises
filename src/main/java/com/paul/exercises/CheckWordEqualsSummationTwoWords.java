package com.paul.exercises;


/**
 * <a href="https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/description/"> 1880. Check if Word Equals Summation of Two Words</a>
 */
public class CheckWordEqualsSummationTwoWords {


    public static void main(String[] args) {
        String firstWord = "acb";
        String secondWord = "cba";
        String targetWord = "cdb";
        boolean res = isSumEqual(firstWord, secondWord, targetWord);
        System.out.println(res);
    }

    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {

        int first = convert(firstWord);
        int second = convert(secondWord);

        int res = first + second;

        int target = convert(targetWord);

        return res == target;
    }

    private static int convert(String word) {
        int l = 0;
        int n = word.length();

        while (l < n) {
            if (word.charAt(l) == 'a') {
                l++;
            } else {
                break;
            }
        }

        int k = 1;
        int res = 0;

        for (int i = n - 1; i >= l; i--) {
            int v = word.charAt(i) - 'a';
            res += k * v;
            k *= 10;
        }

        return res;
    }

}
