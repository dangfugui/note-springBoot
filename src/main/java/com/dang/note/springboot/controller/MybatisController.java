package com.dang.note.springboot.controller;

import com.dang.note.springboot.domain.Person;
import com.dang.note.springboot.resource.mysql.PersonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dangqihe on 2017/7/14.
 */
@RestController
@RequestMapping("/mybatis")
public class MybatisController {
    protected static Logger logger = LoggerFactory.getLogger(MybatisController.class);
    @Resource
    PersonMapper personMapper;
    @RequestMapping("/list")
    public List<Person> list(){
        logger.info("list");
        return personMapper.list();
    }
}
