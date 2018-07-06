package com.jxkj.cjm.model;



import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 */
@TableName("friendlink")
public class Friendlink extends SuperEntity<Friendlink> {

	private static final long serialVersionUID = 95324801427818452L;
	
	/**  */
	private Integer displayorder;
	/**  */
	private String name;
	/**  */
	private String url;
	/**  */
	private String description;
	/**  */
	private String logo;
	/**  */
	private Integer type;
	
	
	public Integer getDisplayorder() {
		return this.displayorder;
	}
	
	public void setDisplayorder(Integer displayorder) {
		this.displayorder = displayorder;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLogo() {
		return this.logo;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public Integer getType() {
		return this.type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
}
