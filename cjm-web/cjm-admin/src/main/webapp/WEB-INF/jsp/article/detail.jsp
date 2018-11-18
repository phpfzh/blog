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
							<a href="#" class="wyft_button">我要发帖</a>
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
					<!-- 全部回复 -->
					<div class="bus_allreply">
						<div class="allreply">
							全部回复（999）
							
							<div class="clear"></div>
						</div>
						<div id="bus_allreply_box">
							<!-- 回复模块 -->
							<div class="leave_message">

								<div class="leave_top">
									<div class="top_img fl">
										<img src="${basePath}/static/images/thread/mn1.png">
									</div>
									<div class="top_js fl">
										<h3>真相大白A888</h3>
										<span>一首渠道，保证高价。群主全天在线，24小时人性化服务，重在投资交流适当退单，更多福利尽在588654424.</span>
										<p>真相只有一个：用李彦宏小三的谣言和公关带来的热点，压下去百度医疗竞价排名重新上线的负面分 析了这么多，感觉很可笑，人家根本不在意输赢，用在带新节奏压负面上，这才是高。
										</p>
									</div>
									<div class="clear"></div>
								</div>


								<div class="leave_reply">
										<div class="re_autoly">
											<h3>栎子江2333</h3>
											<p>惊呆了！竟然是这样子的？！</p>
											<div class="bot_all">
												<div class="bot_reply fr reply3">
													<span>回复TA</span>
												</div>
												<div class="bot_report fr">
													<a href="">举报 &nbsp;|&nbsp; 2018-07-25 05:58&nbsp;&nbsp;1楼</a>
												</div>
												<div class="clear"></div>
											</div>
											<div class="leave_new open3" style="display:none;">
												<div class="bus_example">
													<div class="textarea" contenteditable="true"></div>
													<div class="re_all">
														<a href="javascript:;" class="point">发布</a>
														<a href="javascript:;" class="smille"></a>
													<div class="clear"></div>
													</div>
												</div>
												<div class="faceone w500"></div>
											</div>
										</div>
									   <div class="re_autoly">
											<h3>咪子酱V5566<span>回复</span>栎子江2333</h3>
											<p>惊呆了！竟然是这样子的？！惊呆了！竟然是这样子的？！惊呆了！竟然是这样子的？！惊呆了！ 竟然是这样子的？！惊呆了！竟然是这样子的？！
											</p>
											<div class="bot_all">
												<div class="bot_reply reply4 fr">
													<span>回复TA</span>
												</div>
												<div class="bot_report fr">
													<a href="">举报 &nbsp;|&nbsp; 2018-07-25 05:58&nbsp;&nbsp;1楼</a>
												</div>
												<div class="clear"></div>
											</div>
											 <div class="leave_new open4" style="display:none;">
												<div class="bus_example">
													<div class="textarea" contenteditable="true"></div>
													<div class="re_all">
														<a href="javascript:;" class="point">发布</a>
														<a href="javascript:;" class="smille"></a>
													<div class="clear"></div>
													</div>
												</div>
												<div class="faceone w500"></div>
											</div>
									   </div>
								</div>



								<div class="leave_bot">
									<div class="bot_reply fl" id="reply1">
										<!--<a href="#">-->
										<span>回复</span>
										<!--</a>-->
									</div>
									<div class="bot_report fl">
										<a href="">举报 &nbsp;|&nbsp; 2018-07-25 05:58&nbsp;&nbsp;1楼</a>
									</div>
									<div class="clear"></div>
								</div>
								<div class="leave_zudi" id="open1" style="display:none;">
									<div class="bus_example w500">
										<div class="textarea" contenteditable="true"></div>
										<a href="javascript:;" class="point">发布</a>
										<a href="javascript:;" class='smille'></a>
									</div>
									<div class="faceone w500"></div>
								</div>

								<div class="clear"></div>
							</div>

							<!--回复模块二-->
							<div class="leave_message">
								<div class="leave_top">
									<div class="top_img fl">
										<img src="${basePath}/static/images/thread/mv2.png">
									</div>
									<div class="top_js fl">
										<h3>真相大白A888</h3>
										<span>一首渠道，保证高价。群主全天在线，24小时人性化服务，重在投资交流适当退单，更多福利尽在588654424.</span>
										<p>真相只有一个：用李彦宏小三的谣言和公关带来的热点，压下去百度医疗竞价排名重新上线的负面分 析了这么多，感觉很可笑，人家根本不在意输赢，用在带新节奏压负面上，这才是高。
										</p>
									</div>
									<div class="clear"></div>
								</div>
								<div class="leave_bot">
									<div class="bot_reply fl" id="reply2">
										<span>回复</span>
									</div>
									<div class="bot_report fl">
										<a href="">举报 &nbsp;|&nbsp; 2018-07-25 05:58&nbsp;&nbsp;2楼</a>
									</div>
									<div class="clear"></div>
								</div>
								<div class="leave_zudi" id="open2" style="display:none;">

									<div class="bus_example clear">
									   <div class="textarea" contenteditable="true"></div>
										<a href="javascript:;" class="point">发布</a>
										<a href="javascript:;" class="smille"></a>
									</div>
									<div class="faceone w500"></div>
								</div>
								<div class="clear"></div>
							</div>
						</div>
					</div>
					<!-- 页码 -->
					<div class="page">
						<a href="#" class="sy">首页</a>
						<a href="#">1</a>
						<a href="#">2</a>
						<a href="#" class="act_on">3</a>
						<a href="#">4</a>
						<a href="#">...</a>
						<a href="#">10</a>
						<a href="#" class="wy">下一页</a>
					</div>
					<!-- 参与讨论 -->
 
					<div class="bus_discussions">
						<h3>参与讨论</h3>
						<!--<textarea name="content" class="tlk" placeholder="请登录后参与评论……"></textarea>-->
						<div class="send w500">
							<div class="textarea" contenteditable="true"></div>
							<a href="javascript:;" class="btn">发布</a>
							<a href="javascript:;" class='faces'></a>
							<a href="javascript:;" class='faces_img'></a>
							<input class="upload" name="file" accept="image/*" type="file" style="display: none;">
						</div>
						<div class="face w500"></div>
						<script>
							//上传图片js
							$(function () {
								$(".faces_img").click(function () {
									$(this).parent().find(".upload").click(); //隐藏了input:file样式后，点击头像就可以本地上传

									$(this).parent().find(".upload").on("change", function () {
										var objUrl = getObjectURL(this.files[0]); //获取图片的路径，该路径不是图片在本地的路径
										if (objUrl) {
											$(this).parent().find(".faces_img").attr("src",
												objUrl); //将图片路径存入src中，显示出图片
											$(this).parent().find(".send textarea").attr(
												"src",
												objUrl);
										}
									});
								});
							});

							function getObjectURL(file) {
								var url = null;
								if (window.createObjectURL != undefined) { // basic
									url = window.createObjectURL(file);
								} else if (window.URL != undefined) { // mozilla(firefox)
									url = window.URL.createObjectURL(file);
								} else if (window.webkitURL != undefined) { // webkit or chrome
									url = window.webkitURL.createObjectURL(file);
								}
								return url;
							}
						</script>
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