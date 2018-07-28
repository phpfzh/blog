package com.jxkj.cjm.service.impl;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import com.jxkj.cjm.common.response.ProcessBack;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.DefaultFastFileStorageClient;
import com.jxkj.cjm.common.component.FastDFSUploadComponent;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.mapper.ForumAttachment0Mapper;
import com.jxkj.cjm.mapper.ForumAttachment1Mapper;
import com.jxkj.cjm.mapper.ForumAttachment2Mapper;
import com.jxkj.cjm.mapper.ForumAttachment3Mapper;
import com.jxkj.cjm.mapper.ForumAttachment4Mapper;
import com.jxkj.cjm.mapper.ForumAttachment5Mapper;
import com.jxkj.cjm.mapper.ForumAttachment6Mapper;
import com.jxkj.cjm.mapper.ForumAttachment7Mapper;
import com.jxkj.cjm.mapper.ForumAttachment8Mapper;
import com.jxkj.cjm.mapper.ForumAttachment9Mapper;
import com.jxkj.cjm.mapper.ForumAttachmentMapper;
import com.jxkj.cjm.mapper.ForumAttachmentUnusedMapper;
import com.jxkj.cjm.model.ForumAttachment;
import com.jxkj.cjm.model.ForumAttachment0;
import com.jxkj.cjm.model.ForumAttachment1;
import com.jxkj.cjm.model.ForumAttachment2;
import com.jxkj.cjm.model.ForumAttachment3;
import com.jxkj.cjm.model.ForumAttachment4;
import com.jxkj.cjm.model.ForumAttachment5;
import com.jxkj.cjm.model.ForumAttachment6;
import com.jxkj.cjm.model.ForumAttachment7;
import com.jxkj.cjm.model.ForumAttachment8;
import com.jxkj.cjm.model.ForumAttachment9;
import com.jxkj.cjm.model.ForumAttachmentUnused;
import com.jxkj.cjm.service.ForumAttachmentService;


@Service
public class ForumAttachmentServiceImpl extends ServiceImpl<ForumAttachmentMapper,ForumAttachment> implements ForumAttachmentService {
	 
	protected static Logger LOGGER = LoggerFactory.getLogger(ForumAttachmentServiceImpl.class);
 
	@Resource
	private ForumAttachmentUnusedMapper forumAttachmentUnusedMapper;//附近上传临时记录
	
	@Resource
	private DefaultFastFileStorageClient defaultFastFileStorageClient;//文件上传
	
	@Resource
	private FastDFSUploadComponent fastDFSUploadComponent;//图片上传工具类
	
	@Value("${cjm.fdfs.host}")
	private String fdfsurl;//图片服务器路径

	@Resource
	private ForumAttachment0Mapper forumAttachment0Mapper;
	
	@Resource
	private ForumAttachment1Mapper forumAttachment1Mapper;
	
	@Resource
	private ForumAttachment2Mapper forumAttachment2Mapper;
	
	@Resource
	private ForumAttachment3Mapper forumAttachment3Mapper;
	
	@Resource
	private ForumAttachment4Mapper forumAttachment4Mapper;
	
	@Resource
	private ForumAttachment5Mapper forumAttachment5Mapper;
	
	@Resource
	private ForumAttachment6Mapper forumAttachment6Mapper;
	
	@Resource
	private ForumAttachment7Mapper forumAttachment7Mapper;
	
	@Resource
	private ForumAttachment8Mapper forumAttachment8Mapper;
	
	@Resource
	private ForumAttachment9Mapper forumAttachment9Mapper;

	private Lock uploadImageLock = new ReentrantLock();
	private Lock uploadFileLock  = new ReentrantLock();
	private Lock uploadVideoLock = new ReentrantLock();

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
	@Transactional
	public  ProcessBack uploadImage(MultipartFile multipartFile, Long baseid){
		ProcessBack processBack = new ProcessBack();
		try{
			uploadImageLock.lock();//加锁
 			//上传原图&&缩率图
			Map<String,Object> imageUploadMap = fastDFSUploadComponent.uploadImageAndCrtThumbImage(multipartFile);
	 		if(imageUploadMap.get(FastDFSUploadComponent.FDFS_STATE).equals(FastDFSUploadComponent.FDFS_FAIL_STATUS)){//图片上传失败
	 			throw new IllegalArgumentException("图片上传失败");
			}
			
	 		String url = (String) imageUploadMap.get(FastDFSUploadComponent.FDFS_URL);//原图路径
	 		String thumburl = (String) imageUploadMap.get(FastDFSUploadComponent.FDFS_THUMBURL);//缩率图路径
	 		
//	 		StorePath storePath = StorePath.praseFromUrl(url);
//	 		Map<String,Object> uploadWaterMap = fastDFSUploadComponent.uploadWatermarkImage(storePath);//上传水印图片
//	 		if(uploadWaterMap.get(FastDFSUploadComponent.FDFS_STATE).equals(FastDFSUploadComponent.FDFS_FAIL_STATUS)){//图片上传失败
//	 			throw new IllegalArgumentException("水印图片上传失败");
//			}
//	 		
//	 		String waterurl = (String) uploadWaterMap.get(FastDFSUploadComponent.FDFS_WATERMARKURL);//水印图片路径
	 		String waterurl = "";
	 		//保存附件索引表
	 		ForumAttachment attachment = new ForumAttachment();
	 		attachment.setTid((long)0);//主题id 默认值0
	 		attachment.setPid((long)0);//帖子id 默认值0
 	 		attachment.setTableid(127);//分表id 默认值127
	 		attachment.setDownloads(0);//下载次数 默认值0
	 		attachment.setBaseid(baseid);//用户id
	  		int count = 0;
	  		count = baseMapper.insert(attachment);
	  		if(!(count > 0)){
	  			if(LOGGER.isDebugEnabled()){
	  				LOGGER.debug("保存的数据是："+JSON.toJSONString(attachment));
	  			}
	  			throw new IllegalArgumentException("附件索引记录保存失败");
	  		}
	  		Long dateLine = System.currentTimeMillis();
	  		Integer width = 0;
	  		BufferedImage image = ImageIO.read(multipartFile.getInputStream()); 
	  		if(image != null){
	  			width = image.getWidth();
	  		}
	  		//保存附件临时记录
 	  		ForumAttachmentUnused attachmentUnused = new ForumAttachmentUnused();
 	  		attachmentUnused.setAid(attachment.getId());  //索引表id
 	  		attachmentUnused.setBaseid(baseid);  //用户id
 	  		attachmentUnused.setDateline(dateLine);  //时间撮
 	  		attachmentUnused.setFilename(multipartFile.getOriginalFilename());  //文件名
 	  		attachmentUnused.setFilesize((int)multipartFile.getSize());  //文件大小 
 	  		attachmentUnused.setAttachment(url);  //文件路径
 	  		attachmentUnused.setThumachment(thumburl);  //缩率图路径
 	  		attachmentUnused.setWaterattachment(waterurl);  //水印图路径
 	  		attachmentUnused.setRemote(0);  //是否远程附件
 	  		attachmentUnused.setIsimage(1);  //是否图片 0附件 1图片 2视频
 	  		attachmentUnused.setWidth(width);  //原图宽度
  	  		int coun2 = 0;
 	  		coun2 = forumAttachmentUnusedMapper.insert(attachmentUnused);
  	  		
 	  		if(!(coun2 > 0)){
 	  			if(LOGGER.isDebugEnabled()){
	  				LOGGER.debug("保存的数据是："+JSON.toJSONString(attachmentUnused));
	  			}
	  			throw new IllegalArgumentException("附件临时记录保存失败");
	  		}

			processBack.setCode(ProcessBack.SUCCESS_CODE);
			processBack.setMessage("图片上传成功");
			processBack.setData(fastDFSUploadComponent.getResAccessUrl(thumburl));
			return processBack;
		}catch(RuntimeException e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
 		}catch(Exception e){
			e.printStackTrace();
 		}finally {
			uploadImageLock.unlock();
		}
		processBack.setCode(ProcessBack.FAIL_CODE);
		processBack.setMessage("网络响应不及时,视频上传失败");
		return processBack;
 	}
	
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
	@Override
	@Transactional
	public  ProcessBack uploadFile(MultipartFile multipartFile, Long baseid) {
		ProcessBack processBack = new ProcessBack();
 		try{
			uploadFileLock.lock();//加锁
 			//文件上传
  			StorePath storePath = defaultFastFileStorageClient.uploadFile(multipartFile.getInputStream(), multipartFile.getSize(), 
 					FilenameUtils.getExtension(multipartFile.getOriginalFilename()), null);
 			if(storePath == null){
 				throw new IllegalArgumentException("文件上传失败");
 			}
 			
 			String url = storePath.getFullPath();//文件地址
 			//保存附近索引表
	 		ForumAttachment attachment = new ForumAttachment();
	 		attachment.setTid((long)0);//主题id 默认值0
	 		attachment.setPid((long)0);//帖子id 默认值0
 	 		attachment.setTableid(127);//分表id 默认值127
	 		attachment.setDownloads(0);//下载次数 默认值0
	 		attachment.setBaseid(baseid);//用户id
	  		int count = 0;
	  		count = baseMapper.insert(attachment);
	  		if(!(count > 0)){
	  			if(LOGGER.isDebugEnabled()){
	  				LOGGER.debug("保存的数据是："+JSON.toJSONString(attachment));
	  			}
	  			throw new IllegalArgumentException("附近索引记录保存失败");
	  		}
	  		
	  		Long dateLine = System.currentTimeMillis();
 	  		//保存附近临时记录
 	  		ForumAttachmentUnused attachmentUnused = new ForumAttachmentUnused();
 	  		attachmentUnused.setAid(attachment.getId());  //索引表id
 	  		attachmentUnused.setBaseid(baseid);  //用户id
 	  		attachmentUnused.setDateline(dateLine);  //时间撮
 	  		attachmentUnused.setFilename(multipartFile.getOriginalFilename());  //文件名
 	  		attachmentUnused.setFilesize((int)multipartFile.getSize());  //文件大小 
 	  		attachmentUnused.setAttachment(url);  //文件路径
  	  		attachmentUnused.setRemote(0);  //是否远程附件
 	  		attachmentUnused.setIsimage(0);  //是否图片 0附件 1图片 2视频
 	  		int coun2 = 0;
 	  		coun2 = forumAttachmentUnusedMapper.insert(attachmentUnused);
  	  		if(!(coun2 > 0)){
 	  			if(LOGGER.isDebugEnabled()){
	  				LOGGER.debug("保存的数据是："+JSON.toJSONString(attachmentUnused));
	  			}
	  			throw new IllegalArgumentException("附近索引记录保存失败");
	  		}

			processBack.setCode(ProcessBack.SUCCESS_CODE);
			processBack.setMessage("文件上传成功");
			processBack.setData(fastDFSUploadComponent.getResAccessUrl(url));
			return processBack;
 		}catch(RuntimeException e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
 		}catch(Exception e){
			e.printStackTrace();
 		}finally {
			uploadFileLock.unlock();
		}

		processBack.setCode(ProcessBack.FAIL_CODE);
		processBack.setMessage("网络响应不及时,视频上传失败");
		return processBack;
	}
	
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
	@Override
	@Transactional
	public   ProcessBack uploadVideo(MultipartFile multipartFile, Long baseid) {
		ProcessBack processBack = new ProcessBack();
 		try{
			uploadVideoLock.lock();//加锁
 			//文件上传
  			StorePath storePath = defaultFastFileStorageClient.uploadFile(multipartFile.getInputStream(), multipartFile.getSize(), 
 					FilenameUtils.getExtension(multipartFile.getOriginalFilename()), null);
 			if(storePath == null){
 				throw new IllegalArgumentException("视频上传失败");
 			}
 			
 			String url = storePath.getFullPath();//文件地址
 			//保存附近索引表
	 	    ForumAttachment attachment = new ForumAttachment();
	 		attachment.setTid((long)0);//主题id 默认值0
	 		attachment.setPid((long)0);//帖子id 默认值0
 	 		attachment.setTableid(127);//分表id 默认值127
	 		attachment.setDownloads(0);//下载次数 默认值0
	 		attachment.setBaseid(baseid);//用户id
	  		int count = 0;
	  		count = baseMapper.insert(attachment);
	  		if(!(count > 0)){
	  			if(LOGGER.isDebugEnabled()){
	  				LOGGER.debug("保存的数据是："+JSON.toJSONString(attachment));
	  			}
	  			throw new IllegalArgumentException("附近索引记录保存失败");
	  		}
	  		
	  		Long dateLine = System.currentTimeMillis();
 	  		//保存附近临时记录
 	  		ForumAttachmentUnused attachmentUnused = new ForumAttachmentUnused();
 	  		attachmentUnused.setAid(attachment.getId());  //索引表id
 	  		attachmentUnused.setBaseid(baseid);  //用户id
 	  		attachmentUnused.setDateline(dateLine);  //时间撮
 	  		attachmentUnused.setFilename(multipartFile.getOriginalFilename());  //文件名
 	  		attachmentUnused.setFilesize((int)multipartFile.getSize());  //文件大小 
 	  		attachmentUnused.setAttachment(url);  //文件路径
  	  		attachmentUnused.setRemote(0);  //是否远程附件
 	  		attachmentUnused.setIsimage(2);  //是否图片 0附件 1图片 2视频
  	  		int coun2 = 0;
 	  		coun2 = forumAttachmentUnusedMapper.insert(attachmentUnused);
  	  		if(!(coun2 > 0)){
 	  			if(LOGGER.isDebugEnabled()){
	  				LOGGER.debug("保存的数据是："+JSON.toJSONString(attachmentUnused));
	  			}
	  			throw new IllegalArgumentException("附近索引记录保存失败");
	  		}

			processBack.setCode(ProcessBack.SUCCESS_CODE);
			processBack.setMessage("视频上传成功");
			processBack.setData(fastDFSUploadComponent.getResAccessUrl(url));
  	  		return processBack;
 		}catch(RuntimeException e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
 		}catch(Exception e){
			e.printStackTrace();
		}finally {
			uploadVideoLock.unlock();
		}

		processBack.setCode(ProcessBack.FAIL_CODE);
		processBack.setMessage("网络响应不及时,视频上传失败");
		return processBack;
	}
	
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
	@Override
	@Transactional
	public int insertForumAttachmentByAidAndTid(Long aid,Long tid,Long pid,String description){
		try{
			
			if(aid == null){
				throw new IllegalArgumentException("'aid' 不能为空");
			}
			
			if(tid == null){
				throw new IllegalArgumentException("'tid' 不能为空");
			}
			
			if(pid == null){
				throw new IllegalArgumentException("'pid' 不能为空");
			}
			
			//附件临时记录
			ForumAttachmentUnused attachmentUnused = forumAttachmentUnusedMapper.selectById(aid);
			if(attachmentUnused == null){
				throw new IllegalArgumentException("附件临时记录信息找不到,aid:"+aid);
			}
			
			//附件索引记录
			ForumAttachment entity = new ForumAttachment();
			entity.setId(aid);
			entity.setTableid(127);
			ForumAttachment attachment = baseMapper.selectOne(entity);
			if(attachment == null){
				throw new IllegalArgumentException("符合条件的附件索引记录信息找不到,aid:"+aid);
			}
			
			//根据tid 获取附件分表
			Integer tableid = parseTableidByTid(tid);
			int ppcount = 0;
			switch (tableid) {
				case 0:
					ForumAttachment0 attachment0 = new ForumAttachment0();
					attachment0.setAid(attachmentUnused.getAid());//
					attachment0.setTid(tid);//主题id 
					attachment0.setPid(pid);  //帖子id 
					attachment0.setBaseid(attachmentUnused.getBaseid());  //用户id
					attachment0.setDateline(attachmentUnused.getDateline());  //保存时间撮
					attachment0.setFilename(attachmentUnused.getFilename());  //文件名
					attachment0.setFilesize(attachmentUnused.getFilesize());  //文件大小
					attachment0.setAttachment(attachmentUnused.getAttachment());  //文件路径
					attachment0.setRemote(attachmentUnused.getRemote());  //是否远程附件1是0否
					attachment0.setDescription(description);  //说明
					attachment0.setReadperm(0);  //阅读权限
					attachment0.setPrice(0);  //附件价格 
					attachment0.setIsimage(attachmentUnused.getIsimage());  //是否图片 0附件 1图片 2视频
					attachment0.setWidth(attachmentUnused.getWidth());  //宽度
					attachment0.setThumachment(attachmentUnused.getThumachment());  //缩率图路径
					attachment0.setWaterattachment(attachmentUnused.getWaterattachment());  //水印图路径
					ppcount = forumAttachment0Mapper.insert(attachment0);
	 				break;
				case 1:
					ForumAttachment1 attachment1 = new ForumAttachment1();
					attachment1.setAid(attachmentUnused.getAid());//
					attachment1.setTid(tid);//主题id 
					attachment1.setPid(pid);  //帖子id 
					attachment1.setBaseid(attachmentUnused.getBaseid());  //用户id
					attachment1.setDateline(attachmentUnused.getDateline());  //保存时间撮
					attachment1.setFilename(attachmentUnused.getFilename());  //文件名
					attachment1.setFilesize(attachmentUnused.getFilesize());  //文件大小
					attachment1.setAttachment(attachmentUnused.getAttachment());  //文件路径
					attachment1.setRemote(attachmentUnused.getRemote());  //是否远程附件1是0否
					attachment1.setDescription(description);  //说明
					attachment1.setReadperm(0);  //阅读权限
					attachment1.setPrice(0);  //附件价格 
					attachment1.setIsimage(attachmentUnused.getIsimage());  //是否图片 0附件 1图片 2视频
					attachment1.setWidth(attachmentUnused.getWidth());  //宽度
 					attachment1.setThumachment(attachmentUnused.getThumachment());  //缩率图路径
					attachment1.setWaterattachment(attachmentUnused.getWaterattachment());  //水印图路径
 					ppcount = forumAttachment1Mapper.insert(attachment1);
					break;
				case 2:
					ForumAttachment2 attachment2 = new ForumAttachment2();
					attachment2.setAid(attachmentUnused.getAid());//
					attachment2.setTid(tid);//主题id 
					attachment2.setPid(pid);  //帖子id 
					attachment2.setBaseid(attachmentUnused.getBaseid());  //用户id
					attachment2.setDateline(attachmentUnused.getDateline());  //保存时间撮
					attachment2.setFilename(attachmentUnused.getFilename());  //文件名
					attachment2.setFilesize(attachmentUnused.getFilesize());  //文件大小
					attachment2.setAttachment(attachmentUnused.getAttachment());  //文件路径
					attachment2.setRemote(attachmentUnused.getRemote());  //是否远程附件1是0否
					attachment2.setDescription(description);  //说明
					attachment2.setReadperm(0);  //阅读权限
					attachment2.setPrice(0);  //附件价格 
					attachment2.setIsimage(attachmentUnused.getIsimage());  //是否图片 0附件 1图片 2视频
					attachment2.setWidth(attachmentUnused.getWidth());  //宽度
 					attachment2.setThumachment(attachmentUnused.getThumachment());  //缩率图路径
					attachment2.setWaterattachment(attachmentUnused.getWaterattachment());  //水印图路径
 					ppcount = forumAttachment2Mapper.insert(attachment2);
					break;
				case 3:
					ForumAttachment3 attachment3 = new ForumAttachment3();
					attachment3.setAid(attachmentUnused.getAid());//
					attachment3.setTid(tid);//主题id 
					attachment3.setPid(pid);  //帖子id 
					attachment3.setBaseid(attachmentUnused.getBaseid());  //用户id
					attachment3.setDateline(attachmentUnused.getDateline());  //保存时间撮
					attachment3.setFilename(attachmentUnused.getFilename());  //文件名
					attachment3.setFilesize(attachmentUnused.getFilesize());  //文件大小
					attachment3.setAttachment(attachmentUnused.getAttachment());  //文件路径
					attachment3.setRemote(attachmentUnused.getRemote());  //是否远程附件1是0否
					attachment3.setDescription(description);  //说明
					attachment3.setReadperm(0);  //阅读权限
					attachment3.setPrice(0);  //附件价格 
					attachment3.setIsimage(attachmentUnused.getIsimage());  //是否图片 0附件 1图片 2视频
					attachment3.setWidth(attachmentUnused.getWidth());  //宽度
 					attachment3.setThumachment(attachmentUnused.getThumachment());  //缩率图路径
					attachment3.setWaterattachment(attachmentUnused.getWaterattachment());  //水印图路径
					ppcount = forumAttachment3Mapper.insert(attachment3);
					break;
				case 4:
					ForumAttachment4 attachment4 = new ForumAttachment4();
					attachment4.setAid(attachmentUnused.getAid());//
					attachment4.setTid(tid);//主题id 
					attachment4.setPid(pid);  //帖子id 
					attachment4.setBaseid(attachmentUnused.getBaseid());  //用户id
					attachment4.setDateline(attachmentUnused.getDateline());  //保存时间撮
					attachment4.setFilename(attachmentUnused.getFilename());  //文件名
					attachment4.setFilesize(attachmentUnused.getFilesize());  //文件大小
					attachment4.setAttachment(attachmentUnused.getAttachment());  //文件路径
					attachment4.setRemote(attachmentUnused.getRemote());  //是否远程附件1是0否
					attachment4.setDescription(description);  //说明
					attachment4.setReadperm(0);  //阅读权限
					attachment4.setPrice(0);  //附件价格 
					attachment4.setIsimage(attachmentUnused.getIsimage());  //是否图片 0附件 1图片 2视频
					attachment4.setWidth(attachmentUnused.getWidth());  //宽度
 					attachment4.setThumachment(attachmentUnused.getThumachment());  //缩率图路径
					attachment4.setWaterattachment(attachmentUnused.getWaterattachment());  //水印图路径
					ppcount = forumAttachment4Mapper.insert(attachment4);
					break;
				case 5:
					ForumAttachment5 attachment5 = new ForumAttachment5();
					attachment5.setAid(attachmentUnused.getAid());//
					attachment5.setTid(tid);//主题id 
					attachment5.setPid(pid);  //帖子id 
					attachment5.setBaseid(attachmentUnused.getBaseid());  //用户id
					attachment5.setDateline(attachmentUnused.getDateline());  //保存时间撮
					attachment5.setFilename(attachmentUnused.getFilename());  //文件名
					attachment5.setFilesize(attachmentUnused.getFilesize());  //文件大小
					attachment5.setAttachment(attachmentUnused.getAttachment());  //文件路径
					attachment5.setRemote(attachmentUnused.getRemote());  //是否远程附件1是0否
					attachment5.setDescription(description);  //说明
					attachment5.setReadperm(0);  //阅读权限
					attachment5.setPrice(0);  //附件价格 
					attachment5.setIsimage(attachmentUnused.getIsimage());  //是否图片 0附件 1图片 2视频
					attachment5.setWidth(attachmentUnused.getWidth());  //宽度
 					attachment5.setThumachment(attachmentUnused.getThumachment());  //缩率图路径
					attachment5.setWaterattachment(attachmentUnused.getWaterattachment());  //水印图路径
					ppcount = forumAttachment5Mapper.insert(attachment5);
					break;
				case 6:
					ForumAttachment6 attachment6 = new ForumAttachment6();
					attachment6.setAid(attachmentUnused.getAid());//
					attachment6.setTid(tid);//主题id 
					attachment6.setPid(pid);  //帖子id 
					attachment6.setBaseid(attachmentUnused.getBaseid());  //用户id
					attachment6.setDateline(attachmentUnused.getDateline());  //保存时间撮
					attachment6.setFilename(attachmentUnused.getFilename());  //文件名
					attachment6.setFilesize(attachmentUnused.getFilesize());  //文件大小
					attachment6.setAttachment(attachmentUnused.getAttachment());  //文件路径
					attachment6.setRemote(attachmentUnused.getRemote());  //是否远程附件1是0否
					attachment6.setDescription(description);  //说明
					attachment6.setReadperm(0);  //阅读权限
					attachment6.setPrice(0);  //附件价格 
					attachment6.setIsimage(attachmentUnused.getIsimage());  //是否图片 0附件 1图片 2视频
					attachment6.setWidth(attachmentUnused.getWidth());  //宽度
 					attachment6.setThumachment(attachmentUnused.getThumachment());  //缩率图路径
					attachment6.setWaterattachment(attachmentUnused.getWaterattachment());  //水印图路径
					ppcount = forumAttachment6Mapper.insert(attachment6);
					break;
				case 7:
					ForumAttachment7 attachment7 = new ForumAttachment7();
					attachment7.setAid(attachmentUnused.getAid());//
					attachment7.setTid(tid);//主题id 
					attachment7.setPid(pid);  //帖子id 
					attachment7.setBaseid(attachmentUnused.getBaseid());  //用户id
					attachment7.setDateline(attachmentUnused.getDateline());  //保存时间撮
					attachment7.setFilename(attachmentUnused.getFilename());  //文件名
					attachment7.setFilesize(attachmentUnused.getFilesize());  //文件大小
					attachment7.setAttachment(attachmentUnused.getAttachment());  //文件路径
					attachment7.setRemote(attachmentUnused.getRemote());  //是否远程附件1是0否
					attachment7.setDescription(description);  //说明
					attachment7.setReadperm(0);  //阅读权限
					attachment7.setPrice(0);  //附件价格 
					attachment7.setIsimage(attachmentUnused.getIsimage());  //是否图片 0附件 1图片 2视频
					attachment7.setWidth(attachmentUnused.getWidth());  //宽度
 					attachment7.setThumachment(attachmentUnused.getThumachment());  //缩率图路径
					attachment7.setWaterattachment(attachmentUnused.getWaterattachment());  //水印图路径
					ppcount = forumAttachment7Mapper.insert(attachment7);
					break;
				case 8:
					ForumAttachment8 attachment8 = new ForumAttachment8();
					attachment8.setAid(attachmentUnused.getAid());//
					attachment8.setTid(tid);//主题id 
					attachment8.setPid(pid);  //帖子id 
					attachment8.setBaseid(attachmentUnused.getBaseid());  //用户id
					attachment8.setDateline(attachmentUnused.getDateline());  //保存时间撮
					attachment8.setFilename(attachmentUnused.getFilename());  //文件名
					attachment8.setFilesize(attachmentUnused.getFilesize());  //文件大小
					attachment8.setAttachment(attachmentUnused.getAttachment());  //文件路径
					attachment8.setRemote(attachmentUnused.getRemote());  //是否远程附件1是0否
					attachment8.setDescription(description);  //说明
					attachment8.setReadperm(0);  //阅读权限
					attachment8.setPrice(0);  //附件价格 
					attachment8.setIsimage(attachmentUnused.getIsimage());  //是否图片 0附件 1图片 2视频
					attachment8.setWidth(attachmentUnused.getWidth());  //宽度
 					attachment8.setThumachment(attachmentUnused.getThumachment());  //缩率图路径
					attachment8.setWaterattachment(attachmentUnused.getWaterattachment());  //水印图路径
					ppcount = forumAttachment8Mapper.insert(attachment8);
					break;
				case 9:
					ForumAttachment9 attachment9 = new ForumAttachment9();
					attachment9.setAid(attachmentUnused.getAid());//
					attachment9.setTid(tid);//主题id 
					attachment9.setPid(pid);  //帖子id 
					attachment9.setBaseid(attachmentUnused.getBaseid());  //用户id
					attachment9.setDateline(attachmentUnused.getDateline());  //保存时间撮
					attachment9.setFilename(attachmentUnused.getFilename());  //文件名
					attachment9.setFilesize(attachmentUnused.getFilesize());  //文件大小
					attachment9.setAttachment(attachmentUnused.getAttachment());  //文件路径
					attachment9.setRemote(attachmentUnused.getRemote());  //是否远程附件1是0否
					attachment9.setDescription(description);  //说明
					attachment9.setReadperm(0);  //阅读权限
					attachment9.setPrice(0);  //附件价格 
					attachment9.setIsimage(attachmentUnused.getIsimage());  //是否图片 0附件 1图片 2视频
					attachment9.setWidth(attachmentUnused.getWidth());  //宽度
 					attachment9.setThumachment(attachmentUnused.getThumachment());  //缩率图路径
					attachment9.setWaterattachment(attachmentUnused.getWaterattachment());  //水印图路径
					ppcount = forumAttachment9Mapper.insert(attachment9);
					break;
	 			default:
	  				return 0;
				}
			
			if(!(ppcount > 0)){
				throw new IllegalArgumentException("附件分表保存失败,aid:"+aid);
			}
			
			//更新附件索引表
			attachment.setTableid(tableid);
			attachment.setTid(tid);
			attachment.setPid(pid);
			int count = 0;
			count = baseMapper.updateById(attachment);
 			if(!(count > 0)){
				throw new IllegalArgumentException("附件索引表更新失败,aid:"+aid);
			}
 			
 			int attachmentUnusedCount = 0;
 			attachmentUnusedCount = forumAttachmentUnusedMapper.deleteById(aid);
 			if(!(attachmentUnusedCount > 0)){
				throw new IllegalArgumentException("附件临时表删除失败,aid:"+aid);
			}
 			
			return 1;
		}catch(RuntimeException e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
			return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	 
	
	/**
	 * 
	* @Title: getForumAttachmentByAid 
	* @Description: TODO(根据aid 获取图片或视频的路径) 
	* @param @param aid  主键id
	* @param @return    设定文件 
	* @return PreForumAttachment    返回类型 
	* @throws
	 */
	@Override
	public  ForumAttachment getForumAttachmentByAid(Long aid){
 		 try{
			 if(aid == null){
				 throw new IllegalArgumentException("'aid' 不能为空");  
			  }
 			  
 			  ForumAttachment preForumAttachment = baseMapper.selectById(aid);
			  if(preForumAttachment == null){
				  throw new IllegalArgumentException("'preForumAttachment' 信息找不到");  
			  }
			  
			  String thumbattachment = "";//缩率图路径
			  String waterattachment = "";//水印图路径
			  String attachment = "";//文件路径
			  Integer isimage = 0;//是否图片 0附件 1图片 2视频
 			  switch (preForumAttachment.getTableid()) {
				case 0:
 					ForumAttachment0 preForumAttachment0 = forumAttachment0Mapper.selectById(aid);
					if(preForumAttachment0 != null){
						thumbattachment = preForumAttachment0.getThumachment();
						waterattachment = preForumAttachment0.getWaterattachment();
						attachment  = preForumAttachment0.getAttachment();
						isimage = preForumAttachment0.getIsimage();
 					}
	 				break;
				case 1:
					ForumAttachment1 preForumAttachment1 = forumAttachment1Mapper.selectById(aid);
					if(preForumAttachment1 != null){
						thumbattachment = preForumAttachment1.getThumachment();
						waterattachment = preForumAttachment1.getWaterattachment();
						attachment  = preForumAttachment1.getAttachment();
						isimage = preForumAttachment1.getIsimage();
 					}
	 				break;
				case 2:
					ForumAttachment2 preForumAttachment2 = forumAttachment2Mapper.selectById(aid);
					if(preForumAttachment2 != null){
						thumbattachment = preForumAttachment2.getThumachment();
						waterattachment = preForumAttachment2.getWaterattachment();
						attachment  = preForumAttachment2.getAttachment();
						isimage = preForumAttachment2.getIsimage();
 					}
	 				break;
				case 3:
					ForumAttachment3 preForumAttachment3 = forumAttachment3Mapper.selectById(aid);
					if(preForumAttachment3 != null){
						thumbattachment = preForumAttachment3.getThumachment();
						waterattachment = preForumAttachment3.getWaterattachment();
						attachment  = preForumAttachment3.getAttachment();
						isimage = preForumAttachment3.getIsimage();
 					}
	 				break;
				case 4:
 					ForumAttachment4 preForumAttachment4 = forumAttachment4Mapper.selectById(aid);
					if(preForumAttachment4 != null){
						thumbattachment = preForumAttachment4.getThumachment();
						waterattachment = preForumAttachment4.getWaterattachment();
						attachment  = preForumAttachment4.getAttachment();
						isimage = preForumAttachment4.getIsimage();
 					}
	 				break;
				case 5:
					ForumAttachment5 preForumAttachment5 = forumAttachment5Mapper.selectById(aid);
					if(preForumAttachment5 != null){
						thumbattachment = preForumAttachment5.getThumachment();
						waterattachment = preForumAttachment5.getWaterattachment();
						attachment  = preForumAttachment5.getAttachment();
						isimage = preForumAttachment5.getIsimage();
 					}
	 				break;
				case 6:
					ForumAttachment6 preForumAttachment6 = forumAttachment6Mapper.selectById(aid);
					if(preForumAttachment6 != null){
						thumbattachment = preForumAttachment6.getThumachment();
						waterattachment = preForumAttachment6.getWaterattachment();
						attachment  = preForumAttachment6.getAttachment();
						isimage = preForumAttachment6.getIsimage();
					}
	 				break;
				case 7:
 					ForumAttachment7 preForumAttachment7 = forumAttachment7Mapper.selectById(aid);
					if(preForumAttachment7 != null){
						thumbattachment = preForumAttachment7.getThumachment();
						waterattachment = preForumAttachment7.getWaterattachment();
						attachment  = preForumAttachment7.getAttachment();
						isimage = preForumAttachment7.getIsimage();
					}
	 				break;
				case 8:
 					ForumAttachment8 preForumAttachment8 = forumAttachment8Mapper.selectById(aid);
					if(preForumAttachment8 != null){
						thumbattachment = preForumAttachment8.getThumachment();
						waterattachment = preForumAttachment8.getWaterattachment();
						attachment  = preForumAttachment8.getAttachment();
						isimage = preForumAttachment8.getIsimage();
 					}
	 				break;
				case 9:
 					ForumAttachment9 preForumAttachment9 = forumAttachment9Mapper.selectById(aid);
					if(preForumAttachment9 != null){
						thumbattachment = preForumAttachment9.getThumachment();
						waterattachment = preForumAttachment9.getWaterattachment();
						attachment  = preForumAttachment9.getAttachment();
						isimage = preForumAttachment9.getIsimage();
 					}
	 				break;
	 			default:
 					break;
				}
		     
			  if(StringUtil.isEmpty(attachment)){
				  throw new IllegalArgumentException("'attachment' 找不到,该附件是未使用");
			  }
			  
			  if(isimage != null && isimage == 1){//为图片类型
				  preForumAttachment.setIsimage(isimage);
				  preForumAttachment.setAttachment(this.fdfsurl+attachment);
				  preForumAttachment.setThumbattachment(this.fdfsurl+thumbattachment);
				  preForumAttachment.setWaterattachment(this.fdfsurl+waterattachment);
				  return preForumAttachment;
			  }else{
				  preForumAttachment.setIsimage(isimage);
				  preForumAttachment.setAttachment(this.fdfsurl+attachment);
 				  return preForumAttachment;
			  }
   		 }catch(Exception e){
			 e.printStackTrace();
			 return null;
		 }
	}
	
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
	public Long getForumAttachmentAidByAttach(String attachUrl,Long tid){
		try{
			
			if(StringUtil.isEmpty(attachUrl)){
				throw new IllegalArgumentException("'attach' 不能为空");
			}
			
			if(tid == null){
				throw new IllegalArgumentException("'tid' 不能为空");
			}
			
			Integer tableid = parseTableidByTid(tid);
			
			switch (tableid) {
				case 0:
					Wrapper<ForumAttachment0> wrapper0 = Condition.create();
					wrapper0.eq("attachment", attachUrl);
					wrapper0.orNew().eq("thumachment", attachUrl);
					wrapper0.orNew().eq("waterattachment", attachUrl);
					List<ForumAttachment0> list0s = forumAttachment0Mapper.selectList(wrapper0);
					if(!(list0s.size() > 0)){
						throw new IllegalArgumentException("未找到附件临时记录信息,attachUrl:"+attachUrl);
					}
					
					if(list0s.size() > 1){
						throw new IllegalArgumentException("附件临时记录信息不能超过两条,attachUrl:"+attachUrl);
					}
					
					return list0s.get(0).getAid();
				case 1:
					Wrapper<ForumAttachment1> wrapper1 = Condition.create();
					wrapper1.eq("attachment", attachUrl);
					wrapper1.orNew().eq("thumachment", attachUrl);
					wrapper1.orNew().eq("waterattachment", attachUrl);
					List<ForumAttachment1> list1s = forumAttachment1Mapper.selectList(wrapper1);
					if(!(list1s.size() > 1)){
						throw new IllegalArgumentException("未找到附件临时记录信息,attachUrl:"+attachUrl);
					}
					
					if(list1s.size() > 1){
						throw new IllegalArgumentException("附件临时记录信息不能超过两条,attachUrl:"+attachUrl);
					}
					
					return list1s.get(0).getAid();
				case 2:
					Wrapper<ForumAttachment2> wrapper2 = Condition.create();
					wrapper2.eq("attachment", attachUrl);
					wrapper2.orNew().eq("thumachment", attachUrl);
					wrapper2.orNew().eq("waterattachment", attachUrl);
					List<ForumAttachment2> list2s = forumAttachment2Mapper.selectList(wrapper2);
					if(!(list2s.size() > 0)){
						throw new IllegalArgumentException("未找到附件临时记录信息,attachUrl:"+attachUrl);
					}
					
					if(list2s.size() > 1){
						throw new IllegalArgumentException("附件临时记录信息不能超过两条,attachUrl:"+attachUrl);
					}
					
					return list2s.get(0).getAid();
				case 3:
					Wrapper<ForumAttachment3> wrapper3 = Condition.create();
					wrapper3.eq("attachment", attachUrl);
					wrapper3.orNew().eq("thumachment", attachUrl);
					wrapper3.orNew().eq("waterattachment", attachUrl);
					List<ForumAttachment3> list3s = forumAttachment3Mapper.selectList(wrapper3);
					if(!(list3s.size() > 0)){
						throw new IllegalArgumentException("未找到附件临时记录信息,attachUrl:"+attachUrl);
					}
					
					if(list3s.size() > 1){
						throw new IllegalArgumentException("附件临时记录信息不能超过两条,attachUrl:"+attachUrl);
					}
					
					return list3s.get(0).getAid();
				case 4:
					Wrapper<ForumAttachment4> wrapper4 = Condition.create();
					wrapper4.eq("attachment", attachUrl);
					wrapper4.orNew().eq("thumachment", attachUrl);
					wrapper4.orNew().eq("waterattachment", attachUrl);
					List<ForumAttachment4> list4s = forumAttachment4Mapper.selectList(wrapper4);
					if(!(list4s.size() > 0)){
						throw new IllegalArgumentException("未找到附件临时记录信息,attachUrl:"+attachUrl);
					}
					
					if(list4s.size() > 1){
						throw new IllegalArgumentException("附件临时记录信息不能超过两条,attachUrl:"+attachUrl);
					}
					
					return list4s.get(0).getAid();
				case 5:
					Wrapper<ForumAttachment5> wrapper5 = Condition.create();
					wrapper5.eq("attachment", attachUrl);
					wrapper5.orNew().eq("thumachment", attachUrl);
					wrapper5.orNew().eq("waterattachment", attachUrl);
					List<ForumAttachment5> list5s = forumAttachment5Mapper.selectList(wrapper5);
					if(!(list5s.size() > 0)){
						throw new IllegalArgumentException("未找到附件临时记录信息,attachUrl:"+attachUrl);
					}
					
					if(list5s.size() > 1){
						throw new IllegalArgumentException("附件临时记录信息不能超过两条,attachUrl:"+attachUrl);
					}
					
					return list5s.get(0).getAid();
				case 6:
					Wrapper<ForumAttachment6> wrapper6 = Condition.create();
					wrapper6.eq("attachment", attachUrl);
					wrapper6.orNew().eq("thumachment", attachUrl);
					wrapper6.orNew().eq("waterattachment", attachUrl);
					List<ForumAttachment6> list6s = forumAttachment6Mapper.selectList(wrapper6);
					if(!(list6s.size() > 0)){
						throw new IllegalArgumentException("未找到附件临时记录信息,attachUrl:"+attachUrl);
					}
					
					if(list6s.size() > 1){
						throw new IllegalArgumentException("附件临时记录信息不能超过两条,attachUrl:"+attachUrl);
					}
					
					return list6s.get(0).getAid();
				case 7:
					Wrapper<ForumAttachment7> wrapper7 = Condition.create();
					wrapper7.eq("attachment", attachUrl);
					wrapper7.orNew().eq("thumachment", attachUrl);
					wrapper7.orNew().eq("waterattachment", attachUrl);
					List<ForumAttachment7> list7s = forumAttachment7Mapper.selectList(wrapper7);
					if(!(list7s.size() > 0)){
						throw new IllegalArgumentException("未找到附件临时记录信息,attachUrl:"+attachUrl);
					}
					
					if(list7s.size() > 1){
						throw new IllegalArgumentException("附件临时记录信息不能超过两条,attachUrl:"+attachUrl);
					}
					
					return list7s.get(0).getAid();
					
				case 8:
					Wrapper<ForumAttachment8> wrapper8 = Condition.create();
					wrapper8.eq("attachment", attachUrl);
					wrapper8.orNew().eq("thumachment", attachUrl);
					wrapper8.orNew().eq("waterattachment", attachUrl);
					List<ForumAttachment8> list8s = forumAttachment8Mapper.selectList(wrapper8);
					if(!(list8s.size() > 0)){
						throw new IllegalArgumentException("未找到附件临时记录信息,attachUrl:"+attachUrl);
					}
					
					if(list8s.size() > 1){
						throw new IllegalArgumentException("附件临时记录信息不能超过两条,attachUrl:"+attachUrl);
					}
					
					return list8s.get(0).getAid();
				case 9:
					Wrapper<ForumAttachment9> wrapper9 = Condition.create();
					wrapper9.eq("attachment", attachUrl);
					wrapper9.orNew().eq("thumachment", attachUrl);
					wrapper9.orNew().eq("waterattachment", attachUrl);
					List<ForumAttachment9> list9s = forumAttachment9Mapper.selectList(wrapper9);
					if(!(list9s.size() > 0)){
						throw new IllegalArgumentException("未找到附件临时记录信息,attachUrl:"+attachUrl);
					}
					
					if(list9s.size() > 1){
						throw new IllegalArgumentException("附件临时记录信息不能超过两条,attachUrl:"+attachUrl);
					}
					
					return list9s.get(0).getAid();
 				default:
 					throw new IllegalArgumentException("未找到符合条件的分表附件记录信息,attachUrl:"+attachUrl);
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	* @Title: getForumAttachmentUnusedAidByAttach 
	* @Description: TODO(根据url查询附件临时表aid) 
	* @param @param attach
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public Long getForumAttachmentUnusedAidByAttach(String attachUrl){
		try{
			
			if(StringUtil.isEmpty(attachUrl)){
				throw new IllegalArgumentException("'attachUrl' 不能为空");
			}
			
 			Wrapper<ForumAttachmentUnused> wrapper = Condition.create();
 			wrapper.eq("attachment", attachUrl);
 			wrapper.orNew().eq("thumachment", attachUrl);
			wrapper.orNew().eq("waterattachment", attachUrl);
			List<ForumAttachmentUnused> lists = forumAttachmentUnusedMapper.selectList(wrapper);
			if(!(lists.size() > 0)){
				throw new IllegalArgumentException("未找到附件临时记录信息,attachUrl:"+attachUrl);
			}
			
			if(lists.size() > 1){
				throw new IllegalArgumentException("附件临时记录信息不能超过两条,attachUrl:"+attachUrl);
			}
			
			return lists.get(0).getAid();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
 
	/**
	 * 
	* @Title: parseTableidByTid 
	* @Description: TODO(根据tid 获取tableid) 
	* @param @param tid
	* @param @return    设定文件 
	* @return Integer    返回类型 
	* @throws
	 */
	private Integer parseTableidByTid(Long tid){
		Integer tableid = 0;
		if(tid == null){
			throw new IllegalArgumentException("'tid' 不能为空");
		}
		
		String tidStr = tid.toString();
		String tableidStr = tidStr.substring(tidStr.length()-1, tidStr.length());
		tableid = Integer.valueOf(tableidStr);
 		return tableid;
	}
}
