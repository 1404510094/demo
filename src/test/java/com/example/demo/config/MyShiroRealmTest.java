package com.example.demo.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author:chengbg
 * @date:2018/6/4
 */
public class MyShiroRealmTest {

    @Test
    public void doGetAuthenticationInfo() {
        MyShiroRealm realm = new MyShiroRealm();

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("测试","123");
        subject.login(token);

        System.out.print(subject.isAuthenticated());
    }
}