package com.dang.note.shiro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dang.note.shiro.domain.User;
import com.dang.note.shiro.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/{username}")
    public User list(String username){
        return userService.findByUserName(username);
    }
}
