package com.paul.exercises;

import java.util.List;

public class MinLengthAndTargetSum {


    public static void main(String[] args) {
//        List<Integer> list = List.of(1, 4, 1, 7, 3, 0, 2, 5);
        List<Integer> list = List.of(1, 6, 8);
        int target = 10;
        int res = subarraySumShortest(list, target);

        System.out.println(res);
    }

    public static int subarraySumShortest(List<Integer> nums, int target) {
        int l = 0;
        int r = 0;
        int n = nums.size();
        int min = n;
        int sum = 0;

        while (r < n) {
            if (sum < target) {
                sum += nums.get(r);
                r++;
            } else {
                min = Math.min(r - l, min);
                sum -= nums.get(l);
                l++;
            }


        }
        while (sum >= target && l < n){
            min = Math.min(r - l, min);
            l++;
        }

        return min;
    }
}
