package com.jxkj.cjm.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.LiteDeviceResolver;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.common.component.CjmJwtTokenComponent;
import com.jxkj.cjm.common.component.RedisUtilComponent;
import com.jxkj.cjm.common.constat.Redis_Constat;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.util.IPUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.mapper.UserAccountMapper;
import com.jxkj.cjm.mapper.UserMapper;
import com.jxkj.cjm.mapper.UserSafetyMapper;
import com.jxkj.cjm.model.User;
import com.jxkj.cjm.model.UserAccount;
import com.jxkj.cjm.model.UserSafety;
import com.jxkj.cjm.service.UserService;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
	
	@Resource
	private RedisUtilComponent redisUtilComponent;
	
	@Resource
	private UserSafetyMapper userSafetyMapper;
	
	@Resource
	private UserAccountMapper userAccountMapper;
	
	@Resource
	private CjmJwtTokenComponent cjmJwtTokenComponent;
	 
	/**
	 * 
	* @Title: userLoginApi 
	* @Description: TODO(用户登录) 
	* @param @param request
	* @param @return    设定文件 
	* @return AjaxResult    返回类型 
	* @throws
	 */
	@Override
	public synchronized AjaxResult userLoginApi(HttpServletRequest request) {
		
		AjaxResult ajaxResult = AjaxResult.createAjaxResult();
		String username = request.getParameter("username");
 		String password = request.getParameter("password");
 		
		if(StringUtil.isEmpty(username)){
			return ajaxResult.failAjaxResult("用户名不能为空");
		}
		
		if(StringUtil.isEmpty(password)){
			return ajaxResult.failAjaxResult("用户密码不能为空");
		}
		
		try{
			
 			/*根据用户名或手机号查询*/
	 		User user = null;
	 		User user2 = new User();
	 		user2.setUsername(username.trim());
	 		user = baseMapper.selectOne(user2);
	 		if(user == null){
	 			User entity2 = new User();
	 			entity2.setMobile(username.trim());
	 			user = baseMapper.selectOne(entity2);
		 		if(user == null){
		 			return ajaxResult.failAjaxResult("用户名或密码错误");
		 		}
	 		}
	 		 
	 		//用户安全信息
	 		UserSafety userSafety2 = new UserSafety();
	 		userSafety2.setBaseid(user.getId());
	 		UserSafety userSafety = userSafetyMapper.selectOne(userSafety2);
	 		if(userSafety == null ){
	 			return ajaxResult.failAjaxResult("用户名或密码错误");
	 		}	
	 		
	 		//比较用户密码
	 		boolean pswFlag = BCrypt.checkpw(password,userSafety.getPassword());//解密
     		if(!pswFlag){//用户密码错误
  				return ajaxResult.failAjaxResult("用户名或密码错误");
 			}
     		
     		if(userSafety.getStatus() != null && userSafety.getStatus() == 1){
     			return ajaxResult.failAjaxResult("该用户有异常已被禁止登陆");
     		}
     		
     		if(userSafety.getIsdelete() != null && userSafety.getIsdelete() == 1){
     			return ajaxResult.failAjaxResult("未找到该用户");
     		}
  			
  			String lastloginip = IPUtil.getIpAdd(request);
  			Long lastlogintime = System.currentTimeMillis();
  			userSafety.setLastlogintime(lastlogintime);//最后登录时间
  			userSafety.setLastloginip(lastloginip);//最后登录ip
  			userSafetyMapper.updateById(userSafety);
  			
  			LiteDeviceResolver deviceResolver = new LiteDeviceResolver();
  			Device device = deviceResolver.resolveDevice(request);
   			String token = cjmJwtTokenComponent.generateToken(user, device);
   			 
   		   //缓存用户基本信息，安全信息
   			redisUtilComponent.setRedisKeyAndValue(Redis_Constat.USER+user.getId(), user);//用户基本信息
   			redisUtilComponent.setRedisKeyAndValue(Redis_Constat.USERCENTER+user.getId(), userSafety);//用户安全信息
     			
    		return ajaxResult.successAjaxResultByToken(token);
   			
		}catch(Exception e){
			e.printStackTrace();
			return ajaxResult.failAjaxResult("网络出异常了,请联系客服或重新操作");
		}
  	}
	
	/**
	 * 
	* @Title: userLoginAdminApi 
	* @Description: TODO(管理用户登录) 
	* @param @param request
	* @param @return    设定文件 
	* @return AjaxResult    返回类型 
	* @throws
	 */
	@Override
	public synchronized AjaxResult userLoginAdminApi(HttpServletRequest request) {
		
		AjaxResult ajaxResult = AjaxResult.createAjaxResult();
		String username = request.getParameter("username");
 		String password = request.getParameter("password");
 		
		if(StringUtil.isEmpty(username)){
			return ajaxResult.failAjaxResult("用户名不能为空");
		}
		
		if(StringUtil.isEmpty(password)){
			return ajaxResult.failAjaxResult("用户密码不能为空");
		}
		
		try{
			
 			/*根据用户名或手机号查询*/
	 		User user = null;
	 		User user2 = new User();
	 		user2.setUsername(username.trim());
	 		user = baseMapper.selectOne(user2);
	 		if(user == null){
	 			User entity2 = new User();
	 			entity2.setMobile(username.trim());
	 			user = baseMapper.selectOne(entity2);
		 		if(user == null){
		 			return ajaxResult.failAjaxResult("用户名或密码错误");
		 		}
	 		}
	 		 
	 		//用户安全信息
	 		UserSafety userSafety2 = new UserSafety();
	 		userSafety2.setBaseid(user.getId());
	 		UserSafety userSafety = userSafetyMapper.selectOne(userSafety2);
	 		if(userSafety == null ){
	 			return ajaxResult.failAjaxResult("用户名或密码错误");
	 		}	
	 		
	 		//比较用户密码
	 		boolean pswFlag = BCrypt.checkpw(password,userSafety.getPassword());//解密
     		if(!pswFlag){//用户密码错误
  				return ajaxResult.failAjaxResult("用户名或密码错误");
 			}
     		
     		if(userSafety.getStatus() != null && userSafety.getStatus() == 1){
     			return ajaxResult.failAjaxResult("该用户有异常已被禁止登陆");
     		}
     		
     		if(userSafety.getIsdelete() != null && userSafety.getIsdelete() == 1){
     			return ajaxResult.failAjaxResult("未找到该用户");
     		}
     		
     		if(userSafety.getIsadmin() == null || userSafety.getIsadmin() == 0){
     			return ajaxResult.failAjaxResult("您不是管理用户");
     		}
  			
  			String lastloginip = IPUtil.getIpAdd(request);
  			Long lastlogintime = System.currentTimeMillis();
  			userSafety.setLastlogintime(lastlogintime);//最后登录时间
  			userSafety.setLastloginip(lastloginip);//最后登录ip
  			userSafetyMapper.updateById(userSafety);
  			
  			LiteDeviceResolver deviceResolver = new LiteDeviceResolver();
  			Device device = deviceResolver.resolveDevice(request);
   			String token = cjmJwtTokenComponent.generateToken(user, device);
   			 
   		   //缓存用户基本信息，安全信息
   			redisUtilComponent.setRedisKeyAndValue(Redis_Constat.USER+user.getId(), user);//用户基本信息
   			redisUtilComponent.setRedisKeyAndValue(Redis_Constat.USERCENTER+user.getId(), userSafety);//用户安全信息
     			
    		return ajaxResult.successAjaxResultByToken(token);
   			
		}catch(Exception e){
			e.printStackTrace();
			return ajaxResult.failAjaxResult("网络出异常了,请联系客服或重新操作");
		}
  	}
	
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
	@Override
	@Transactional
	public synchronized AjaxResult userRegisterApi(HttpServletRequest request) {
		AjaxResult ajaxResult = AjaxResult.createAjaxResult();
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
 		String password = request.getParameter("password");
 		String code = request.getParameter("code");
		if(StringUtil.isEmpty(mobile)){
			return ajaxResult.failAjaxResult("手机号不能为空");
		}
		
		if(StringUtil.isEmpty(password)){
			return ajaxResult.failAjaxResult("用户密码不能为空");
		}
		
		if(!StringUtil.isMobile(mobile)){
			return ajaxResult.failAjaxResult("用户手机号码格式不正确");
		}
		
		if(StringUtil.isNotEmpty(email)){
			if(!StringUtil.isEmail(email)){
				return ajaxResult.failAjaxResult("用户邮箱格式不正确");
			}
		}
		
		if(StringUtil.isNotEmpty(username)){
			if(username.length() > 10){
				return ajaxResult.failAjaxResult("用户名长度不能超过10位");
			}
		}
		
		if(StringUtil.isEmpty(code)){
 			return ajaxResult.failAjaxResult("短信验证码不能为空");
 		}
		 
		try{
			
			//判断手机号是否已注册
			User entityValid = new User();
			entityValid.setMobile(mobile.trim());
			User commonMemberValidate = baseMapper.selectOne(entityValid);
			if(commonMemberValidate != null){
				return ajaxResult.failAjaxResult("该手机号已注册");
			}
			
 			//用户名不为空的时候判断该用户名是否已注册
			if(StringUtil.isNotEmpty(username)){
				User entityValid1 = new User();
				entityValid1.setUsername(username.trim());
				User commonMemberValidate1 = baseMapper.selectOne(entityValid1);
				if(commonMemberValidate1 != null){
					return ajaxResult.failAjaxResult("该用户名已注册");
				}
			}else{
				//自动生成
				username = generateUserName();
 			}
			
			//判断邮箱是否已注册
			if(StringUtil.isNotEmpty(email)){
				User entityValid2 = new User();
				entityValid2.setMobile(mobile.trim());
				User commonMemberValidate2 = baseMapper.selectOne(entityValid2);
				if(commonMemberValidate2 != null){
					return ajaxResult.failAjaxResult("该邮箱已注册");
				}
			}
			
			//手机短信验证码
			String ssmCode = (String) redisUtilComponent.getRedisByKey(Redis_Constat.USER_SSM_CODE+mobile);
			//发送手机短信验证码手机号
			String ssmMobile = (String) redisUtilComponent.getRedisByKey(Redis_Constat.USER_MOBILE+mobile);
			if(StringUtil.isEmpty(ssmCode) || StringUtil.isEmpty(ssmMobile)){
				return ajaxResult.failAjaxResult("短信验证码错误或已过期");
			}
			 
			//判断短信验证码是否正确
			if(!ssmCode.equals(code)){
				return ajaxResult.failAjaxResult("短信验证码错误或已过期");
			}
			
			//判断是否是发送原手机短信验证码手机号
			if(!ssmMobile.equals(mobile)){
				return ajaxResult.failAjaxResult("请输入发送短信验证码的手机号");
			}
			
			LiteDeviceResolver deviceResolver = new LiteDeviceResolver();
			Device device = deviceResolver.resolveDevice(request);
			
			String ip = IPUtil.getIpAdd(request);//注册ip
			
 			String newPassWord  = BCrypt.hashpw(password, BCrypt.gensalt());  //加密;
			Long regdate = System.currentTimeMillis();
 			User commonMember = new User();
 			commonMember.setMobile(mobile.trim());//手机号
			commonMember.setRegtime(regdate);//注册时间
			commonMember.setUsername(username);//用户名
			commonMember.setEmailstatus(0);//邮箱是否验证 0未验证 1已验证
			commonMember.setMobilestatus(1);//手机是否验证 0未验证 1已验证
			commonMember.setRelastatus(0);//身份证是否验证 0未验证 1已验证
			commonMember.setRegip(ip);//注册IP
 			if(device != null && device.getDevicePlatform() != null){
 				commonMember.setDevice(device.getDevicePlatform().name());//注册来源  
			}
			
			if(StringUtil.isNotEmpty(email)){
				commonMember.setEmail(email);//邮箱
			}
			
			int count = 0;
			count = baseMapper.insert(commonMember);
			if(!(count > 0)){//保存失败
				return ajaxResult.failAjaxResult("因网络响应不及时,注册失败");
			}
			
			//用户安全信息
			UserSafety members = new UserSafety();
			members.setBaseid(commonMember.getId()); //
 			members.setPassword(newPassWord); //密码
 			members.setRegip(ip); //注册ip
			members.setRegtime(regdate);; //注册时间 
			members.setIsdelete(0);//用户是否注销
			members.setStatus(0);//是否禁止登陆
			members.setErrorcount(0);//登陆失败次数
			members.setIsadmin(0);
  			int cou = 0;
 			cou = userSafetyMapper.insert(members);
 			if(!(cou > 0)){//保存失败
				throw new IllegalArgumentException("用户安全信息添加失败,uid：" + commonMember.getId());
			}
 			
 			//添加用户账号表
 			UserAccount userAccount = new UserAccount();
 			userAccount.setBaseid(commonMember.getId());
 			userAccount.setBalance(new BigDecimal(0.00));
 			userAccount.setFreezebalance(new BigDecimal(0.00));
 			userAccount.setTotalbalance(new BigDecimal(0.00));
 			int accountCount = 0;
 			accountCount = userAccountMapper.insert(userAccount);
 			if(!(accountCount > 0)){
 				throw new IllegalArgumentException("用户账号信息添加失败,uid：" + commonMember.getId());
 			}
 			
 			//缓存用户基本信息，安全信息
 			redisUtilComponent.setRedisKeyAndValue(Redis_Constat.USER+commonMember.getId(), commonMember);
 			redisUtilComponent.setRedisKeyAndValue(Redis_Constat.USERCENTER+commonMember.getId(), members);
 			
 			//删除缓存的手机验证码，手机号
			redisUtilComponent.deleteRedisKey(Redis_Constat.USER_SSM_CODE+mobile);
			redisUtilComponent.deleteRedisKey(Redis_Constat.USER_MOBILE+mobile);
 			
  			//签发token
 			String token = cjmJwtTokenComponent.generateToken(commonMember, device);
 			Map<String,String> ha = new HashMap<>();
 			ha.put("token", token);
 			ha.put("username", username);
 			ha.put("mobile", mobile);
  			//注册成功
 			return ajaxResult.successAjaxResult("注册成功", ha);
		}catch(RuntimeException e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
 			return ajaxResult.failAjaxResult("因网络响应不及时,操作失败,请联系客服排查或重新操作");
		}catch(Exception e){
			e.printStackTrace();
			return ajaxResult.failAjaxResult("因网络响应不及时,操作失败,请联系客服排查或重新操作");
		}
  	}

	/**
	 * 自动生成用户名
	 * @return
	 */
	public synchronized String generateUserName(){
		boolean falg = true;
		String username = "";
		int i = 4;
		Random random = new Random();
		while (falg) {
 			username = generateUserName(i);
			User user = new User();
			user.setUsername(username);
			User user2 = baseMapper.selectOne(user);
			if(user2 == null ){
				falg = false;
			}
			
			if(random.nextInt(7) % 2 == 1){
 				i++;
			}
			
			if(i > 7){i=4;}//不能超过7  用户名长度不能超过10位 bus+数字
		}
 		return username;
	}
	
	private String generateUserName(int length){
		String[] arr = { "0","1","2", "3", "4", "5", "6", "7", "8", "9"};
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		while (sb.length() < length) {
			String str = arr[random.nextInt(9)];
			if (sb.indexOf(str) == -1) {
				sb.append(str);
			}
		}
		return "bus"+sb.toString();
	}
	
	/***
	 * 
	* @Title: sendSSMByRegApi 
	* @Description: TODO(注册时发送手机短信验证码) 
	* @param @param request
	* @param @return    设定文件 
	* @return AjaxResult    返回类型 
	* @throws
	 */
	@Override
	public synchronized AjaxResult sendSSMByRegApi(HttpServletRequest request) {
		AjaxResult ajaxResult = AjaxResult.createAjaxResult();
		String mobile = request.getParameter("mobile");
		if(StringUtil.isEmpty(mobile)){
			return ajaxResult.failAjaxResult("手机号不能为空");
		}
		
		if(!StringUtil.isMobile(mobile)){
			return ajaxResult.failAjaxResult("手机号格式不正确");
		}
		
		try{
			//判断手机号是否已注册
			User entityValid = new User();
			entityValid.setMobile(mobile.trim());
			User commonMemberValidate = baseMapper.selectOne(entityValid);
			if(commonMemberValidate != null){
				return ajaxResult.failAjaxResult("该手机号已注册");
			}
 			 
			//String code = String.valueOf(StringUtil.getN(6));
			//System.out.println("code："+code);
			String code = "111111";
			//缓存手机号,短信验证码
		    redisUtilComponent.setRedisKeyAndValue((Redis_Constat.USER_SSM_CODE+mobile),code);
		    redisUtilComponent.setRedisKeyAndValue((Redis_Constat.USER_MOBILE+mobile),mobile);
    	 	return ajaxResult.successAjaxResult("短信发送成功");
		}catch(Exception e){
			e.printStackTrace();
			return ajaxResult.failAjaxResult("因网络响应不及时,操作失败");
		}
 	}
}
