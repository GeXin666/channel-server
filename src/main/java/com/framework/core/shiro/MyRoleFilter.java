package com.framework.core.shiro;

import com.framework.core.excepton.ErrorCode;
import com.framework.core.excepton.PermissionException;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 当前用户必须拥有相应角色
 * subject.hasAllRoles(roles);
 */
public class MyRoleFilter extends RolesAuthorizationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        throw new PermissionException(ErrorCode.CODE_00004);
    }
}
