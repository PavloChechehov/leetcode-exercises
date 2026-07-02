package com.paul.exercises;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/beautiful-array/description/">Beautiful Array</a>
 */
public class BeautifulArray {

    public static void main(String[] args) {
        int[] res = beautifulArray(5);
        System.out.println(Arrays.toString(res));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.addAll(Arrays.stream(res).boxed().toList());
    }


    public static int[] beautifulArray(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);

        while (res.size() < n) {
            List<Integer> next = new ArrayList<>();

            for (int x : res) {
                if (2 * x - 1 <= n) {
                    next.add(2 * x - 1);
                }
            }

            for (int x : res) {
                if (2 * x <= n) {
                    next.add(2 * x);
                }
            }


            res = next;
        }

        return res.stream().mapToInt(v -> v).toArray();
    }
}
