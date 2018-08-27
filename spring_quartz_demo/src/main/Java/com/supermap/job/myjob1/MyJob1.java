package com.supermap.job.myjob1;

import com.supermap.entity.RunnableJob;
import com.supermap.entity.Variable;
import com.supermap.service.RunnableJobService;
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
    private RunnableJobService runnableJobService;

    @Autowired
    private OrderdJobUtils orderdJobUtils;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("MyJob1任务开始");
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        System.out.println("MyJob1 的运行 ：" + dateFormat.format(new Date()));
        orderdJobUtils.getJob();
        orderdJobUtils.stop();
    }

}
