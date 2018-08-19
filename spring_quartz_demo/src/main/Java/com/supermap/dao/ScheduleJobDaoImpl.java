package com.supermap.dao;

import com.supermap.entity.ScheduleJob;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        Transaction transaction = getCurrentSession().beginTransaction();
        String hql = "from ScheduleJob";
        Query query = getCurrentSession().createQuery(hql);
        List<ScheduleJob> list = query.list();
        transaction.commit();
        return list;
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
    public void updateState(ScheduleJob scheduleJob) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        ScheduleJob job = (ScheduleJob) session.get(ScheduleJob.class, scheduleJob.getId());
        if (scheduleJob.getJobState().equals("1")){
            job.setJobState("0");
            session.update(job);
            transaction.commit();
        }else {
            job.setJobState("1");
            session.update(job);
            transaction.commit();
        }
    }

    @Override
    public void updateJob(ScheduleJob scheduleJob) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        ScheduleJob job = (ScheduleJob) session.get(ScheduleJob.class, scheduleJob.getId());
        session.update(job);
        transaction.commit();
    }


    @Override
    public boolean delete(Long id) {
        Transaction transaction = getCurrentSession().beginTransaction();
        ScheduleJob scheduleJob = load(id);
        getCurrentSession().delete(scheduleJob);
        transaction.commit();
        return true;
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }

    @Override
    public ScheduleJob getByJobName(String jobName) {
        Transaction transaction = getCurrentSession().beginTransaction();
        String hql = "select t from ScheduleJob t where t.jobName = ?";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter(0,jobName);
        ScheduleJob scheduleJob = (ScheduleJob) query.uniqueResult();
        transaction.commit();
        return scheduleJob;
    }

    @Override
    public boolean delete(ScheduleJob entity) {
        boolean flag = false;
        try {
            Session session = getCurrentSession();
            Transaction transaction = session.beginTransaction();
            ScheduleJob scheduleJob = get(entity.getId());
            session.delete(scheduleJob);
            System.out.println("删除成功");
            transaction.commit();
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
