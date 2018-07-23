package com.jxkj.cjm.controller;

import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.model.ForumForum;
import com.jxkj.cjm.service.ForumForumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
* @ClassName: GetInformationController 
* @Description: TODO 获取信息Controller 不需要认证 
* @author cjm  
* @date 2018年6月3日  
* @version 1.0 
* www.chenjiaming.com
 */
@Controller
@RequestMapping("/getInfo")
public class GetInformationController extends BaseController{
	
	@Resource
	private ForumForumService forumForumService;
	
	/**
	 * 
	 * Title: getForums 
	 * TODO:(查询板块信息) 
	 * @return
	 */
	@ResponseBody
	@PostMapping("/getForums")
	public AjaxResult getForums(){
		AjaxResult ajaxResult = new AjaxResult();
		String pageNum = request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
 		try{
 			List<ForumForum> lists = forumForumService.getForumForums(pageNum, pageSize);
 			if(lists.size() > 0){
 				for(ForumForum forum : lists){
 					forum.setStatus(null);
 					forum.setAddtime(null);
 					forum.setAddbaseid(null);
 					forum.setUpdatetime(null);
 					forum.setUpdatebaseid(null);
 					forum.setIsdelete(null);
  				}
				ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
				ajaxResult.setMessage("操作成功");
				ajaxResult.setData(lists);
  				return ajaxResult;
 			}else{
 				ajaxResult.setCode(AjaxResult.FAIL_CODE);
				ajaxResult.setMessage("未找到符合条件的信息");
 				return ajaxResult;
 			}
		}catch(Exception e){
			e.printStackTrace();
 		}
 		ajaxResult.setCode(AjaxResult.FAIL_CODE);
		ajaxResult.setMessage("因网络响应不及时,操作失败");
		return ajaxResult;
	}
}
