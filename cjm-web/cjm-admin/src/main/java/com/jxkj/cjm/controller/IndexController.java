package com.jxkj.cjm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.service.UserService;
/**
 * 
* @ClassName: IndexController 
* @Description: TODO  用户登录&&注册Controller
* @author cjm  
* @date 2018年5月31日  
* @version 1.0 
* www.chenjiaming.com
 */
@Controller
public class IndexController {
	
	@Resource
	UserService userService;
	
	/**
	 * 
	 * Title: register 
	 * TODO:(注册) 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/api/register")
	public AjaxResult register(HttpServletRequest request){
		return userService.userRegisterApi(request);
	}
	
	/**
	 * 
	 * Title: login 
	 * TODO:(登录) 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/api/login")
	public AjaxResult login(HttpServletRequest request){
		return userService.userLoginAdminApi(request);
	}
	
	/**
	 * 
	 * Title: generateUserName 
	 * TODO:(自动生成用户名) 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/api/generateUserName")
	public AjaxResult generateUserName(HttpServletRequest request){
		AjaxResult ajaxResult = AjaxResult.createAjaxResult();
		try{
			String username = userService.generateUserName();
			if(StringUtil.isNotEmpty(username)){
				Map<String,String> map = new HashMap<>();
				map.put("username", username);
 				return ajaxResult.successAjaxResult(map);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ajaxResult.failAjaxResult();
	}
	
	/**
	 * 
	 * Title: sendSSMByRegApi 
	 * TODO:(发送短信验证码) 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/api/ssmRegCode")
	public AjaxResult sendSSMByRegApi(HttpServletRequest request){
		return userService.sendSSMByRegApi(request);
	}
	
	
	@ResponseBody
	@RequestMapping("/api/index")
	public AjaxResult index(HttpServletRequest request){
		return AjaxResult.createAjaxResult().successAjaxResult();
	}
}
