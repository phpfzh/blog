package com.jxkj.cjm.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 角色 对象
 */
@ApiModel(description = "请求参数")
public class SystemRoleVo {

    /**角色id**/
    @ApiModelProperty(value = "角色主键id，修改必填,其他不需要填写")
    @NotNull(message = "主键id不能为空",groups = {GroupUpdate.class})
     private Long roleid;
    /**角色名称**/
    @ApiModelProperty(value = "角色名称",required = true,example = "管理员")
    @NotBlank(message = "角色名称不能为空",groups = {GroupSave.class})
    @Length(max = 50,message = "角色名称不能超过50字符",groups = {GroupSave.class})
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
