package com.dang.note.springboot.controller;

import com.dang.note.springboot.domain.Person;
import com.dang.note.springboot.resource.redis.ObjectDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ObjectRedisController {

    protected static Logger logger=LoggerFactory.getLogger(ObjectRedisController.class);
    @Autowired
    ObjectDao<String,Person> objectDao;
    @RequestMapping("/setPerson")
    public String set(String id,String name,Integer age){
        logger.debug("访问setPerson:id={},name={},age={}",id,name,age);
        Person person = new Person(id,name,age);
        objectDao.save(person.getId(),person);
        return "save:"+person.toString();
    }

    @RequestMapping("/getPerson")
    public Person getPerson(String id){
        return objectDao.get(id);
    }
}