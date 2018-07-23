package com.jxkj.cjm.model;



import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 系统资源
 */
@TableName("system_resource")
public class SystemResource extends Model<SystemResource> {

	private static final long serialVersionUID = 4298843905193480L;
	
	/** 资源ID */
	@TableId(type= IdType.AUTO)
	private Long resourceid;
	/** 资源ID */
	private String resourceurl;
	/** 资源名称 */
	private String resourcename;
	/** 排序编号 */
	private Integer sort;
	/** 备注 */
	private String remark;
	/** 父资源ID */
	private Long parentid ;
	/** 类型 （1为菜单 2 按钮） */
	private Integer type;
	/** 权限 */
	private String permission;
	/** 路由url */
	private String link;
	/** 是否隐藏 */
	private Boolean hide;
	/**  */
	private String icon;
	/** 外部链接 */
	private String externallink;
	/** 链接打开方式  '_blank' | '_self' | '_parent' | '_top' */
	private String target;
	
	
	public Long getResourceid() {
		return this.resourceid;
	}
	
	public void setResourceid(Long resourceid) {
		this.resourceid = resourceid;
	}
	
	public String getResourceurl() {
		return this.resourceurl;
	}
	
	public void setResourceurl(String resourceurl) {
		this.resourceurl = resourceurl;
	}
	
	public String getResourcename() {
		return this.resourcename;
	}
	
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	
	public Integer getSort() {
		return this.sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Long getParentid() {
		return this.parentid;
	}
	
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	
	public Integer getType() {
		return this.type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getPermission() {
		return this.permission;
	}
	
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	public String getLink() {
		return this.link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public Boolean getHide() {
		return this.hide;
	}
	
	public void setHide(Boolean hide) {
		this.hide = hide;
	}
	
	public String getIcon() {
		return this.icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public String getExternallink() {
		return this.externallink;
	}
	
	public void setExternallink(String externallink) {
		this.externallink = externallink;
	}
	
	public String getTarget() {
		return this.target;
	}
	
	public void setTarget(String target) {
		this.target = target;
	}

	@Override
	protected Serializable pkVal() {
		return this.resourceid;
	}
}
