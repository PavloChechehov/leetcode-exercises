package com.paul.blind75;

import java.util.HashMap;
import java.util.Map;


/**
 * <a href="https://leetcode.com/problems/contains-duplicate-ii/description/">219. Contains Duplicate II</a>
 */
public class ContainsNearbyDuplicates {


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int v = nums[i];
            if (map.containsKey(v)) {
                if (Math.abs(map.get(v) - i) <= k) {
                    return true;
                }
            }

            map.put(v, i);

        }

        return false;
    }
}
