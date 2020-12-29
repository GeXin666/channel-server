package com.framework.web.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public final class AccountInfo {

    /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/
    public static final String ATTR_PREFIX = AccountInfo.class.getName();

    public static final String SESSION_ATTR_USER_ID = ATTR_PREFIX + ".userId";

    public static final String SESSION_ATTR_USER_NAME = ATTR_PREFIX + ".userName";

    /**
     * 初始化账户信息
     * @param userId 用户ID
     * @param username 用户名
     */
    public static void init(String userId, String username) {
        Session session = getSession();
        session.setAttribute(SESSION_ATTR_USER_ID, userId);
        session.setAttribute(SESSION_ATTR_USER_NAME, username);
    }

    /**
     * 删除账户信息
     */
    public static void clean() {
        Session session = getSession();
        session.removeAttribute(SESSION_ATTR_USER_ID);
        session.removeAttribute(SESSION_ATTR_USER_NAME);
    }

    /**
     * 获取SESSION
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 获取用户ID
     * @return
     */
    public static String getUserId() {
        return (String) getSession().getAttribute(SESSION_ATTR_USER_ID);
    }

    /**
     * 获取用户姓名
     * @return
     */
    public static String getUserName() {
        return (String) getSession().getAttribute(SESSION_ATTR_USER_NAME);
    }
}
