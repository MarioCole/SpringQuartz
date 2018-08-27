package com.supermap.job.myjob1;


public class TestRunnableJob1 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("RunnableJob1运行...");
    }
}
