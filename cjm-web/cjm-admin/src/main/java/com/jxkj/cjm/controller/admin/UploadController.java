package com.jxkj.cjm.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.service.ForumAttachmentService;

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
			AjaxResult ajax = preForumAttachmentService.uploadImage(multipartFile, (long)999999);
			Map<String,String> ma = (Map<String, String>) ajax.getData();
 			res.put("url", ma.get("url"));//上传的图片路径
			res.put("state", "SUCCESS");
			res.put("title", multipartFile.getOriginalFilename());
			res.put("original", multipartFile.getOriginalFilename());
 			return res ;
		}catch(Exception e){
			e.printStackTrace();
			return res;
		}
	}
	
	@ResponseBody
	@RequestMapping("uploadvideo")
	public Map<String,Object> uploadvideo(@RequestParam("upfile") MultipartFile multipartFile){
		System.out.println("===uploadvideo=======");
		Map<String,Object> res = new HashMap<>();
		try{
			//封装的图片上传方法
			AjaxResult ajax = preForumAttachmentService.uploadVideo(multipartFile, (long)10);
			Map<String,String> ma = (Map<String, String>) ajax.getData();
 			res.put("url", ma.get("url"));//上传的图片路径
			res.put("state", "SUCCESS");
			res.put("title", multipartFile.getOriginalFilename());
			res.put("original", multipartFile.getOriginalFilename());
 			return res ;
		}catch(Exception e){
			e.printStackTrace();
			return res;
		}
	}
}
