package com.supermap.entity;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Variable {
    private static BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
    private static boolean running = false;

    public BlockingQueue<Runnable> getQueue() {
        return queue;
    }

    @SuppressWarnings("static-access")
    public void setQueue(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    public boolean isRunning() {
        return running;
    }

    @SuppressWarnings("static-access")
    public void setRunning(boolean running) {
        this.running = running;
    }
}
