package com.paul.google.week4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * <a href="https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/">373. Find K Pairs with Smallest Sums</a>
 */

/**
 * The pair data container class
 * @param i is index of first array
 * @param j is index of second array
 * @param sum sum of nums1[i] + nums2[j]
 */
record Pair(int i, int j, int sum) {
}

public class FindKPairs {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 5, 6};
        int[] nums2 = {3, 5, 7, 9};

        int k = 3;
        List<List<Integer>> lists = kSmallestPairs(nums1, nums2, k);
        System.out.println(lists);
    }


    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::sum));

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.add(new Pair(i, 0, nums1[i] + nums2[0]));
        }

        /*
        while (k > 0 AND heap not empty):
            pop smallest (i, j)
            add result
            k--
            if j + 1 exists:
            push (i, j + 1)
        */

        // Initialize with (i, 0)
        // Extract k smallest pairs
        while (k > 0 && !pq.isEmpty()) {
            Pair p = pq.poll();
            int i = p.i();
            int j = p.j();

            res.add(List.of(nums1[i], nums2[j]));
            k--;

            // Push next pair from the same row
            if (j + 1 < nums2.length) {
                pq.add(new Pair(i, j + 1, nums1[i] + nums2[j + 1]));
            }
        }

        return res;
    }


//first iteration: brute force
    /*public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::sum));

        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                int sum = nums1[i] + nums2[j];

                // if (sum > pq.peek() && pq.size() < k) break;

                if (pq.size() < k) {
                    pq.add(new Pair(nums1[i], nums2[j], sum));
                } else {
                    break;
                }
            }

        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            Pair p = pq.poll();
            res.add(List.of(p.x(), p.y()));
        }


        return res;
    }*/
}

