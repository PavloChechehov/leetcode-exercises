package com.paul.blind75;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/">1061. Lexicographically Smallest Equivalent String</a>
 *
 */
public class LexicographicallySmallestEquivalentString {

    public static void main(String[] args) {
        String s1 = "adbfgjdi";
        String s2 = "bccgheej";
        String baseStr = "abcdefgheij";

        String s = smallestEquivalentString(s1, s2, baseStr);
        System.out.println(s);

    }

    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character, TreeSet<Character>> map = new HashMap<>();

        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            //no exists both
            if (!map.containsKey(c1) && !map.containsKey(c2)) {
                TreeSet<Character> values = new TreeSet<>();
                values.add(c1);
                values.add(c2);

                map.put(c1, values);
                map.put(c2, values);
            } else {
                //one of them exist;

                TreeSet<Character> values1 = map.get(c1);
                TreeSet<Character> values2 = map.get(c2);

                TreeSet<Character> newValues = new TreeSet<>();
                if (values1 != null) {
                    newValues.addAll(values1);
                }

                if (values2 != null) {
                    newValues.addAll(values2);
                }
                newValues.add(c1);
                newValues.add(c2);


                for (Character ch : newValues) {
                    map.put(ch, newValues);
                }

//                map.put(c1, newValues);
//                map.put(c2, newValues);
//
//                for (Character value : newValues) {
//                    if (value == c1 || value == c2) {
//                        continue;
//                    }
//
//                    TreeSet<Character> set = map.get(value);
//                    set.add(c1);
//                    set.add(c2);
//                }

            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            char v = baseStr.charAt(i);
            TreeSet<Character> set = map.get(v);
            if (set == null) {
                sb.append(v);
            } else {
                Character c = set.first();
                sb.append(c);
            }

        }

        return sb.toString();
    }
}

//            if (map.containsKey(c1)) {
//                TreeSet<Character> values1 = map.get(c1);
//
//                for (Character c : values1) {
//                    if (c == c1) continue;
//                    TreeSet<Character> values = map.get(c);
//                    values.add(c2);
//                }
//
//                values1.add(c1);
//            } else {
//                TreeSet<Character> values1 = new TreeSet<>();
//                values1.add(c1);
//                values1.add(c2);
//                map.put(c1, values1);
//                map.put(c2, values1);
//            }
//
//            if (map.containsKey(c2)) {
//                TreeSet<Character> values2 = map.get(c2);
//
//                for (Character c : values2) {
//                    if (c == c2) continue;
//                    TreeSet<Character> values = map.get(c);
//                    values.add(c1);
//                }
//
//                values2.add(c1);
//
//            } else {
//                TreeSet<Character> values2 = new TreeSet<>();
//                values2.add(c1);
//                values2.add(c2);
//                map.put(c1, values2);
//                map.put(c2, values2);
//            }
