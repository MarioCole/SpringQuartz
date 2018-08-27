package com.supermap.test;

import com.supermap.entity.RunnableJob;
import com.supermap.job.myjob1.TestRunnableJob1;
import com.supermap.job.myjob1.TestRunnableJob2;
import com.supermap.utils.orderdJobUtils.InitDataQuartzCommon;
import com.supermap.utils.orderdJobUtils.OrderdJobUtils;
import org.junit.jupiter.api.Test;

public class TestOrderJobUtils {
    @Test
    public void testInsertAndGet(){
        InitDataQuartzCommon initDataQuartzCommon = new InitDataQuartzCommon();
        OrderdJobUtils orderdJobUtils = new OrderdJobUtils();
        TestRunnableJob1 testRunnableJob1 = new TestRunnableJob1();
        TestRunnableJob2 testRunnableJob2 = new TestRunnableJob2();

        orderdJobUtils.insertJob(testRunnableJob1);
        orderdJobUtils.insertJob(testRunnableJob2);
        orderdJobUtils.start();
        //initDataQuartzCommon.startClearData();

        orderdJobUtils.getJob();
        orderdJobUtils.stop();
    }

    @Test
    public void testGetRunnableJob(){
        RunnableJob runnableJob = new RunnableJob();
        RunnableJob runnableJob1 = new RunnableJob();
        OrderdJobUtils orderdJobUtils = new OrderdJobUtils();

        runnableJob.setRunnable_type("test1");
        runnableJob1.setRunnable_type("test2");
        orderdJobUtils.insertJob(orderdJobUtils.getRunnableJob(runnableJob));
        orderdJobUtils.insertJob(orderdJobUtils.getRunnableJob(runnableJob1));
        orderdJobUtils.start();
        orderdJobUtils.getJob();
        orderdJobUtils.stop();
    }
}
