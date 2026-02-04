package com.paul.google.week4;

public class ReturnPositiveInt {

    public static void main(String[] args) {

        int[] arr = {3, 4, -1, 1};
        int res = firstMissingPositive(arr);
        System.out.println(res);
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 1) {
            return nums[0] == 1 ? 2 : 1;
        }

        int n = nums.length;

        for (int i = 0; i < n; i++) {
           /* int elem = nums[i];

            if (elem - 1 != i) {

                if (elem < 0) {
                    nums[i] = 0;
                }

                if (elem > 0 && elem < n) {
                    int temp = nums[elem - 1];
                    nums[elem - 1] = elem;
                    nums[i] = temp;
                } else {
                    nums[i] = 0;
                }


            }*/
            while (nums[i] > 0
                    && nums[i] <= n
                    && nums[i] != nums[nums[i] - 1]
            ) {
                int elem = nums[i];
                int temp = nums[elem - 1];
                nums[elem - 1] = elem;
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {

            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n;

    }
}
