package com.jxkj.cjm.common.component;

import com.jxkj.cjm.common.jwt.JwtTokenUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.model.User;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
public class CjmJwtTokenComponent extends JwtTokenUtil{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String generateToken(User user,Device device){
		Map<String, Object> claims = new HashMap<>();
		claims.put(AUDIENCE_BASEID, user.getId().toString());//用户ID
 		if(device != null ){//校验来源
 			return doGenerateToken(claims, user.getUsername(), device);
		}
		
		return doGenerateToken(claims, user.getUsername(), null);
	}
	
	public Boolean validateToken(String token,User user,Device device){
		if(device != null ){//校验来源
 			return doValidateToken(token, user.getId().toString(), user.getUsername(),device);
		}
		
 		return doValidateToken(token, user.getId().toString(), user.getUsername(),null);
	}
	
	public String getUserBaseId(HttpServletRequest request){
		String token = getToken(request);
		String uid = getBaseIdFromToken(token);
		if(StringUtil.isEmpty(uid)){
			throw new IllegalArgumentException("uid 找不到");
		}
		return uid;
	}

}
