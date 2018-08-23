package com.supermap.service.listenerService;

import com.supermap.entity.ScheduleJob;
import com.supermap.service.QuartzManager.QuartzMangerService;
import com.supermap.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ScheduleJobService scheduleJobService;

    @Autowired
    private QuartzMangerService quartzMangerService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            runAllWhileStart();
        }
    }

    public void runAllWhileStart(){
        List<ScheduleJob> scheduleJobServiceAll = scheduleJobService.findAll();
        for (ScheduleJob scheduleJob: scheduleJobServiceAll) {
            ScheduleJob scheduleJobByJobName = scheduleJobService.getScheduleJobByJobName(scheduleJob.getJobName());
            if (scheduleJobByJobName.getJobState().equals("1")) {
                quartzMangerService.addJob(scheduleJobByJobName);
            }
        }
    }
}
