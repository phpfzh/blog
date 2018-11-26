package com.jxkj.cjm.tag;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.model.ForumForum;
import com.jxkj.cjm.model.vo.ForumThreadVo;
import com.jxkj.cjm.service.ForumForumService;
import com.jxkj.cjm.service.ForumThreadService;

/**
 * 尾部 Tag
 * @author admin
 *
 */
public class NavigationTag extends BodyTagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String navigationVar;
	
	private String pageSize;
	 
	@Override
	public int doAfterBody() throws JspException {
 		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		navigationVar = null;
		pageSize = null;
    	return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		ServletContext context = this.pageContext.getServletContext();
 		WebApplicationContext ct = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
 		ForumForumService forumForumService = (ForumForumService) ct.getBean(ForumForumService.class);
  		if(StringUtil.isEmpty(navigationVar))navigationVar="navigationVar";
  		if(StringUtil.isEmpty(pageSize))pageSize="5";
  		//点击排行
  		List<ForumForum> forumForums = forumForumService.getForumForums("1", pageSize);
      	pageContext.setAttribute(navigationVar, forumForums);
   		return EVAL_BODY_INCLUDE;//返回此则执行标签body中内容，SKIP_BODY则不执行
	}

	@Override
	public void release() {
 		super.release();
	}
 
	public void setNavigationVar(String navigationVar) {
		this.navigationVar = navigationVar;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
  
	
}
