package com.supermap.controller;

import com.supermap.entity.ScheduleJob;
import com.supermap.job.myjob1.MyJob1;
import com.supermap.service.QuartzManager.QuartzMangerService;
import com.supermap.service.ScheduleJobService;
import com.supermap.utils.classUtils.ClassTools;
import com.supermap.utils.classUtils.ClassUtils;
import org.quartz.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class ScheduleJobController {

    @Autowired
    private QuartzMangerService quartzMangerService;

    @Autowired
    private ScheduleJobService scheduleJobService;


    /**
     * 新增一个job
     * @param jobName
     * @param cronExpression
     * @return
     */
    @RequestMapping(value = "addJob",method = RequestMethod.GET)
    public String addJob(@RequestParam(value = "jobName") String jobName,
                       @RequestParam(value = "cronExpression") String cronExpression,
                         @RequestParam(value = "jobLocation") String jobLocation,
                         Map<String,Object> map){
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setCronExpression(cronExpression);
        scheduleJob.setJobName(jobName);
        scheduleJob.setJobGroupName(jobName);
        scheduleJob.setJobLocation(jobLocation);
        scheduleJob.setJobState("1");
        scheduleJobService.saveScheduleJob(scheduleJob);
        
        quartzMangerService.addJob(MyJob1.class,scheduleJob);
        map.put("message","添加成功");
        return "message";
    }

    /**
     * 立即执行一个job
     * @param jobName
     * @return
     */
    @RequestMapping(value = "runJobNow",method = RequestMethod.GET)
    public String runJobNow(@RequestParam(value = "jobName") String jobName,
                            Map<String,Object> map){
        ScheduleJob scheduleJobByJobName = scheduleJobService.getScheduleJobByJobName(jobName);
        quartzMangerService.runJobOnce(MyJob1.class,scheduleJobByJobName);
        //quartzManager.runAJobNow(jobName,jobName);
        System.out.println(scheduleJobByJobName);
        map.put("message","正在执行");
        return "message";
    }

    /**
     * 暂停一个job
     * @param jobName
     * @return
     */
    @RequestMapping(value = "pauseJob",method = RequestMethod.GET)
    public String pauseJob(@RequestParam(value = "jobName") String jobName,
                           Map<String,Object> map){
        ScheduleJob scheduleJobByJobName = scheduleJobService.getScheduleJobByJobName(jobName);
        String jobState = scheduleJobByJobName.getJobState();
        System.out.println(jobState);
        scheduleJobService.updateScheduleJob(scheduleJobByJobName);
        quartzMangerService.pauseJob(scheduleJobByJobName);
        map.put("message","任务已暂停");
        return "message";
    }

    /**
     * 恢复一个job
     * @param jobName
     * @return
     */
    @RequestMapping(value = "resumeJob",method = RequestMethod.GET)
    public String resumeJob(@RequestParam(value = "jobName") String jobName,
                            Map<String,Object> map){
        ScheduleJob scheduleJobByJobName = scheduleJobService.getScheduleJobByJobName(jobName);
        scheduleJobService.updateScheduleJob(scheduleJobByJobName);
        quartzMangerService.resumeJob(scheduleJobByJobName);
        map.put("message","任务已恢复");
        return "message";
    }

    /**
     * 删除一个job
     * @param jobName
     * @return
     */
    @RequestMapping(value = "deleteJob",method = RequestMethod.GET)
    public String deleteJob(@RequestParam(value = "jobName") String jobName,
                            Map<String,Object> map){
        ScheduleJob scheduleJobByJobName = scheduleJobService.getScheduleJobByJobName(jobName);
        System.out.println(scheduleJobByJobName);
        quartzMangerService.deleteJob(scheduleJobByJobName);
        scheduleJobService.deleteScheduleJob(scheduleJobByJobName);
        map.put("message","删除成功");
        return "message";
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

    /**
     * 查询所有
     * @param map
     * @return
     */
    @RequestMapping(value = "findAllJob",method = RequestMethod.GET)
    public String findAll(Map<String,Object> map){
        List<ScheduleJob> scheduleJobAll = scheduleJobService.findAll();
        map.put("scheduleJobAll",scheduleJobAll);
        return "list";
    }
}