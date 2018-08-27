package com.supermap.service;

import com.supermap.entity.RunnableJob;

public interface RunnableJobService {

    /**
     * 保存一个任务到队列
     * @param runnableJob
     * @return
     */
    Long saveRunnableJob(RunnableJob runnableJob);

    /**
     * 更新一个任务到队列
     * @param runnableJob
     */
    void updateRunnableJob(RunnableJob runnableJob);

    RunnableJob getByRunnable_type(String runnable_type);
}
