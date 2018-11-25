package com.jxkj.cjm.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.common.util.IPUtil;
import com.jxkj.cjm.model.User;
import com.jxkj.cjm.model.vo.ForumThreadReplyVo;
import com.jxkj.cjm.service.ForumThreadReplyAttachService;
import com.jxkj.cjm.service.ForumThreadReplyService;

@Controller
@RequestMapping("user/forumThreadReply")
public class UserForumThreadReply extends BaseController{
	@Resource
	private ForumThreadReplyService forumThreadReplyService;
	
	@Resource
	private ForumThreadReplyAttachService forumThreadReplyAttachService;
	
	/**
	 * 
	 * Title: save 
	 * TODO:(保存) 
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@PostMapping("save")
	public ProcessBack save(ForumThreadReplyVo vo){
	    String userip = IPUtil.getIpAdd(request);
	    vo.setUserip(userip);
	    User user = getUserByPC();
	    System.out.println(JSON.toJSONString(vo));
		return forumThreadReplyService.insertForumThreadReplay(user, vo);
	}
	
	//回复图片上传
	@ResponseBody
	@PostMapping("/uploadimage")
	public ProcessBack uploadimage(@RequestParam("upfile") MultipartFile multipartFile){
		 User user = getUserByPC();
		//图片上传
		ProcessBack processBack = forumThreadReplyAttachService.uploadImage(multipartFile, user.getId());
		return processBack;
	}
}
