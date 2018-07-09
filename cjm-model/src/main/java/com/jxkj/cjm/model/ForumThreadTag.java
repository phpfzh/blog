package com.jxkj.cjm.model;



import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 主题类型实体类
 */
@TableName("forum_thread_tag")
public class ForumThreadTag extends SuperEntity<ForumThreadTag> {

	private static final long serialVersionUID = 84579181089860371L;
	
	/** 名称 */
	private String name;
	/** 添加时间 */
	private String dateline;
	/** 用户id */
	private String uid;
	/** 是否删除 */
	private Integer isdelete;
	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDateline() {
		return this.dateline;
	}
	
	public void setDateline(String dateline) {
		this.dateline = dateline;
	}
	
	public String getUid() {
		return this.uid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public Integer getIsdelete() {
		return this.isdelete;
	}
	
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	
}
