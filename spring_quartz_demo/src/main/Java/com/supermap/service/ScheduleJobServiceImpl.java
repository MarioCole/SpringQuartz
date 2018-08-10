package com.supermap.service;


import com.supermap.dao.ScheduleDao;
import com.supermap.entity.ScheduleJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleJobServiceImpl implements ScheduleJobService{
    @Autowired
    private ScheduleDao scheduleDao;
    @Override
    public Long saveScheduleJob(ScheduleJob scheduleJob) {
        return  scheduleDao.save(scheduleJob);
    }

    @Override
    public boolean deleteScheduleJob(Long id) {
        return scheduleDao.delete(id);
    }

    @Override
    public ScheduleJob getScheduleJobById(Long id) {
        ScheduleJob scheduleJob = this.scheduleDao.get(id);
        return scheduleJob;
    }
}
