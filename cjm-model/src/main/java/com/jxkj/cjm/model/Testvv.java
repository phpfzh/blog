package com.jxkj.cjm.model;



import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 */
@TableName("testvv")
public class Testvv extends SuperEntity<Testvv> {

	private static final long serialVersionUID = 70253829357915872L;
	
	/**  */
	private Boolean visfff;
	/**  */
	private Boolean visfff2;
	
	
	public Boolean getVisfff() {
		return this.visfff;
	}
	
	public void setVisfff(Boolean visfff) {
		this.visfff = visfff;
	}
	
	public Boolean getVisfff2() {
		return this.visfff2;
	}
	
	public void setVisfff2(Boolean visfff2) {
		this.visfff2 = visfff2;
	}
	
}
