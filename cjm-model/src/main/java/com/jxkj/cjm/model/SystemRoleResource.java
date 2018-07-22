package com.jxkj.cjm.model;



import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 角色资源关联
 */
@TableName("system_role_resource")
public class SystemRoleResource {

	private static final long serialVersionUID = 31907197746807877L;
	
	/** 角色id */
	private String roleid;
	/** 资源id */
	private String resourceid;
	
	
	public String getRoleid() {
		return this.roleid;
	}
	
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	public String getResourceid() {
		return this.resourceid;
	}
	
	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}
	
}
