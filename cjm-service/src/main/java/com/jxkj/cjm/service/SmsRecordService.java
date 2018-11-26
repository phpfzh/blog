package com.jxkj.cjm.service;

import com.baomidou.mybatisplus.service.IService;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.SmsRecord;

public interface SmsRecordService extends IService<SmsRecord>{ 
	
	public ProcessBack sendSSm(String mobile,String code);
	
	 
}