package com.paul.blind75;

public class MaxThird {

    public static void main(String[] args) {
        int[] nums = {2,1};
//        int[] nums = {2,2,3,1};
        int res = thirdMax(nums);
        System.out.println(res);

    }


    public static int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for(int n: nums) {

            if (n == first || n == second || n == third) continue;

            if (n > first) {
                third = second;
                second = first;
                first = n;
            } else if (n > second) {
                third = second;
                second = n;
            } else if (n > third) {
                third = n;
            }
        }

        return third == Long.MIN_VALUE? (int) first: (int) third;
    }
}
