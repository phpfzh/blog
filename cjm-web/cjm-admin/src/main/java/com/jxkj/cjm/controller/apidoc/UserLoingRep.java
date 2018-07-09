package com.jxkj.cjm.controller.apidoc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 登录接口返回的 API doc 描述
 */
@ApiModel
public class UserLoingRep {

    @ApiModelProperty(value = "登录成功返回的token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
