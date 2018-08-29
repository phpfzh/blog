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
    <link href="${basePath }/static/css/index.css" rel="stylesheet" type="text/css">
    <%@include file="../../common/public.jsp" %>
    <script type="text/javascript">
        $(function(){
            //轮播图
            layui.use('carousel', function () {
                var carousel = layui.carousel;
                //建造实例
                carousel.render({
                    elem: '#carousel_cjm',
                    arrow: 'hover', //始终显示箭头
                    width: 680,
                    height: 360
                });
            });
        })
        function queryAllPerson(Num, pageSize) {
           window.location.href = basePath+"/index?pageNum="+Num+"&pageSize="+pageSize;
        }
    </script>
</head>
<body>
 <%@include file="../../common/header.jsp" %>
<!--内容开始-->
<div id="content">
    <!--轮播图盒子 开始-->
    <div id="carousel_box">
        <div class="layui-carousel" id="carousel_cjm">
            <div carousel-item>
                <div class="img_box">
                    <a href="#">
                        <img src="${basePath}/static/images/1.jpg">
                        <span class="title">表藤太拖拖拖拖</span>
                    </a>
                </div>
                <div class="img_box">
                    <a href="#">
                        <img src="${basePath}/static/images/2.jpg">
                        <span class="title">表藤太拖拖拖拖22</span>
                    </a>
                </div>
                <div class="img_box">
                    <a href="#">
                        <img src="${basePath}/static/images/3.jpg">
                        <span class="title">表藤太拖拖拖拖33</span>
                    </a>
                </div>
                <div class="img_box">
                    <a href="#">
                        <img src="${basePath}/static/images/4.jpg">
                        <span class="title">表藤太拖拖拖拖4</span>
                    </a>
                </div>
                <div class="img_box">
                    <a href="#">
                        <img src="${basePath}/static/images/5.jpg">
                        <span class="title">表藤太拖拖拖拖5</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="hotnew">
            <!--like_site start-->
            <div class="hotnew_site">
                <h3>常用站点</h3>
                <span class="all">
                      <a href="javascript:void(0)" target="_blank">
                         更多
                      </a>
                </span>
                <span class="mark"></span>
                <div class="box">
                    <ul>
                        <c:forEach var="linkVos" items="${linkVos}">
                              <li>
                                <a href="${linkVos.link}" target="_blank">${linkVos.name}</a>
                            </li>
                        </c:forEach>
                     </ul>
                </div>
            </div>
            <!--like_site end-->
        </div>
    </div>
    <!--轮播图盒子 结束-->

    <!--文章盒子 开始-->
    <div id="article_box">
        <!--文章列表 开始-->
        <div class="article">
            <c:forEach var="item" items="${voLists}">
                <!--item_box start-->
                <div class="item_box">
                    <div class="i_img">
                        <c:choose>
                            <c:when test="${not empty item.staticlink and item.staticlink.length() > 5}">
                                <a href="${basePath}/${item.staticlink}" target="_blank">
                                    <img src="${item.coverimg}"/>
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a href="${basePath}/article/${item.id}" target="_blank">
                                    <img src="${item.coverimg}"/>
                                </a>
                            </c:otherwise>
                        </c:choose>
                     </div>
                    <div class="i_content">
                        <h2>
                            <c:choose>
                                <c:when test="${not empty item.staticlink and item.staticlink.length() > 5}">
                                    <a href="${basePath}/${item.staticlink}" target="_blank">
                                            ${item.subject}
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="${basePath}/article/${item.id}" target="_blank">
                                            ${item.subject}
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </h2>
                        <div class="user_item">
                            <div class="user_info">
                                <div class="user_img">
                                    <a href="javascript:void(0)" target="_blank">
                                        <img src="${item.headurl}">
                                    </a>
                                </div>
                                <a href="javascript:void(0)" target="_blank">
                                    <span class="author-name">${item.username}</span>
                                </a>
                                <span class="datetime">${item.datelinestr}</span>
                                <i class="glyphicon glyphicon-eye-open"></i>
                                <em>${item.views}</em>
                                <i class="glyphicon glyphicon-comment"></i>
                                <em>${item.replies}</em>
                            </div>
                        </div>
                        <div class="tags">
                            <ul>
                                <c:forEach items="${item.listtags}" var="tag">
                                    <li>
                                        <a href="#">${tag.name}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                            <div class="forum">
                                <a href="javascript:void(0)" target="_blank">
                                        ${item.fname}
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <!--item_box end-->
            </c:forEach>
            <%@include file="../../common/pagehelper.jsp" %>
        </div>
        <!--文章列表 结束-->

        <!--文章右边盒子 开始-->
        <div class="article_right">
            <!--点击排行 开始-->
            <div class="r_box hot_article">
                <h3>点击排行</h3>
                <span class="all">
          <a href="javascript:void(0)" target="_blank">
             更多
          </a>
      </span>
                <span class="mark"></span>
                <div class="box">
                    <ul>
                        <c:forEach var="hotVoLists" items="${hotVoLists}" varStatus="index">
                             <li>
                                 <c:choose>
                                     <c:when test="${not empty hotVoLists.staticlink and hotVoLists.staticlink.length() > 5}">
                                         <a href="${basePath}/${hotVoLists.staticlink}" target="_blank">
                                             <c:choose>
                                                 <c:when test="${index.index == 0}">
                                                     <span class="one">${index.index+1}</span>
                                                 </c:when>
                                                 <c:when test="${index.index == 1}">
                                                     <span class="two">${index.index+1}</span>
                                                 </c:when>
                                                 <c:when test="${index.index == 2}">
                                                     <span class="three">${index.index+1}</span>
                                                 </c:when>
                                                 <c:otherwise>
                                                     <span>${index.index+1}</span>
                                                 </c:otherwise>
                                             </c:choose>
                                                 ${hotVoLists.subject}
                                         </a>
                                     </c:when>
                                     <c:otherwise>
                                         <a href="${basePath}/article/${hotVoLists.id}" target="_blank">
                                             <c:choose>
                                                 <c:when test="${index.index == 0}">
                                                     <span class="one">${index.index+1}</span>
                                                 </c:when>
                                                 <c:when test="${index.index == 1}">
                                                     <span class="two">${index.index+1}</span>
                                                 </c:when>
                                                 <c:when test="${index.index == 2}">
                                                     <span class="three">${index.index+1}</span>
                                                 </c:when>
                                                 <c:otherwise>
                                                     <span>${index.index+1}</span>
                                                 </c:otherwise>
                                             </c:choose>
                                                 ${hotVoLists.subject}
                                         </a>
                                     </c:otherwise>
                                 </c:choose>
                             </li>
                        </c:forEach>
                     </ul>
                </div>
            </div>
            <!--点击排行 结束-->

            <!--友情链接 开始-->
            <div class="r_box friendly_link">
                <h3>友情链接</h3>
                <span class="all">
                  <a href="javascript:void(0)" target="_blank">
                     更多
                  </a>
                </span>
                <span class="mark"></span>
                <div class="box">
                    <ul>
                        <c:forEach var="friendlinkVos" items="${friendlinkVos}">
                            <li>
                                <a href="${friendlinkVos.link}" target="_blank">${friendlinkVos.name}</a>
                            </li>
                        </c:forEach>
                      </ul>
                </div>
            </div>
            <!--友情链接 结束-->

        </div>
        <!--文章右边盒子 结束-->
    </div>
    <!--文章盒子 结束-->
</div>
<!--内容结束-->


 <!--尾部开始-->
<div id="footer">


</div>
<!--尾部结束-->
</body>
</html>
