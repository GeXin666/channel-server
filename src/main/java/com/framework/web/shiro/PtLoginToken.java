package com.framework.web.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class PtLoginToken extends UsernamePasswordToken {

    private int userType;

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
