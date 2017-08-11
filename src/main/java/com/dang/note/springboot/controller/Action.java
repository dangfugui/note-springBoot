package com.dang.note.springboot.controller;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Description:
 *
 * @Author dangqihe dangqihe@baidu.com
 * @Date Create in 2017/8/10
 */

@Target(ElementType.METHOD)
@Retention(RUNTIME)
@Documented
public @interface Action {

    String name();

}