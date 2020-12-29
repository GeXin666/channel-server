package com.framework.web.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 账号密码登录验证器
 */
@Slf4j
public class LoginRealm extends AuthorizingRealm {

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof PtLoginToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo account = new SimpleAuthorizationInfo();
        account.addRole("role1");
        account.addStringPermission("p1");
        return account;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        PtLoginToken loginToken = (PtLoginToken) token;
        String username = loginToken.getUsername();
        String password = new String(loginToken.getPassword());
        log.debug("authentication username=[" + username + "] password=[" + password + "]");
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
        return info;
    }

}
