package com.supermap.service;

import com.supermap.entity.ScheduleJob;

import java.util.List;

public interface ScheduleJobService {
    /**
     * 保存一个job
     * @param scheduleJob
     * @return
     */
    Long saveScheduleJob(ScheduleJob scheduleJob);

    /**
     * 更新一个job
     * @param scheduleJob
     */
    void updateScheduleJob(ScheduleJob scheduleJob);

    /**
     * 删除一个job
     * @param id 主键
     * @return
     */
    boolean deleteScheduleJob(Long id);

    /**
     * 获取job
     * @param id 主键值
     * @return
     */
    ScheduleJob getScheduleJobById(Long id);

    /**
     * 获取job
     * @param jobName
     * @return
     */
    ScheduleJob getScheduleJobByJobName(String jobName);

    /**
     * 删除一个job
     * @param scheduleJob
     * @return
     */
    boolean deleteScheduleJob(ScheduleJob scheduleJob);

    List<ScheduleJob> findAll();


}
