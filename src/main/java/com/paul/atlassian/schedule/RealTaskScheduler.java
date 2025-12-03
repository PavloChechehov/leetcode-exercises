package com.paul.atlassian.schedule;

import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class RealTaskScheduler implements TaskScheduler{

    // Represents a scheduled item
    public record ScheduledTask(long time, Runnable task) implements Comparable<ScheduledTask> {

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
        throw new ThisMethodIsNotUsedException("This method is not used in this implementation");
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
            long now = System.currentTimeMillis();
            ScheduledTask nextTask = getNextReadyTaskOrWait(now);
            if (nextTask == null) continue;
            executor.submit(nextTask.task);
        }
    }

    private ScheduledTask getNextReadyTaskOrWait(long now) {
        synchronized (lock) {

            // Wait until there is at least one task
            waitWhileQueueEmpty();

            // If we were woken up due to shutdown
            if (!running.get()) {
                return null;
            }

            // Peek at the nearest future task
            ScheduledTask next = pq.peek();
            long delay = next.time - now;

            if (delay > 0) {
                // Wait until it's time (or something new arrives)
                waitUntil(next.time);
                return null;  // Not ready yet
            }

            // Due now
            return pq.poll();
        }
    }


    private void waitWhileQueueEmpty() {
        while (pq.isEmpty() && running.get()) {
            waitOnLock();
        }
    }

    private void waitUntil(long targetTime) {
        long delay = targetTime - System.currentTimeMillis();
        if (delay > 0) {
            waitOnLock(delay);
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
