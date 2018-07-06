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
		AjaxResult logoutResult = AjaxResult.createAjaxResult().logoutAjaxResult();
		System.out.println(JSON.toJSONString(failResult));
		System.out.println(JSON.toJSONString(successResult));
		System.out.println(JSON.toJSONString(logoutResult));
		
		AjaxResult failResult1 = AjaxResult.createAjaxResult().failAjaxResult("操作失败");
		AjaxResult successResult1 = AjaxResult.createAjaxResult().successAjaxResult("操作失败");
		AjaxResult logoutResult1 = AjaxResult.createAjaxResult().logoutAjaxResult("操作失败");
		System.out.println(JSON.toJSONString(failResult1));
		System.out.println(JSON.toJSONString(successResult1));
		System.out.println(JSON.toJSONString(logoutResult1));
		
 	}

	public static final String SUCCESS_CODE = "88";
	public static final String SUCCESS_MESSAGE = "操作成功";

	public static final String FAIL_CODE = "00";
	public static final String FAIL_MESSAGE = "操作失败";

	public static final String LOGOUT_CODE = "11";
	public static final String LOGOUT_MESSAGE = "请重新登录";

	private Meta meta;

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

	public  AjaxResult logoutAjaxResult() {
		return allAjaxResult(LOGOUT_CODE, LOGOUT_MESSAGE, null);
	}

	public  AjaxResult logoutAjaxResult(Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException("obj 不能为空");
		}

		return allAjaxResult(LOGOUT_CODE, LOGOUT_MESSAGE, obj);
	}

	public  AjaxResult logoutAjaxResult(String message) {
		if (isEmpty(message)) {
			throw new IllegalArgumentException("message 不能为空");
		}
		return allAjaxResult(LOGOUT_CODE, message, null);
	}

	public  AjaxResult logoutAjaxResult(String message, Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException("obj 不能为空");
		}

		if (isEmpty(message)) {
			throw new IllegalArgumentException("message 不能为空");
		}
		return allAjaxResult(LOGOUT_CODE, LOGOUT_MESSAGE, obj);
	}

	private  AjaxResult allAjaxResult(String code, String message, Object obj) {
		Meta meta = new Meta();
		meta.setCode(code);
		meta.setMessage(message);
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setMeta(meta);
		ajaxResult.setData(obj);
		Long time = System.currentTimeMillis();
		ajaxResult.setTime(time);
		return ajaxResult;
	}
	
	private  boolean isEmpty(Object str) {
		return str == null || "".equals(str) || String.valueOf(str).length() == 0
				|| String.valueOf(str).matches("\\s*");
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
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
}
