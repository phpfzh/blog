package com.jxkj.cjm.model;


import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 
 */
@TableName("forum_attachment_unused")
public class ForumAttachmentUnused extends Model<ForumAttachmentUnused> {

	private static final long serialVersionUID = 53156362690628966L;
	
	/** 附件id */
	@TableId(type=IdType.INPUT)
	private Long aid;
	/** 主题id */
	private Long tid;
	/**帖子id  */
	private Long pid;
	/** 用户id */
	private Long baseid;
	/** 上传时间 */
	private Long dateline;
	/** 原文件名 */
	private String filename;
	/**文件大小  */
	private Integer filesize;
	/**原图服务器路径  */
	private String attachment;
	/** 缩率图服务器路径 */
	private String thumachment;
	/**水印图服务器路径  */
	private String waterattachment;
	/** 是否远程附件 */
	private Integer remote;
	/** 说明 */
	private String description;
	/** 阅读权限 */
	private Integer readperm;
	/** 附件价格 */
	private Integer price;
	/**是否图片0附件1图片2视频  */
	private Integer isimage;
	/**附件宽度  */
	private Integer width;
	
	
	public Long getAid() {
		return this.aid;
	}
	
	public void setAid(Long aid) {
		this.aid = aid;
	}
	
	public Long getTid() {
		return this.tid;
	}
	
	public void setTid(Long tid) {
		this.tid = tid;
	}
	
	public Long getPid() {
		return this.pid;
	}
	
	public void setPid(Long pid) {
		this.pid = pid;
	}
	
	public Long getBaseid() {
		return this.baseid;
	}
	
	public void setBaseid(Long baseid) {
		this.baseid = baseid;
	}
	
	public Long getDateline() {
		return this.dateline;
	}
	
	public void setDateline(Long dateline) {
		this.dateline = dateline;
	}
	
	public String getFilename() {
		return this.filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public Integer getFilesize() {
		return this.filesize;
	}
	
	public void setFilesize(Integer filesize) {
		this.filesize = filesize;
	}
	
	public String getAttachment() {
		return this.attachment;
	}
	
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	public String getThumachment() {
		return this.thumachment;
	}
	
	public void setThumachment(String thumachment) {
		this.thumachment = thumachment;
	}
	
	public String getWaterattachment() {
		return this.waterattachment;
	}
	
	public void setWaterattachment(String waterattachment) {
		this.waterattachment = waterattachment;
	}
	
	public Integer getRemote() {
		return this.remote;
	}
	
	public void setRemote(Integer remote) {
		this.remote = remote;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getReadperm() {
		return this.readperm;
	}
	
	public void setReadperm(Integer readperm) {
		this.readperm = readperm;
	}
	
	public Integer getPrice() {
		return this.price;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Integer getIsimage() {
		return this.isimage;
	}
	
	public void setIsimage(Integer isimage) {
		this.isimage = isimage;
	}
	
	public Integer getWidth() {
		return this.width;
	}
	
	public void setWidth(Integer width) {
		this.width = width;
	}

	@Override
	protected Serializable pkVal() {
 		return this.aid;
	}
	
}
