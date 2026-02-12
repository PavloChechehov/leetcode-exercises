package com.paul.blind75;

public class EqualsSumOfTwoArray {
    public static void main(String[] args) {
//        int[] arr = {5, 1, 1, 1, 1, 1};
        int[] arr = {5,3,7,6,9};

        boolean res = isSumEquals(arr);
        System.out.println(res);
    }


    private static boolean isSumEquals(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;

        int sumL = 0;
        int sumR = 0;

        while (l <= r) {

            if(sumL < sumR) {
                sumL += arr[l++];
            } else {
                sumR += arr[r--];
            }
        }


        return sumL == sumR;
    }

}
