package com.paul.blind75;


import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/number-of-recent-calls/description/">933. Number of Recent Calls</a>
 */
public class RecentCounter {


    private final LinkedList<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        int startTime = t - 3000;

        while (!queue.isEmpty() && queue.getFirst() < startTime) {
            queue.removeFirst();
        }

        return queue.size();
    }
}
