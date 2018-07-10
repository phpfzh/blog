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
	 * Title: insertForumForumByApi 
	 * TODO:(Api 保存板块信息) 
	 * @param baseid 用户id
	 * @param name
	 * @return
	 */
	public ProcessBack insertForumForumByApi(Long baseid, String name){
		ProcessBack processBack = new ProcessBack();
		try{
			
			if(StringUtil.isEmpty(name)){
 				processBack.setCode(ProcessBack.FAIL_CODE);
				processBack.setMessage("'name' 板块名称不能为空");
				return processBack;
			}
 			
			if(name.length() > 50){
 				processBack.setCode(ProcessBack.FAIL_CODE);
				processBack.setMessage("'name' 板块名称不能超过50字");
				return processBack;
			}
			
			int count = insertForumForum(baseid, name);
			if(count == 1){
 				processBack.setCode(ProcessBack.SUCCESS_CODE);
				processBack.setMessage("操作成功");
				return processBack;
			}else if(count == 2){
 				processBack.setCode(ProcessBack.FAIL_CODE);
				processBack.setMessage("该板块名称已存在");
				return processBack;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		processBack.setCode(ProcessBack.FAIL_CODE);
		processBack.setMessage("因网络响应不及时,操作失败");
		return processBack;
 	}
	
	/**
	 * 
	 * Title: insertForumForum 
	 * TODO:(保存板块信息) 
	 * @param baseid 用户id
	 * @param name 板块名称
	 * @return
	 */
	@Transactional
	public synchronized int insertForumForum(Long baseid,String name){
		try{
			if(baseid == null){
				throw new IllegalArgumentException("'baseid' 用户id不能为空");
			}
			
			if(StringUtil.isEmpty(name)){
				throw new IllegalArgumentException("'name' 板块名称不能为空");
			}
			
			if(name.length() > 50){
				throw new IllegalArgumentException("'name' 板块名称不能超过50字");
			}
			Wrapper<ForumForum> wrapper = Condition.create();
			wrapper.eq("name", name);
			List<ForumForum> lists = baseMapper.selectList(wrapper);
			if(lists.size() > 0){//该板块已存在
				return 2;
			}
			
			
			ForumForum forum = new ForumForum();
			forum.setName(name);//板块名称
			forum.setStatus(1); //状态1显示0不显示
			forum.setThreads((long)0); //主题数量
			forum.setCommonts((long)0); //回复数量
			Long addtime = System.currentTimeMillis();
			forum.setAddtime(addtime); //添加时间
			forum.setAddbaseid(baseid); //添加人
			forum.setIsdelete(0); //是否删除1是0否
			forum.setSort(0); //排序最大100
			int count = 0;
			count = baseMapper.insert(forum); 
			
			if(!(count > 0)){
				throw new IllegalArgumentException("板块信息保存失败");
			}
			
			return 1;
		}catch(RuntimeException e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * Title: delForumForumByApi 
	 * TODO:(Api 删除板块信息) 
	 * @param id 板块id
 	 * @return
	 */
	public ProcessBack delForumForumByApi(String id){
		ProcessBack processBack = new ProcessBack();
		try{
			
			if(StringUtil.isEmpty(id)){
				processBack.setMessage("'id' 不能为空");
				processBack.setCode(ProcessBack.FAIL_CODE);
				return processBack;
			}
			
			int count = 0;
			count = baseMapper.deleteById(Long.valueOf(id));
			if(count > 0){
 				processBack.setMessage("删除成功");
				processBack.setCode(ProcessBack.SUCCESS_CODE);
				return processBack;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		processBack.setMessage("因网络响应不及时,保存失败");
		processBack.setCode(ProcessBack.FAIL_CODE);
		return processBack;
 	}
	
	
	/**
	 * 
	 * Title: updateForumForumByApi 
	 * TODO:(Api 修改板块信息) 
	 * @param baseid 用户id
 	 * @return
	 */
	public ProcessBack updateForumForumByApi(Long baseid,ForumForum forum){
		ProcessBack processBack = new ProcessBack();
		if(forum.getId() == null){
			processBack.setCode(ProcessBack.FAIL_CODE);
			processBack.setMessage("'id' 不能为空");
			return processBack;
		}
		
		int count = updateForumForum(baseid, forum);
		if(count > 0){
			processBack.setCode(ProcessBack.SUCCESS_CODE);
			processBack.setMessage("保存成功");
			return processBack;
 		}
		processBack.setCode(ProcessBack.FAIL_CODE);
		processBack.setMessage("因网络响应不及时,保存失败");
		return processBack;

	}
 	
	/**
	 * 
	 * Title: insertForumForum 
	 * TODO:(修改板块信息) 
  	 * @return
	 */
	public int updateForumForum(Long baseid,ForumForum forum){
		try{
 			ForumForum forum2 = new ForumForum();
			forum2.setId(forum.getId());
			if(StringUtil.isNotEmpty(forum.getName())){
 				forum2.setName(forum.getName());//板块名称
			}
			
			if(forum.getStatus() != null){
 				forum2.setStatus(forum.getStatus()); //状态1显示0不显示
			}
			
			if(forum.getThreads() != null){
  				forum2.setThreads(forum.getThreads()); //主题数量
			}
			
			if(forum.getCommonts() != null){
  				forum2.setCommonts(forum.getCommonts()); //回复数量
			}
			
			if(forum.getIsdelete() != null){
  				forum2.setIsdelete(forum.getIsdelete()); //是否删除1是0否
			}
			
			if(forum.getSort() != null){
   				forum2.setSort(forum.getSort()); //排序最大100
			}
			Long updatetime = System.currentTimeMillis();
			forum2.setUpdatetime(updatetime); //添加时间
			forum2.setUpdatebaseid(baseid); //添加人
			 
			int count = 0;
			count = baseMapper.updateById(forum2);
			if(count > 0){
				return 1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
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
