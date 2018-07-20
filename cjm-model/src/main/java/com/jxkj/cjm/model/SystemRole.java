package com.jxkj.cjm.model;



import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 角色
 */
@TableName("system_role")
public class SystemRole extends Model<SystemRole> {

	private static final long serialVersionUID = 83030362303029344L;
	
	/** 角色id */
	@TableId(type= IdType.AUTO)
	private Long roleid;
	/** 角色名称 */
	private String rolename;
	
	
	public Long getRoleid() {
		return this.roleid;
	}
	
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	
	public String getRolename() {
		return this.rolename;
	}
	
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Override
	protected Serializable pkVal() {
		return this.roleid;
	}
}
