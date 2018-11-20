package com.jxkj.cjm.model;



import com.baomidou.mybatisplus.annotations.TableName;
import com.jxkj.cjm.model.SuperEntity;

/**
 * 短信记录
 */
@TableName("sms_record")
public class SmsRecord extends SuperEntity<SmsRecord> {

	private static final long serialVersionUID = 16445718355803908L;
	
	/** 发送号码 */
	private String sendno;
	/** 用户名 */
	private String username;
	/**名称  */
	private String name;
	/** 接收信息电话 */
	private String mobile;
	/** 验证码  */
	private String vercode;
	/** 发送时间 */
	private Long sendtime;
	/** 短信内容 */
	private String smscontent;
	/**发送方式 （1:手工   2:系统）   */
	private Integer sendtype;
	/** 发送状态 0初始 1成功  2失败*/
	private Integer status;
	/**备注 */
	private String remark;
	/** 用户id */
	private Long baseid;
	/**短信发送返回内容  */
	private String smsreturn;
	
	
	public String getSendno() {
		return this.sendno;
	}
	
	public void setSendno(String sendno) {
		this.sendno = sendno;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobile() {
		return this.mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getVercode() {
		return this.vercode;
	}
	
	public void setVercode(String vercode) {
		this.vercode = vercode;
	}
	
	public Long getSendtime() {
		return this.sendtime;
	}
	
	public void setSendtime(Long sendtime) {
		this.sendtime = sendtime;
	}
	
	public String getSmscontent() {
		return this.smscontent;
	}
	
	public void setSmscontent(String smscontent) {
		this.smscontent = smscontent;
	}
	
	public Integer getSendtype() {
		return this.sendtype;
	}
	
	public void setSendtype(Integer sendtype) {
		this.sendtype = sendtype;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Long getBaseid() {
		return this.baseid;
	}
	
	public void setBaseid(Long baseid) {
		this.baseid = baseid;
	}
	
	public String getSmsreturn() {
		return this.smsreturn;
	}
	
	public void setSmsreturn(String smsreturn) {
		this.smsreturn = smsreturn;
	}
	
}
