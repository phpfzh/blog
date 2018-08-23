package com.jxkj.cjm.model;



import com.baomidou.mybatisplus.annotations.TableName;
import com.jxkj.cjm.model.SuperEntity;

/**
 * 
 */
@TableName("friendlink")
public class Friendlink extends SuperEntity<Friendlink> {

	private static final long serialVersionUID = 62340403248561999L;

	/** 链接 */
	private String link;
	/** 保存时间 */
	private Long dateline;
	/** 用户id */
	private Long baseid;
	/**  名称 */
	private String name;
	/** 排序 */
	private Integer sort;
	/** 类型1友情链接 2 常用站点 */
	private Integer type;
	/**  备注信息 */
	private String remark;
	/**  备注信息 */
	private Long updateid;
	/**  备注信息 */
	private Long updateline;
	public String getLink() {
		return this.link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public Long getDateline() {
		return this.dateline;
	}
	
	public void setDateline(Long dateline) {
		this.dateline = dateline;
	}
	
	public Long getBaseid() {
		return this.baseid;
	}
	
	public void setBaseid(Long baseid) {
		this.baseid = baseid;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getSort() {
		return this.sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public Integer getType() {
		return this.type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getUpdateid() {
		return updateid;
	}

	public void setUpdateid(Long updateid) {
		this.updateid = updateid;
	}

	public Long getUpdateline() {
		return updateline;
	}

	public void setUpdateline(Long updateline) {
		this.updateline = updateline;
	}
}
