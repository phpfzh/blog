<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>陈嘉明个人博客-分享web前端和Java技术的个人博客网站</title>
    <meta name="keywords" content="陈嘉明,陈嘉明个人博客,个人博客,个人博客网站">
    <meta name="description" content="陈嘉明个人博客，分享web前端技术和Java技术的个人博客网站">
    <meta http-equiv="Cache-Control" content="no-transform ">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <meta http-equiv="Window-target" content="_top">
    <link href="${basePath }/static/css/index.css" rel="stylesheet" type="text/css">
    <%@include file="/common/public.jsp" %>
 </head>
<body>
  <form id="indexSubmit" action="${basePath}" method="post">
        <input name="pageNum" id="indexPageNum" style="display: none"/>
        <input name="pageSize" id="indexPageSize" style="display: none"/>
  </form>

 <%@include file="/common/header.jsp" %>

 <!--尾部开始-->
<div id="footer">


</div>
<!--尾部结束-->
</body>
</html>
