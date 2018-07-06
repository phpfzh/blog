package com.jxkj.cjm.model;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 主题操作日志表
 */
@TableName("forum_thread_operation")
public class PreForumThreadOperation extends SuperEntity<PreForumThreadOperation> {


	/**  
	* Title: PreForumThreadOperation.java
	* Description:  
	*  www.chenjiaming.com  
	* @author cjm  
	* @date 2018年6月9日  
	* @version 1.0  
	*/  
	private static final long serialVersionUID = 1L;
	/** 主题id */
	private Long tid;
	/** 操作状态 1成功0失败 */
	private Integer status;
	/** 类型 */
	private String type;
	/** 时间 */
	private Long dateline;
	/** 操作用户 */
	private Long baseid;
	/** 操作用户名 */
	private String username;
	/** 操作用户ip*/
	private String userip;

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getDateline() {
		return dateline;
	}

	public void setDateline(Long dateline) {
		this.dateline = dateline;
	}

	public Long getBaseid() {
		return baseid;
	}

	public void setBaseid(Long baseid) {
		this.baseid = baseid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserip() {
		return userip;
	}

	public void setUserip(String userip) {
		this.userip = userip;
	}

}
