<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/cjm.tld" prefix="cjm"%>
<cjm:getHotArticle hotArticleVar="hotVoLists" />
<!DOCTYPE html>
<html>
<head>
<title>主题列表页-陈嘉明个人博客-分享web前端和Java技术的个人博客网站</title>
<meta name="keywords" content="陈嘉明,陈嘉明个人博客,个人博客,个人博客网站">
<meta name="description" content="陈嘉明个人博客，分享web前端技术和Java技术的个人博客网站">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/public.jsp"%>
<link href="${basePath}/static/css/thread.css" rel="stylesheet" type="text/css">
 </head>
  <script type="text/javascript">
         function queryAllPerson(Num, pageSize) {
        	var fid = $("#listSubmit_fid").val();
        	var url = basePath+"/articlelist-"+fid+"-"+Num+".html";
        	$("#listSubmit").attr("action",url);
            $("#listSubmit").submit();
        }
     </script>
<body>
<form id="listSubmit" action="${basePath}" method="post">
       <input name="fid" id="listSubmit_fid" value="${vo.fid}" style="display: none"/>
 </form>

<%@include file="/common/header.jsp" %>
    
<!--内容开始-->
<div id="content">
     <!--文章盒子 开始-->
    <div id="article_box">
        <!--文章列表 开始-->
        <div class="article">
             <c:forEach items="${vos }" var="vos">
             		<!--item_box start-->
		            <div class="item_box">
		                <div class="i_content">
		                    <h2>
		                        <a href="${basePath}/article-${vos.id}-1-1.html" target="_blank">${vos.subject }</a>
		                    </h2>
		                    <div class="user_item">
		                        <div class="user_info">
		                            <div class="user_img">
		                                <a href="javascript:void(0)" target="_blank">
		                                    <img src="${vos.headurl }">
		                                </a>
		                            </div>
		                            <a href="javascript:void(0)" target="_blank">
		                                <span class="author-name">${vos.username }</span>
		                            </a>
		                            <span class="datetime">发布时间：${vos.datelinestr }</span>
		                            <i class="glyphicon glyphicon-eye-open"></i>
		                            <em>${vos.views }</em>
		                            <i class="glyphicon glyphicon-comment"></i>
		                            <em>${vos.replies}</em>
		                        </div>
		                    </div>
		                    <div class="tags">
		                        <ul>
		                        	<c:forEach items="${vos.listtags}" var="listtags">
 			                            <li>
			                                <a href="javascript:void(0)" target="_blank">${listtags.name }</a>
			                            </li>
		                        	</c:forEach>
 		                        </ul>
		                        <div class="forum">
		                            <a href="${basePath}/articlelist-${vos.fid}-1.html" target="_blank">
		                                ${vos.fname}
		                            </a>
		                        </div>
		                    </div>
		                </div>
		            </div>
		            <!--item_box end-->
             </c:forEach>
              <%@include file="/common/pagehelper.jsp" %>
         </div>
        <!--文章列表 结束-->

        <!--文章右边盒子 开始-->
        <div class="article_right">
            <!--点击排行 开始-->
            <div class="r_box hot_article">
                <h3>点击排行</h3>
                <span class="all">
        <!--   <a href="javascript:void(0)" target="_blank">
             更多 >
          </a> -->
      </span>
                <span class="mark"></span>
                <div class="box">
                    <ul>
                         <c:forEach var="hotVoLists" items="${hotVoLists}" varStatus="index">
                             <li> 
                                    <a href="${basePath}/article-${hotVoLists.id}-1-1.html" target="_blank">
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
                              </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <!--点击排行 结束-->

            <!--个人链接 开始-->
            <div class="r_box friendly_link">
                <h3>个人链接</h3>
                <span class="all">
                  <!--<a href="javascript:void(0)" target="_blank">
                     更多
                  </a>-->
                </span>
                <span class="mark"></span>
                <div class="box">
                    <ul>
                      	<li>
							<span>CSDN博客 : </span>
                            <a href="https://blog.csdn.net/phpfzh" target="_blank">
								 phpfzh
							</a>
                         </li>
                    </ul>
                </div>
            </div>
            <!--个人链接 结束-->

        </div>
        <!--文章右边盒子 结束-->
    </div>
    <!--<div id="pageTtest1">32323</div>-->
    <!--文章盒子 结束-->
</div>
<!--内容结束-->

<!--公共底部开始-->
 <%@include file="/common/footer.jsp"%>
<!--公共底部结束-->
 </body>
</html>