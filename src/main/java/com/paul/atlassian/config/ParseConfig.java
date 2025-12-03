package com.paul.atlassian.config;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ParseConfig {
    public static void main(String[] args) {
        String s = """
                        timeout=30
                        mode=debug
                        maxUsers=200
                        enabled=true
                        someKey=
                        =value
                        #key=value
                        timeout=45
                """;


        Map<String, String> res = parseConfig(s);
    }


    public static Map<String, String> parseConfig(String config) {

        String[] lines = config.split("\n");
        Map<String, String> res = Arrays.stream(lines)
//                .filter(s -> !s.isBlank() || s.startsWith("#")) // my solution
                .filter(s -> !s.isBlank() && !s.stripLeading().startsWith("#"))
                .peek(System.out::println)
                .map(s -> s.split("=", 2))
                .filter(parts -> parts.length == 2 && !parts[0].isBlank())
                .map(parts -> Map.entry(parts[0].trim(), parts[1].trim()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal) -> newVal));

        System.out.println(res);
        return res;
    }

}
