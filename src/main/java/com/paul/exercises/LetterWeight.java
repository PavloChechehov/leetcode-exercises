package com.paul.exercises;

//https://leetcode.com/problems/weighted-word-mapping/?envType=daily-question&envId=2026-06-13

public class LetterWeight {

    public static void main(String[] args) {
        String[] words = {"abcd","def","xyz"};
        int[] weights = {5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2};
        String res = mapWordWeights(words, weights);
        System.out.println(res);
    }

    public static String mapWordWeights(String[] words, int[] weights) {
        String alphabet = "zyxwvutsrqponmlkjihgfedcba";
        StringBuilder sb = new StringBuilder();

        for(String s: words) {
            int sum = 0;

            for(int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                sum += weights[c];
            }

            sb.append(alphabet.charAt(sum % 26));
        }

        return sb.toString();
    }
}
