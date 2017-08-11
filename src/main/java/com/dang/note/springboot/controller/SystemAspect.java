package com.dang.note.springboot.controller;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Description: 拦截器
 *
 * @Author dangqihe dangqihe@baidu.com
 * @Date Create in 2017/8/10
 */

@Aspect
@Component
public class SystemAspect {
    // 通过注解拦截
    @Pointcut("@annotation( com.dang.note.springboot.controller.Action)")
    public void annotationPointCut() {

    }

    @Before("execution(* com.dang.note.springboot.controller.*.*(..))")
    public void beforeAdmin(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则拦截拦截---------" + method.getName());
    }

    @Before("execution(* com.dang.note.springboot.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则拦截拦截---------" + method.getName());
    }

    @Before("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);

        System.out.println("注解式拦截--------Name: " + action.name());
    }
}
