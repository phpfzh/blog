package com.jxkj.cjm.model.vo;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录
 */
public class UserLoginVo {
    /**
     * 用户名
     **/
    @NotBlank(message = "登录名不能为空")
    private String username;
    /**
     * 密码
     **/
    @NotBlank(message = "登录密码不能为空")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
