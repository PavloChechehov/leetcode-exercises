package com.paul.blind75;


/**
 <a href="https://leetcode.com/problems/reverse-pairs/description/">493. Reverse Pairs</a>
 */
public class ReversePairs {

    static int count = 0;
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 1};
        int res = reversePairs(nums);
        System.out.println(res);

    }

    /*
     Optimize solution with hints
     Complexity is O(n * log(n))
     */
    public static int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        countPairs(nums, left, mid, right);
        merge(nums, left, mid, right);

    }

    private static void countPairs(int[] nums, int left, int mid, int right) {
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > (2L * nums[j])) {
                j++;
            }
            count += j - (mid + 1);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }

        while (i <= mid)
            temp[k++] = nums[i++];
        while (j <= right)
            temp[k++] = nums[j++];

        for (int t = 0; t < temp.length; t++) {
            nums[left + t] = temp[t];
        }

    }

    /* brute force solution O(n^2)
        public static int reversePairs(int[] nums) {
        int counter = 0;
        int n = nums.length;

        // Arrays.sort(nums);

        for (int i = 0; i < n - 1; i++) {
            int left = nums[i];

            for (int j = i + 1; j < n; j++) {

                int right = nums[j];

                if (left < 0 && right < 0 && left > (right + right)) {
                    counter++;
                    continue;
                }

                if (right == Integer.MAX_VALUE)
                    continue;

                long sum = (long) (2L * right);

                if (left > sum)
                    counter++;

            }
        }

        return counter;
    }
     */
}