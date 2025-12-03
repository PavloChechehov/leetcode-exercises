package com.paul.atlassian.schedule;

import java.util.List;
/*
Day 4 — Priority Queues & Task Scheduling Basics
Today's goal is to master:
  -  PriorityQueue usage
  -  Custom comparators
  -  Designing a simple scheduling component
  -  Handling insertions, cancellations, and executions
  -  Clean code + clear reasoning (very important for Atlassian)


Task 4.1 — Implement a Basic Task Scheduler (Core)

You need to implement a scheduler with these functions:
* */
public interface TaskScheduler {
    void schedule(long time, Runnable task);

    List<Runnable> runDueTasks(long now);

    void start() throws InterruptedException;
}
