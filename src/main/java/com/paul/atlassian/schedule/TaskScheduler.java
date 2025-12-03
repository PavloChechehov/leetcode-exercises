package com.paul.atlassian.schedule;

import java.util.List;

public interface TaskScheduler {
    void schedule(long time, Runnable task);

    List<Runnable> runDueTasks(long now);

    void start() throws InterruptedException;
}
