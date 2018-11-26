<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="../../../common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>陈嘉明个人博客-分享web前端和Java技术的个人博客网站</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="陈嘉明,陈嘉明个人博客,个人博客,个人博客网站">
<meta name="description" content="陈嘉明个人博客，分享web前端技术和Java技术的个人博客网站">
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/reset2.css" />
<link rel="stylesheet" href="${basePath}/static/css/swiper-3.3.1.min.css">
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/first_week2.css"/>
<%@include file="../../../common/public.jsp"%>
<script type="text/javascript" src="${basePath}/static/js/first_week2.js"></script>
<script type="text/javascript" src="${basePath}/static/js/platform/portalarticle/portalarticle.js"></script>
 <script type="text/javascript">
	$(function(){
		var obj = $(".navs").find("ul li a");
		$(obj).removeClass('active').eq(1).addClass("active");
	})
 </script>
 <style type="text/css">
 	#messagetext{
 		width:600px;
 		height:400px;
 		margin:35px auto;
 	}
 </style>
</head>
<body>
   <div class="bus">
		<!-- 公共头部开始 -->
		 <%@include file="../../../common/header.jsp"%>
		 <div id="messagetext" class="alert_error">
			<p>抱歉，指定的主题不存在或已被删除或正在被审核</p>
			<script type="text/javascript">
			if(history.length > (BROWSER.ie ? 0 : 1)) {
				document.write('<p class="alert_btnleft"><a href="javascript:history.back()">[ 点击这里返回上一页 ]</a></p>');
			} else {
				document.write('<p class="alert_btnleft"><a href="/">[首页 ]</a></p>');
			}
			</script><p class="alert_btnleft"><a href="/">[ 点击这里返回首页]</a></p>
		</div>
		<!--公共底部开始-->
		 <%@include file="../../../common/footer.jsp"%>
		<!--公共底部结束-->
	</div>
 </body>
</html>