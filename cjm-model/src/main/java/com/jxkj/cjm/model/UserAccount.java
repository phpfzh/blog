package com.jxkj.cjm.model;



import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 */
@TableName("user_account")
public class UserAccount extends SuperEntity<UserAccount> {

	private static final long serialVersionUID = 4844091889780630L;
	
	/**  */
	private Long baseid;
	/**  */
	private BigDecimal balance;
	/**  */
	private BigDecimal freezebalance;
	/**  */
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
