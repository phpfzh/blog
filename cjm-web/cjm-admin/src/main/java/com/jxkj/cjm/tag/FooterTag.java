package com.jxkj.cjm.tag;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.model.vo.FriendlinkVo;
import com.jxkj.cjm.service.FriendlinkService;

/**
 * 尾部 Tag
 * @author admin
 *
 */
public class FooterTag extends BodyTagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String friendLinksVar;
	 
	@Override
	public int doAfterBody() throws JspException {
 		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		friendLinksVar = null;
    	return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		ServletContext context = this.pageContext.getServletContext();
 		WebApplicationContext ct = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
 		FriendlinkService friendlinkService = (FriendlinkService) ct.getBean(FriendlinkService.class);
  		if(StringUtil.isEmpty(friendLinksVar))friendLinksVar="friendLinks";
  		List<FriendlinkVo> friendlinkVos = friendlinkService.getIndexFriendlinkVosByType(1);
     	pageContext.setAttribute(friendLinksVar, friendlinkVos);
   		return EVAL_BODY_INCLUDE;//返回此则执行标签body中内容，SKIP_BODY则不执行
	}

	@Override
	public void release() {
 		super.release();
	}

	public void setFriendLinksVar(String friendLinksVar) {
		this.friendLinksVar = friendLinksVar;
	}
 
}
