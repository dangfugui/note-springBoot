package com.dang.note.springboot.controller;

import com.dang.note.springboot.domain.Person;
import com.dang.note.springboot.resource.mongodb.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by dangqihe on 2017/7/14.
 */
@RestController
@RequestMapping("/mongo")
public class MongoController {
    Logger logger = LoggerFactory.getLogger(MongoController.class);
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/savePerson")
    public String set(Person person){
        personRepository.save(person);
        return "save:"+person.toString();
    }
    @RequestMapping("/findById")
    public Person findById(String id){
        return personRepository.findOne(id);
    }
    @RequestMapping("/findByName")
    public List<Person> findByName(String name){
        return personRepository.findByName(name);
    }
    @RequestMapping("list")
    public List<Person> list(){
        return personRepository.findAll();
    }
}
