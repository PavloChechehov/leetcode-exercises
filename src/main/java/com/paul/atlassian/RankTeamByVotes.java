package com.paul.atlassian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * <a href="https://leetcode.com/problems/rank-teams-by-votes/">1366 Rank teams by votes</a>
 *
 */

public class RankTeamByVotes {

    public static void main(String[] args) {
//
//        Map<Character, Integer> map =
//                IntStream.rangeClosed('A', 'Z')
//                        .boxed()
//                        .collect(Collectors.toMap(
//                                i -> (char) i.intValue(),
//                                i -> 'Z' - i
//                        ));
//
//
//        System.out.println(map);

        String[] votes = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        String res = solution(votes);
        System.out.println(res);
    }

    //Right solution
    private static String solution(String[] votes) {
//        Map<Character, List<Integer>> map = new HashMap<>();
        int length = votes[0].length();
        String[] letters = votes[0].split("");
        Map<String, int[]> map = Arrays.stream(letters)
                .collect(Collectors.toMap(Function.identity(), s -> new int[length]));


        for (String vote : votes) {
            for (int i = 0; i < length; i++) {
                map.get(String.valueOf(vote.charAt(i)))[i]++;
            }
        }


        String result = map.entrySet()
                .stream().sorted((teams1, teams2) ->
                        {
                            int[] arr1 = teams1.getValue();
                            int[] arr2 = teams2.getValue();

                            for (int i = 0; i < arr1.length; i++) {
                                int a = arr1[i];
                                int b = arr2[i];
                                if (a != b) {
                                    return b - a;
                                }
                            }

                            return teams1.getKey().compareTo(teams2.getKey());
                        }

                )
                .map(Map.Entry::getKey)
                .collect(Collectors.joining());


        return result;
    }




    //Wrong solution
    /*private static String solution(String[] votes) {


        // letter, counter
        Map<Character, Integer> map = new HashMap<>();


        for (String vote : votes) {

            int length = votes[0].length();

            for (int j = 0; j < length; j++) {

                int adder = 26 - j;

                char letter = vote.charAt(j);
                if (map.containsKey(letter)) {
                    map.put(letter, map.get(letter) + adder);
                } else {
                    map.put(letter, adder);
                }
            }
        }


        String res = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .map(e -> e.getKey().toString())
                .collect(Collectors.joining(""));


        return res;

    }*/
}
