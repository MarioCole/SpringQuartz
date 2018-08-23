package com.supermap.job.myjob1;

import com.supermap.entity.RunnableJob;
import com.supermap.utils.orderdJobUtils.OrderdJobUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyJob1 implements Job {
    @Autowired
    private OrderdJobUtils orderdJobUtils;

    private TestRunnableJob1 testRunnableJob1 = new TestRunnableJob1();
    private TestRunnableJob2 testRunnableJob2 = new TestRunnableJob2();
    private RunnableJob runnableJob = new RunnableJob();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("MyJob1任务开始");
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        System.out.println("MyJob1 的运行 ：" + dateFormat.format(new Date()));

        orderdJobUtils.insertJob(testRunnableJob1);
        orderdJobUtils.insertJob(testRunnableJob2);
        //orderdJobUtils.insertJob(OrderdJobUtils.getRunnableJob(runnableJob));
        orderdJobUtils.start();
        orderdJobUtils.getJob();
        orderdJobUtils.stop();
    }

}
