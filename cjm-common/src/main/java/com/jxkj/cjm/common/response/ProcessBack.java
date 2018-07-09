package com.jxkj.cjm.common.response;

/**
 * 系统内部业务方法处理返回对象
 */
public class ProcessBack {

    public static final String SUCCESS_CODE = "88";//成功状态码
    public static final String FAIL_CODE = "00";//失败状态码
    public static final String EXCEPTION_CODE = "22";//系统异常状态码
    //other 其他请自己定义

    public static final String SUCCESS_MESSAGE = "操作成功";//成功返回描述
    public static final String FAIL_MESSAGE = "操作失败";//失败返回描述
    public static final String EXCEPTION_MESSAGE = "因网络响应不及时,请联系客服或重新操作";//异常返回描述

    private String code = ProcessBack.SUCCESS_CODE;//内部方法处理状态码

    private String message = ProcessBack.SUCCESS_MESSAGE;

    private Object data;

    public ProcessBack() {

    }

    public ProcessBack(String code) {
        this.code = code;
    }



    public ProcessBack(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
