package com.jxkj.cjm.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jxkj.cjm.common.response.ProcessBack;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.util.PageHelperInfoUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.common.util.TransferUtil;
import com.jxkj.cjm.mapper.ForumForumMapper;
import com.jxkj.cjm.model.ForumForum;
import com.jxkj.cjm.service.ForumForumService;


@Service
public class ForumForumServiceImpl extends ServiceImpl<ForumForumMapper,ForumForum> implements ForumForumService {

	/**
	 * 
	 * Title: getForumForums 
	 * TODO:(获取板块信息 默认5条) 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<ForumForum> getForumForums(String pageNum,String pageSize){
		PageHelperInfoUtil helperInfoUtil = new PageHelperInfoUtil();
		if(StringUtil.isEmpty(pageSize)){//默认5条
			pageSize = "5";
		}
 		
		Map<String,Object> map = new HashMap<>();
		PageHelper.orderBy("sort DESC, addtime ASC");
		helperInfoUtil.initPage(map, pageNum, pageSize);
		ForumForum forum = new ForumForum();
		forum.setStatus(1);//状态1显示0不显示
		forum.setIsdelete(0);  //是否删除1是0否
		List<ForumForum> lists = baseMapper.selectByMap(TransferUtil.beanToMap(forum));
 		return lists;
	}
	
	
	
	
}
