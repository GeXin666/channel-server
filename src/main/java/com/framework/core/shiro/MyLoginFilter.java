package com.framework.core.shiro;

import com.framework.core.excepton.ErrorCode;
import com.framework.core.excepton.PermissionException;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 当前用户须进行过登录认证
 * subject.isAuthenticated() == true
 */
public class MyLoginFilter extends AuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        throw new PermissionException(ErrorCode.CODE_00006);
    }

}
