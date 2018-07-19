package com.jxkj.cjm.service;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.service.IService;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.Meta;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.User;
import com.jxkj.cjm.model.vo.UserLoginVo;
import com.jxkj.cjm.model.vo.UserRegVo;

public interface UserService extends IService<User>{ 
	/**
	 * 
	* @Title: userLogin
	* @Description: TODO(用户登录) 
	* @param @param request
	 * @param @param UserLoginVo
	* @param @return    设定文件 
	* @return ProcessBack    返回类型
	* @throws

	 */
	public ProcessBack userLogin(HttpServletRequest request, UserLoginVo userLoginVo);
 	/**
	 * 
	* @Title: userRegister
	* @Description: TODO(用户注册) 
	* @param @param request
	* @param @return    设定文件 
	* @return ProcessBack    返回类型
	* @throws
	 */
	public ProcessBack userRegister(HttpServletRequest request,UserRegVo UserRegVo);
	/**
	 * 自动生成用户名
	 * @return
	 */
	public  String generateUserName();
	/***
	 * 
	* @Title: sendSSMByReg
	* @Description: TODO(注册时发送手机短信验证码) 
	* @param @param mobile
	* @param @return    设定文件 
	* @return ProcessBack    返回类型
	* @throws
	 */
	public ProcessBack sendSSMByReg(String mobile);

	/**
	 *
	 * @param baseid 根据用户id 获取用户信息
	 * @return
	 */
	public ProcessBack getUserByBaseid(String baseid);
}