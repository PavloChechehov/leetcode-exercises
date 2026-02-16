package com.paul.blind75;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/max-number-of-k-sum-pairs/description">1679. Max Number of K-Sum Pairs</a>
 */
public class MaxKSumPairs {

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int elem : nums) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }

        int counter = 0;
        for (int i : nums) {

            Integer indexSize = map.get(i);
            if (i + i == k) {
                if (indexSize > 1) {
                    map.put(i, map.get(i) - 2);
                    counter++;
                }
            } else {
                Integer indexKSize = map.get(k - i);
                if ((indexSize != null && indexSize > 0)
                        && (indexKSize != null && indexKSize > 0)) {
                    map.put(i, map.get(i) - 1);
                    map.put(k - i, map.get(k - i) - 1);
                    counter++;
                }
            }
        }

        return counter;
    }
}
