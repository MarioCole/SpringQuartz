package com.supermap.test;

import com.supermap.entity.VariableQueue;
import com.supermap.job.myjob1.TestRunnableJob1;
import com.supermap.job.myjob1.TestRunnableJob2;
import com.supermap.utils.orderdJobUtils.OrderdJobUtils;
import com.supermap.utils.orderdJobUtils.QueueUtils;
import org.junit.jupiter.api.Test;

public class TestQueueUtils {
    @Test
    public void testInsert(){
        TestRunnableJob1 testRunnableJob1 = new TestRunnableJob1();
        TestRunnableJob2 testRunnableJob2 = new TestRunnableJob2();
        OrderdJobUtils orderdJobUtils = new OrderdJobUtils();
        orderdJobUtils.insertJob(testRunnableJob1);
        orderdJobUtils.insertJob(testRunnableJob2);
        orderdJobUtils.start();

        int queueSize = orderdJobUtils.getQueueSize();
        System.out.println(queueSize);


        orderdJobUtils.getJob();

        orderdJobUtils.stop();
    }

    @Test
    public void testInserAndGet(){
        TestRunnableJob1 testRunnableJob1 = new TestRunnableJob1();
        TestRunnableJob2 testRunnableJob2 = new TestRunnableJob2();
        VariableQueue variableQueue = new VariableQueue();
        QueueUtils queueUtils = new QueueUtils();

        queueUtils.insertRunable(testRunnableJob1,variableQueue);
        //queueUtils.insertRunable(testRunnableJob2,variableQueue);

        queueUtils.start(variableQueue);
        queueUtils.getJob(variableQueue);

        try {
            Thread.sleep(10*1000);
            queueUtils.insertRunable(testRunnableJob2,variableQueue);
            queueUtils.getJob(variableQueue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        queueUtils.stop(variableQueue);
    }
}
