package com.jxkj.cjm.model.vo;

public class UserVo {

    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 手机是否验证1是0否
     */
    private Integer mobilestatus;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 邮箱是否验证 1是0否
     */
    private Integer emailstatus;

    /**
     * 用户号
     */
    private String userno;
    /**
     * 用户头像
     */
    private String img;
    /**
     * 真实姓名
     */
    private String relaname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getMobilestatus() {
        return mobilestatus;
    }

    public void setMobilestatus(Integer mobilestatus) {
        this.mobilestatus = mobilestatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmailstatus() {
        return emailstatus;
    }

    public void setEmailstatus(Integer emailstatus) {
        this.emailstatus = emailstatus;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRelaname() {
        return relaname;
    }

    public void setRelaname(String relaname) {
        this.relaname = relaname;
    }
}
