package com.jxkj.cjm.service.impl;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.common.dysms.api.SmsDemo;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.mapper.SmsRecordMapper;
import com.jxkj.cjm.model.SmsRecord;
import com.jxkj.cjm.service.SmsRecordService;

@Service
public class SmsRecordServiceImpl extends ServiceImpl<SmsRecordMapper,SmsRecord> implements SmsRecordService {
	
	protected static Logger LOGGER = LoggerFactory.getLogger(SmsRecordServiceImpl.class);

	@Override
	public ProcessBack sendSSm(String mobile,String code){
		ProcessBack back = new ProcessBack();
		try{
			
			SmsRecord record = new SmsRecord();
			record.setMobile(mobile);//接收信息电话
			record.setVercode(code); //验证码   
			record.setSendtime(System.currentTimeMillis());//发送时间
			record.setSendtype(2);//发送方式 （1:手工   2:系统）     
			record.setStatus(0); //发送状态 0初始 1成功  2失败    
			record.setName("阿里云"); //名称   
 		    //发短信
	        SendSmsResponse response = SmsDemo.sendSms(mobile,code);
	        record.setSmsreturn(JSON.toJSONString(response)); //短信发送返回内容  
	        LOGGER.info("==短信接口返回的数据=="+JSON.toJSONString(response));
	        
	        if(response.getCode().equals("OK")){//短信发送成功
	    		record.setStatus(1); //发送状态 0初始 1成功  2失败    
	        	baseMapper.insert(record);
	        	
 	        	Map<String,Object> map = new HashMap<>();
	        	map.put("code", code);
	        	back.setCode(ProcessBack.SUCCESS_CODE);
	    		back.setMessage("短信发送成功");
	    		back.setData(map);
	    		return back;
	        }else{
	        	record.setStatus(2); //发送状态 0初始 1成功  2失败    
	        	baseMapper.insert(record);
	        }
 		}catch(Exception e){
			e.printStackTrace();
		}
		back.setCode(ProcessBack.FAIL_CODE);
		back.setMessage("短信发送失败");
		return back;
	}
	
	
}
