package com.jxkj.cjm.controller.apidoc;

import com.jxkj.cjm.common.response.AjaxResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class UserRegRep{
    @ApiModelProperty(value = "注册成功返回的token")
  	private String token;
    @ApiModelProperty(value = "注册成功返回的用户名")
    private String username;
    @ApiModelProperty(value = "注册成功返回的手机号")
    private String mobile;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
