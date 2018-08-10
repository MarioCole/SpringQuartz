package com.supermap.test;

import com.supermap.dao.PersonRepositoryImpl;
import com.supermap.entity.Person;
import com.supermap.entity.ScheduleJob;
import org.junit.jupiter.api.Test;

public class TestDao {


    @Test
    public void testPersonAdd(){
        Person person = new Person();
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl();
        person.setUsername("kkk");
        person.setAddress("nanc");
        personRepository.save(person);
    }
}
