package com.paul.blind75;

import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/description/">1758. Minimum Changes To Make Alternating Binary String</a>
 *
 */

class MinimumChangesToMakeAlternatingBinaryString {

    private Map<Character, Character> map = Map.of(
            '0', '1',
            '1', '0'
    );

    public int minOperations(String s) {
        if (s == null || s.isBlank())
            return 0;

        char[] letters = s.toCharArray();
        int counter1 = calculateCounter(letters, '0');
        int counter2 = calculateCounter(letters, '1');

        return Math.min(counter1, counter2);
    }

    private int calculateCounter(char[] letters, char expected) {
        int n = letters.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (expected != letters[i]) { // 0 == 1
                count++; // 1
            }
            expected = map.get(expected);
        }

        return count;
    }
}
