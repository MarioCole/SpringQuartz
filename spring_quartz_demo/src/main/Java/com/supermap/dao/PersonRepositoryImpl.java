package com.supermap.dao;

import com.supermap.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.openSession();
    }

    @Override
    public Person load(Long id) {

        return (Person) getCurrentSession().load(Person.class,id);
    }

    @Override
    public Person get(Long id) {

        return (Person)getCurrentSession().get(Person.class,id);
    }

    @Override
    public List<Person> findAll() {

        return null;
    }

    @Override
    public void persist(Person entity) {

        getCurrentSession().persist(entity);
    }

    @Override
    public Long save(Person entity) {

        return (Long) getCurrentSession().save(entity);
    }

    @Override
    public void updateState(Person entity) {

        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public boolean delete(Long id) {
        Person person = load(id);
        getCurrentSession().delete(person);
        return true;
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }

    @Override
    public Person getByJobName(String jobName) {
        return null;
    }

    @Override
    public boolean delete(Person entity) {
        return false;
    }
}
