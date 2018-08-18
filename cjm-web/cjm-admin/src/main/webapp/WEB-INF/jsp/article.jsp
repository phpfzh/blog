<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../common/taglib.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>陈嘉明个人博客-分享web前端和Java技术的个人博客网站</title>
    <meta name="keywords" content="陈嘉明,陈嘉明个人博客,个人博客,个人博客网站">
    <meta name="description" content="陈嘉明个人博客，分享web前端技术和Java技术的个人博客网站">
    <meta http-equiv="Cache-Control" content="no-transform ">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <meta http-equiv="Window-target" content="_top">
    <link href="${basePath }/static/css/article.css" rel="stylesheet" type="text/css">
    <%@include file="../../common/public.jsp" %>
</head>
<body>
<%@include file="../../common/header.jsp"%>

<!--内容开始-->
<div id="article">
    <div id="article_box">
        <div class="article_left">
            <div class="l_tag">
                <ul>
                    <li>
                        <a href="javascript:void(0)">
                            <i class="icon iconfont icon-weixin"></i>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <i class="icon iconfont icon-qq"></i>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <i class="icon iconfont icon-xinlang"></i>
                        </a>
                    </li>

                    <li style="margin-top:35px;">
                        <a href="javascript:void(0)">
                            <i class="icon iconfont icon-xiaoxi"></i>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <i class="icon iconfont icon-shoucang"></i>
                        </a>
                    </li>

                    <li>
                        <a href="javascript:void(0)">
                            <i class="icon iconfont icon-edit"></i>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <i class="icon iconfont icon-shanchu"></i>
                        </a>
                    </li>
                </ul>
            </div>
            <!--l_content start-->
            <div class="l_content">
                <div class="l_content_header">
                    <h1 class="header_subject">
                        ${en.subject}
                    </h1>
                    <div class="header_author">
                        <div class="header_link_box">
                            <span class="article_time">${en.dateline}</span>
                            <span class="article_view">浏览&nbsp;${en.views}</span>
                            <span class="article_com">评论&nbsp;${en.replies}</span>
                            <a href="javascript:void(0)" class="article_link">${en.fname}</a>
                        </div>
                    </div>

                    <div class="tags">
                        <div class="tags_icon">
                            <i class="icon iconfont icon-label"></i>
                            <span>标签</span>
                        </div>
                        <ul>
                            <c:forEach items="${en.listtags}" var="listtags">
                                <li>
                                    <a href="#">
                                        ${listtags.name}
                                    </a>
                                </li>
                             </c:forEach>
                          </ul>
                    </div>
                </div>
                <div class="l_content_img">
                    <img src=${en.coverimg}>
                </div>
                <div class="l_content_con">
                    ${en.content}
                </div>
            </div>
            <!--l_content end-->
        </div>

        <div class="article_right">
            <!-- 作者信息 开始 -->
            <div class="author_info">
                <div class="author_img">
                    <a href="javascript:void(0)" target="_blank">
                        <img src="${en.headurl}">
                    </a>
                </div>
                <div class="auhtor_username">
                    <a href="javascript:void(0)" target="_blank">
                        ${en.username}
                    </a>
                </div>
                <div class="author-one">你今天必须做别人不愿做的事，好让你明天可以拥有别人不能拥有的东西</div>
                <div class="author-one"></div>
                <div class="author-article-box">
                    <ul>
                        <li>
                            <a href="javascript:void(0)" target="_blank">${en.count}篇文章</a>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- 作者信息 结束 -->

            <!--热门标签 开始 -->
            <div class="hot_tag">
                <h3>热门标签</h3>
                <span class="tag_all">
                        <a href="javascript:void(0)" target="_blank">
                           全部
                        </a>
                    </span>
                <span class="mark"></span>
                <div class="tag_box">
                    <ul>
                        <li>
                            <a href="javascript:void(0)" target="_blank">SpringBoot</a>
                        </li>
                        <li>
                            <a href="javascript:void(0)" target="_blank">SpringMvc</a>
                        </li>
                        <li>
                            <a href="javascript:void(0)" target="_blank">JAVA8</a>
                        </li>
                        <li>
                            <a href="javascript:void(0)" target="_blank">vue</a>
                        </li>
                        <li>
                            <a href="javascript:void(0)" target="_blank">SpringB</a>
                        </li>
                        <li>
                            <a href="javascript:void(0)" target="_blank">SpringM</a>
                        </li>
                        <li>
                            <a href="javascript:void(0)" target="_blank">JAVA8</a>
                        </li>
                        <li>
                            <a href="javascript:void(0)" target="_blank">vue</a>
                        </li>
                        <li>
                            <a href="javascript:void(0)" target="_blank">vue</a>
                        </li>
                        <li>
                            <a href="javascript:void(0)" target="_blank">vue</a>
                        </li>
                    </ul>
                </div>
            </div>
            <!--热门标签 结束 -->

        </div>
    </div>
</div>
<!--内容结束-->


<!--尾部开始-->
<div id="footer">


</div>
<!--尾部结束-->
</body>
</html>
