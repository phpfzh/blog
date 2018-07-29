package com.jxkj.cjm.controller.admin;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.component.CjmJwtTokenComponent;
import com.jxkj.cjm.common.controller.AbstractVoBaseController;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.common.util.TransferUtil;
import com.jxkj.cjm.model.ForumForum;
import com.jxkj.cjm.model.User;
import com.jxkj.cjm.model.vo.ForumForumVo;
import com.jxkj.cjm.service.ForumForumService;
import com.jxkj.cjm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class ForumForumController extends AbstractVoBaseController<ForumForum,ForumForumVo> {

	@Resource
	private CjmJwtTokenComponent cjmJwtTokenComponent;

	@Resource
	private UserService userService;

	@Override
	public AjaxResult valiPreSaveEntity(ForumForum forumForum) {
		Wrapper<ForumForum> wrapper = Condition.create();
		wrapper.eq("name", forumForum.getName());
		List<ForumForum> lists = baseService.selectList(wrapper);
		if (lists.size() > 0) {
 			return AjaxResult.failAjaxResult("该板块已存在");
		}

		String baseIdStr = cjmJwtTokenComponent.getUserBaseId(request);
		Long baseid = Long.valueOf(baseIdStr);
		forumForum.setAddbaseid(baseid);
		forumForum.setStatus(forumForum.getStatus() == null ? 1 : forumForum.getStatus()); //状态1显示0不显示
		forumForum.setThreads((long) 0); //主题数量
		forumForum.setCommonts((long) 0); //回复数量
		Long addtime = System.currentTimeMillis();
		forumForum.setAddtime(addtime); //添加时间
		forumForum.setIsdelete(0); //是否删除1是0否
		forumForum.setSort(forumForum.getSort() == null ? 0 : forumForum.getSort()); //排序最大100
		return super.valiPreSaveEntity(forumForum);
	}

	@Override
	public AjaxResult valiPreUpdateEntity(ForumForum forumForum) {

		Wrapper<ForumForum> wrapper = Condition.create();
		wrapper.eq("name", forumForum.getName());
		wrapper.notIn("id", forumForum.getId());
		List<ForumForum> lists = baseService.selectList(wrapper);
		if (lists.size() > 0) {
 			return AjaxResult.failAjaxResult("该板块已存在");
		}

		String baseIdStr = cjmJwtTokenComponent.getUserBaseId(request);
		Long baseid = Long.valueOf(baseIdStr);
		forumForum.setUpdatebaseid(baseid);
		Long updateTime = System.currentTimeMillis();
		forumForum.setUpdatetime(updateTime);
		return super.valiPreUpdateEntity(forumForum);
	}


	@Override
	public AjaxResult getEntity(ForumForumVo forumForumVo) {
		try{

			if(forumForumVo.getId() == null){
				return AjaxResult.failAjaxResult("id 不能为空");
			}

			ForumForum forumForum = baseService.selectById(forumForumVo.getId());
			if(forumForum == null){
				return AjaxResult.failAjaxResult("查询失败");
			}
			return AjaxResult.successAjaxResult(parseForumForumVo(forumForum));
		}catch (Exception e){
			e.printStackTrace();
		}
		return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);
	}

	@Override
	public AjaxResult preList(ForumForum forumForum, ForumForumVo forumForumVo) {
 		try {
			forumForum = copyEntityByEntityVo(forumForum, forumForumVo);

			// 处理分页请求
			String pageNum = request.getParameter("pageNum");
			String pageSize = request.getParameter("pageSize");
			Map<String, Object> map = new HashMap<>();
			initPage(map, pageNum, pageSize);
			PageHelper.orderBy("sort DESC");
			List<ForumForum> lists = baseService.selectByMap(TransferUtil.beanToMap(forumForum));
			List<ForumForumVo> voLists = new ArrayList<>();
			for (ForumForum entity1 : lists) {
				ForumForumVo en = parseForumForumVo(entity1);
				voLists.add(en);
			}

			PageInfo<Object> pagehelper = initPagehelper(map, lists);

			Map<String, Object> ha = new HashMap<>();
			ha.put("list", voLists);
			ha.put("total", pagehelper.getTotal());
			ha.put("entity", forumForumVo);
 			return AjaxResult.successAjaxResult(ha);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}

		return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);
	}

	private ForumForumVo parseForumForumVo(ForumForum forumForum){
		ForumForumVo forumForumVo1 = new ForumForumVo();
		User addUser = userService.selectById(forumForum.getAddbaseid());
		forumForumVo1.setAddusername(addUser.getUsername());
		User updateUser = null;
		if(forumForum.getUpdatebaseid() != null){
			updateUser = userService.selectById(forumForum.getUpdatebaseid());
			forumForumVo1.setUpdateusername(updateUser.getUsername());
		}
		forumForumVo1.setId(forumForum.getId());
		forumForumVo1.setName(forumForum.getName());
		forumForumVo1.setStatus(forumForum.getStatus());
		forumForumVo1.setThreads(forumForum.getThreads());
		forumForumVo1.setCommonts(forumForum.getCommonts());
		forumForumVo1.setAddtime(forumForum.getAddtime());
		forumForumVo1.setUpdatetime(forumForum.getUpdatetime());
		forumForumVo1.setSort(forumForum.getSort());
		return forumForumVo1;
	}
}
