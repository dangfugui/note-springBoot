package com.dang.note.shiro.auth;

import com.dang.note.shiro.domain.Permission;
import com.dang.note.shiro.domain.Role;
import com.dang.note.shiro.domain.User;
import com.dang.note.shiro.resource.mysql.UserMapper;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 类AuthRealm完成根据用户名去数据库的查询,并且将用户信息放入shiro中,供第二个类调用.
 * Realm：域，Shiro从从Realm获取安全数据（如用户、角色、权限），就是说SecurityManager要验证用户身份，那么它需要从Realm
 * 获取相应的用户进行比较以确定用户身份是否合法；也需要从Realm得到用户相应的角色/权限进行验证用户是否能进行操作；可以把
 * Realm看成DataSource，即安全数据源。
 */
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    //认证.登录 Authenticator的职责是验证用户帐号，是Shiro API中身份验证核心的入口点：
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        User user = userMapper.findByUserName(username);
        if (user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        if (user.getLocked() == 1) {
            throw new LockedAccountException(); //帐号锁定
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以在此判断或自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户名
                user.getPassword(), //密码
               // ByteSource.Util.bytes(user.getUsername() + user.getSalt()),//salt=username+salt
                this.getClass().getName()  //realm name
        );
        return authenticationInfo;
        //return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());//放入shiro
        // .调用CredentialsMatcher检验密码
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user = (User) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<Role> roles = user.getRoles();
        for (Role role : user.getRoles()) {
            info.addRole(role.getRole());
            for (Permission p : role.getPermissions()) {
                info.addStringPermission(p.getPermission());//将权限放入shiro中.
            }
        }
        return info;
    }
}