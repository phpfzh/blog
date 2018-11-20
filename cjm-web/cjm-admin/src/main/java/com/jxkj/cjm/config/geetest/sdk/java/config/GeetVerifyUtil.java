package com.jxkj.cjm.config.geetest.sdk.java.config;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.config.geetest.sdk.java.GeetestLib;

/**
 * 封装的滑块后台验证 工具类
 * @author cjm
 *
 */
public class GeetVerifyUtil {

	public static ProcessBack GeetVerify(HttpServletRequest request){
		ProcessBack processBack = new ProcessBack();
		
		try{
			GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key(), 
					GeetestConfig.isnewfailback());
				
			String challenge = request.getParameter(GeetestLib.fn_geetest_challenge);
			String validate = request.getParameter(GeetestLib.fn_geetest_validate);
			String seccode = request.getParameter(GeetestLib.fn_geetest_seccode);
			
			//从session中获取gt-server状态
			int gt_server_status_code = (Integer) request.getSession().getAttribute(gtSdk.gtServerStatusSessionKey);
			
			//从session中获取userid
			String userid = (String)request.getSession().getAttribute("geetuserid");
			
			//自定义参数,可选择添加
			HashMap<String, String> param = new HashMap<String, String>(); 
			param.put("user_id", userid); //网站用户id
			//param.put("client_type", "web"); //web:电脑上的浏览器；h5:手机上的浏览器，包括移动应用内完全内置的web_view；native：通过原生SDK植入APP应用的方式
			//param.put("ip_address", "127.0.0.1"); //传输用户请求验证时所携带的IP
			
			int gtResult = 0;
	
			if (gt_server_status_code == 1) {
				//gt-server正常，向gt-server进行二次验证
					
				gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode, param);
				System.out.println(gtResult);
			} else {
				// gt-server非正常情况下，进行failback模式验证
					
				System.out.println("failback:use your own server captcha validate");
				gtResult = gtSdk.failbackValidateRequest(challenge, validate, seccode);
				System.out.println(gtResult);
			}
	
 			if (gtResult == 1) {
				// 验证成功
 				processBack.setCode(ProcessBack.SUCCESS_CODE);
				processBack.setMessage("滑块验证成功");
				return processBack;
	 		} else {
				// 验证失败
	 			throw new IllegalArgumentException(gtSdk.getVersionInfo());
  	 		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		processBack.setCode(ProcessBack.FAIL_CODE);
		processBack.setMessage("滑块验证失败");
		return processBack;
	}
}
