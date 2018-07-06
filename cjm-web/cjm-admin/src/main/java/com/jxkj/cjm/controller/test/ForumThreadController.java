package com.jxkj.cjm.controller.test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.component.CjmJwtTokenComponent;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.Meta;
import com.jxkj.cjm.common.util.IPUtil;
import com.jxkj.cjm.model.ForumThread;
import com.jxkj.cjm.service.ForumThreadService;

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
		AjaxResult ajaxResult = AjaxResult.createAjaxResult();
		try{
			String pageSize = request.getParameter("pageSize");
			String orderBy = request.getParameter("orderBy");
			String pageNum = request.getParameter("pageNum");
			PageInfo<Object> lists = forumThreadService.getForumThreadsBy(pageSize, pageNum, orderBy, forumThread);
  			return ajaxResult.successAjaxResult("查询成功", lists);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ajaxResult.failAjaxResult("因网络响应不及时,操作失败");
	}
}
