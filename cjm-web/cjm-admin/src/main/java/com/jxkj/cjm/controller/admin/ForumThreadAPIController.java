package com.jxkj.cjm.controller.admin;

import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.component.CjmJwtTokenComponent;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.Meta;
import com.jxkj.cjm.common.util.IPUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.model.ForumThread;
import com.jxkj.cjm.model.vo.ForumPostVo;
import com.jxkj.cjm.service.ForumPostService;
import com.jxkj.cjm.service.ForumThreadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	private ForumPostService forumPostService;

	@Resource
	private CjmJwtTokenComponent cjmJwtTokenComponent;

	/**
	 * 主题浏览
	 * @return
	 */
	@ResponseBody
	@GetMapping("/forumThreadView")
	public AjaxResult forumThreadView(){
		try{
			String tidStr = request.getParameter("tid");
			if(StringUtil.isEmpty(tidStr)){
				 return AjaxResult.failAjaxResult("tid 不能为空");
			}
			Long baseid = null;
			try{
				String baseIdStr = cjmJwtTokenComponent.getUserBaseId(request);
				baseid = Long.valueOf(baseIdStr);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Long tid = Long.valueOf(tidStr);
			String userip = IPUtil.getIpAdd(request);
			ForumPostVo forumPostVo = forumPostService.getForumPostByTid(tid);
			if(forumPostVo == null){
				throw new IllegalArgumentException("未找到帖子信息");
			}

			if(forumPostVo.getIsdelete().equals(1)){//是否删除1是0否
				AjaxResult ajaxResult = new AjaxResult();
				ajaxResult.setCode("22");
				ajaxResult.setMessage("该帖子已删除或正在审核中");
				return ajaxResult;
			}

			if(!(forumPostVo.getStatus().equals(0))){//状态-1审核中 -2审核失败 0审核通过
				AjaxResult ajaxResult = new AjaxResult();
				ajaxResult.setCode("22");
				ajaxResult.setMessage("该帖子已删除或正在审核中");
				return ajaxResult;
			}

  			forumThreadService.addForumThreadView(tid,userip,baseid);

			return AjaxResult.successAjaxResult(forumPostVo);
		}catch (Exception e){
			e.printStackTrace();
		}
		return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);
	}

}
