package com.jxkj.cjm.model;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * @ClassName: ForumForum
 * @Description: 栏目表
 * @author cjm
 * @date 2018年5月31日
 * @version 1.0 www.chenjiaming.com
 */
@TableName("forum_forum")
public class ForumForum extends SuperEntity<ForumForum> {

	private static final long serialVersionUID = 79056245001848264L;

	/** 板块名称 */
	private String name;
	/** 状态1显示0不显示 */
	private Integer status;
	/** 主题数量 */
	private Long threads;
	/** 回复数量 */
	private Long commonts;
	/** 添加时间 */
	private Long addtime;
	/** 添加人 */
	private Long addbaseid;
	/** 修改时间 */
	private Long updatetime;
	/** 修改人 */
	private Long updatebaseid;
	/** 是否删除1是0否 */
	private Integer isdelete;
	/** 排序最大100 */
	private Integer sort;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getThreads() {
		return threads;
	}

	public void setThreads(Long threads) {
		this.threads = threads;
	}

	public Long getCommonts() {
		return commonts;
	}

	public void setCommonts(Long commonts) {
		this.commonts = commonts;
	}

	public Long getAddtime() {
		return addtime;
	}

	public void setAddtime(Long addtime) {
		this.addtime = addtime;
	}

	public Long getAddbaseid() {
		return addbaseid;
	}

	public void setAddbaseid(Long addbaseid) {
		this.addbaseid = addbaseid;
	}

	public Long getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Long updatetime) {
		this.updatetime = updatetime;
	}

	public Long getUpdatebaseid() {
		return updatebaseid;
	}

	public void setUpdatebaseid(Long updatebaseid) {
		this.updatebaseid = updatebaseid;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
