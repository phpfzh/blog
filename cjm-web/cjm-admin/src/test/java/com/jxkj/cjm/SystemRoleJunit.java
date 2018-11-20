package com.jxkj.cjm;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jxkj.cjm.model.SystemRole;
import com.jxkj.cjm.service.SmsRecordService;
import com.jxkj.cjm.service.SystemResourceService;
import com.jxkj.cjm.service.SystemRoleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemRoleJunit {

	@Resource
	SystemRoleService systemRoleService;

	@Resource
	SystemResourceService systemResourceService;
	@Resource 
	SmsRecordService smsRecordService;
	
	@Test
	public void System(){

		smsRecordService.sendSSm("13653865012", "123456");
	}

	@Test
	public void SystemRoleInsert(){
 		SystemRole systemRole = new SystemRole();
		systemRole.setRolename("管理员");
		Boolean count = systemRoleService.insert(systemRole);
		System.out.println(count);
	}
}
