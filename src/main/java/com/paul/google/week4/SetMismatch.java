package com.paul.google.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/set-mismatch/description/">Q1. Set Mismatch</a>
 */
public class SetMismatch {


    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 4};
        int[] errorNums = findErrorNums(arr);
        System.out.println(Arrays.toString(errorNums));

    }


    public static int[] findErrorNums(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;

        Set<Integer> duplicates = new HashSet<>();
        Set<Integer> set = IntStream.range(1, len + 1)
                .boxed()
                .collect(Collectors.toSet());

        for (int i = 0; i < len; i++) {
            int elem = nums[i];

            if (set.contains(elem)) {
                set.remove(elem);
            } else {
                duplicates.add(elem);
            }

        }

        duplicates.addAll(set);


        return duplicates.stream().distinct().mapToInt(Integer::intValue).sorted().toArray();
    }
}
