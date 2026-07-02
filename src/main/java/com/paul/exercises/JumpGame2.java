package com.paul.exercises;

import java.util.HashMap;
import java.util.Map;

public class JumpGame2 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int res = jump(nums);
        System.out.println(res);

    }

    public static int jump(int[] nums) {
        // 2,3,1,1,4
        Map<Integer, Integer> map = new HashMap<>();
        int res = dfs(nums, 0, 0, map);
        return res;
    }

    private static int dfs(int[] nums, int pos, int count, Map<Integer, Integer> map) {
        if (pos == nums.length - 1) return count;
        if (map.containsKey(pos)) return map.get(pos);
        // if (pos >= nums.length) return Integer.MAX_VALUE;

        int j = nums[pos];
        int min = Integer.MAX_VALUE;

        for (int i = pos + 1; i <= pos + j; i++) {
            int res = dfs(nums, i, count + 1, map);
            min = Math.min(res, min);
        }

        map.put(pos, min);
        return min;
    }

}
