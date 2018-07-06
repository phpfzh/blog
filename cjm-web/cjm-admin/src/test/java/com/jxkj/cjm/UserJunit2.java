package com.jxkj.cjm;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jxkj.cjm.model.User;
import com.jxkj.cjm.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserJunit2 {
	
	@Autowired
     UserService  userService;
	
	@Test
	public void test() throws SQLException{
		User user = new User();
		user.setEmail("41fsd2523");
		System.out.println("========"+userService);
	   boolean fa = userService.insert(user);
	   System.out.println(fa);
	   System.out.println("========"+userService.selectById((long)3).getEmail());
	   
	}
}
