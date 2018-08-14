package com.supermap.test;

import com.supermap.dao.PersonRepositoryImpl;
import com.supermap.dao.ScheduleDao;
import com.supermap.entity.Person;
import com.supermap.entity.ScheduleJob;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ScheduleDao scheduleDao;

    @Test
    public void testPersonAdd(){
        Person person = new Person();
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl();
        person.setUsername("kkk");
        person.setAddress("nanc");
        personRepository.save(person);
    }

}
