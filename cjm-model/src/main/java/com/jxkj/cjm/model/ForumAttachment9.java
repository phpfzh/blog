package com.jxkj.cjm.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 
 */
@TableName("forum_attachment_9")
public class ForumAttachment9 extends Model<ForumAttachment0> {

	private static final long serialVersionUID = 32892834134865398L;

	/**  */
	@TableId(type=IdType.INPUT)
	private Long aid;
	/**  */
	private Long tid;
	/**  */
	private Long pid;
	/**  */
	private Long baseid;
	/**  */
	private Long dateline;
	/**  */
	private String filename;
	/**  */
	private Integer filesize;
	/**  */
	private String attachment;
	/**  */
	private String thumachment;
	/**  */
	private String waterattachment;
	/**  */
	private Integer remote;
	/**  */
	private String description;
	/**  */
	private Integer readperm;
	/**  */
	private Integer price;
	/**  */
	private Integer isimage;
	/**  */
	private Integer width;
	/**  */
	private String picid;

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getBaseid() {
		return baseid;
	}

	public void setBaseid(Long baseid) {
		this.baseid = baseid;
	}

	public Long getDateline() {
		return dateline;
	}

	public void setDateline(Long dateline) {
		this.dateline = dateline;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Integer getFilesize() {
		return filesize;
	}

	public void setFilesize(Integer filesize) {
		this.filesize = filesize;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getThumachment() {
		return thumachment;
	}

	public void setThumachment(String thumachment) {
		this.thumachment = thumachment;
	}

	public String getWaterattachment() {
		return waterattachment;
	}

	public void setWaterattachment(String waterattachment) {
		this.waterattachment = waterattachment;
	}

	public Integer getRemote() {
		return remote;
	}

	public void setRemote(Integer remote) {
		this.remote = remote;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReadperm() {
		return readperm;
	}

	public void setReadperm(Integer readperm) {
		this.readperm = readperm;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getIsimage() {
		return isimage;
	}

	public void setIsimage(Integer isimage) {
		this.isimage = isimage;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getPicid() {
		return picid;
	}

	public void setPicid(String picid) {
		this.picid = picid;
	}

	@Override
	protected Serializable pkVal() {
 		return this.aid;
	}

}
