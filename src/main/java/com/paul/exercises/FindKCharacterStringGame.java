package com.paul.exercises;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKCharacterStringGame {
//    public static void main(String[] args) {
//        char res = kthCharacter(5);
//        System.out.println(res);
//    }
//
//    public static char kthCharacter(int k) {
//        StringBuilder sb = new StringBuilder("a");
//
//        while (sb.length() < k) {
//
//            char[] arr = new char[sb.length()];
//
//            for (int i = 0; i < sb.length(); i++) {
//                arr[i] = (char) (sb.charAt(i) + 1);
//            }
//
//            sb.append(String.valueOf(arr));
//
//        }
//
//
//        return sb.charAt(k-1);
//    }


    public static void main(String[] args) {
        int[] arr = {1,3, 2};
        int k = 2;
        long res = maxTotalValue(arr, k);
        System.out.println(res);
    }

    public static long maxTotalValue(int[] nums, int k) {
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();

        for(int n: nums) {
            pqMax.add(n);
            pqMin.add(n);
        }

        int l = 0;
        int r = nums.length - 1;
        long res = 0;
        int i = 0;
        while (l < r && !pqMax.isEmpty() && !pqMin.isEmpty()) {

            int sum = pqMax.peek() - pqMin.peek();
            res += sum;

            if (l+1 <= r && nums[l+1] <= nums[l]) {
                if (pqMin.peek() == nums[l]) pqMin.poll();
                l++;
            } else  {
                if (pqMax.peek() == nums[r]) pqMax.poll();
                r--;
            }
            i++;
        }

        return res;
    }
}
