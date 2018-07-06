package com.jxkj.cjm.service;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.service.IService;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.model.User;

public interface UserService extends IService<User>{ 
	/**
	 * 
	* @Title: userLoginApi 
	* @Description: TODO(用户登录) 
	* @param @param request
	* @param @return    设定文件 
	* @return AjaxResult    返回类型 
	* @throws
	*   注意：
	*   String username = request.getParameter("username"); 用户名 or 手机号
 		String password = request.getParameter("password"); 用户密码
	 */
	public AjaxResult userLoginApi(HttpServletRequest request);
	
	/**
	 * 
	* @Title: userLoginAdminApi 
	* @Description: TODO(管理用户登录) 
	* @param @param request
	* @param @return    设定文件 
	* @return AjaxResult    返回类型 
	* @throws
	*   注意：
	*   String username = request.getParameter("username"); 用户名 or 手机号
 		String password = request.getParameter("password"); 用户密码
	 */
	public AjaxResult userLoginAdminApi(HttpServletRequest request);
	
	/**
	 * 
	* @Title: userRegisterApi 
	* @Description: TODO(用户注册) 
	* @param @param request
	* @param @return    设定文件 
	* @return AjaxResult    返回类型 
	* @throws
	* 	注意：
	*   	String username = request.getParameter("username"); 用户名 （选填）
	*       String email = request.getParameter("email"); 邮箱 （选填）
	*       String mobile = request.getParameter("mobile"); 手机号
 	*		String password = request.getParameter("password"); 用户密码
	 */
	public AjaxResult userRegisterApi(HttpServletRequest request);
	/**
	 * 自动生成用户名
	 * @return
	 */
	public  String generateUserName();
	/***
	 * 
	* @Title: sendSSMByRegApi 
	* @Description: TODO(注册时发送手机短信验证码) 
	* @param @param request
	* @param @return    设定文件 
	* @return AjaxResult    返回类型 
	* @throws
	 */
	public AjaxResult sendSSMByRegApi(HttpServletRequest request);
}