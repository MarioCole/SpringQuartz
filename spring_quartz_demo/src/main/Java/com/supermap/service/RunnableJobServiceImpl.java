package com.supermap.service;

import com.supermap.dao.RunnableJobDao;
import com.supermap.entity.RunnableJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunnableJobServiceImpl implements RunnableJobService {
    @Autowired
    private RunnableJobDao runnableJobDao;

    @Override
    public Long saveRunnableJob(RunnableJob runnableJob) {
        return runnableJobDao.save(runnableJob);
    }

    @Override
    public void updateRunnableJob(RunnableJob runnableJob) {
        runnableJobDao.updateJob(runnableJob);
    }

    @Override
    public RunnableJob getByRunnable_type(String runnable_type) {
        return runnableJobDao.getByJobName(runnable_type);
    }
}
