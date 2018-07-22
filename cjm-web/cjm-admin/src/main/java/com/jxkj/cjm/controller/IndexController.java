package com.jxkj.cjm.controller;

import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.controller.apidoc.GenerateUserNameRep;
import com.jxkj.cjm.controller.apidoc.UserLoingRep;
import com.jxkj.cjm.controller.apidoc.UserRegRep;
import com.jxkj.cjm.model.vo.UserLoginVo;
import com.jxkj.cjm.model.vo.UserRegVo;
import com.jxkj.cjm.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@Api(tags = "1",description = "用户登录&&注册接口")
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
	@ApiOperation(value = "用户注册接口")
	@ResponseBody
	@PostMapping("/api/register")
	public AjaxResult<UserRegRep> register(HttpServletRequest request, @ApiParam UserRegVo userRegVo){
		ProcessBack processBack = userService.userRegister(request,userRegVo);
 		if(processBack.getCode().equals(ProcessBack.SUCCESS_CODE)){//成功
  			return AjaxResult.successAjaxResult(processBack.getData());
		}else{
			return AjaxResult.failAjaxResult();
		}
  	}
	
	/**
	 * 
	 * Title: login 
	 * TODO:(登录) 
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "用户登录接口")
	@ResponseBody
	@PostMapping("/api/login")
	public AjaxResult<UserLoingRep> login(HttpServletRequest request, @ApiParam UserLoginVo userLoginVo){
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
	@ApiOperation(value = "自动生成用户名")
 	@ResponseBody
	@PostMapping("/api/generateUserName")
	public AjaxResult<GenerateUserNameRep> generateUserName(HttpServletRequest request){
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
 		return AjaxResult.failAjaxResult();
	}
	
	/**
	 * 
	 * Title: sendSSMByRegApi 
	 * TODO:(发送短信验证码) 
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "发送短信验证码")
	@ApiImplicitParam(name = "mobile" ,value = "手机号" ,required = true,dataType = "String")
	@ResponseBody
	@PostMapping("/api/ssmRegCode")
	public AjaxResult sendSSMByRegApi(HttpServletRequest request,String mobile){
 		ProcessBack processBack = userService.sendSSMByReg(mobile);
  		if(processBack.getCode().equals(ProcessBack.SUCCESS_CODE)){
			return  AjaxResult.successAjaxResult("短信发送成功");
		}
		return AjaxResult.failAjaxResult();
	}
 }
