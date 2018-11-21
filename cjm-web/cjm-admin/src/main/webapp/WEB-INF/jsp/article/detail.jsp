<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="../../../common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>${en.subject}-陈嘉明个人博客-分享web前端和Java技术的个人博客网站</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="陈嘉明个人博客,陈嘉明,个人博客,个人博客网站">
<meta name="description" content="陈嘉明个人博客，分享web前端技术和Java技术的个人博客网站">
<link href="${basePath}/static/css/thread_detail.css" rel="stylesheet" type="text/css">
<%@include file="../../../common/public.jsp"%>
<script type="text/javascript">
	$(function(){
		var obj = $(".navs").find("ul li a");
		$(obj).removeClass('active').eq(1).addClass("active");
	})
	
	//分页
	function getData(pageNum,pageSize){
		var opid = $("#wdb_id").data("opid");
		var action = basePath+"/article-"+opid+"-"+pageNum+"-1.html";
		$("#cjmform").attr("action",action);
  		$("#pageNum").val(pageNum);
 		$("#pageSize").val(pageSize);
 		$("#cjmform").submit();
	}
	
 </script>
  <style type="text/css">
 	.wdb_zoom{
 		max-width:650px;
 	}
 	.zoom{
 		max-width:750px;
 	}
 	.pt_title a:hover{
 		color:#000;
 	}
 </style>
</head>
<body>
<!-- 公共头部开始 -->
<%@include file="../../../common/header.jsp"%>
<!-- 公共头部结束 -->
<input type="hidden" id="wdb_id" data-opid="${en.id }">
<input type="hidden" id="wdb_subject" data-subject="${en.subject }">
<input type="hidden" id="wdb_baseid" data-baseid="${en.baseid }">
 
<form id="cjmform" action="${basePath}/article-156321-1-1.html" method="post">
 <input type="hidden" name="pageNum" id="pageNum">
 <input type="hidden" name="pageSize" id="pageSize">
</form>
 		
<!--内容盒子开始-->
<div class="bus">
	<div class="main">
		<div class="container">
				<p class="pt_title">
					<a href="${basePath}">&nbsp;首页&nbsp;></a> <a href="${basePath}/articlelist-${en.fid }-1.html">${en.fname }&nbsp;></a><a href="">&nbsp;${en.subject }</a>
				</p>
				<%-- <div class="ap_advert advertisement">
					<img src="${basePath}/static/images/thread/gg_a.png">
					<span class="ggtext">广告</span>
				</div> --%>
			</div>
		</div>
		<!-- 平台内容 -->
		<div class="bus_content">
			<div class="container">
				<!-- 平台左内容 -->
				<!-- <div class="bus_condition fl">
					<div class="notice">
						<a>管理员公告：</a>公告。
					</div>
				</div> -->
				<div class="bus_condition fl">
						<div class="bus_allnotice">
							<!-- <a href="#" class="wyft_button">我要发帖</a> -->
						<div class="allnotice_title">
							<h3>
								${en.subject}
							</h3>
						</div>
						<div class="bus_icon">
							<ul>
								<!-- <li>
									<img src="${basePath}/static/images/thread/gf.png">
									<span>官方</span>
								</li> -->
								<li>
									<img src="${basePath}/static/images/thread/nz.png">
									<span>${en.datelinestr}</span>
								</li>
								<li>
									<img src="${basePath}/static/images/thread/ye.png">
									<span>${en.views}</span>
								</li>
								<li>
									<img src="${basePath}/static/images/thread/dx.png">
									<span>${en.replies}</span>
								</li>
								<div class="clear"></div>
							</ul>
						</div>

						<div class="allnotice_content">
						 	<p>
						 		${en.content}
						 	</p>
						</div>
					</div>
					<div class="bus_reply">
						<div class="reply_left fl">
							<img src="${basePath}/static/images/thread/hf1.png">
							<span>回复</span>
						</div>
						<div class="reply_left fr">
							<img src="${basePath}/static/images/thread/jb.png">
							<span>举报</span>
						</div>
						<div class="clear"></div>
					</div>
					
				 
				</div>
				<!-- 平台左内容  结束-->

				<!-- 平台右内容 开始-->
				<div class="plat_rewards fr">
					<!-- 作者信息 开始 -->
					<div class="author_info">
						<div class="author_img">
							<a href="javascript:void(0)" target="_blank">
								<img src="./static/images/logo.png">
							</a>
						</div>
						<div class="auhtor_username">
							<a href="javascript:void(0)" target="_blank">
								${en.username }
							</a>
						</div>
						<div class="author-one">你今天必须做别人不愿做的事，好让你明天可以拥有别人不能拥有的东西</div>
						<div class="author-one"></div>
						<div class="author-article-box">
							<ul>
								<li>
									<a href="javascript:void(0)" target="_blank">${en.count }篇文章</a>
								</li>
							</ul>
						</div>
					</div>
					<!-- 作者信息 结束 -->
					 
					<!-- 广告模块 开始-->
					<!-- <div class="millde_pic">
						<div class="advertisement">
							<img src="./static/images/thread/sq.png">
							<span class="ggtext">广告</span>
						</div>
						<div class="advertisement">
							<img src="./static/images/thread/zu.png">
							<span class="ggtext">广告</span>
						</div>
					</div> -->
					<!-- 广告模块 结束-->


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
								 <li>
									 <a href="#" target="_blank" class="tviewClick"  >
											 <span class="one">1</span>
											 fdfgdg的梵蒂冈的股份的股份的股份给股份的股份
									 </a>
								 </li>
								  <li>
										 <a href="#" target="_blank" class="tviewClick"  >
 													 <span class="two">2</span>
 												 fdfgdg的梵蒂冈的股份的股份的股份给股份的股份
										 </a>
								 </li>
								  <li>
										 <a href="#" target="_blank" class="tviewClick"  >
 													 <span class="three">3</span>
												 fdfgdg的梵蒂冈的股份的股份的股份给股份的股份
										 </a>
								 </li>
								  <li>
										 <a href="#" target="_blank" class="tviewClick"  >
													 <span>4</span>
												 fdfgdg的梵蒂冈的股份的股份的股份给股份的股份
										 </a>
								 </li>
								  <li>
										 <a href="#" target="_blank" class="tviewClick"  >
													 <span>5</span>
												 fdfgdg的梵蒂冈的股份的股份的股份给股份的股份
										 </a>
								 </li>
								  <li>
										 <a href="#" target="_blank" class="tviewClick"  >
													 <span>6</span>
												 fdfgdg的梵蒂冈的股份的股份的股份给股份的股份
										 </a>
								 </li>
 							 </ul>
						</div>
					</div>
					<!--点击排行 结束-->

  				</div>
				<!-- 平台右内容 结束-->
				<div class="clear"></div>
			</div>
		</div>
</div>
<!--内容盒子结束-->

<!--公共底部开始-->
<%@include file="../../../common/footer.jsp"%>
<!--公共底部结束-->
    
</body>
</html>