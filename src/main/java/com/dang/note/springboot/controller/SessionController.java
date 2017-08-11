package com.dang.note.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @Author dangqihe dangqihe@baidu.com
 * @Date Create in 2017/8/11
 */
@RestController
@RequestMapping("/session")
public class SessionController {
    @RequestMapping("/set")
    public String set(String key, String value, HttpSession session){
        session.setAttribute(key,value);
        return value;
    }
    @RequestMapping("/get")
    public String get(String key, HttpSession session){
        return (String) session.getAttribute(key);
    }
}
