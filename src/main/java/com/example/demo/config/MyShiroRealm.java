package com.example.demo.config;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author:chengbg
 * @date:2018/6/4
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        //得到从主体传入的用户名
        String username = (String)token.getPrincipal();

        //从数据库获取用户
        User user = userService.findByUsername(username);

        //检测是否有此用户
        if(user == null){
            throw new UnknownAccountException("用户不存在");
        }

        String password = user.getPassword();
        //认证信息
        SimpleAuthenticationInfo authenticationInfo =
                new SimpleAuthenticationInfo(username, password, getName());

        return authenticationInfo;
    }
}
