package com.jxkj.cjm.common.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.jxkj.cjm.common.interceptor.UserApiInterceptor;
import com.jxkj.cjm.common.interceptor.UserPCInterceptor;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mobile.device.DeviceHandlerMethodArgumentResolver;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ApplicationConfig extends WebMvcConfigurationSupport {
 	/** spring-mobile配置 Start   具体请看  https://projects.spring.io/spring-mobile/ **/
	@Bean
	public DeviceResolverHandlerInterceptor deviceResolverHandlerInterceptor() {
	    return new DeviceResolverHandlerInterceptor();
	}

	@Bean
	public DeviceHandlerMethodArgumentResolver deviceHandlerMethodArgumentResolver() {
	    return new DeviceHandlerMethodArgumentResolver();
	}
 	
	@Bean
	public UserApiInterceptor userApiInterceptor(){
		//特别注意：拦截器是默认是不被spring context控制的
		return new UserApiInterceptor();
	}
	
	@Bean
	public UserPCInterceptor userPCInterceptor(){
		//特别注意：拦截器是默认是不被spring context控制的
		return new UserPCInterceptor();
	}
   
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(deviceResolverHandlerInterceptor());
	    //api 返回拦截器
	    registry.addInterceptor(userApiInterceptor())
	    		.addPathPatterns("/api/**")
	    		.excludePathPatterns("/api/login")
	    		.excludePathPatterns("/api/register")
	    		.excludePathPatterns("/api/ssmRegCode")
	    		.excludePathPatterns("/api/generateUserName")
 	    		.excludePathPatterns("/api/refreshToken")
	    		.excludePathPatterns("/api/forumThreadApi/**");
	    
	    registry.addInterceptor(userPCInterceptor())
				.addPathPatterns("/user/**");
   	}

	@Bean
    public FilterRegistrationBean urlRewrite(){
        UrlRewriteFilter rewriteFilter = new UrlRewriteFilterConfig();
        FilterRegistrationBean registration = new FilterRegistrationBean(rewriteFilter);
        registration.setUrlPatterns(Arrays.asList("/*"));
        Map initParam=new HashMap();
        initParam.put("confPath","urlrewirte.xml");
        initParam.put("infoLevel","INFO");
        registration.setInitParameters(initParam);
        return  registration;
    }
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
	    argumentResolvers.add(deviceHandlerMethodArgumentResolver());
	}
 	/** spring-mobile配置 end **/
	
	//配置JSP视图解析器
	@Bean
	public ViewResolver viewResolver() {  
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	//配置静态资源
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");

		super.addResourceHandlers(registry);
	}
 	
	//配置fastjson 中文乱码
  	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		  // 1、需要先定义一个 convert 转换消息的对象;  
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();  
          
        //2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;  
        FastJsonConfig fastJsonConfig = new FastJsonConfig();  
           
        //2-1 处理中文乱码问题  
        List<MediaType> fastMediaTypes = new ArrayList<>();  
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);  
        fastConverter.setSupportedMediaTypes(fastMediaTypes);  
          
        //3、在convert中添加配置信息.  
        fastConverter.setFastJsonConfig(fastJsonConfig);  
		converters.add(fastConverter);
	}

}
