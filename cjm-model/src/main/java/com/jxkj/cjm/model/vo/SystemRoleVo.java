package com.jxkj.cjm.model.vo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 角色 对象
 */
public class SystemRoleVo {

    /**
     * 角色id
     **/
    @NotNull(message = "主键id不能为空", groups = {GroupUpdate.class})
    private Long roleid;
    /**
     * 角色名称
     **/
    @NotBlank(message = "角色名称不能为空", groups = {GroupSave.class})
    @Length(max = 50, message = "角色名称不能超过50字符", groups = {GroupSave.class})
    private String rolename;

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
