package com.jxkj.cjm.model;



import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 用户角色关联表
 */
@TableName("system_user_role")
public class SystemUserRole {

	private static final long serialVersionUID = 66166411820933111L;
	
	/** 角色id */
	private Long roleid;
	/** 用户id */
	private Long userid;
	
	
	public Long getRoleid() {
		return this.roleid;
	}
	
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	
	public Long getUserid() {
		return this.userid;
	}
	
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
}
