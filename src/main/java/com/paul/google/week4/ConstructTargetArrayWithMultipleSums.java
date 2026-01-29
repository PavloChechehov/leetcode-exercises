
package com.paul.google.week4;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {


    public static void main(String[] args) {

        int[] arr = {5,2};
        boolean res = isPossible(arr);
        System.out.println(res);
    }

    public static boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.comparingLong(a -> -a));

        long sum = 0L;

        for (int i : target) {
            sum += i;
            pq.add((long) i);
        }

        while (pq.peek() != 1) {
            long curr = pq.poll();
            long rest = sum - curr;

            if (rest <= 0 || curr <= rest) return false;

            long prev = curr % rest;

            if (prev == 0) {
                if (rest != 1) return false;
                prev = rest;
            }

            sum = rest + prev;

            pq.add(prev);
        }

        return true;
    }

}
