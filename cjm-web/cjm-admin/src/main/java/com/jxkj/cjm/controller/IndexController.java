package com.jxkj.cjm.controller;

import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.controller.apidoc.GenerateUserNameRep;
import com.jxkj.cjm.controller.apidoc.UserLoingRep;
import com.jxkj.cjm.model.vo.UserLoginVo;
import com.jxkj.cjm.model.vo.UserRegVo;
import com.jxkj.cjm.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
	@ApiOperation(value = "用户注册接口")
	@ResponseBody
	@RequestMapping("/api/register")
	public AjaxResult register(HttpServletRequest request, @ApiParam UserRegVo userRegVo){
		ProcessBack processBack = userService.userRegister(request,userRegVo);
		AjaxResult ajaxResult = new AjaxResult();
		if(processBack.getCode().equals(ProcessBack.SUCCESS_CODE)){//成功
			ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
			ajaxResult.setMessage(processBack.getMessage());
		}else{
			ajaxResult.setCode(AjaxResult.FAIL_CODE);
			ajaxResult.setMessage(processBack.getMessage());
		}
		return ajaxResult;
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
	@RequestMapping("/api/login")
	public AjaxResult<UserLoingRep> login(HttpServletRequest request, @ApiParam UserLoginVo userLoginVo){
		AjaxResult<UserLoingRep> ajaxResult = new AjaxResult<UserLoingRep>();
 		ProcessBack	processBack = userService.userLogin(request,userLoginVo);
 		if(processBack.getCode().equals(ProcessBack.SUCCESS_CODE)){//成功
			UserLoingRep userLoingRep = new UserLoingRep();
			userLoingRep.setToken(processBack.getData().toString());
			ajaxResult.setData(userLoingRep);
			ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
			ajaxResult.setMessage("登录成功");
		}else{
 			ajaxResult.setCode(AjaxResult.FAIL_CODE);
			ajaxResult.setMessage(processBack.getMessage());
		}
		return ajaxResult;
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
	@RequestMapping("/api/generateUserName")
	public AjaxResult<GenerateUserNameRep> generateUserName(HttpServletRequest request){
		AjaxResult<GenerateUserNameRep> ajaxResult = new AjaxResult<GenerateUserNameRep>();
		try{
			String username = userService.generateUserName();
			if(StringUtil.isNotEmpty(username)){
				GenerateUserNameRep generateUserNameRep = new GenerateUserNameRep();
				generateUserNameRep.setUsername(username);
				ajaxResult.setData(generateUserNameRep);
				ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
				ajaxResult.setMessage("生成成功");
				return ajaxResult;
 			}
		}catch(Exception e){
			e.printStackTrace();
		}
		ajaxResult.setCode(AjaxResult.FAIL_CODE);
		ajaxResult.setMessage(AjaxResult.MESSAGE);
		return ajaxResult;
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
	@RequestMapping("/api/ssmRegCode")
	public AjaxResult sendSSMByRegApi(HttpServletRequest request,String mobile){
 		ProcessBack processBack = userService.sendSSMByReg(mobile);
		AjaxResult ajaxResult = new AjaxResult();
 		if(processBack.getCode().equals(ProcessBack.SUCCESS_CODE)){
			ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
			ajaxResult.setMessage("短信发送成功");
		}else{
			ajaxResult.setCode(AjaxResult.FAIL_CODE);
			ajaxResult.setMessage(processBack.getMessage());
		}
		return ajaxResult;
	}
 }
