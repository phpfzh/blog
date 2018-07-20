package com.jxkj.cjm.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录
 */
@ApiModel(description = "用户登录请求参数描述")
public class UserLoginVo {
    /**用户名**/
    @NotBlank(message = "登录名不能为空")
    @ApiModelProperty(value = "登录名",required = true,example = "13553869052")
    private String username;
    /**密码**/
    @NotBlank(message = "登录密码不能为空")
    @ApiModelProperty(value = "登录密码",required = true,example = "123456a")
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
