package com.jxkj.cjm.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.jxkj.cjm.common.response.Meta;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.vo.UserLoginVo;
import com.jxkj.cjm.model.vo.UserRegVo;
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

	private Lock userLoginLock = new ReentrantLock();//用户登录锁

	private Lock userRegLock = new ReentrantLock();//用户注册锁

	private Lock sendSSMLock = new ReentrantLock();//发送短信验证码lock

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
	* @Title: userLogin
	* @Description: TODO(用户登录) 
	* @param @param request
	* @param @return    设定文件 
	* @return int    返回类型  0 失败 1成功 2验证不通过
	* @throws
	 */
	@Override
	public  ProcessBack userLogin(HttpServletRequest request, UserLoginVo userLoginVo) {
		ProcessBack processBack = new ProcessBack();
		try{
			userLoginLock.lock();//加锁
			//验证请求参数
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<UserLoginVo>> constraintViolations = validator.validate(userLoginVo);
			if(constraintViolations.iterator().hasNext() && constraintViolations.iterator().next().getMessage() != null){
				processBack.setCode(ProcessBack.FAIL_CODE);
				processBack.setMessage(constraintViolations.iterator().next().getMessage());
				return processBack;
			}

 			/*根据用户名或手机号查询*/
	 		User user = null;
	 		User user2 = new User();
	 		user2.setUsername(userLoginVo.getUsername());
	 		user = baseMapper.selectOne(user2);
	 		if(user == null){
	 			User entity2 = new User();
	 			entity2.setMobile(userLoginVo.getUsername());
	 			user = baseMapper.selectOne(entity2);
		 		if(user == null){
					processBack.setCode(ProcessBack.FAIL_CODE);
 					processBack.setMessage("用户名或密码错误");
					return processBack;
		 		}
	 		}
	 		 
	 		//用户安全信息
	 		UserSafety userSafety2 = new UserSafety();
	 		userSafety2.setBaseid(user.getId());
	 		UserSafety userSafety = userSafetyMapper.selectOne(userSafety2);
	 		if(userSafety == null ){
				processBack.setCode(ProcessBack.FAIL_CODE);
 				processBack.setMessage("用户名或密码错误");
				return processBack;
	 		}	
	 		
	 		//比较用户密码
	 		boolean pswFlag = BCrypt.checkpw(userLoginVo.getPassword(),userSafety.getPassword());//解密
     		if(!pswFlag){//用户密码错误
				processBack.setCode(ProcessBack.FAIL_CODE);
 				processBack.setMessage("用户名或密码错误");
				return processBack;
 			}
     		
     		if(userSafety.getStatus() != null && userSafety.getStatus() == 1){
				processBack.setCode(ProcessBack.FAIL_CODE);
 				processBack.setMessage("该用户有异常已被禁止登陆");
				return processBack;
     		}
     		
     		if(userSafety.getIsdelete() != null && userSafety.getIsdelete() == 1){
				processBack.setCode(ProcessBack.FAIL_CODE);
 				processBack.setMessage("未找到该用户");
				return processBack;
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
			processBack.setData(token);//登录token
			return processBack;
 		}catch(Exception e){
			e.printStackTrace();
		}finally {
			userLoginLock.unlock();//释放锁
		}
		processBack.setCode(ProcessBack.EXCEPTION_CODE);
		processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
 		return processBack;
  	}

	/**
	 * 
	* @Title: userRegister
	* @Description: TODO(用户注册) 
	* @param @param request
	* @param @return    设定文件 
	* @return AjaxResult    返回类型 
	* @throws
 	 */
	@Override
	@Transactional
	public  ProcessBack userRegister(HttpServletRequest request,UserRegVo userRegVo) {
		ProcessBack processBack = new ProcessBack();
		try{
			userRegLock.lock();
			//验证请求参数
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<UserRegVo>> constraintViolations = validator.validate(userRegVo);
			if(constraintViolations.iterator().hasNext() && constraintViolations.iterator().next().getMessage() != null){
				processBack.setCode(ProcessBack.FAIL_CODE);
				processBack.setMessage(constraintViolations.iterator().next().getMessage());
				return processBack;
			}

			//判断手机号是否已注册
			User entityValid = new User();
			entityValid.setMobile(userRegVo.getMobile());
			User commonMemberValidate = baseMapper.selectOne(entityValid);
			if(commonMemberValidate != null){
 				processBack.setCode(ProcessBack.FAIL_CODE);
				processBack.setMessage("该手机号已注册");
				return processBack;
			}
			
 			//用户名不为空的时候判断该用户名是否已注册
			if(StringUtil.isNotEmpty(userRegVo.getUsername())){
				User entityValid1 = new User();
				entityValid1.setUsername(userRegVo.getUsername());
				User commonMemberValidate1 = baseMapper.selectOne(entityValid1);
				if(commonMemberValidate1 != null){
 					processBack.setCode(ProcessBack.FAIL_CODE);
					processBack.setMessage("该用户名已注册");
					return processBack;
				}
			}else{
				//自动生成
				userRegVo.setUsername(generateUserName());
 			}
			
			//判断邮箱是否已注册
			if(StringUtil.isNotEmpty(userRegVo.getEmail())){
				User entityValid2 = new User();
				entityValid2.setEmail(userRegVo.getEmail());
				User commonMemberValidate2 = baseMapper.selectOne(entityValid2);
				if(commonMemberValidate2 != null){
 					processBack.setCode(ProcessBack.FAIL_CODE);
					processBack.setMessage("该邮箱已注册");
					return processBack;
				}
			}
			
			//手机短信验证码
			String ssmCode = (String) redisUtilComponent.getRedisByKey(Redis_Constat.USER_SSM_CODE+userRegVo.getMobile());
			//发送手机短信验证码手机号
			String ssmMobile = (String) redisUtilComponent.getRedisByKey(Redis_Constat.USER_MOBILE+userRegVo.getMobile());
			if(StringUtil.isEmpty(ssmCode) || StringUtil.isEmpty(ssmMobile)){
 				processBack.setCode(ProcessBack.FAIL_CODE);
				processBack.setMessage("短信验证码错误或已过期");
				return processBack;
			}
			 
			//判断短信验证码是否正确
			if(!ssmCode.equals(userRegVo.getCode())){
 				processBack.setCode(ProcessBack.FAIL_CODE);
				processBack.setMessage("短信验证码错误或已过期");
				return processBack;
			}
			
			//判断是否是发送原手机短信验证码手机号
			if(!ssmMobile.equals(userRegVo.getMobile())){
 				processBack.setCode(ProcessBack.FAIL_CODE);
				processBack.setMessage("手机号码与发送短信验证码的不一致");
				return processBack;
			}
			
			LiteDeviceResolver deviceResolver = new LiteDeviceResolver();
			Device device = deviceResolver.resolveDevice(request);
			
			String ip = IPUtil.getIpAdd(request);//注册ip
			
 			String newPassWord  = BCrypt.hashpw(userRegVo.getPassword(), BCrypt.gensalt());  //加密;
			Long regdate = System.currentTimeMillis();
 			User commonMember = new User();
 			commonMember.setMobile(userRegVo.getMobile());//手机号
			commonMember.setRegtime(regdate);//注册时间
			commonMember.setUsername(userRegVo.getUsername());//用户名
			commonMember.setEmailstatus(0);//邮箱是否验证 0未验证 1已验证
			commonMember.setMobilestatus(1);//手机是否验证 0未验证 1已验证
			commonMember.setRelastatus(0);//身份证是否验证 0未验证 1已验证
			commonMember.setRegip(ip);//注册IP
 			if(device != null && device.getDevicePlatform() != null){
 				commonMember.setDevice(device.getDevicePlatform().name());//注册来源  
			}
			
			if(StringUtil.isNotEmpty(userRegVo.getEmail())){
				commonMember.setEmail(userRegVo.getEmail());//邮箱
			}
			
			int count = 0;
			count = baseMapper.insert(commonMember);
			if(!(count > 0)){//保存失败
 				processBack.setCode(ProcessBack.FAIL_CODE);
				processBack.setMessage("因网络响应不及时,注册失败");
				return processBack;
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
			redisUtilComponent.deleteRedisKey(Redis_Constat.USER_SSM_CODE+userRegVo.getMobile());
			redisUtilComponent.deleteRedisKey(Redis_Constat.USER_MOBILE+userRegVo.getMobile());
 			
  			//签发token
 			String token = cjmJwtTokenComponent.generateToken(commonMember, device);
 			Map<String,String> ha = new HashMap<>();
 			ha.put("token", token);
 			ha.put("username", userRegVo.getUsername());
 			ha.put("mobile", userRegVo.getMobile());
 			processBack.setData(ha);
			processBack.setMessage("注册成功");
			//注册成功
			return processBack;
 		}catch(RuntimeException e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
 		}catch(Exception e){
			e.printStackTrace();
		}finally {
			userRegLock.unlock();
		}
		processBack.setCode(ProcessBack.EXCEPTION_CODE);
		processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
		return processBack;
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
	* @Title: sendSSMByReg
	* @Description: TODO(注册时发送手机短信验证码) 
	* @param @param request
	* @param @return    设定文件 
	* @return AjaxResult    返回类型 
	* @throws
	 */
	@Override
	public ProcessBack sendSSMByReg(String mobile) {
		ProcessBack processBack = new ProcessBack();
 		if(StringUtil.isEmpty(mobile)){
			processBack.setCode(ProcessBack.FAIL_CODE);
			processBack.setMessage("手机号不能为空");
			return processBack;
		}

		if(!StringUtil.isMobile(mobile)){
 			processBack.setCode(ProcessBack.FAIL_CODE);
			processBack.setMessage("手机号格式不正确");
			return processBack;
		}
		try{
			//判断手机号是否已注册
			User entityValid = new User();
			entityValid.setMobile(mobile.trim());
			User commonMemberValidate = baseMapper.selectOne(entityValid);
			if(commonMemberValidate != null){
 				processBack.setCode(ProcessBack.FAIL_CODE);
				processBack.setMessage("该手机号已注册");
				return processBack;
			}

			//String code = String.valueOf(StringUtil.getN(6));
			//System.out.println("code："+code);
			String code = "111111";
			//缓存手机号,短信验证码
			redisUtilComponent.setRedisKeyAndValue((Redis_Constat.USER_SSM_CODE+mobile),code);
			redisUtilComponent.setRedisKeyAndValue((Redis_Constat.USER_MOBILE+mobile),mobile);
			processBack.setCode(ProcessBack.SUCCESS_CODE);
			processBack.setMessage("短信发送成功");
			return processBack;
 		}catch(Exception e){
			e.printStackTrace();
 			processBack.setCode(ProcessBack.EXCEPTION_CODE);
			processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
			return processBack;
		}

 	}
}
