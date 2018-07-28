package com.jxkj.cjm;

import com.alibaba.fastjson.JSON;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.User;
import com.jxkj.cjm.model.vo.ForumPostVo;
import com.jxkj.cjm.service.ForumPostService;
import com.jxkj.cjm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ForumPostJunit {
	
	@Autowired
	ForumPostService forumPostService;


	@Test
	public void test() throws SQLException{
		Long tid = (long)19;
		ForumPostVo forumPostVo = forumPostService.getForumPostByTid(tid);
		System.out.println(JSON.toJSONString(forumPostVo));
	   
	}
}
