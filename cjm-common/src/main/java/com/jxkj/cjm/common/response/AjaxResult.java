package com.jxkj.cjm.common.response;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
* @ClassName: AjaxResult 
* @Description: TODO(接口返回数据格式定义) 
* @author cjm
* @date 2018年4月19日 上午11:47:52 
*
 */
@ApiModel(description = "返回对象")
public class AjaxResult<T> {

	public static void main(String[] args) {
		System.out.println(JSON.toJSONString(AjaxResult.successAjaxResult()));
	}

	public static final String SUCCESS_CODE = "88";//成功状态码
	public static final String FAIL_CODE = "00";//失败状态码
	public static final String SUCCESS_MESSAGE = "操作成功";//操作成功默认描述
	public static final String FAIL_MESSAGE = "操作失败";//操作失败默认描述
	public static final String MESSAGE = "因网络响应不及时,请联系客服或重新操作";//系统异常默认描述

	@ApiModelProperty(value = "业务处理返回码,88 成功 00 失败")
	 private String code;
	 @ApiModelProperty(value = "业务处理返回描述")
	 private String message;
	 @ApiModelProperty(value = "数据体")
	 private T data;
	 @ApiModelProperty(value = "服务器处理时间撮")
	 private Long time;

	 public AjaxResult() {
  	 	this.time = System.currentTimeMillis();
	 }

	 public static AjaxResult successAjaxResult(){
		 AjaxResult ajaxResult = new AjaxResult();
		 ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
		 ajaxResult.setMessage(AjaxResult.SUCCESS_MESSAGE);
		 ajaxResult.setData(new Object());
		 return ajaxResult;
	 }

	public static AjaxResult successAjaxResult(String message){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
		ajaxResult.setMessage(message);
		ajaxResult.setData(new Object());
		return ajaxResult;
	}

	public  static AjaxResult successAjaxResult(Object o){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
		ajaxResult.setMessage(AjaxResult.SUCCESS_MESSAGE);
		ajaxResult.setData(o);
		return ajaxResult;
	}

	public  static AjaxResult successAjaxResult(String message,Object o){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
		ajaxResult.setMessage(message);
		ajaxResult.setData(o);
 		return ajaxResult;
	}

	public static AjaxResult failAjaxResult(){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setCode(AjaxResult.FAIL_CODE);
		ajaxResult.setMessage(AjaxResult.FAIL_MESSAGE);
		ajaxResult.setData(new Object());
		return ajaxResult;
	}

	public static AjaxResult failAjaxResult(String message){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setCode(AjaxResult.FAIL_CODE);
		ajaxResult.setMessage(message);
		ajaxResult.setData(new Object());
		return ajaxResult;
	}

	public  static AjaxResult failAjaxResult(Object o){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setCode(AjaxResult.FAIL_CODE);
		ajaxResult.setMessage(AjaxResult.FAIL_MESSAGE);
		ajaxResult.setData(o);
		return ajaxResult;
	}

	public  static AjaxResult failAjaxResult(String message,Object o){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setCode(AjaxResult.FAIL_CODE);
		ajaxResult.setMessage(message);
		ajaxResult.setData(o);
		return ajaxResult;
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

}
