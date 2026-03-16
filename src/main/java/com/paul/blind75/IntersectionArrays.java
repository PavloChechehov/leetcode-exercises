package com.paul.blind75;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/intersection-of-two-arrays/description/">349. Intersection of Two Arrays</a>
 */
public class IntersectionArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = intersection(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }


    public static int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l = 0;
        int r = 0;

        int length1 = nums1.length;
        int length2 = nums2.length;
        int n = Math.min(length1, length2);
        int[] res = new int[n];
        int k = 0;
        int prev = -1;

        while (l < length1 && r < length2) {

            if (nums1[l] == nums2[r]) {

                if (prev != nums1[l]) {
                    prev = nums1[l];
                    res[k] = prev;
                    k++;
                }

                l++;
                r++;
                continue;

            }

            if (nums1[l] < nums2[r]) {
                l++;
            } else {
                r++;
            }

        }

        return Arrays.copyOfRange(res, 0, k);
    }
}
