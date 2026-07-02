package com.paul.exercises;

public class ProcessStringWithSpecialOperations {


    public static void main(String[] args) {
        String s = "a#b%*";
        String res = processStr(s);
        System.out.println(res);
    }


    public static String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        int n = s.length();
        for(char c: s.toCharArray()) {

            if (Character.isLetter(c)) {
                sb.append(c);
            } else if (c == '#') {
                sb.append(sb);
            } else if (c == '%') {
                sb.reverse();
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }

        }

        return sb.toString();
    }
}
