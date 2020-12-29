package com.framework.web.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationListener;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.PrincipalCollection;

@Slf4j
public class AuthcListener implements AuthenticationListener {

    @Override
    public void onSuccess(AuthenticationToken token, AuthenticationInfo info) {
        if(log.isDebugEnabled()) {
            log.debug("Account [" + token.getPrincipal() + "] Login Success, Init AccountInfo.");
        }
        AccountInfo.init(token.getPrincipal().toString(), "admin");
    }

    @Override
    public void onFailure(AuthenticationToken token, AuthenticationException ae) {
        if(log.isDebugEnabled()) {
            log.debug("[" + token.getPrincipal() + "] Login Failure");
        }
    }

    @Override
    public void onLogout(PrincipalCollection principals) {
        if(log.isDebugEnabled()) {
            log.debug("Account [" + principals.getPrimaryPrincipal() + "] Logout, Clean AccountInfo.");
        }
        AccountInfo.clean();
    }

}
