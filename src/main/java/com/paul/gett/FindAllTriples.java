package com.paul.gett;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/3sum/">Leetcode 15: 3Sum</a>
 * This is a similar exercise
 * */

public class FindAllTriples {


    public static void main(String[] args) {
//        int[] arr = {1, 2, -1, 0, -2, 4};
        int[] arr = {-4, -1, -1, 0, 1, 2};

        List<List<Integer>> res = threeSum(arr, 0);
        System.out.println(res);

    }

    /*
    Requirements:
        - Return all unique triplets (order inside a triplet does not matter)
        - No duplicate triplets
        - Time complexity O(n²) expected
        - Sorting is allowed
    */

    /*
    * Notes (same as Company interview):
        - Handle negative numbers
        - Handle duplicate numbers
        - Return empty list if none found
        - Do not use brute force O(n³) unless you want to show it first (optional)
* */


    static List<List<Integer>> threeSum(int[] nums, int target) {

        if (nums.length < 3) {
            return List.of();
        }

        List<List<Integer>> res = new ArrayList<>();

        //this should be sorted
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int r = nums.length - 1;
            int l = i + 1;


            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];

                if (sum == target) {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    r--;


                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;

                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }

            }
        }


        return res;
    }
}
