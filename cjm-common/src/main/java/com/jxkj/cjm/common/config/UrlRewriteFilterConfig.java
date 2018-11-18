package com.jxkj.cjm.common.config;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.tuckey.web.filters.urlrewrite.Conf;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;
public class UrlRewriteFilterConfig extends UrlRewriteFilter{
	private String confPath;

	private final Log logger = LogFactory.getLog(getClass());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	    String confPathStr = filterConfig.getInitParameter("confPath");
	    confPath = StringUtils.trim(confPathStr);
	    super.init (filterConfig);
	}

	@Override
	protected void loadUrlRewriter (FilterConfig aFilterConfig) throws ServletException {

	    try {  
	        configure (aFilterConfig.getServletContext());
	    }
	    catch (Throwable e) {
	        throw new IllegalArgumentException (e);
	    }

	}
	
	private void configure (ServletContext context) throws IOException {

	    ResourceLoader webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(context);

	    Resource resource = webApplicationContext.getResource(confPath);

	    logger.info("Loaded urlrewrite.xml from " + resource.getFilename());

	   // InputStream inputStream = resource.getInputStream();
	    ClassLoader classLoader = this.getClass().getClassLoader();
 	    InputStream inputStream  = classLoader.getResourceAsStream(confPath);
	    URL confUrl = null;
	    try {
	        confUrl = context.getResource(confPath);
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }

	    String confUrlStr = null;
	    if (confUrl != null) {
	        confUrlStr = confUrl.toString();
	    }

	    if (inputStream != null) {
	        Conf conf = new Conf(context, inputStream, confPath, confUrlStr, false);
	        checkConf(conf);
	    }
	}
}
