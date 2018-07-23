package com.jxkj.cjm.controller.admin;

import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.service.ForumAttachmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 
* @ClassName: UploadController 
* @Description: TODO 文件上传工具类  
* @author cjm  
* @date 2018年5月31日  
* @version 1.0 
* www.chenjiaming.com
 */
@Controller
public class UploadController extends BaseController{
	
	@Resource
	private ForumAttachmentService preForumAttachmentService;
	
	@ResponseBody
	@RequestMapping("uploadimage")
	public Map<String,Object> uploadimage(@RequestParam("upfile") MultipartFile multipartFile){
		System.out.println("===uploadimage=======");
		Map<String,Object> res = new HashMap<>();
		try{
			//封装的图片上传方法
			ProcessBack processBack = preForumAttachmentService.uploadImage(multipartFile, (long)999999);
			if(processBack.getCode().equals(ProcessBack.SUCCESS_CODE)){
				res.put("url", processBack.getData());//上传的图片路径
				res.put("state", "SUCCESS");
				res.put("title", multipartFile.getOriginalFilename());
				res.put("original", multipartFile.getOriginalFilename());
				return res ;
 			}
		}catch(Exception e){
			e.printStackTrace();
		}
			return res;
	}
	
	@ResponseBody
	@RequestMapping("uploadvideo")
	public Map<String,Object> uploadvideo(@RequestParam("upfile") MultipartFile multipartFile){
		System.out.println("===uploadvideo=======");
		Map<String,Object> res = new HashMap<>();
		try{
			//封装的图片上传方法
			ProcessBack processBack = preForumAttachmentService.uploadVideo(multipartFile, (long)10);
			if(processBack.getCode().equals(ProcessBack.SUCCESS_CODE)){
 				res.put("url", processBack.getData());//上传的图片路径
				res.put("state", "SUCCESS");
				res.put("title", multipartFile.getOriginalFilename());
				res.put("original", multipartFile.getOriginalFilename());
			}
 			return res ;
		}catch(Exception e){
			e.printStackTrace();
			return res;
		}
	}
}
