package com.jxkj.cjm.common.response;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 
* @ClassName: AjaxResult 
* @Description: TODO(接口返回数据格式定义) 
* @author cjm
* @date 2018年4月19日 上午11:47:52 
*
 */
public class AjaxResult {
	
	//示例
	public static void main(String[] args) {
		AjaxResult failResult = AjaxResult.createAjaxResult().failAjaxResult();
		AjaxResult successResult = AjaxResult.createAjaxResult().successAjaxResult();
 		System.out.println(JSON.toJSONString(failResult));
		System.out.println(JSON.toJSONString(successResult));

		AjaxResult failResult1 = AjaxResult.createAjaxResult().failAjaxResult("操作失败");
		AjaxResult successResult1 = AjaxResult.createAjaxResult().successAjaxResult("操作失败");
 		System.out.println(JSON.toJSONString(failResult1));
		System.out.println(JSON.toJSONString(successResult1));

 	}

	public static final String SUCCESS_CODE = "88";
	public static final String SUCCESS_MESSAGE = "操作成功";

	public static final String FAIL_CODE = "00";
	public static final String FAIL_MESSAGE = "操作失败";

	 private String code;

	 private String message;

	private Object data;
	
	private Long time;

	public AjaxResult() {

	}


	public static AjaxResult createAjaxResult(){
		return new AjaxResult();
	}
  	 
	public  AjaxResult successAjaxResult() {
		return allAjaxResult(SUCCESS_CODE, SUCCESS_MESSAGE, null);
	}
	
	public  AjaxResult successAjaxResultByToken(String token) {
		if (isEmpty(token)) {
			throw new IllegalArgumentException("token 不能为空");
		}
		Map<String,String> ha = new HashMap<>();
		ha.put("token", token);
 		return allAjaxResult(SUCCESS_CODE, "登录成功", ha);
	}

	public  AjaxResult successAjaxResult(Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException("Obj 不能为空");
		}
		return allAjaxResult(SUCCESS_CODE, SUCCESS_MESSAGE, obj);
	}

	public  AjaxResult successAjaxResult(String message) {
		if (isEmpty(message)) {
			throw new IllegalArgumentException("message 不能为空");
		}
		return allAjaxResult(SUCCESS_CODE, message, null);
	}

	public  AjaxResult successAjaxResult(String message, Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException("obj 不能为空");
		}

		if (isEmpty(message)) {
			throw new IllegalArgumentException("message 不能为空");
		}
		return allAjaxResult(SUCCESS_CODE, message, obj);
	}

	public  AjaxResult failAjaxResult() {
		return allAjaxResult(FAIL_CODE, FAIL_MESSAGE, null);
	}

	public  AjaxResult failAjaxResult(Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException("obj 不能为空");
		}
		return allAjaxResult(FAIL_CODE, FAIL_MESSAGE, obj);
	}

	public  AjaxResult failAjaxResult(String message) {

		if (isEmpty(message)) {
			throw new IllegalArgumentException("message 不能为空");
		}
		return allAjaxResult(FAIL_CODE, message, null);
	}

	public  AjaxResult failAjaxResult(String message, Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException("obj 不能为空");
		}

		if (isEmpty(message)) {
			throw new IllegalArgumentException("message 不能为空");
		}
		return allAjaxResult(FAIL_CODE, message, obj);
	}

	private  AjaxResult allAjaxResult(String code, String message, Object obj) {
 		AjaxResult ajaxResult = new AjaxResult();
 		ajaxResult.setData(obj);
		ajaxResult.setCode(code);
		ajaxResult.setMessage(message);
		Long time = System.currentTimeMillis();
		ajaxResult.setTime(time);
		return ajaxResult;
	}
	
	private  boolean isEmpty(Object str) {
		return str == null || "".equals(str) || String.valueOf(str).length() == 0
				|| String.valueOf(str).matches("\\s*");
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	 
	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
