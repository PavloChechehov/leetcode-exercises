package com.paul.google.week2;

/**
 * <a href="https://leetcode.com/problems/peak-index-in-a-mountain-array/">852. Peak Index in a Mountain Array</a>
 */
public class PeakIndexMountainArray {

    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 2, 0};
        int res = peakIndexInMountainArray(arr);
        System.out.println(5 == arr[res]);
    }

    public static int peakIndexInMountainArray(int[] arr) {
        if (arr.length == 3) return 1;

        //O(log(n))
        // 3,5,3,2,0
        //

        int l = 0;
        int r = arr.length - 1;

        while(l < r) {

            int mid = l + (r - l)/2;

            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }


        return l;
    }
}
