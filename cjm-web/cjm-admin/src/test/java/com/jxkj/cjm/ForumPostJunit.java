package com.jxkj.cjm;

import com.alibaba.fastjson.JSON;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.ForumThreadReplyAttach;
import com.jxkj.cjm.model.User;
import com.jxkj.cjm.model.vo.ForumPostVo;
import com.jxkj.cjm.service.ForumPostService;
import com.jxkj.cjm.service.ForumThreadReplyAttachService;
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
	ForumThreadReplyAttachService forumThreadReplyAttachService;


	@Test
	public void test() throws SQLException{
		ForumThreadReplyAttach forumThreadReplyAttach = forumThreadReplyAttachService.getForumThreadReplyAttachByAttach("group1/M00/00/4F/rBMV6VtgAHqAHP1UAADks5uFQOw459_200x80.jpg");
		System.out.println(forumThreadReplyAttach);
	}
}
