package com.supermap.controller;

import com.supermap.entity.ScheduleJob;
import com.supermap.job.myjob1.MyJob1;
import com.supermap.service.QuartzManager.QuartzManager;
import com.supermap.service.QuartzManager.QuartzMangerService;

import com.supermap.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TestJobController {

    @Autowired
    private QuartzManager quartzManager;

    @Autowired
    private ScheduleJobService scheduleJobService;

    @Autowired
    private QuartzMangerService quartzMangerService;


    @RequestMapping("testJob1")
    public void text(){
        try {
            String jobName="job1";
            String jobGroupName="job1";
            String jobTime="0/5 * * * * ? ";
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            System.out.println("TestQuartJob 开始启动："+dateFormat.format(new Date()));
            quartzManager.addJob(MyJob1.class,jobName,jobGroupName,jobTime);
            Thread.sleep(10000);
            quartzManager.pauseJob(jobName,jobGroupName);
            Thread.sleep(5000);
            quartzManager.resumeJob(jobName,jobGroupName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "testJob2",method = RequestMethod.GET)
    public void test(){
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setJobName("mario");
        scheduleJob.setJobGroupName("group1");
        scheduleJob.setCronExpression("333");
        scheduleJobService.saveScheduleJob(scheduleJob);
    }

    @RequestMapping(value = "testJob3", method = RequestMethod.GET)
    public void test2(){
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setJobName("heke");
        scheduleJob.setJobGroupName("heke1");
        scheduleJob.setCronExpression("0/2 * * * * ?");
        quartzMangerService.addJob(MyJob1.class,scheduleJob);
        scheduleJobService.saveScheduleJob(scheduleJob);
    }

    @RequestMapping(value = "testJob4")
    public void test3(){
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setJobName("lili");
        scheduleJob.setJobGroupName("lili1");
        scheduleJob.setCronExpression("0/1 * * * * ?");
        try {
            System.out.println("-------开始执行，每秒执行一次----------");
            quartzMangerService.addJob(MyJob1.class,scheduleJob);
            Thread.sleep(10000);
            System.out.println("-------暂停----------");
            quartzMangerService.pauseJob(scheduleJob);

            Thread.sleep(5000);
            System.out.println("-------重启任务----------");
            quartzMangerService.runJobNow(scheduleJob);
            /*
            Thread.sleep(5000);
            quartzMangerService.pauseJob(scheduleJob);
            System.out.println("-------删除任务----------");
            quartzMangerService.deleteJob(scheduleJob);
            System.out.println("-------重新设定----------");
            scheduleJob.setCronExpression("0/3 * * * * ?");
            scheduleJob.setJobName("hahhh");
            scheduleJob.setJobGroupName("hhhhh");
            System.out.println("-------再次开始----------");
            quartzMangerService.addJob(MyJob1.class,scheduleJob);
            */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "testJob5")
    public void test4(){
        List<ScheduleJob> scheduleJobServiceAll = scheduleJobService.findAll();
        System.out.println(scheduleJobServiceAll);
    }
}
