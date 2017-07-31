package com.dang.note.shiro.resource.mysql;

import com.dang.note.shiro.domain.User;
import com.dang.note.springboot.domain.Person;

import java.util.List;

/**
 * Created by dangqihe on 2017/7/14.
 */
public interface UserMapper {
    public User findByUserName(String username);
}