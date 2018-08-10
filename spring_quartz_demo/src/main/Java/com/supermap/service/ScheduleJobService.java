package com.supermap.service;

import com.supermap.entity.ScheduleJob;

public interface ScheduleJobService {
    Long saveScheduleJob(ScheduleJob scheduleJob);

    boolean deleteScheduleJob(Long id);

    ScheduleJob getScheduleJobById(Long id);
}
