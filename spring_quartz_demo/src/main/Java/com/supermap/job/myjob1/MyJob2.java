package com.supermap.job.myjob1;

import com.supermap.entity.VariableQueue;
import com.supermap.utils.orderdJobUtils.QueueUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob2 implements Job {

    @Autowired
    private QueueUtils queueUtils;

    private TestRunnableJob1 testRunnableJob1 = new TestRunnableJob1();
    private TestRunnableJob2 testRunnableJob2 = new TestRunnableJob2();
    private VariableQueue variableQueue = new VariableQueue();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("MyJob2任务开始");
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        System.out.println("MyJob2 的运行 ：" + dateFormat.format(new Date()));

        queueUtils.insertRunable(testRunnableJob1,variableQueue);
        queueUtils.insertRunable(testRunnableJob2,variableQueue);

        queueUtils.start(variableQueue);
        queueUtils.getJob(variableQueue);

        queueUtils.stop(variableQueue);
    }
}
