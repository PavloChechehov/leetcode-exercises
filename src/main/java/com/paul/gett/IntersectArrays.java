package com.paul.gett;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectArrays {
    public static void main(String[] args) {
        int[] arr1 = {4, 9, 5};
        int[] arr2 = {9, 4, 9, 8, 4};

        int[] res = intersection(arr1, arr2);
        System.out.println(Arrays.toString(res));

    }


    private static int[] intersection(int[] a, int[] b) {
        // arr1 < arr2
        // Set(arr1) and Set(arr2)
        // Set(empty) put 4, 9,
        //        int[] arr1 = {4, 9, 5};
        //        int[] arr2 = {9, 4, 9, 8, 4};
        // O(n * m)
        // O(n + m)

        // sort both
        // O(n + m)
        // Do not sort unless you want to show a second solution.



        // arr1 < arr2

        // O(n * m) ~ O(n^2) - quadratic time complexity

//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < b.length; j++) {
//
//            }
//        }


        //we can use the Set too instead the Map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.put(i, i);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : b) {
            if (map.containsKey(i)) {
                map2.put(i, i);
            }
        }


        int[] res = new int[map2.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            res[i++] = entry.getKey();
        }


        return res;
    }
}
