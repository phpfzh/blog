package com.jxkj.cjm.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
* @ClassName: AttachUtil 
* @Description: TODO  图片转换attach工具类
* @author cjm  
* @date 2018年6月3日  
* @version 1.0 
* www.chenjiaming.com
 */
public class AttachUtil {
	//获取[attach]4562[/attach] 4562值
	public List<String>  getAttachAidByContent(String content){
 		if(isEmpty(content)){
			throw new IllegalArgumentException("'content' 不能为空");
		}
		
 		List<String> attachs = new ArrayList<>();
 		//[attach]10358[/attach][attach]10359[/attach]
		Pattern p = Pattern.compile("(\\[attach](.*?)\\[/attach])");
		Matcher m = p.matcher(content);
		boolean fal = m.find();
		if(fal){
 			while(fal){
 				Pattern p2 = Pattern.compile("(\\d+)");
				Matcher m2 = p2.matcher(m.group());
				if(m2.find()){
					attachs.add(m2.group());
				}
				fal = m.find();
			}
		}
 		return attachs;
	}
	
	//获取img src的值
	public  Map<String,String> getImgSrcList(String content) {
		Map<String,String> list = new HashMap<>();
		// 目前img标签标示有3种表达式
		// <img alt="" src="1.jpg"/> <img alt="" src="1.jpg"></img> <img alt=""
		// src="1.jpg">
		// 开始匹配content中的<img />标签
		Pattern p_img = Pattern.compile("<(img|IMG)(.*?)(/>|></img>|>)");
		Matcher m_img = p_img.matcher(content);
 		//提取img
		while (m_img.find()) {
			// 获取到匹配的<img />标签中的内容
			String str_img = m_img.group(2);
			// 开始匹配<img />标签中的src
			Pattern p_src = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");
			Matcher m_src = p_src.matcher(str_img);
			if (m_src.find()) {
				String str_src = m_src.group(3);
				String str = "http://image.chenjiaming.com/";
				if(StringUtil.isNotEmpty(str_src) && str_src.contains(str)){
					String subSrc = str_src.substring(str.length());
					list.put(m_img.group(), subSrc);
				}
			}
			// 匹配content中是否存在下一个<img />标签，有则继续以上步骤匹配<img />标签中的src
 		}
 		
		//提取video
		Pattern p_video = Pattern.compile("<(video|VIDEO)(.*?)(/>|></video>|</VIDEO>)");
		Matcher m_video = p_video.matcher(content);
 		while (m_video.find()) {
			// 获取到匹配的<video />标签中的内容
			String str_video = m_video.group(2);
			// 开始匹配<video />标签中的src
			Pattern p_src = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");
			Matcher m_src = p_src.matcher(str_video);
			while (m_src.find()) {
				String str_src = m_src.group(3);
				String str = "http://image.chenjiaming.com/";
				if(StringUtil.isNotEmpty(str_src) && str_src.contains(str)){
					String subSrc = str_src.substring(str.length());
					list.put(m_video.group(), subSrc);
				}
			}
			// 匹配content中是否存在下一个<img />标签，有则继续以上步骤匹配<img />标签中的src
 		}
 		return list;
	}
	
	/** 
	 * 转义正则特殊字符 （$()*+.[]?\^{},|） 
	 *  
	 * @param keyword 
	 * @return 
	 */  
	public  String escapeExprSpecialWord(String keyword) {  
	    if (!isEmpty(keyword)) {  
//	        String[] fbsArr = { "\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|" };
	        String[] fbsArr = {"{", "}"};
	        
	        for (String key : fbsArr) {  
	            if (keyword.contains(key)) {  
	                keyword = keyword.replace(key, "");  
	            }  
	        }  
	    }  
	    return keyword;  
	} 
	
	//替换video 里面的花括号
	public String replaceVideoDataSetup(String content){
		//提取video
		Pattern p_video = Pattern.compile("<(video|VIDEO)(.*?)(/>|></video>|</VIDEO>)");
		Matcher m_video = p_video.matcher(content);
 		while (m_video.find()) {
 			String[] fbsArr = {"{", "}"};
 			String str = m_video.group();
 	        for (String key : fbsArr) {
	            if (str.contains(key)) {  
	            	str = str.replace(key, "");  
	            }  
	        }
 			content = content.replaceFirst("<(video|VIDEO)(.*?)(/>|></video>|</VIDEO>)", str);
   		}
 		return content;
	}
	
	private static  boolean isEmpty(Object str) {
		return str == null || "".equals(str) || String.valueOf(str).length() == 0
				|| String.valueOf(str).matches("\\s*");
	}
	
	
	public static void main(String[] args) {
		String str = "<VIDEO class=\"edui-upload-video  vjs-default-skin video-js\" controls=\"\" preload=\"none\" width=\"420\" height=\"280\" src=\"http://image.chenjiaming.com/group1/M00/00/01/rBKphlsUB0yAf5C7AJykdAReKkA560.mp4\" data-setup=\"{}\"></VIDEO>";
		System.out.println(str);
		AttachUtil attachUtil = new AttachUtil();
		str = attachUtil.replaceVideoDataSetup(str);
		Map<String,String> map = attachUtil.getImgSrcList(str);
		System.out.println("=========="+str);
		for(Map.Entry<String,String> map2 : map.entrySet()){
			System.out.println(map2.getValue());
			System.out.println(map2.getKey());
 			str = str.replaceFirst(map2.getKey(), "[attach]"+22+"[/attach]");
 		}
		System.out.println("----------"+str);
	}
}
