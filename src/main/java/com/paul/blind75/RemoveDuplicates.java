package com.paul.blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int res = removeDuplicates(arr);
        System.out.println(res);
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {

        int n = nums.length;
        int k = n;

        int index = 0;
        int prev = nums[0];
        Map<Integer, Integer> map = new HashMap<>();


        for(int i = 1; i < n; i++) {

            //1,1,1,2,2,3
            if (nums[i] == prev && (map.get(prev) == null || map.get(prev) == 1)) {
                map.put(prev, map.getOrDefault(prev, 0) + 1);
            } else {
                k--;

                nums[i - 1] = nums[i];
                prev = nums[i];
            }


        }

        return k;
    }
}
