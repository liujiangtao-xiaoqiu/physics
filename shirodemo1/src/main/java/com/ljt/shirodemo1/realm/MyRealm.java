package com.ljt.shirodemo1.realm;

import com.ljt.shirodemo1.config.ShiroConfig;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;

public class MyRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("我是授权操作");
        // 获取用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 给该用户设置角色，角色信息存在 t_role 表中取
        if (username.equals("liu")) {

        }
        HashSet<String> set = new HashSet<>();
        set.add("admin");
        authorizationInfo.setRoles(set);
        // 给该用户设置权限，权限信息存在 t_permission 表中取
        HashSet<String> set2 = new HashSet<>();
        set2.add("user:create");
        authorizationInfo.setStringPermissions(set2);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("我是认证操作");

        // 根据 Token 获取用户名，如果您不知道该 Token 怎么来的，先可以不管，下文会解释
        String username = (String) authenticationToken.getPrincipal();
        // 根据用户名从数据库中查询该用户
        //User user = userService.getByUsername(username);
        // 把当前用户存到 Session 中
        SecurityUtils.getSubject().getSession().setAttribute(username, "username" + 1);
        // 传入用户名和密码进行身份认证，并返回认证信息
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(username, "123456", "myRealm");
        return authcInfo;
    }


}

