package com.supermap.test;

import com.supermap.dao.ScheduleDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TestDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ScheduleDao scheduleDao;


}
