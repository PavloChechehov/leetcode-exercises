package com.paul.exercises;

import java.util.HashMap;
import java.util.Map;

public class MinimumDistanceTypeWordUsingTwoFingers {

    private static final char[][] letters = {
            {'A', 'B', 'C', 'D', 'E', 'F'},
            {'G', 'H', 'I', 'J', 'K', 'L'},
            {'M', 'N', 'O', 'P', 'Q', 'R'},
            {'S', 'T', 'U', 'V', 'W', 'X'},
            {'Y', 'Z', '0', '0', '0', '0'},
    };

    public static void main(String[] args) {
        String s = "HAPPY";
        int res = minimumDistance(s);
        System.out.println(res);
    }

    public static int minimumDistance(String word) {
        Map<Character, Point> map = new HashMap<>();

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters[0].length; j++) {
                if (letters[i][j] != '0') {
                    map.put(letters[i][j], new Point(i, j));
                }
            }
        }

        int res = 0;

        int n = word.length();
        for (int i = 0; i < n; i += 2) {
            char c1 = word.charAt(i);

            if (i + 1 < n) {
                char c2 = word.charAt(i + 1);
                Point p1 = map.get(c1);
                Point p2 = map.get(c2);
                int distance = Math.abs(p1.x() - p2.x()) + Math.abs(p1.y() - p2.y());
                res += distance;
            } else {
                char c2 = word.charAt(0);
                Point p1 = map.get(c1);
                Point p2 = map.get(c2);
                int distance = Math.abs(p1.x() - p2.x()) + Math.abs(p1.y() - p2.y());
                res += distance;
            }
        }

        return res;

    }

}

record Point(int x, int y) {
}
