package com.paul.google.week2;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/sliding-window-maximum/description/">239. Sliding Window Maximum</a>
 */


record MaxValue(Integer max, Integer val) {

}
public class SlidingWindowMaximum {




    public static void main(String[] args) {
//        int[] nums = {4, 3, 2, 1};
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return res;
    }

    //4,1,2,5
    //4(4,4), 1(1,4), 2(2,2), 5(5,5)
    //k = 2
    //naive implementation but still doesn't work
/*
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<MaxValue> deque = new ArrayDeque<>();

        int l = 0;
        int r = k;

        int length = nums.length;
        int max = Integer.MIN_VALUE;
        int[] res = new int[length - k + 1];
        for (int i = 0; i < k; i++) {

            int val = nums[i];
            max = Math.max(max, val);
            deque.add(new MaxValue(max, val));
        }

        res[0] = deque.getLast().max();

        for (int i = k; i < length; i++) {

            int val = nums[i];
            MaxValue prev = deque.getLast();
            Integer prevMax = Math.max(prev.max(), val);

            MaxValue newMax = new MaxValue(prevMax, val);
            deque.add(newMax);
            res[i - k + 1] = newMax.max();
            deque.removeFirst();
        }

        return res;

    }
*/
}


