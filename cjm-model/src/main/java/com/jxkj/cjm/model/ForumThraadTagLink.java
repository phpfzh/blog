package com.jxkj.cjm.model;



import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 主题类型关联实体类
 */
@TableName("forum_thraad_tag_link")
public class ForumThraadTagLink extends SuperEntity<ForumThraadTagLink> {

	private static final long serialVersionUID = 36965101045963581L;
	
	/** 主题类型id */
	private String tagid;
	/** 主题id */
	private String tid;
	
	
	public String getTagid() {
		return this.tagid;
	}
	
	public void setTagid(String tagid) {
		this.tagid = tagid;
	}
	
	public String getTid() {
		return this.tid;
	}
	
	public void setTid(String tid) {
		this.tid = tid;
	}
	
}
