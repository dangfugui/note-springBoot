package com.dang.note.shiro.resource.mysql;

import com.dang.note.shiro.domain.User;
import com.dang.note.springboot.domain.Person;

import java.util.List;

/**
 * Created by dangqihe on 2017/7/14.
 */
public interface UserMapper {
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(Long userId);
    User findOne(long userId);
    User findByUserName(String username);

}