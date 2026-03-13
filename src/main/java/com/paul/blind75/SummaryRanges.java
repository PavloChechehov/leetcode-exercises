package com.paul.blind75;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/summary-ranges/description/">228. Summary Ranges</a>
 */
public class SummaryRanges {

    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 4, 5, 7};
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        List<String> res = summaryRanges(nums);
        System.out.println(res);

    }


    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return List.of();
        if (nums.length == 1) return List.of(String.valueOf(nums[0]));

        int n = nums.length;

        List<String> list = new ArrayList<>();

        //0,1,2,4,5,7

        for (int i = 0; i < n; i++) {

            int j = i;

            for (; j < n - 1; j++) {

                if (nums[j] + 1 != nums[j + 1])
                    break;

            }

            if (i == j) {
                list.add(String.valueOf(nums[i]));
            } else {
                list.add(nums[i] + "->" + nums[j]);
            }
            i = j;

        }

        return list;
    }
}
