package com.supermap.service;


import com.supermap.dao.ScheduleDao;
import com.supermap.entity.ScheduleJob;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleJobServiceImpl implements ScheduleJobService{
    @Autowired
    private ScheduleDao scheduleDao;

    @Override
    public Long saveScheduleJob(ScheduleJob scheduleJob) {
        return  scheduleDao.save(scheduleJob);
    }

    @Override
    public void updateScheduleJobState(ScheduleJob scheduleJob) {
        this.scheduleDao.updateState(scheduleJob);
    }

    @Override
    public void updateScheduleJob(ScheduleJob scheduleJob) {
        this.scheduleDao.updateJob(scheduleJob);
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

    @Override
    public ScheduleJob getScheduleJobByJobName(String groupName) {
        ScheduleJob byJobName = this.scheduleDao.getByJobName(groupName);
        return byJobName;
    }

    @Override
    public boolean deleteScheduleJob(ScheduleJob scheduleJob) {
        return this.scheduleDao.delete(scheduleJob);
    }

    @Override
    public List<ScheduleJob> findAll() {
        return scheduleDao.findAll();
    }
}
