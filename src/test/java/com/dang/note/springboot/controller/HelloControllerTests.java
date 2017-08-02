package com.dang.note.springboot.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dang.note.Application;

/**
 * Created by dangqihe on 2017/7/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class HelloControllerTests {
    @Autowired
    HelloController helloController;
    @Test
    public void testHelloworld(){
        String expectedResult="Hello world!";
        String result=helloController.helloworld();
        //Assert.assertTrue("数据一致", expectedResult.equals(result));
        Assert.assertEquals(expectedResult,result);
        //Assert.assertFalse("数据不一致", !expectedResult.equals(result));
    }
}
