package com.paul.google.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * <a href="https://leetcode.com/problems/keyboard-row/description/">500. Keyboard Row</a>
 */
public class KeyboardRow {
    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] res = findWords(words);
        System.out.println(Arrays.toString(res));
    }



    // I think this solution is not optimal, however it works. Maybe I will return back to check more optimal
    public static String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";


        Set<Character> rowSet1 = getSet(row1);
        Set<Character> rowSet2 = getSet(row2);
        Set<Character> rowSet3 = getSet(row3);

        List<Set<Character>> rows = List.of(rowSet1, rowSet2, rowSet3);

        List<String> res = new ArrayList<>();
        for (String word : words) {

            String lowercase = word.toLowerCase();
            for (Set<Character> row : rows) {

                int count = 0;

                for (int i = 0; i < lowercase.length(); i++) {
                    char ch = lowercase.charAt(i);

                    if (row.contains(ch)) {
                        count++;
                    } else {
                        break;
                    }
                }

                if (count == lowercase.length()) {
                    res.add(word);
                    break;
                }

                if (count != 0) {
                    break;
                }
            }
        }
//["Alaska","Dad"]
        return res.toArray(new String[0]);
    }

    private static Set<Character> getSet(String row1) {
        return row1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
    }
}
