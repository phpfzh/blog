package com.jxkj.cjm.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.component.CjmJwtTokenComponent;
import com.jxkj.cjm.common.constat.ForumThreadOperation_Constat;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.Meta;
import com.jxkj.cjm.common.util.IPUtil;
import com.jxkj.cjm.model.ForumThread;
import com.jxkj.cjm.service.ForumThreadService;

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
@RequestMapping("/api/forumThread")
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
		AjaxResult ajaxResult = AjaxResult.createAjaxResult();
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
				return ajaxResult.failAjaxResult(meta.getMessage());
			}else if(count == 1){
				return ajaxResult.successAjaxResult("保存成功");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ajaxResult.failAjaxResult("因网络响应不及时,操作失败");
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
	
	/**
	 * 
	 * Title: auditForumThread 
	 * TODO:(审核主题) 
	 * @param forumThread
	 * @return
	 */
	@ResponseBody
	@PostMapping("/auditForumThread")
	public AjaxResult auditForumThread(ForumThread forumThread){
		AjaxResult ajaxResult = AjaxResult.createAjaxResult();
		try{
			String baseId = cjmJwtTokenComponent.getUserBaseId(request);
			String status = request.getParameter("status");
			String tid = request.getParameter("tid");
  			String userip = IPUtil.getIpAdd(request);
			Meta meta = new Meta();
			int count = forumThreadService.auditForumThread(tid, status, Long.valueOf(baseId), userip, meta);
			if(count == 2){//校验不通过
				return ajaxResult.failAjaxResult(meta.getMessage());
			}else if(count == 1){
				return ajaxResult.successAjaxResult("操作成功");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ajaxResult.failAjaxResult("因网络响应不及时,操作失败");
	}
	
	/**
	 * 
	 * Title: auditBatchForumThread 
	 * TODO:(批量审核主题信息) 
	 * @param forumThread
	 * @return
	 */
	@ResponseBody
	@PostMapping("/auditBatchForumThread")
	public AjaxResult auditBatchForumThread(ForumThread forumThread){
		AjaxResult ajaxResult = AjaxResult.createAjaxResult();
		try{
			String baseId = cjmJwtTokenComponent.getUserBaseId(request);
			String status = request.getParameter("status");
			String tids = request.getParameter("tids");
  			String userip = IPUtil.getIpAdd(request);
			Meta meta = new Meta();
			int count = forumThreadService.auditBatchForumThread(tids, status, Long.valueOf(baseId), userip, meta);
			if(count == 2){//校验不通过
				return ajaxResult.failAjaxResult(meta.getMessage());
			}else if(count == 1){
				return ajaxResult.successAjaxResult("操作成功");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
 		return ajaxResult.failAjaxResult("因网络响应不及时,操作失败");
	}
	
	/**
	 * 
	 * Title: delForumThread 
	 * TODO:(删除主题) 
	 * @param forumThread
	 * @return
	 */
	@ResponseBody
	@PostMapping("/delForumThread")
	public AjaxResult delForumThread(ForumThread forumThread){
		AjaxResult ajaxResult = AjaxResult.createAjaxResult();
		try{
			String baseId = cjmJwtTokenComponent.getUserBaseId(request);
			String status = request.getParameter("status");
			String tid = request.getParameter("tid");
  			String userip = IPUtil.getIpAdd(request);
			Meta meta = new Meta();
			int count = forumThreadService.delForumThread(tid, status, Long.valueOf(baseId), userip, meta);
			if(count == 2){//校验不通过
				return ajaxResult.failAjaxResult(meta.getMessage());
			}else if(count == 1){
				return ajaxResult.successAjaxResult("操作成功");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ajaxResult.failAjaxResult("因网络响应不及时,操作失败");
	}
	
	/**
	 * 
	 * Title: delBatchForumThread 
	 * TODO:(批量删除主题信息) 
	 * @param forumThread
	 * @return
	 */
	@ResponseBody
	@PostMapping("/delBatchForumThread")
	public AjaxResult delBatchForumThread(ForumThread forumThread){
		AjaxResult ajaxResult = AjaxResult.createAjaxResult();
		try{
			String baseId = cjmJwtTokenComponent.getUserBaseId(request);
			String status = request.getParameter("status");
			String tids = request.getParameter("tids");
  			String userip = IPUtil.getIpAdd(request);
			Meta meta = new Meta();
			int count = forumThreadService.delBatchForumThread(tids, status, Long.valueOf(baseId), userip, meta);
			if(count == 2){//校验不通过
				return ajaxResult.failAjaxResult(meta.getMessage());
			}else if(count == 1){
				return ajaxResult.successAjaxResult("操作成功");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ajaxResult.failAjaxResult("因网络响应不及时,操作失败");
	}
}
