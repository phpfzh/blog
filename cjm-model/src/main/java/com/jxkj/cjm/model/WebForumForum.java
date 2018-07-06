package com.jxkj.cjm.model;



import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 */
@TableName("web_forum_forum")
public class WebForumForum extends SuperEntity<WebForumForum> {

	private static final long serialVersionUID = 15680192161618852L;
	
	/**  */
	private String fid;
	/**  */
	private Integer type;
	/**  */
	private String addtime;
	/**  */
	private String addbaseid;
	/**  */
	private String updatetime;
	/**  */
	private String updatebaseid;
	/**  */
	private Integer isshow;
	/**  */
	private Integer isdelete;
	/**  */
	private Integer sort;
	
	
	public String getFid() {
		return this.fid;
	}
	
	public void setFid(String fid) {
		this.fid = fid;
	}
	
	public Integer getType() {
		return this.type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getAddtime() {
		return this.addtime;
	}
	
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	
	public String getAddbaseid() {
		return this.addbaseid;
	}
	
	public void setAddbaseid(String addbaseid) {
		this.addbaseid = addbaseid;
	}
	
	public String getUpdatetime() {
		return this.updatetime;
	}
	
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	
	public String getUpdatebaseid() {
		return this.updatebaseid;
	}
	
	public void setUpdatebaseid(String updatebaseid) {
		this.updatebaseid = updatebaseid;
	}
	
	public Integer getIsshow() {
		return this.isshow;
	}
	
	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}
	
	public Integer getIsdelete() {
		return this.isdelete;
	}
	
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	
	public Integer getSort() {
		return this.sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
