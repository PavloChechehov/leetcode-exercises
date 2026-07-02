package com.paul.exercises;

public class SumAllOddLengthSubarrays {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int res = sumOddLengthSubarrays(arr);
        System.out.println(res);
    }


    public static int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;

        int sum = 0;

        // 1 2 3 4 5

        // 1 2 3
        // 2 3 4
        // 3 4 5

        for (int len = 1; len <= n; len += 2) {

            for (int start = 0; start + len <= n; start++) {

                int subSum = 0;

                for (int k = start; k < start + len; k++) {
                    subSum += arr[k];
                }

                sum += subSum;
            }
        }

        return sum;
    }
}
