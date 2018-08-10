package com.jxkj.cjm.model;



import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 主题封面图片临时记录表
 */
@TableName("forum_thread_coverimg")
public class ForumThreadCoverimg extends SuperEntity<ForumThreadCoverimg> {

	private static final long serialVersionUID = 38294486283951455L;
	
	/** 图片url */
	private String url;
	/** 上传时间 */
	private Long dateline;
	/** 是否已使用 1是0否 */
	private Integer status;

	
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Long getDateline() {
		return this.dateline;
	}
	
	public void setDateline(Long dateline) {
		this.dateline = dateline;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}

	
}
