package com.framework.core.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

//@Validated({Foo.Adult.class})
//@Min(value = 18,groups = {Adult.class})
//@NotBlank(message = "{Login.password.NotBlank}")

@Data
public class Login {

    @NotBlank(message = "账号不能为空")
    @Length(min = 11, max = 11, message = "账户长度必须11位")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 15, message = "密码长度必须6-15位")
    private String password;

    private int userType;
}
