package com.jxkj.cjm.model;



import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 用户角色关联表
 */
@TableName("system_user_role")
public class SystemUserRole {

	private static final long serialVersionUID = 66166411820933111L;
	
	/** 角色id */
	private String roleid;
	/** 用户id */
	private String userid;
	
	
	public String getRoleid() {
		return this.roleid;
	}
	
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	public String getUserid() {
		return this.userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
}
