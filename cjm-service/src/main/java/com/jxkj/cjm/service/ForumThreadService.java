package com.jxkj.cjm.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.response.Meta;
import com.jxkj.cjm.model.ForumThread;

public interface ForumThreadService extends IService<ForumThread>{ 

	/**
	 * 
	 * Title: insertForumThread 
	 * TODO:(保存主题信息) 
	 * @param baseid   用户id
	 * @param threadtype  主题类型
	 * @param fid  板块id
	 * @param subject  主题
	 * @param content  内容
	 * @param userip  用户iP
	 * @param usesig  是否带签名
	 * @return
	 */
	public int insertForumThread(Long baseid,String fid,String threadtype, 
			String subject,String content,String userip,String usesig,Meta meta);

	/**
	 * 添加主题浏览量
	 * @param tid  主题id
	 * @param ip   ip地址
	 */
	public void addForumThreadView(Long tid,String ip,Long baseid);

	/**
	 * 
	 * Title: auditForumThread 
	 * TODO:(审核主题 ) 
	 * @param tid 主题id
	 * @param status 审核通过1 审核失败0
	 * @param baseid 审核用户
	 * @return
	 */
	public int auditForumThread(String tid,String status,Long baseid,String userip,Meta meta);
	
	
	/**
	 * 
	 * Title: auditBatchForumThread 
	 * TODO:(批量审核主题 ) 
	 * @param tids 主题id集合
	 * @param status 审核通过1 审核失败0
	 * @param baseid 审核用户
	 * @return
	 */
	public int auditBatchForumThread(String tids,String status,Long baseid,String userip,Meta meta);
	/**
	 * 
	 * Title: delForumThread 
	 * TODO:(删除主题) 
	 * @param tid  主题id
	 * @param status  状态0删除 1恢复  
	 * @param baseid  操作用户
	 * @param userip  操作ip
	 * @param meta
	 * @return
	 */
	public int delForumThread(String tid,String status,Long baseid,String userip,Meta meta);
	/**
	 * 
	 * Title: delForumThread 
	 * TODO:(批量删除主题) 
	 * @param tids  主题id
	 * @param status  状态0删除 1恢复
	 * @param baseid  操作用户
	 * @param userip  操作ip
	 * @param meta
	 * @return
	 */
	public int delBatchForumThread(String tids,String status,Long baseid,String userip,Meta meta);
 }