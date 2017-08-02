package com.dang.note.shiro.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dang.note.shiro.domain.Permission;
import com.dang.note.shiro.domain.Role;
import com.dang.note.shiro.domain.User;
import com.dang.note.shiro.resource.mysql.UserMapper;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User findByUserName(String username){
        return userMapper.findByUserName(username);
    }
    public User createUser(User user) { //创建账户
        //加密密码
       // passwordHelper.encryptPassword(user);
        userMapper.createUser(user);
        return user;
    }
    public void changePassword(Long userId, String newPassword) {//修改密码
        User user = new User();
        user.setId(userId);
        user.setPassword(newPassword);
        userMapper.updateUser(user);
    }
    public void correlationRoles(Long userId, Long... roleIds) { //添加用户-角色关系
    }
    public void uncorrelationRoles(Long userId, Long... roleIds) {// 移除用户-角色关系
    }
    public Set<String> findRoles(String username) {// 根据用户名查找其角色
        User user = userMapper.findByUserName(username);
        Set<String> roles = new HashSet<>();
        for(Role role:user.getRoles()){
            roles.add(role.getRole());
        }
        return roles;
    }
    public Set<String> findPermissions(String username) { //根据用户名查找其权限
        User user = userMapper.findByUserName(username);
        Set<String> set = new HashSet<>();
        for(Role role:user.getRoles()){
            for(Permission permission:role.getPermissions()){
                set.add(permission.getPermission());
            }
        }
        return set;
    }
}
//此处使用findByUsername、findRoles及findPermissions来查找用户名对应的帐号、角色及权限信息。之后的Realm就使用这些方法来查找相关信息。