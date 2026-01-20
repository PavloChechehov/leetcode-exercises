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

        int[] arr = {2,2};
        int[] errorNums = findErrorNums(arr);
        System.out.println(Arrays.toString(errorNums));

    }

    //my second solution without Set, only array
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n + 1];

        int duplicate = -1;
        int missing = -1;

        for (int elem : nums) {
            if (arr[elem] != 0) {
                duplicate = elem;
            } else {
                arr[elem]++;
            }
        }

        for (int i = 1; i <= n; i++) {

            int elem = arr[i];
            if (elem == 0) {
                missing = i;
                break;
            }
        }
        return new int[]{duplicate, missing};
    }




    /*public static int[] findErrorNums(int[] nums) {
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
    }*/
}
