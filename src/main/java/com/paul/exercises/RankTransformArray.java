package com.paul.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * <a href="https://leetcode.com/problems/rank-transform-of-an-array/description/?envType=daily-question&envId=2026-07-12">1331. Rank Transform of an Array</a>
 */
public class RankTransformArray {

    public static void main(String[] args) {
        int[] arr = {37,12,28,9,100,56,80,5,12};

        int[] res = arrayRankTransform(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] dest = new int[n];
        System.arraycopy(arr, 0, dest, 0, n);

        Arrays.sort(dest);

        Map<Integer, Integer> map = new HashMap<>();

        int k = 1;
        for(int i = 0; i < n; i++) {
            if (!map.containsKey(dest[i])) {
                map.put(dest[i], k++);
            }
        }

        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            res[i] = map.get(arr[i]);
        }

        return res;
    }
}
