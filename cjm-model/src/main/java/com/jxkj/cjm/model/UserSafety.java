package com.jxkj.cjm.model;


import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 用户安全表
 */
@TableName("user_safety")
public class UserSafety extends SuperEntity<UserSafety> {

    private static final long serialVersionUID = 64846764927369568L;

    /**
     * 用户id
     */
    private Long baseid;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 注册时间
     */
    private Long regtime;
    /**
     * 注册ip
     */
    private String regip;
    /**
     * 登录失败次数
     */
    private Integer errorcount;
    /**
     * 是否禁止登录 1是 0否
     */
    private Integer status;
    /**
     * 是否删除
     */
    private Integer isdelete;
    /**
     * 最后登录时间
     */
    private Long lastlogintime;
    /**
     * 最后登录ip
     */
    private String lastloginip;
    /**
     * 是否管理员
     **/
    private Integer isadmin;

    public Long getBaseid() {
        return this.baseid;
    }

    public void setBaseid(Long baseid) {
        this.baseid = baseid;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRegtime() {
        return this.regtime;
    }

    public void setRegtime(Long regtime) {
        this.regtime = regtime;
    }

    public String getRegip() {
        return this.regip;
    }

    public void setRegip(String regip) {
        this.regip = regip;
    }

    public Integer getErrorcount() {
        return this.errorcount;
    }

    public void setErrorcount(Integer errorcount) {
        this.errorcount = errorcount;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsdelete() {
        return this.isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Long getLastlogintime() {
        return this.lastlogintime;
    }

    public void setLastlogintime(Long lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip;
    }

    public Integer getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Integer isadmin) {
        this.isadmin = isadmin;
    }

}
