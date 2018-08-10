package com.supermap.service;

import com.supermap.dao.PersonRepository;
import com.supermap.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Long savePerson() {
        Person person = new Person();
        person.setUsername("hahah");
        person.setAddress("nanc");

        return personRepository.save(person);
    }
}
