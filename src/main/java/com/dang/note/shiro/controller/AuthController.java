package com.dang.note.shiro.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dang.note.shiro.domain.User;
import com.dang.note.utils.ListUtils;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private Logger log = LoggerFactory.getLogger(AuthController.class);
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);   //完成登录
            User user=(User) subject.getPrincipal();
            session.setAttribute("user",user);
            return "ok";
        } catch(Exception e) {
            log.info("登陆失败",e);
            return "error";//返回登录页面
        }
    }
    @RequestMapping("/hasRole")
    @ResponseBody
    public String hasRole(@RequestBody List<String> role, HttpSession session) {
        User user = (User)session.getAttribute("user");
        Subject subject = SecurityUtils.getSubject();
        return subject.hasRoles(role).toString();

    }
}