package com.paul.exercises;

public class FindSpecial {
    public static void main(String[] args) {
        String w = "AbBCab";
        int res = findSpecial(w);
        System.out.println(res);
        int[] arr = {1, 2, 3, 4, 5};

        //descending order
//        Arrays.sort(arr, (a, b) -> Integer.compare(b, a));
    }

    private static int findSpecial(String word) {
        boolean[] lowers = new boolean[26];
        boolean[] uppers = new boolean[26];

        int n = word.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);

            if (Character.isLowerCase(c) ) {
                lowers[c - 'a'] = true;
            } else {
                char lower = Character.toLowerCase(c);

                if (lowers[lower - 'a'] && !uppers[c - 'A']) {
                    count++;
                    uppers[c - 'A'] = true;
                }
            }

        }
        return count;
    }
}
