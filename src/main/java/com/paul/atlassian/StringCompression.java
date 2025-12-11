package com.paul.atlassian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StringCompression {
    public static void main(String[] args) {
        char[] letters = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int res = compress(letters);
        System.out.println(res);

    }

    // a,b,b,b ->
    // correct ab3 -> [a, b, 3] -> length is 3 return 3
    //, not this -> a1b3
    // b11 -> b1b10
        /*
        Input: chars = ["a","a","b","b","c","c","c"]
        Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

        a 2 b 2 c 3 -> 6

        Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
        Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
        Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".

        10 -> 1,0

        */


    public static int compress(char[] chars) {
        List<String> list = new ArrayList<>();
        int length = chars.length;
        int i = 0;

        while (i < length) {

            char curr = chars[i];
            int count = 0;
            while (i < length && chars[i] == curr) {
                i++;
                count++;
            }


            list.add(String.valueOf(curr));

            if (count > 1) {
                String[] number = String.valueOf(count).split("");
                Collections.addAll(list, number);
            }

        }

        for (int j = 0; j < list.size(); j++) {
            chars[j] = list.get(j).charAt(0);
        }


        return list.size();

    }


    //first approach
    /*public static int compress(char[] chars) {
        int res = 0;

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value == 1) {
                list.add(String.valueOf(entry.getKey()));

            } else if (value > 9) {
                String[] numbers = String.valueOf(value).split("");
                list.add(String.valueOf(entry.getKey()));
                list.addAll(Arrays.asList(numbers));
            } else {
                list.add(String.valueOf(entry.getKey()));
                list.add(String.valueOf(value));

            }
        }

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);

            chars[i] = s.charAt(0);

        }


        return list.size();
    }*/
}
