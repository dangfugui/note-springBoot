package com.dang.note.shiro.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.dang.note.shiro.domain.User;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private Logger log = LoggerFactory.getLogger(AuthController.class);
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session,HttpServletRequest request){
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);   //完成登录
            User user=(User) subject.getPrincipal();
            session.setAttribute("user",user);
            request.setAttribute("user",user);
            return "index";
        } catch(Exception e) {
            log.info("登陆失败",e);
            return "error";//返回登录页面
        }
    }

    @RequestMapping("/hasRole")
    public boolean hasRole( String role, HttpSession session) {
        User user = (User)session.getAttribute("user");
        Subject subject = SecurityUtils.getSubject();
        return subject.hasRole(role);

    }
    @RequestMapping("/isPermitted")
    public boolean isPermitted( String permitted, HttpSession session) {
        User user = (User)session.getAttribute("user");
        Subject subject = SecurityUtils.getSubject();
        return subject.isPermitted(permitted);

    }
}
