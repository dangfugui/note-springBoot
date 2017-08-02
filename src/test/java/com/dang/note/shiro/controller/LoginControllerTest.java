package com.dang.note.shiro.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.dang.note.shiro.resource.mysql.UserMapper;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LoginControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserMapper userMapper;
    @Test
    public void  testLogin() throws Exception {
        String url = "/login/loginUser?username=dang&password=dang";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.ALL)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertTrue("错误，正确的返回值为200", status == 200);
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertTrue("数据不一致", "login".equals(content));
    }
}
