package com.supermap.service.QuartzManager;


import com.supermap.entity.ScheduleJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuartzMangerService {
    @Autowired
    private Scheduler scheduler;

    /**
     * 增加一个job
     * @param jobClass
     * @param scheduleJob
     */
    public void addJob(Class<? extends Job> jobClass, ScheduleJob scheduleJob){
        try {
        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity(scheduleJob.getJobName(),scheduleJob.getJobGroupName())
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(scheduleJob.getJobName(),scheduleJob.getJobGroupName())
                .startAt(DateBuilder.futureDate(1,DateBuilder.IntervalUnit.SECOND))
                .withSchedule(CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression()))
                .startNow().build();

            scheduler.scheduleJob(jobDetail,trigger);
            if (!scheduler.isShutdown()){
                scheduler.start();
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改一个job的cron表达式
     * @param scheduleJob
     */
    public void update(ScheduleJob scheduleJob){
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getJobName(),scheduleJob.getJobGroupName());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            trigger.getTriggerBuilder().withIdentity(triggerKey)
                    .withSchedule(CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression()))
                    .build();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除一个job
     * @param scheduleJob
     */
    public void deleteJob(ScheduleJob scheduleJob){
        try {
            scheduler.deleteJob(new JobKey(scheduleJob.getJobName(),scheduleJob.getJobGroupName()));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 暂停一个job
     * @param scheduleJob
     */
    public void pauseJob(ScheduleJob scheduleJob){
        try {
            JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(),scheduleJob.getJobGroupName());
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 恢复一个job
     * @param scheduleJob
     */
    public void resumeJob(ScheduleJob scheduleJob){
        try {
            JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(),scheduleJob.getJobGroupName());
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行一个job
     * @param scheduleJob
     */
    public void runJobNow(ScheduleJob scheduleJob){
        try {
            JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(),scheduleJob.getJobGroupName());
            scheduler.triggerJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
