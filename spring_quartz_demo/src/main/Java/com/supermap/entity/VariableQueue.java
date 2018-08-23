package com.supermap.entity;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class VariableQueue {
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
    private boolean running = false;

    public BlockingQueue<Runnable> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
