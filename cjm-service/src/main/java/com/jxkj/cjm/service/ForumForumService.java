package com.jxkj.cjm.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.ForumForum;
/**
 * 
* @ClassName: ForumForumService 
* @Description: TODO  
* @author cjm  
* @date 2018年5月31日  
* @version 1.0 
* www.chenjiaming.com
 */
public interface ForumForumService extends IService<ForumForum>{ 
	/**
	 * 
	 * Title: insertForumForumByApi 
	 * TODO:(Api 保存板块信息) 
	 * @param baseid 用户id
	 * @param name
	 * @return
	 */
	public ProcessBack insertForumForumByApi(Long baseid, String name);
	
	/**
	 * 
	 * Title: delForumForumByApi 
	 * TODO:(Api 删除板块信息) 
	 * @param id 板块id
 	 * @return
	 */
	public ProcessBack delForumForumByApi(String id);
	
	
	/**
	 * 
	 * Title: updateForumForumByApi 
	 * TODO:(Api 修改板块信息) 
	 * @param baseid 用户id
	 * @param forum
	 * @return
	 */
	public ProcessBack updateForumForumByApi(Long baseid,ForumForum forum);
 	
	/**
	 * 
	 * Title: insertForumForum 
	 * TODO:(修改板块信息) 
  	 * @return
	 */
	public int updateForumForum(Long baseid,ForumForum forum);
	
	/**
	 * 
	 * Title: insertForumForum 
	 * TODO:(保存板块信息) 
	 * @param baseid 用户id
	 * @param name 板块名称
	 * @return
	 */
	public int insertForumForum(Long baseid,String name);
	
	/**
	 * 
	 * Title: getForumForums 
	 * TODO:(获取板块信息 默认5条) 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<ForumForum> getForumForums(String pageNum,String pageSize);
}