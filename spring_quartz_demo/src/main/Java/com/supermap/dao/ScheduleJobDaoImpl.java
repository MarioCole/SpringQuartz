package com.supermap.dao;

import com.supermap.entity.ScheduleJob;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleJobDaoImpl implements ScheduleDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.openSession();
    }
    @Override
    public ScheduleJob load(Long id) {
        return (ScheduleJob) getCurrentSession().load(ScheduleJob.class,id);
    }

    @Override
    public ScheduleJob get(Long id) {
        return (ScheduleJob) getCurrentSession().get(ScheduleJob.class,id);
    }

    @Override
    public List<ScheduleJob> findAll() {
        return null;
    }

    @Override
    public void persist(ScheduleJob entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public Long save(ScheduleJob entity) {
        return (Long) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(ScheduleJob entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public boolean delete(Long id) {
        ScheduleJob scheduleJob = load(id);
        getCurrentSession().delete(scheduleJob);
        return false;
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }
}
