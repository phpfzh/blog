package com.jxkj.cjm.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.jxkj.cjm.common.constat.Session_Constat;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.model.User;
import com.jxkj.cjm.model.UserSafety;

public class UserPCInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestType = request.getHeader("X-Requested-With");
		String requestUrl = request.getScheme() //当前链接使用的协议
				+"://" + request.getServerName()//服务器地址
				+ ":" + request.getServerPort() //端口号
				+ request.getContextPath() //应用名称，如果应用名称为
				+ request.getServletPath() //请求的相对url
				+ "?" + request.getQueryString(); //请求参数
		request.getSession().setAttribute(Session_Constat.URLREDIRCT,requestUrl);
 		User user = (User) request.getSession().getAttribute(Session_Constat.USER);
 		UserSafety  userSafety = (UserSafety) request.getSession().getAttribute(Session_Constat.USERCENTER);
		if(user != null && userSafety != null){
 			return true;
		}else{
			//检查是否是ajax请求
			if(StringUtil.isNotEmpty(requestType) && requestType.equalsIgnoreCase("XMLHttpRequest")){
  				response.getWriter().print("logout");
 			}else{
				response.sendRedirect(request.getContextPath()+"/?logouted=logout");
			}
 			return false;
		}	
	}
 }
