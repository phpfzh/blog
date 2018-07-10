package com.jxkj.cjm.service;

import com.jxkj.cjm.common.response.ProcessBack;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.service.IService;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.model.ForumAttachment;

public interface ForumAttachmentService extends IService<ForumAttachment>{
	/**
	 * 
	* @Title: uploadImage 
	* @Description: TODO(app 图片上传接口) 
	* @param @param multipartFile 上传的文件
	* @param @param baseid 用户id
	* @param @return    设定文件 
	* @return ProcessBack    返回类型
	* @throws
	 */
	public ProcessBack uploadImage(MultipartFile multipartFile, Long baseid);
	
	/**
	 * 
	* @Title: uploadFile 
	* @Description: TODO(文件上传接口) 
	* @param @param multipartFile 上传的文件
	* @param @param baseid  用户id
	* @param @return    设定文件 
	* @return ProcessBack    返回类型
	* @throws
	 */
	public  ProcessBack uploadFile(MultipartFile multipartFile, Long baseid);
	
	/**
	 * 
	* @Title: uploadVideo 
	* @Description: TODO(视频上传接口) 
	* @param @param multipartFile 上传的文件
	* @param @param baseid  用户id
	* @param @return    设定文件 
	* @return ProcessBack    返回类型
	* @throws
	 */
	public  ProcessBack uploadVideo(MultipartFile multipartFile, Long baseid);
	
	/**
	 * 
	* @Title: insertForumAttachmentByAidAndTid 
	* @Description: TODO(保存附件记录) 
	* @param @param aid
	* @param @param tid
	* @param @return    设定文件 
	* @return int    返回类型  1添加成功  0失败
	* @throws
	 */

	public int insertForumAttachmentByAidAndTid(Long aid,Long tid,Long pid,String description);
	 
	
	/**
	 * 
	* @Title: getForumAttachmentByAid 
	* @Description: TODO(根据aid 获取图片或视频的路径) 
	* @param @param aid  主键id
	* @param @return    设定文件 
	* @return ForumAttachment    返回类型 
	* @throws
	 */
	public ForumAttachment getForumAttachmentByAid(Long aid);
	
	/**
	 * 
	* @Title: getAidByAttach 
	* @Description: TODO(根据附件url和tid 查找aid) 
	* @param @param attachUrl  附件url
	* @param @param tid     主题id
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long getForumAttachmentAidByAttach(String attachUrl,Long tid);
	
	/**
	 * 
	* @Title: getForumAttachmentUnusedAidByAttach 
	* @Description: TODO(根据url查询附件临时表aid) 
	* @param @param attach
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long getForumAttachmentUnusedAidByAttach(String attachUrl);
 
	
}