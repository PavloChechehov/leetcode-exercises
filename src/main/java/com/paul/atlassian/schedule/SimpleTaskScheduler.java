package com.paul.atlassian.schedule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SimpleTaskScheduler implements TaskScheduler {

    private static class ScheduledTask {
        final long time;
        final Runnable task;

        ScheduledTask(long time, Runnable task) {
            this.time = time;
            this.task = task;
        }
    }

    private final PriorityQueue<ScheduledTask> pq =
            new PriorityQueue<>(Comparator.comparingLong(t -> t.time));


    @Override
    public void schedule(long time, Runnable task) {
        pq.add(new ScheduledTask(time, task));
    }


    @Override
    public List<Runnable> runDueTasks(long now) {
        List<Runnable> due = new ArrayList<>();

        while (!pq.isEmpty() && pq.peek().time <= now) {
            due.add(pq.poll().task);
        }

        return due;
    }

    @Override
    public void start() throws InterruptedException {

    }
}
