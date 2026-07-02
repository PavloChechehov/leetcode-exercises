package com.paul.exercises;

public class RotatedArrayIsSorted {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        boolean res = check(nums);
        System.out.println(res);

    }


    public static boolean check(int[] nums) {
        int l = 0;
        int n = nums.length;
        int r = n - 1;
        int last = nums[r];

        while (l < r) {
            int mid = (l + r) / 2;

            if (nums[mid] > last) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        System.out.println(r);


        for (int i = l; i < n - 1; i++) {

            int curr = nums[i % n];
            int next = nums[(i + 1) % n];

            if (curr + 1 != next) {
                return false;
            }
        }

        return true;
    }
}
