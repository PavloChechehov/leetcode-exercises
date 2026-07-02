package com.paul.exercises;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class MajorityFrequencyCharacters {



    public static void main(String[] args) {
        String s = "adnphaoxnu";
        String res = majorityFrequencyGroup(s);
        System.out.println(res);

//        Output: "ab"
    }


    public static String majorityFrequencyGroup(String s) {

        Map<Character, Long> result =
                s.chars()
                        .mapToObj(c -> (char) c)
                        .collect(groupingBy(
                                Function.identity(),
                                counting()
                        ));

        Map<Long, List<Character>> sortedDesc =
                result.entrySet().stream()
                        .collect(Collectors.groupingBy(
                                Map.Entry::getValue,
                                () -> new TreeMap<Long, List<Character>>(Comparator.reverseOrder()),
                                Collectors.mapping(
                                        Map.Entry::getKey,
                                        Collectors.toList()
                                )
                        ));


        for (Map.Entry<Long, List<Character>> entry : sortedDesc.entrySet()) {

            int size = entry.getValue().size();
            int count = entry.getKey().intValue();

            if ((size * count) >= s.length()/2) {
                List<Character> list = entry.getValue();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < entry.getValue().size(); i++) {
                    sb.append(list.get(i));
                }
                return sb.toString();
            }
        }

        return s;
    }
}
