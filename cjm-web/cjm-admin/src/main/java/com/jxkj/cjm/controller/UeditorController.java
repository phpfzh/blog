package com.jxkj.cjm.controller;

import com.baidu.ueditor.ActionEnter;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 
* @ClassName: UeditorController 
* @Description: TODO 
* @author cjm
* @date 2018年5月7日 上午10:01:13 
*
* 注意：
 *  这里主要是实现 src/main/resources/config.json 的配置信息返回给Ueditor
*  
*  测试： /config?action=config
*   
 */
@Controller
public class UeditorController {

 	@RequestMapping("/config")
	public void config(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException, JSONException{
		    response.setContentType("application/json");
	        String rootPath = request.getSession().getServletContext().getRealPath("/");
	        try {
	            //
	            ActionEnter actionEnter = new ActionEnter(request, rootPath);
	            String exec=actionEnter.exec();
	            PrintWriter writer = response.getWriter();
	            writer.write(exec);
	            writer.flush();
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        };
	}
}
