package com.supermap.controller;

import com.supermap.entity.RunnableJob;
import com.supermap.entity.ScheduleJob;
import com.supermap.service.QuartzManager.QuartzMangerService;
import com.supermap.service.RunnableJobService;
import com.supermap.service.ScheduleJobService;
import com.supermap.utils.orderdJobUtils.OrderdJobUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ScheduleJobController {

    @Autowired
    private QuartzMangerService quartzMangerService;

    @Autowired
    private ScheduleJobService scheduleJobService;

    @Autowired
    private RunnableJobService runnableJobService;

    @Autowired
    private OrderdJobUtils orderdJobUtils;

    /**
     * 新增一个job
     * @param jobName
     * @param cronExpression
     * @return
     */
    @RequestMapping(value = "addJob",method = RequestMethod.GET)
    public String addJob(@RequestParam(value = "jobName") String jobName,
                         @RequestParam(value = "cronExpression") String cronExpression,
                         @RequestParam(value = "jobType") String jobType,
                         @RequestParam(value = "startYear") String startYear,
                         @RequestParam(value = "startMonth") String startMonth,
                         @RequestParam(value = "startDay") String startDay,
                         @RequestParam(value = "endYear") String endYear,
                         @RequestParam(value = "endMonth") String endMonth,
                         @RequestParam(value = "endDay") String endDay,
                         @RequestParam(value = "runnable_type") String runnable_type,
                         Map<String,Object> map){
        String startTime = startYear + "-" + startMonth + "-" + startDay;
        String endTime = endYear + "-" + endMonth + "-" + endDay;
        ScheduleJob scheduleJob = new ScheduleJob();
        SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd" );

        try {
            Date startDate = format.parse(startTime);
            Date endDate = format.parse(endTime);
            scheduleJob.setStartDate(startDate);
            scheduleJob.setEndDate(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        scheduleJob.setCronExpression(cronExpression);
        scheduleJob.setJobName(jobName);
        scheduleJob.setJobGroupName(jobName);
        scheduleJob.setJobType(jobType);
        scheduleJob.setJobState("1");

        Set<RunnableJob> runnableJobs = new HashSet<>();
        RunnableJob runnableJob = new RunnableJob();
        runnableJob.setRunnable_type(runnable_type);
        runnableJob.setRunnable_state("0");
        runnableJob.setRunnable_starttime(new Date());
        runnableJob.setScheduleJob(scheduleJob);
        runnableJobs.add(runnableJob);
        scheduleJob.setRunnableJobs(runnableJobs);

        scheduleJobService.saveScheduleJob(scheduleJob);
        orderdJobUtils.insertJob(orderdJobUtils.getRunnableJob(runnableJob));
        orderdJobUtils.start();
        quartzMangerService.addJob(scheduleJob);

        RunnableJob byRunnable_type = runnableJobService.getByRunnable_type(runnable_type);
        byRunnable_type.setRunnable_endtime(new Date());
        byRunnable_type.setRunnable_state("1");
        runnableJobService.updateRunnableJob(byRunnable_type);
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

        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setId(scheduleJobByJobName.getId());
        scheduleJob.setJobName(scheduleJobByJobName.getJobName());
        scheduleJob.setJobGroupName(scheduleJobByJobName.getJobGroupName());
        scheduleJob.setCronExpression(scheduleJobByJobName.getCronExpression());
        scheduleJob.setJobState("1");
        scheduleJob.setJobType(scheduleJobByJobName.getJobType());
        scheduleJob.setStartDate(scheduleJobByJobName.getStartDate());
        scheduleJob.setEndDate(scheduleJobByJobName.getEndDate());

        quartzMangerService.deleteJob(scheduleJobByJobName);
        scheduleJobService.deleteScheduleJob(scheduleJobByJobName);

        scheduleJobService.saveScheduleJob(scheduleJob);
        quartzMangerService.runJobOnce(scheduleJob);
        System.out.println(scheduleJob);
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
        scheduleJobService.updateScheduleJobState(scheduleJobByJobName);
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
        scheduleJobService.updateScheduleJobState(scheduleJobByJobName);
        quartzMangerService.resumeJob(scheduleJobByJobName);
        map.put("message","任务已恢复");
        return "message";
    }

    @RequestMapping(value = "updateJob",method = RequestMethod.GET)
    public String updateJob(@RequestParam(value = "id") Long id,
                            @RequestParam(value = "jobName") String jobName,
                            @RequestParam(value = "cronExpression") String cronExpression,
                            @RequestParam(value = "jobType") String jobType,
                            @RequestParam(value = "startYear") String startYear,
                            @RequestParam(value = "startMonth") String startMonth,
                            @RequestParam(value = "startDay") String startDay,
                            @RequestParam(value = "endYear") String endYear,
                            @RequestParam(value = "endMonth") String endMonth,
                            @RequestParam(value = "endDay") String endDay,
                            Map<String,Object> map){
        ScheduleJob scheduleJobById = scheduleJobService.getScheduleJobById(id);
        String startTime = startYear + "-" + startMonth + "-" + startDay;
        String endTime = endYear + "-" + endMonth + "-" + endDay;
        ScheduleJob scheduleJob = new ScheduleJob();
        SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd" );

        try {
            Date startDate = format.parse(startTime);
            Date endDate = format.parse(endTime);
            scheduleJobById.setStartDate(startDate);
            scheduleJobById.setEndDate(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        scheduleJobById.setJobName(jobName);
        scheduleJobById.setCronExpression(cronExpression);
        scheduleJobById.setJobType(jobType);
        scheduleJobService.updateScheduleJob(scheduleJobById);
        map.put("message","任务已更新");
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
     * 修改前删除
     * @param jobName
     * @return
     */
    @RequestMapping(value = "deleteBeforeUpdate")
    public String deleteBeforeUpdate(@RequestParam(value = "jobName") String jobName){
        ScheduleJob scheduleJobByJobName = scheduleJobService.getScheduleJobByJobName(jobName);
        quartzMangerService.deleteJob(scheduleJobByJobName);
        scheduleJobService.deleteScheduleJob(scheduleJobByJobName);
        return "addJob";
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