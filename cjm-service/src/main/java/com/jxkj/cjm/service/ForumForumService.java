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
	 * Title: getForumForums 
	 * TODO:(获取板块信息 默认5条) 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<ForumForum> getForumForums(String pageNum,String pageSize);
}