package com.supermap.controller;

import com.supermap.service.PersonService;
import com.supermap.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    private TestService testService;

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(){
        return null;
    }

    @RequestMapping(value = "springtest",method = RequestMethod.GET)
    public String springTest(){
        return testService.test();
    }

    @RequestMapping(value = "savePerson",method = RequestMethod.GET)
    public String savePerson(){
        personService.savePerson();
        return "success";
    }
}
