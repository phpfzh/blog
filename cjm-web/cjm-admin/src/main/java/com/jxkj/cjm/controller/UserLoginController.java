package com.jxkj.cjm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.config.geetest.sdk.java.config.GeetVerifyUtil;
import com.jxkj.cjm.model.vo.UserLoginVo;
import com.jxkj.cjm.model.vo.UserRegVo;
import com.jxkj.cjm.service.UserService;

@Controller
public class UserLoginController extends BaseController{
	
	@Resource
	UserService userService;
	
	/**
	 * 用户登录 @Title: login 
	 * @Description: 
	 * TODO(用户登录)
	 *  @param 
	 *  @return 设定文件
	 *   @return
	 * ProcessBack 返回类型 @throws
	 */
	@ResponseBody
	@RequestMapping("/login")
	public ProcessBack login(UserLoginVo userLoginVo) {
		ProcessBack processBack = userService.userLoginByPC(request, userLoginVo);
		return processBack;
	}

	/**
	 *
	 * @Title: register @Description: 
	 * TODO(用户注册) @param
	 *  @return 设定文件 
	 *  @return ProcessBack 返回类型 @throws
	 */
	@ResponseBody
	@RequestMapping("/register")
	public ProcessBack register(UserRegVo userRegVo) {
		ProcessBack processBack = userService.userRegisterByPC(request, userRegVo);
		return processBack;
	}
	
	/**
	 * 
	 * Title: sendSms 
	 * TODO:(发送注册短信) 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/sendSms")
	public ProcessBack sendSms() {
		String mobile = request.getParameter("mobile");
 		ProcessBack processBack = GeetVerifyUtil.GeetVerify(request);
		if (processBack.getCode().equals(ProcessBack.FAIL_CODE)) {// 滑块验证不通过
			return processBack;
		}

		ProcessBack back = userService.sendSSMByRegByPC(request, mobile);
		return back;
	}
}
