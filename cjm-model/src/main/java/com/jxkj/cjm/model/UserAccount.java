package com.jxkj.cjm.model;


import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;

/**
 * 
 */
@TableName("user_account")
public class UserAccount extends SuperEntity<UserAccount> {

	private static final long serialVersionUID = 4844091889780630L;
	
	/**  用户id*/
	private Long baseid;
	/**可用余额  */
	private BigDecimal balance;
	/** 冻结余额 */
	private BigDecimal freezebalance;
	/** 总余额 */
	private BigDecimal totalbalance;
	
	
	public Long getBaseid() {
		return this.baseid;
	}
	
	public void setBaseid(Long baseid) {
		this.baseid = baseid;
	}
	
	public BigDecimal getBalance() {
		return this.balance;
	}
	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	public BigDecimal getFreezebalance() {
		return this.freezebalance;
	}
	
	public void setFreezebalance(BigDecimal freezebalance) {
		this.freezebalance = freezebalance;
	}
	
	public BigDecimal getTotalbalance() {
		return this.totalbalance;
	}
	
	public void setTotalbalance(BigDecimal totalbalance) {
		this.totalbalance = totalbalance;
	}
	
}
