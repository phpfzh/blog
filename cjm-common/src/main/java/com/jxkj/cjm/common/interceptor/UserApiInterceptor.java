package com.jxkj.cjm.common.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.LiteDeviceResolver;
import org.springframework.web.servlet.HandlerInterceptor;

import com.alibaba.fastjson.JSON;
import com.jxkj.cjm.common.component.CjmJwtTokenComponent;
import com.jxkj.cjm.common.component.RedisUtilComponent;
import com.jxkj.cjm.common.constat.Redis_Constat;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.model.User;
import com.jxkj.cjm.model.UserSafety;


/**
 * 
* @ClassName: UserApiInterceptor 
* @Description: TODO(Api 拦截器实现) 
* @author cjm
* @date 2018年4月19日 下午6:33:19 
*
 */
public class UserApiInterceptor implements HandlerInterceptor{
	
	@Value("${jwt.header.tokenHead}")
	private String tokenHead;
	
	@Value("${jwt.header}")
	private String header;
	
	@Resource
	private CjmJwtTokenComponent cjmJwtTokenComponent;
	
	@Resource
	private RedisUtilComponent redisUtilComponent;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String requestToken = request.getHeader(this.header);
		//token 为空
		if(StringUtil.isEmpty(requestToken)){
 			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"token 不能为空");
 			return false;
		}
		 
		//配置文件 tokenHead 为空
		if(!requestToken.startsWith(this.tokenHead)){
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"tokenHead 不能为空");
  			return false;
		}
		
		LiteDeviceResolver deviceResolver = new LiteDeviceResolver();
		Device device = deviceResolver.resolveDevice(request);
		
 		String token = requestToken.substring(this.tokenHead.length());
 		boolean fal = cjmJwtTokenComponent.doValidateToken(token, device);
 		
 		//验证不通过
 		if(!fal){
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"请重新登录");
			return false;
 		}
 		
 		String uid = cjmJwtTokenComponent.getBaseIdFromToken(token);
   		if(!redisUtilComponent.getRedisTemplate().hasKey(Redis_Constat.USER+uid)){
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"请重新登录");
			return false;
 		}
   		
   		//延长缓存时间
   		User commonMember = (User) redisUtilComponent.getRedisByKey(Redis_Constat.USER+uid);
   		UserSafety members = (UserSafety) redisUtilComponent.getRedisByKey(Redis_Constat.USERCENTER+uid);
   		redisUtilComponent.setRedisKeyAndValue(Redis_Constat.USER+uid, commonMember);
   		redisUtilComponent.setRedisKeyAndValue(Redis_Constat.USERCENTER+uid, members);
  		
   		//把刷新后的token 返回
 		String refreshToken = cjmJwtTokenComponent.refreshToken(token);
 		response.setHeader("refreshToken", refreshToken);
 		return true;
	}
    
 }
