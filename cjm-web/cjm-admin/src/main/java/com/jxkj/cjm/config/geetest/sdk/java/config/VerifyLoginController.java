package com.jxkj.cjm.config.geetest.sdk.java.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxkj.cjm.config.geetest.sdk.java.GeetestLib;

/**
 * 验证测试 Controller
 * @author admin
 *
 */
@Controller
public class VerifyLoginController {

	@ResponseBody
	@RequestMapping("/verifyLogin")
	public Map<String,String> verifyLogin(HttpServletRequest request,
			HttpServletResponse response){

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

		Map<String,String> data = new HashMap<>();
		if (gtResult == 1) {
			// 验证成功
			data.put("status", "success");
			data.put("version", gtSdk.getVersionInfo());
 		} else {
			// 验证失败
			data.put("status", "fail");
			data.put("version", gtSdk.getVersionInfo());
 		}
		return data;
	}
}
