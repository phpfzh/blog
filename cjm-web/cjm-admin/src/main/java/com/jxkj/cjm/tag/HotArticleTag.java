package com.jxkj.cjm.tag;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.model.vo.ForumThreadVo;
import com.jxkj.cjm.model.vo.FriendlinkVo;
import com.jxkj.cjm.service.ForumThreadService;

/**
 * 尾部 Tag
 * @author admin
 *
 */
public class HotArticleTag extends BodyTagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String hotArticleVar;
	
	private String pageSize;
	 
	@Override
	public int doAfterBody() throws JspException {
 		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		hotArticleVar = null;
		pageSize = null;
    	return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		ServletContext context = this.pageContext.getServletContext();
 		WebApplicationContext ct = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        ForumThreadService forumThreadService = (ForumThreadService) ct.getBean(ForumThreadService.class);
  		if(StringUtil.isEmpty(hotArticleVar))hotArticleVar="hotArticleVar";
  		if(StringUtil.isEmpty(pageSize))pageSize="10";
  		//点击排行
  		List<ForumThreadVo> hotVoLists = forumThreadService.getForumThreadsByViewOrder("1", pageSize);
      	pageContext.setAttribute(hotArticleVar, hotVoLists);
   		return EVAL_BODY_INCLUDE;//返回此则执行标签body中内容，SKIP_BODY则不执行
	}

	@Override
	public void release() {
 		super.release();
	}

	public void setHotArticleVar(String hotArticleVar) {
		this.hotArticleVar = hotArticleVar;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
  
	
}
