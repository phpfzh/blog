package com.jxkj.cjm.model;



import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 */
@TableName("user_safety")
public class UserSafety extends SuperEntity<UserSafety> {

	private static final long serialVersionUID = 64846764927369568L;
	
	/**  */
	private Long baseid;
	/**  */
	private String password;
	/**  */
	private Long regtime;
	/**  */
	private String regip;
	/**  */
	private Integer errorcount;
	/**  */
	private Integer status;
	/**  */
	private Integer isdelete;
	/**  */
	private Long lastlogintime;
	/**  */
	private String lastloginip;
	
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
