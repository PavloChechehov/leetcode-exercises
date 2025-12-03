package com.paul.atlassian.schedule;

import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class RealTaskScheduler implements TaskScheduler{

    // Represents a scheduled item
    public static class ScheduledTask implements Comparable<ScheduledTask> {
        final long time;
        final Runnable runnable;

        public ScheduledTask(long time, Runnable runnable) {
            this.time = time;
            this.runnable = runnable;
        }

        @Override
        public int compareTo(ScheduledTask o) {
            return Long.compare(this.time, o.time);
        }
    }

    private final PriorityQueue<ScheduledTask> pq = new PriorityQueue<>();
    private final ExecutorService executor;
    private final AtomicBoolean running = new AtomicBoolean(true);
    private final Object lock = new Object();

    public RealTaskScheduler(int threads) {
        this.executor = Executors.newFixedThreadPool(threads);
    }

    /** Public API: schedule a task */
    public void schedule(long time, Runnable runnable) {
        synchronized (lock) {
            pq.add(new ScheduledTask(time, runnable));
            lock.notify(); // wake up runner if sleeping
        }
    }

    @Override
    public List<Runnable> runDueTasks(long now) {
        return List.of();
    }
    /** Background thread that polls tasks */
    @Override
    public void start() {
        Thread runner = new Thread(this::runLoop);
        runner.start();
    }

    /** Stops accepting new tasks and shuts down gracefully */
    public void shutdown() {
        running.set(false);
        synchronized (lock) {
            lock.notify();
        }
        executor.shutdown();
    }

    // Main loop
    private void runLoop() {
        while (running.get()) {
            ScheduledTask nextTask = null;
            long now = System.currentTimeMillis();

            synchronized (lock) {
                // wait for tasks if empty
                while (pq.isEmpty() && running.get()) {
                    waitOnLock();
                }
                if (!running.get()) break;

                nextTask = pq.peek();
                long delay = nextTask.time - now;

                if (delay > 0) {
                    // sleep until task time or until new task arrives
                    waitOnLock(delay);
                    continue;
                }

                // due task
                pq.poll();
            }

            // run task outside lock
            executor.submit(nextTask.runnable);
        }
    }

    private void waitOnLock() {
        try { lock.wait(); } catch (InterruptedException ignored) {}
    }

    private void waitOnLock(long millis) {
        try { lock.wait(millis); } catch (InterruptedException ignored) {}
    }

    public static void main(String[] args) throws Exception {
        RealTaskScheduler scheduler = new RealTaskScheduler(3);

        scheduler.start();

        long now = System.currentTimeMillis();

        scheduler.schedule(now + 1000, () -> System.out.println("Task A"));
        scheduler.schedule(now + 500, () -> System.out.println("Task B"));
        scheduler.schedule(now + 2000, () -> System.out.println("Task C"));

        Thread.sleep(3000);
        scheduler.shutdown();
    }
}
