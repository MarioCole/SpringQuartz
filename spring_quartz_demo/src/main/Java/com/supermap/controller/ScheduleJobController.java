package com.supermap.controller;

import com.supermap.entity.ScheduleJob;
import com.supermap.job.MyJob1;
import com.supermap.service.QuartzManager.QuartzMangerService;
import com.supermap.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "testJob")
public class ScheduleJobController {

    @Autowired
    private QuartzMangerService quartzMangerService;

    @Autowired
    private ScheduleJobService scheduleJobService;

    @RequestMapping(value = "addJob",method = RequestMethod.GET)
    public String addJob(@RequestParam(value = "jobName") String jobName,
                       @RequestParam(value = "cronExpression") String cronExpression){
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setCronExpression(cronExpression);
        scheduleJob.setJobName(jobName);
        scheduleJob.setJobGroupName(jobName);

        quartzMangerService.addJob(MyJob1.class,scheduleJob);
        scheduleJobService.saveScheduleJob(scheduleJob);
        return "success";
    }
}
