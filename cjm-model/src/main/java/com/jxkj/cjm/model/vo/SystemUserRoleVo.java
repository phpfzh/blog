package com.jxkj.cjm.model.vo;

import javax.validation.constraints.NotNull;

public class SystemUserRoleVo {

    private static final long serialVersionUID = 66166411820933111L;

    /**
     * 角色id
     */
    @NotNull(message = "角色id不能为空")
    private Long roleid;
    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空")
    private Long userid;

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
