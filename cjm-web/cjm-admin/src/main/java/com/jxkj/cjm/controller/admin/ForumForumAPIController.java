package com.jxkj.cjm.controller.admin;

import com.jxkj.cjm.common.component.CjmJwtTokenComponent;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.ForumForum;
import com.jxkj.cjm.service.ForumForumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
		AjaxResult ajaxResult = new AjaxResult();
		try{
 			String name = request.getParameter("name");
			String baseIdStr = cjmJwtTokenComponent.getUserBaseId(request);
			Long baseid = Long.valueOf(baseIdStr);
			ProcessBack processBack = forumForumService.insertForumForumByApi(baseid, name);
			if(processBack.getCode().equals(ProcessBack.SUCCESS_CODE)){
				ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
				ajaxResult.setMessage("保存成功");
				return ajaxResult;
			}else{
				ajaxResult.setCode(AjaxResult.FAIL_CODE);
				ajaxResult.setMessage(processBack.getMessage());
				return ajaxResult;
			}
 		}catch(Exception e){
			e.printStackTrace();
 		}
		ajaxResult.setCode(AjaxResult.FAIL_CODE);
		ajaxResult.setMessage(AjaxResult.MESSAGE);
		return ajaxResult;
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
		AjaxResult ajaxResult = new AjaxResult();
		try{
 			String baseIdStr = cjmJwtTokenComponent.getUserBaseId(request);
			Long baseid = Long.valueOf(baseIdStr);
			ProcessBack processBack = forumForumService.updateForumForumByApi(baseid, forum);
			if(processBack.getCode().equals(ProcessBack.SUCCESS_CODE)){
				ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
				ajaxResult.setMessage("操作成功");
			}else{
				ajaxResult.setCode(AjaxResult.FAIL_CODE);
				ajaxResult.setMessage(processBack.getMessage());
			}
			return ajaxResult;
		}catch(Exception e){
			e.printStackTrace();
 		}

		ajaxResult.setCode(AjaxResult.FAIL_CODE);
		ajaxResult.setMessage("因网络响应不及时,操作失败");
		return ajaxResult;
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
		AjaxResult ajaxResult = new AjaxResult();
		try{
			String id = request.getParameter("id");
			ProcessBack processBack	= forumForumService.delForumForumByApi(id);
			if(processBack.getCode().equals(ProcessBack.SUCCESS_CODE)){
				ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
				ajaxResult.setMessage("操作成功");
			}else{
				ajaxResult.setCode(AjaxResult.FAIL_CODE);
				ajaxResult.setMessage(processBack.getMessage());
			}
 			return ajaxResult;
		}catch(Exception e){
			e.printStackTrace();
 		}
		ajaxResult.setCode(AjaxResult.FAIL_CODE);
		ajaxResult.setMessage("因网络响应不及时,操作失败");
		return ajaxResult;
	}
  }
