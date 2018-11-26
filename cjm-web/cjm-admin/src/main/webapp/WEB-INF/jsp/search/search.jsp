<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>搜索页面-陈嘉明个人博客-分享web前端和Java技术的个人博客网站</title>
    <meta name="keywords" content="陈嘉明个人博客,陈嘉明,个人博客,个人博客网站">
    <meta name="description" content="陈嘉明个人博客，分享web前端技术和Java技术的个人博客网站">
    <meta http-equiv="Cache-Control" content="no-transform ">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <meta http-equiv="Window-target" content="_top">
    <%@include file="/common/public.jsp" %>
    <link href="${basePath }/static/css/search.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${basePath}/static/js/second_weeks.js"></script>
    <script type="text/javascript" src="${basePath}/static/js/last_week.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".cheat_back_page .cheat_back_each").hide().eq(0).show();
            $(".label_cheat_back h4").removeClass("on").eq(0).addClass("on");
            var indexVal = $("#indexNum").val();
            if(!isEmpty(indexVal)){
                $(".cheat_back_page .cheat_back_each").hide().eq(indexVal).show();
                $(".label_cheat_back h4").removeClass("on").eq(indexVal).addClass("on");
            }
        })


        function searchSubmit(obj){
            $("#subject").val(getSubjectData());
            $("#searchSubmit").submit();
        }

        function getThreadData(pageNumThread,pageSizeThread){
            $("#subject").val(getSubjectData());
            $("#pageNumThread").val(pageNumThread);
            $("#pageSizeThread").val(pageSizeThread);
            $("#indexNum").val(1);
            $("#searchSubmit").submit();
        }

        function getArticleData(pageNumArticle,pageSizeArticle){
            $("#subject").val(getSubjectData());
            $("#pageNumArticle").val(pageNumArticle);
            $("#pageSizeArticle").val(pageSizeArticle);
            $("#indexNum").val(2);
            $("#searchSubmit").submit();
        }

        function getSubjectData(){
            var subject = $("#subjectInp").val();
            return subject;
        }

    </script>
 </head>
<body>
  <form id="searchSubmit" action="${basePath}/search/list" method="post">
      <input type="hidden" name="subject" id="subject" value="${vo.subject }"/>
      <input type="hidden" name="pageNumThread" id="pageNumThread" />
      <input type="hidden" name="pageSizeThread" id="pageSizeThread" />
      <input type="hidden" name="pageNumArticle" id="pageNumArticle" />
      <input type="hidden" name="pageSizeArticle" id="pageSizeArticle" />
      <input type="hidden" name="indexNum" id="indexNum" value="${vo.indexNum }"/>
  </form>

  <div class="centen search_html">
      <!--搜索头部开始-->
      <div class="tou">
          <div class="nav">
              <!-- <div class="tobox"> -->
              <div class="float_l" style="margin-left: -90px;">
                  <a href="${basePath }"><img src="${basePath}/static/images/logo.png" width="120" height="80" /> </a>
              </div>
              <div class="float_l search_button">
                  <input class="float_l" type="text" id="subjectInp" value="${vo.subject }"/>
                  <a href="javascript:void(0)" class="float_l a_button" onclick="searchSubmit(this)">搜一下</a>
                  <div class="clear"></div>
                  <div class="label_cheat_back">
                      <h4 class="float_l">帖子</h4>
<%--
                      <h4 class="float_l">资讯</h4>
--%>
                      <div class="clear"></div>
                  </div>
              </div>
              <div class="clear"></div>
          </div>

      </div>
      <!--搜索头部结束-->

      <!--搜索页面内容-->
      <div class="search_label">
          <div class="cheat_back_page">
              <!-- 主题 开始 -->
              <div class="cheat_back_each post">
                  <div class="post">
                      <c:if test="${empty threadvos}">很抱歉，没有搜到和 “ ${vo.subject} ” 相关的结果。</c:if>
                      <c:forEach items="${threadvos}" var="threadvos">
                          <div class="each">
                               <a href="${basePath}/article-${threadvos.id}-1-1.html" target="_blank">
                                   <h3>【<span>${vo.subject}</span>】${threadvos.subject }</h3>
                               </a>
                               <p>${threadvos.replies }个回复 - ${threadvos.views} 次查看</p>
                              <p>${threadvos.datelinestr } - <span>${threadvos.username}</span> - <span>${threadvos.fname}</span></p>
                          </div>
                      </c:forEach>
                  </div>
                  <c:if test="${threadpagehelper.total > 10}">
                      <div class="paging">
                          <ul>
                              <%@include file="/WEB-INF/jsp/search/threadpagehelper.jsp"%>
                          </ul>
                      </div>
                  </c:if>

              </div>
              <!-- 主题 结束 -->

              <!-- 资讯开始 -->
              <div class="cheat_back_each information" style="display: none;">
                  该板块正在开发中
                   <%--<div class="information">
                       <c:forEach var="articlevos" items="${threadvos }">
                       <div class="each">
                           <a href="${basePath}/article-${articlevos.id }-1-1.html">
                               <h3>的范德萨发的广泛地</h3>
                               <div class="information_img">
                                       <img class="float_l" src="http://localhost:8080/static/images/1.jpg" width="207" height="120">
                                       <div class="float_l p">
                                           <p>近日，深圳不少网贷平台的转让公告在朋友圈“疯转”，内容从平台注册资金
                                               到具体累积的投资人数量，再到“带团队一起转让”等信息非常详细。可见
                                               ，随着网贷行业监管的不断深入，不少平台已经扛不住了，迫切希望能及时 ...</p>
                                           <p>20180506</p>
                                       </div>
                               </a>
                               <div class="clear"></div>
                           </div>
                        </div>
                   </c:forEach>
               </div>--%>
               <c:if test="${articlepagehelper.total > 10}">
                   <div class="paging">
                       <ul>
                           <%@include file="/WEB-INF/jsp/search/articlepagehelper.jsp"%>
                       </ul>
                   </div>
               </c:if>
               <div class=""></div>
          </div>
          <!-- 资讯结束 -->

       </div>
  </div>
  </div>
  <%@include file="/common/footer.jsp" %>
</body>
</html>
