package com.dang.note.shiro.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.dang.note.shiro.domain.User;
import com.dang.note.shiro.resource.mysql.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void testCreate(){
        User user = new User();
        user.setUsername("dang12");
        user.setPassword("dang12");
        user.setSalt("salt12");
        user.setLocked(0);
        userMapper.createUser(user);
        user.setSalt("dang");
        userMapper.updateUser(user);
        userMapper.deleteUser(user.getId());
    }
    @Test
    public void testFindOne(){
        User user = userMapper.findOne(1);
        Assert.assertEquals(user.getUsername(),"dang");
    }
}
