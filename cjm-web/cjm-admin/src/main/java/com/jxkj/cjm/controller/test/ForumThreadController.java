package com.jxkj.cjm.controller.test;

import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.component.CjmJwtTokenComponent;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.model.ForumThread;
import com.jxkj.cjm.service.ForumThreadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 
* @ClassName: ForumThreadController 
* @Description: TODO  主题信息保存
* @author cjm  
* @date 2018年6月3日  
* @version 1.0 
* www.chenjiaming.com
 */
@Controller
@RequestMapping("/forumThread")
public class ForumThreadController extends BaseController{
	
	@Resource
	private ForumThreadService forumThreadService;
	
	@Resource
	private CjmJwtTokenComponent cjmJwtTokenComponent;
	 
	@ResponseBody
	@PostMapping("/getForumThreads")
	public AjaxResult getForumThreads(ForumThread forumThread){
		AjaxResult ajaxResult = new AjaxResult();
		try{
			String pageSize = request.getParameter("pageSize");
			String orderBy = request.getParameter("orderBy");
			String pageNum = request.getParameter("pageNum");
			PageInfo<Object> lists = forumThreadService.getForumThreadsBy(pageSize, pageNum, orderBy, forumThread);
			ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
			ajaxResult.setMessage("查询成功");
			ajaxResult.setData(lists);
			return ajaxResult;
		}catch(Exception e){
			e.printStackTrace();
		}
		ajaxResult.setCode(AjaxResult.FAIL_CODE);
		ajaxResult.setMessage("因网络响应不及时,操作失败");
		return ajaxResult ;
	}
}
