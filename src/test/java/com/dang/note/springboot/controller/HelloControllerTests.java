package com.dang.note.springboot.controller;

import com.dang.note.springboot.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by dangqihe on 2017/7/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class HelloControllerTests {
    @Autowired
    HelloController helloController;
    @Test
    public void testHelloworld(){
        String expectedResult="Hello world!";
        String result=helloController.helloworld();
        Assert.assertTrue("数据一致", expectedResult.equals(result));
        Assert.assertFalse("数据不一致", !expectedResult.equals(result));
    }
}
