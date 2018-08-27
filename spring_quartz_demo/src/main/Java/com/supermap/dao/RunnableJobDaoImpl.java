package com.supermap.dao;

import com.supermap.entity.RunnableJob;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RunnableJobDaoImpl implements RunnableJobDao{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return  this.sessionFactory.openSession();
    }

    @Override
    public RunnableJob load(Long id) {
        return null;
    }

    @Override
    public RunnableJob get(Long id) {
        return null;
    }

    @Override
    public List<RunnableJob> findAll() {
        return null;
    }

    @Override
    public void persist(RunnableJob entity) {

    }

    @Override
    public Long save(RunnableJob entity) {
        return (Long) getCurrentSession().save(entity);
    }

    @Override
    public void updateState(RunnableJob runnableJob) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        RunnableJob job = (RunnableJob) session.get(RunnableJob.class, runnableJob.getId());
        job.setRunnable_state("1");
        session.update(job);
        transaction.commit();
    }

    @Override
    public void updateJob(RunnableJob runnableJob) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        RunnableJob job = (RunnableJob) session.get(RunnableJob.class, runnableJob.getId());
        session.update(job);
        transaction.commit();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public RunnableJob getByJobName(String runnable_type) {
        Transaction transaction = getCurrentSession().beginTransaction();
        String hql = "select t from RunnableJob t where t.runnable_type = ?";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter(0,runnable_type);
        RunnableJob runnableJob= (RunnableJob) query.uniqueResult();
        transaction.commit();
        return runnableJob;
    }

    @Override
    public boolean delete(RunnableJob entity) {
        return false;
    }
}
