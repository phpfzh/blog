package com.jxkj.cjm.model.vo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @Auther: cjm
 * @Date: 2018/7/8 18:07
 * @Description:
 * @ClassName: UserRegVo
 */
 public class UserRegVo {
    /**用户名**/
    @Length(max = 10,message = "用户名长度不能超过10位")
    private String username;
    /**邮箱**/
    private String email;
    /**手机号**/
    @NotBlank(message = "手机号不能为空")
     private String mobile;
    /**密码**/
    @NotBlank(message = "用户密码不能为空")
    private String password;
    /**手机短信验证码**/
    @NotBlank(message = "手机短信验证码不能为空")
    private String code;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
