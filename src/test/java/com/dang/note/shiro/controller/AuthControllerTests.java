package com.dang.note.shiro.controller;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.dang.note.Application;
import com.dang.note.springboot.controller.HelloController;
import com.dang.note.tool.UrlBean;

/**
 * Created by dangqihe on 2017/7/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AuthControllerTests {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private AuthController authController;
    @Test
    public void testLogin() throws Exception {
        UrlBean urlBean = new UrlBean("/auth/login");
        urlBean.addGetProperty("username","dang");
        urlBean.addGetProperty("password","dang");
        for(int i =0 ;i<100;i++){
            mvc.perform(MockMvcRequestBuilders.get(urlBean.getUrl()).accept(MediaType.ALL)).andReturn();
            System.out.println(i);
        }
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(urlBean.getUrl()).accept(MediaType.ALL)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertTrue("登陆失败", "ok".equals(content));
    }
    @Test
    public void testRole() throws Exception {
        testLogin();
        UrlBean urlBean = new UrlBean("/auth/hasRole");
        urlBean.addGetProperty("role","admin");
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(urlBean.getUrl()).accept(MediaType.ALL)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertTrue("验证失败", "true".equals(content));
    }
//    @Test(expected = UnknownAccountException.class)
//    public void testLoginFailWithUnknownUsername() {
//        login("classpath:shiro.ini",  "1", "");
//    }

//    @Test(expected = IncorrectCredentialsException.class)
//    public void testLoginFailWithErrorPassowrd() {
//        login("classpath:shiro.ini", "dang",  "1");
//    }
//
//    @Test(expected = LockedAccountException.class)
//    public void testLoginFailWithLocked() {
//        login("classpath:shiro.ini", "dang_lock",  "dang");
//    }
//
//    @Test(expected = ExcessiveAttemptsException.class)
//    public void testLoginFailWithLimitRetryCount() {
//        for(int i = 1; i <= 5; i++) {
//            try {
//                login("classpath:shiro.ini", "dang",  "dang"+ "1");
//            } catch (Exception e) {/*ignore*/}
//        }
//        login("classpath:shiro.ini", "dang", "dang");
//
//        //需要清空缓存，否则后续的执行就会遇到问题(或者使用一个全新账户测试)
//    }
//
//
//    @Test
//    public void testHasRole() {
//        login("classpath:shiro.ini", "dang","dang" );
//        junit.framework.Assert.assertTrue(subject().hasRole("admin"));
//    }
//
//    @Test
//    public void testNoRole() {
//        login("classpath:shiro.ini", "dang","dang");
//        junit.framework.Assert.assertFalse(subject().hasRole("admin"));
//    }
//
//    @Test
//    public void testHasPermission() {
//        login("classpath:shiro.ini", "dang","dang");
//        junit.framework.Assert.assertTrue(subject().isPermittedAll("user:create", "menu:create"));
//    }
//
//    @Test
//    public void testNoPermission() {
//        login("classpath:shiro.ini", "dang","dang");
//        junit.framework.Assert.assertFalse(subject().isPermitted("user:create"));
//    }
}
