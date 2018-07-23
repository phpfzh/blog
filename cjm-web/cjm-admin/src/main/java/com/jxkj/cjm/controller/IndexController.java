package com.jxkj.cjm.controller;

import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.model.vo.UserLoginVo;
import com.jxkj.cjm.model.vo.UserRegVo;
import com.jxkj.cjm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
	@PostMapping("/api/register")
	public AjaxResult register(HttpServletRequest request,  UserRegVo userRegVo){
 		ProcessBack processBack = userService.userRegister(request,userRegVo);
 		if(processBack.getCode().equals(ProcessBack.SUCCESS_CODE)){//成功
  			return AjaxResult.successAjaxResult(processBack.getData());
		}else{
			return AjaxResult.failAjaxResult(processBack.getMessage());
		}
  	}
	
	/**
	 * 
	 * Title: login 
	 * TODO:(登录) 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@PostMapping("/api/login")
	public AjaxResult login(HttpServletRequest request,  UserLoginVo userLoginVo){
		AjaxResult ajaxResult = new AjaxResult();
 		ProcessBack	processBack = userService.userLogin(request,userLoginVo);
 		if(processBack.getCode().equals(ProcessBack.SUCCESS_CODE)){//成功
			return AjaxResult.successAjaxResult("登录成功",processBack.getData());
		}else{
 			return AjaxResult.failAjaxResult(processBack.getMessage());
		}
	}
	
	/**
	 * 
	 * Title: generateUserName 
	 * TODO:(自动生成用户名) 
	 * @param request
	 * @return
	 */
  	@ResponseBody
	@PostMapping("/api/generateUserName")
	public AjaxResult generateUserName(HttpServletRequest request){
 		try{
			String username = userService.generateUserName();
			if(StringUtil.isNotEmpty(username)){
 				Map<String,String> ha = new HashMap<>();
				ha.put("username",username);
  				return AjaxResult.successAjaxResult(ha);
 			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return AjaxResult.failAjaxResult("生成失败");
 	}
	
	/**
	 * 
	 * Title: sendSSMByRegApi 
	 * TODO:(发送短信验证码) 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@PostMapping("/api/ssmRegCode")
	public AjaxResult sendSSMByRegApi(HttpServletRequest request,String mobile){
 		ProcessBack processBack = userService.sendSSMByReg(mobile);
  		if(processBack.getCode().equals(ProcessBack.SUCCESS_CODE)){
			return  AjaxResult.successAjaxResult("短信发送成功");
		}
		return AjaxResult.failAjaxResult(processBack.getMessage());
	}
 }
