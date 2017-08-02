package com.dang.note.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by dangqihe on 2017/7/14.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    protected static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
    public String helloworld(){
        logger.debug("访问hello");
        return "Hello world!";
//        ModelAndView mv = new ModelAndView("/html/hi");
//        return mv;
    }

    @RequestMapping("/{name}")
    public String hellName(@PathVariable String name){
        logger.debug("访问helloName,Name={}",name);
        return name;
    }
    @RequestMapping("/index")
    public ModelAndView index(Map<String, Object> model){
        ModelAndView mav = new ModelAndView("/hi");
        mav.addObject("content", "index");
        return mav;
    }

}
