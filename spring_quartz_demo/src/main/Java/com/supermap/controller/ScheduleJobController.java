package com.supermap.controller;

import com.supermap.entity.ScheduleJob;
import com.supermap.job.MyJob1;
import com.supermap.service.QuartzManager.QuartzManager;
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

    @Autowired
    private QuartzManager quartzManager;

    /**
     * 新增一个job
     * @param jobName
     * @param cronExpression
     * @return
     */
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

    /**
     * 立即执行一个job
     * @param jobName
     * @return
     */
    @RequestMapping(value = "runJobNow",method = RequestMethod.GET)
    public String runJobNow(@RequestParam(value = "jobName") String jobName){
        ScheduleJob scheduleJobByJobName = scheduleJobService.getScheduleJobByJobName(jobName);
        quartzMangerService.runJobOnce(MyJob1.class,scheduleJobByJobName);
        //quartzManager.runAJobNow(jobName,jobName);
        System.out.println(scheduleJobByJobName);
        return null;
    }

    /**
     * 暂停一个job
     * @param jobName
     * @return
     */
    @RequestMapping(value = "pauseJob",method = RequestMethod.GET)
    public String pauseJob(@RequestParam(value = "jobName") String jobName){
        ScheduleJob scheduleJobByJobName = scheduleJobService.getScheduleJobByJobName(jobName);
        quartzMangerService.pauseJob(scheduleJobByJobName);
        System.out.println(scheduleJobByJobName);
        return null;
    }

    /**
     * 恢复一个job
     * @param jobName
     * @return
     */
    @RequestMapping(value = "resumeJob",method = RequestMethod.GET)
    public String resumeJob(@RequestParam(value = "jobName") String jobName){
        ScheduleJob scheduleJobByJobName = scheduleJobService.getScheduleJobByJobName(jobName);
        quartzMangerService.resumeJob(scheduleJobByJobName);
        System.out.println(scheduleJobByJobName);
        return null;
    }

    /**
     * 删除一个job
     * @param jobName
     * @return
     */
    @RequestMapping(value = "deleteJob",method = RequestMethod.GET)
    public String deleteJob(@RequestParam(value = "jobName") String jobName){
        ScheduleJob scheduleJobByJobName = scheduleJobService.getScheduleJobByJobName(jobName);
        System.out.println(scheduleJobByJobName);
        quartzMangerService.deleteJob(scheduleJobByJobName);
        scheduleJobService.deleteScheduleJob(scheduleJobByJobName);
        return null;
    }

    /**
     * 修改一个job的cron表达式
     * @param jobName
     * @return
     */
    @RequestMapping(value = "updateJobCron",method = RequestMethod.GET)
    public String updateJobCron(@RequestParam(value = "jobName") String jobName,
                                @RequestParam(value = "cronExpression") String cronExpression){
        ScheduleJob scheduleJobByJobName = scheduleJobService.getScheduleJobByJobName(jobName);
        quartzMangerService.deleteJob(scheduleJobByJobName);
        scheduleJobService.deleteScheduleJob(scheduleJobByJobName);
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setJobName(jobName);
        scheduleJob.setJobGroupName(jobName);
        scheduleJob.setCronExpression(cronExpression);
        quartzMangerService.addJob(MyJob1.class,scheduleJob);
        scheduleJobService.saveScheduleJob(scheduleJob);
        System.out.println(scheduleJob);
        return null;
    }
}