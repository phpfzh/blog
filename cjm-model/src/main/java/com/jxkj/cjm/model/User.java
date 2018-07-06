package com.jxkj.cjm.model;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
* @ClassName: User 
* @Description: TODO  用户表
* @author cjm  
* @date 2018年6月6日  
* @version 1.0 
* www.chenjiaming.com
 */
@TableName("user")
public class User extends SuperEntity<User> {

	private static final long serialVersionUID = 27126354867580511L;
	
	/** 用户名 */
	private String username;
	/** 手机号 */
	private String mobile;
	/** 手机是否验证1是0否 */
	private Integer mobilestatus;
	/** 邮箱 */
	private String email;
	/** 邮箱是否验证 1是0否*/
	private Integer emailstatus;
	/** 用户号*/
	private String userno;
	/** 注册时间 */
	private Long regtime;
	/** 用户头像 */
	private String img;
	/**  */
	private String signature;
	/** 真实姓名 */
	private String relaname;
	/** 身份证号码 */
	private String idcardnumber;
	/**是否身份证验证  */
	private Integer relastatus;
	/**注册ip  */
	private String regip;
	/** 注册来源 */
	private String device;
	 
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	 
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getEmailstatus() {
		return this.emailstatus;
	}
	
	public void setEmailstatus(Integer emailstatus) {
		this.emailstatus = emailstatus;
	}
	
	public String getUserno() {
		return this.userno;
	}
	
	public void setUserno(String userno) {
		this.userno = userno;
	}
	
	public Long getRegtime() {
		return this.regtime;
	}
	
	public void setRegtime(Long regtime) {
		this.regtime = regtime;
	}
	
	public String getImg() {
		return this.img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getSignature() {
		return this.signature;
	}
	
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	public String getRelaname() {
		return this.relaname;
	}
	
	public void setRelaname(String relaname) {
		this.relaname = relaname;
	}
	
	public String getIdcardnumber() {
		return this.idcardnumber;
	}
	
	public void setIdcardnumber(String idcardnumber) {
		this.idcardnumber = idcardnumber;
	}
	
	public Integer getRelastatus() {
		return this.relastatus;
	}
	
	public void setRelastatus(Integer relastatus) {
		this.relastatus = relastatus;
	}
	
	public String getRegip() {
		return this.regip;
	}
	
	public void setRegip(String regip) {
		this.regip = regip;
	}
	
	public String getDevice() {
		return this.device;
	}
	
	public void setDevice(String device) {
		this.device = device;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getMobilestatus() {
		return mobilestatus;
	}

	public void setMobilestatus(Integer mobilestatus) {
		this.mobilestatus = mobilestatus;
	}
	
	
}
