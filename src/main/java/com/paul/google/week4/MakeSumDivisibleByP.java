package com.paul.google.week4;

public class MakeSumDivisibleByP {


    public static void main(String[] args) {
        int[] nums = {3,6,8,1};
        int res = minSubarray(nums, 8);
        System.out.println(res);

    }


    public static int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];

        for(int i = 1; i <= n; i++) {

            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];

        }

        for(int i = 1; i < n; i++) {
            if ((prefixSum[n] - nums[i - 1]) % p == 0) {
                return 1;
            }
        }

        int max = -1;

        for(int i = n; i > 0; i--) {

            for(int j = 0; j < i; j++) {

                if((prefixSum[i] - prefixSum[j]) % p == 0 ) {
                    max = Math.max(max, i - j);
                }

            }


        }


        return max == -1? -1: n - max;
    }
}
