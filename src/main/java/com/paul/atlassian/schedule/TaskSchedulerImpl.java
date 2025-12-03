package com.paul.atlassian.schedule;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskSchedulerImpl implements TaskScheduler {
    record ScheduledTask(
            long time,
            Runnable task) {

    }

    private final PriorityQueue<ScheduledTask> pq;
    private final ExecutorService executor;
    private final List<Runnable> tasks;

    public ExecutorService getExecutor() {
        return executor;
    }

    public TaskSchedulerImpl() {
        this.pq = new PriorityQueue<>(Comparator.comparingLong(ScheduledTask::time));
        this.executor = Executors.newFixedThreadPool(3);
        this.tasks = new CopyOnWriteArrayList<>();
    }

    @Override
    public void schedule(long time, Runnable runnable) {
        ScheduledTask task = new ScheduledTask(time, runnable);
        pq.add(task);
    }


    @Override
    public List<Runnable> runDueTasks(long now) {
        return tasks;
    }

    private final AtomicInteger counter = new AtomicInteger();

    @Override
    public void start() throws InterruptedException {
        while (true) {
            long now = System.currentTimeMillis();
            if (!pq.isEmpty() && pq.peek().time <= now) {
                ScheduledTask task = pq.poll();
                tasks.add(task.task());

                System.out.println("Task time: " + (now - task.time()));
                System.out.println("Current time: " + task.time);
                executor.submit(task.task());
                Thread.sleep(1000);

                counter.set(0);
                tasks.removeFirst();
            } else {
                int n = counter.getAndIncrement();
                if (n == 5) {
                    break;
                }
                System.out.println("Waiting new tasks... " + (5 - n));
                Thread.sleep(1000);

            }

        }
    }

    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        TaskSchedulerImpl taskScheduler = new TaskSchedulerImpl();

        Runnable runnable = new Runnable() {


            @Override
            public void run() {
                System.out.println("Hello world: " + Thread.currentThread());
            }
        };
        for (int i = 0; i < 5; i++) {
            long now = System.currentTimeMillis();
            int randomTime = random.nextInt(500, 3000);
            long time = randomTime + now;

            System.out.println(i + ": rand : " + randomTime);
            System.out.println(i + ": time : " + time);
            taskScheduler.schedule(time, runnable);

        }
        taskScheduler.start();


        for (int i = 0; i < 1000; i++) {

            if (i % 2 == 0) {
                List<Runnable> runnables = taskScheduler.runDueTasks(100);
                System.out.println(runnables);
            }
            Thread.sleep(100);
        }

        taskScheduler.executor.shutdown();
        boolean res = taskScheduler.executor.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("Executor finished -> " + res);
    }


}
