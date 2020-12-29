package com.framework.core.shiro;

import com.framework.core.excepton.ErrorCode;
import com.framework.core.excepton.PermissionException;
import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 客户端RememberMe会把当前账户加密记录到Cookie里
 * 在访问时会从中恢复当前账户，但当前账户并没有登录
 * subject.getPrincipal() != null;
 */
public class MyUserFilter extends UserFilter {

    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        throw new PermissionException(ErrorCode.CODE_00003);
    }
}
