package com.jxkj.cjm.controller.admin;

import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.component.CjmJwtTokenComponent;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.Meta;
import com.jxkj.cjm.common.util.IPUtil;
import com.jxkj.cjm.model.ForumThread;
import com.jxkj.cjm.service.ForumThreadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 
* @ClassName: ForumThreadAPIController 
* @Description: TODO  主题信息保存
* @author cjm  
* @date 2018年6月3日  
* @version 1.0 
* www.chenjiaming.com
 */
@Controller
@RequestMapping("/api/forumThreadApi")
public class ForumThreadAPIController extends BaseController{
	
	@Resource
	private ForumThreadService forumThreadService;
	
	@Resource
	private CjmJwtTokenComponent cjmJwtTokenComponent;
	
	/**
	 * 
	 * Title: insertForumThread 
	 * TODO:(保存主题信息) 
	 * @return
	 */
	@ResponseBody
	@PostMapping("/insertForumThread")
	public AjaxResult insertForumThread(){
 		try{
			String baseId = cjmJwtTokenComponent.getUserBaseId(request);
			String fid = request.getParameter("fid");
			String threadtype = request.getParameter("threadtype");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			String userip = IPUtil.getIpAdd(request);
			String usesig = request.getParameter("usesig");
			Meta meta = new Meta();
 			int count = forumThreadService.insertForumThread(Long.valueOf(baseId), fid, threadtype,
					subject, content, userip, usesig,meta);
			if(count == 2){//校验不通过
 				return AjaxResult.failAjaxResult(meta.getMessage());
			}else if(count == 1){
 				return AjaxResult.successAjaxResult("保存成功");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
 		return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);
	}
	 
	/**
	 * 
	 * Title: getForumThreads 
	 * TODO:(获取主题信息) 
	 * @param forumThread
	 * @return
	 */
	@ResponseBody
	@PostMapping("/getForumThreads")
	public AjaxResult getForumThreads(ForumThread forumThread){
 		try{
			String pageSize = request.getParameter("pageSize");
			String orderBy = request.getParameter("orderBy");
			String pageNum = request.getParameter("pageNum");
			PageInfo<Object> lists = forumThreadService.getForumThreadsBy(pageSize, pageNum, orderBy, forumThread);
 			return AjaxResult.successAjaxResult("查询成功",lists);
		}catch(Exception e){
			e.printStackTrace();
		}
 		return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);
	}
	

}
