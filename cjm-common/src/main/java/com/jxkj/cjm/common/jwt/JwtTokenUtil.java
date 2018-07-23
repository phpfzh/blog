package com.jxkj.cjm.common.jwt;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
/**
 * 
* @ClassName: JwtTokenUtil 
* @Description: TODO(Jwt token 工具类) 
* @author cjm
* @date 2018年4月17日 下午5:19:52 
* 
*   See:
*   https://github.com/jwtk/jjwt
*	https://stormpath.com/blog/jwt-java-create-verify
*	http://mvnrepository.com/artifact/io.jsonwebtoken/jjwt/0.9.0
*/
@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	static final String CLAIM_KEY_USERNAME = "sub";
	static final String CLAIM_KEY_AUDIENCE = "aud";
	static final String CLAIM_KEY_CREATED = "iat";

	static final String AUDIENCE_UNKNOWN = "unknown";
	static final String AUDIENCE_WEB = "web";
	static final String AUDIENCE_MOBILE = "mobile";
	static final String AUDIENCE_TABLET = "tablet";
    
	public static final String AUDIENCE_BASEID = "baseId";
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private Long expiration;
	
	@Value("${jwt.header.tokenHead}")
	private String tokenHead;
	
	@Value("${jwt.header}")
	private String header;
	
	/**
	 * 
	* @Title: getToken 
	* @Description: TODO(根据传进的 request 获取 token) 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String getToken(HttpServletRequest request){
 		//requestToken like [Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwaW5ndGFpemhpamlhIiwiYXVkIjoid2ViIiwiYmFzZUlkIjoiMSIsImV4cCI6MTUyNDEzNjg5NCwiaWF0IjoxNTI0MTMzMjk0fQ.lohqsc8_fRXCM79BtEh0Bl7FZdchCcFOeTXDMk8W-JeQPNhzkSNOt8Q927jXdi9sz_G3JEBd7d5EJCL5smRwnA]
		String requestToken = request.getHeader(header);
		
		if(isEmpty(requestToken)){
			throw new IllegalArgumentException("token 不能为空");
		}
		
		//tokenHead  like [Bearer ]
		String token = requestToken.substring(tokenHead.length());
		return token;
	}
	
	/**
	 * 
	* @Title: doValidateToken 
	* @Description: TODO(验证token) 
	* @param @param token  token
	* @param @param audience 请求来源（pc，ipa，ios）   当来源不为空时校验来源
	* @param @return    设定文件 
	* @return Boolean    返回类型 
	* @throws
	 */
	public Boolean doValidateToken(String token,Device device){
		try{
			Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			if(device != null){
				String audience = generateAudience(device);
	 			if(!isEmpty(audience)){//校验来源
	 				final String audienceStr = claims.getAudience();
	 				return  audience.equals(audienceStr);
				}
			}
  			return true;
		}catch(SignatureException e){
			e.printStackTrace();
			return false;
		}catch(JwtException e){
			e.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 
	* @Title: doValidateToken 
	* @Description: TODO(验证token ) 
	* @param @param token  
	* @param @param id   用户id
	* @param @param username  用户名
	* @param @param device  请求来源 ios android ipa
	* @param @return    设定文件 
	* @return Boolean    返回类型 
	* @throws
	 */
	public Boolean doValidateToken(String token,String id,String username,Device device){
		try{
 			final String userNameStr = getUsernameFromToken(token);
			final String baseID 	 = getBaseIdFromToken(token);
			
			if(device != null){
				String audience = generateAudience(device);
 				if(!isEmpty(audience)){//校验来源
					final String audienceStr = getAudienceFromToken(token);
					return userNameStr.equals(username) 
							&& audience.equals(audienceStr)
							&& baseID.equals(id);
				}
			}
			 
 			return userNameStr.equals(username) && baseID.equals(id);
		}catch(ExpiredJwtException e){
			e.printStackTrace();
			return false;
		}catch(JwtException e){
			e.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		} 
	}
  
	
	/**
	 * 
	* @Title: refreshToken 
	* @Description: TODO(刷新token) 
	* @param @param token
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String refreshToken(String token){
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		
		final Claims claims = getAllClaimsFromToken(token);
		claims.setIssuedAt(now);
		if(expiration > 0){
			claims.setExpiration(calculateExpirationDate(now));//最后过期时间
		}
		
		JwtBuilder jwtBuilder = Jwts.builder();
		jwtBuilder.setClaims(claims);
		jwtBuilder.signWith(SignatureAlgorithm.HS512, secret);
		return jwtBuilder.compact();
	}
	 
	/**
	 * 
	* @Title: doGenerateToken 
	* @Description: TODO(Token 签发) 
	* @param @param claims
	* @param @param subject
	* @param @param device
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String doGenerateToken(Map<String, Object> claims,String subject,Device device){
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		
		JwtBuilder jwtBuilder = Jwts.builder();
  		jwtBuilder.setClaims(claims);
		jwtBuilder.setSubject(subject);//主体
		jwtBuilder.setIssuedAt(now);//当前时间
		jwtBuilder.signWith(SignatureAlgorithm.HS512, secret);
		
		if(device != null){
			String audience = generateAudience(device);
			if(!isEmpty(audience)){
				jwtBuilder.setAudience(audience);//来源
			}
		}
		
 		if(expiration > 0){
 			jwtBuilder.setExpiration(calculateExpirationDate(now));//最后过期时间
		}
		
 		return jwtBuilder.compact();
 	}		
 	 
	public String getBaseIdFromToken(String token){
		final Claims claims = getAllClaimsFromToken(token);
		return claims.get(AUDIENCE_BASEID).toString();
	}
	
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
	 
	public String getAudienceFromToken(String token){
		return getClaimFromToken(token, Claims::getAudience);
	}
	 
	public <T> T getClaimFromToken(String token,Function<Claims,T> claimsResolver){
		final Claims claims = getAllClaimsFromToken(token);
 		return claimsResolver.apply(claims);
	}
  
	private Claims getAllClaimsFromToken(String token){
 		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	 
	private String generateAudience(Device device) {
        String audience = AUDIENCE_UNKNOWN;
        if (device.isNormal()) {
            audience = AUDIENCE_WEB;
        } else if (device.isTablet()) {
            audience = AUDIENCE_TABLET;
        } else if (device.isMobile()) {
            audience = AUDIENCE_MOBILE;
        }
        return audience;
	}
 
	private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + expiration * 1000);
    }
	
	private  boolean isEmpty(Object str) {
		return str == null || "".equals(str) || String.valueOf(str).length() == 0
				|| String.valueOf(str).matches("\\s*");
	}
}
