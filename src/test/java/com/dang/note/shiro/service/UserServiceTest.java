package com.dang.note.shiro.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dang.note.shiro.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {
    @Autowired
    public UserService userService;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setUsername("dang2");
        user.setPassword("dang2");
        user.setSalt("salt2");
        user.setLocked(0);
        User createUser = userService.createUser(user);
        Assert.assertEquals(user,createUser);
    }
}
