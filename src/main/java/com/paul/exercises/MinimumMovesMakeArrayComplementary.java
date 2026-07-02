package com.paul.exercises;

import java.util.HashMap;
import java.util.Map;

public class MinimumMovesMakeArrayComplementary {


    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3};
        int limit = 4;
        int res = minMoves(nums, limit);
        System.out.println(res);
    }

    public static int minMoves(int[] nums, int limit) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int moves = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int target = nums[i] + limit;
            if (map.containsKey(target)) {
                moves += map.get(target);
                map.put(target, map.get(target) - 1);
                if (map.get(target) == 0) {
                    map.remove(target);
                }
            } else {
                int diff = limit - nums[i];
                if (map.containsKey(diff)) {
                    moves++;
                    map.put(diff, map.get(diff) - 1);
                    if (map.get(diff) == 0) {
                        map.remove(diff);
                    }
                } else {
                    return -1;
                }
            }
            if (map.isEmpty()) {
                break;
            }
            int complement = target - limit;
            if (map.containsKey(complement)) {
                moves++;
                map.put(complement, map.get(complement) - 1);
                if (map.get(complement) == 0) {
                    map.remove(complement);
                }
                break;
            }
            if (i == n - 1) {
                return -1;
            }
        }
        return moves;
    }
}
