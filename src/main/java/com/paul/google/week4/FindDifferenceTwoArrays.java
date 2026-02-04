package com.paul.google.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-the-difference-of-two-arrays/description/">2215. Find the Difference of Two Arrays</a>
 *
 */
public class FindDifferenceTwoArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 3};
        int[] arr2 = {1, 1, 2, 2};
        List<List<Integer>> difference = findDifference(arr1, arr2);
        System.out.println(difference);
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1 = nums1.length;
        int n2 = nums2.length;

        int p1 = 0;
        int p2 = 0;

        while (p1 < n1 && p2 < n2) {

            while ((p1 + 1) < n1 && nums1[p1] == nums1[p1 + 1]) {
                p1++;
            }

            while ((p2 + 1) < n2 && nums2[p2] == nums2[p2 + 1]) {
                p2++;
            }

            if (nums1[p1] == nums2[p2]) {
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                list1.add(nums1[p1]);
                p1++;
            } else {
                list2.add(nums2[p2]);
                p2++;
            }

        }


        while (p1 < n1) {
            if ((p1 + 1) < n1 && nums1[p1] == nums1[p1 + 1]) {
                // continue;
            } else {
                list1.add(nums1[p1]);
            }
            p1++;
        }

        while (p2 < n2) {
            if ((p2 + 1) < n2 && nums2[p2] == nums2[p2 + 1]) {
                // continue;
            } else {
                list2.add(nums2[p2]);
            }

            p2++;

        }


        return List.of(list1, list2);
    }


}
