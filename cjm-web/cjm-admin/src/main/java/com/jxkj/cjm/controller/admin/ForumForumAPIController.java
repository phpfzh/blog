package com.jxkj.cjm.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxkj.cjm.common.component.CjmJwtTokenComponent;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.model.ForumForum;
import com.jxkj.cjm.service.ForumForumService;
/**
 * 
* @ClassName: ForumForumController 
* @Description: TODO 板块 Controller  
* @author cjm  
* @date 2018年5月31日  
* @version 1.0 
* www.chenjiaming.com
 */

@Controller
@RequestMapping("/api/forumForum")
public class ForumForumAPIController extends BaseController{

	@Resource
	private ForumForumService forumForumService;
	
	@Resource
	private CjmJwtTokenComponent cjmJwtTokenComponent;
	/**
	 * 
	 * Title: saveForum 
	 * TODO:(保存板块信息) 
	 * @return
	 */
	@ResponseBody
	@PostMapping("/saveForum")
	public AjaxResult saveForum(){
		try{
 			String name = request.getParameter("name");
			String baseIdStr = cjmJwtTokenComponent.getUserBaseId(request);
			Long baseid = Long.valueOf(baseIdStr);
			return forumForumService.insertForumForumByApi(baseid, name);
		}catch(Exception e){
			e.printStackTrace();
			return AjaxResult.createAjaxResult().failAjaxResult("因网络响应不及时,操作失败");
		}
	}
	
	/**
	 * 
	 * Title: updateForum 
	 * TODO:(修改板块信息) 
	 * @return
	 */
	@ResponseBody
	@PostMapping("/updateForum")
	public AjaxResult updateForum(ForumForum forum){
		try{
 			String baseIdStr = cjmJwtTokenComponent.getUserBaseId(request);
			Long baseid = Long.valueOf(baseIdStr);
			return forumForumService.updateForumForumByApi(baseid, forum);
		}catch(Exception e){
			e.printStackTrace();
			return AjaxResult.createAjaxResult().failAjaxResult("因网络响应不及时,操作失败");
		}
	}
	
	/**
	 * 
	 * Title: delForum 
	 * TODO:(删除板块) 
	 * @return
	 */
	@ResponseBody
	@PostMapping("/delForum")
	public AjaxResult delForum(){
		try{
			String id = request.getParameter("id");
 			return forumForumService.delForumForumByApi(id);
		}catch(Exception e){
			e.printStackTrace();
			return AjaxResult.createAjaxResult().failAjaxResult("因网络响应不及时,操作失败");
		}
	}
  }
