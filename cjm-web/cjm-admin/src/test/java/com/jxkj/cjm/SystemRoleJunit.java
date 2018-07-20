package com.jxkj.cjm;

import com.jxkj.cjm.model.SystemResource;
import com.jxkj.cjm.model.SystemRole;
import com.jxkj.cjm.model.User;
import com.jxkj.cjm.service.SystemResourceService;
import com.jxkj.cjm.service.SystemRoleService;
import com.jxkj.cjm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemRoleJunit {

	@Resource
	SystemRoleService systemRoleService;

	@Resource
	SystemResourceService systemResourceService;

	@Test
	public void System(){


	}

	@Test
	public void SystemRoleInsert(){
 		SystemRole systemRole = new SystemRole();
		systemRole.setRolename("管理员");
		Boolean count = systemRoleService.insert(systemRole);
		System.out.println(count);
	}
}
