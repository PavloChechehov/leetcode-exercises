package com.paul.blind75;

import java.util.Map;

public class MinimumNumberFlipsMakeBinaryStringAlternating {

    public static void main(String[] args) {
        String s = "01001001101";
        int res = minFlips(s);
        System.out.println(res);
    }


    private static Map<Character, Character> map = Map.of(
            '0', '1',
            '1', '0');

    public static int minFlips(String s) {
        if (s == null || s.isBlank())
            return 0;

        int counter1 = calculateCounter(s.toCharArray(), '0');
        int counter2 = calculateCounter(s.toCharArray(), '1');

        return Math.min(counter1, counter2);
    }

    private static int calculateCounter(char[] letters, char expected) {
        int n = letters.length;
        int count = 0;

        //111000
        for (int i = 0; i < n - 1; i++) {

            if (expected != letters[i]) {

                for (int j = i + 1; j < n; j++) {

                    if (expected == letters[j]) {

                        char temp = letters[j];
                        letters[j] = letters[i];
                        letters[i] = temp;
                        break;

                    }

                }

                count++;

            }
            expected = map.get(expected);
        }

        return count;
    }
}
