<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="../../../common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/cjm.tld" prefix="cjm"%>
<cjm:getHotArticle hotArticleVar="hotVoLists" />
<!DOCTYPE html>
<html>
<head>
<title>${en.subject}-陈嘉明个人博客-分享web前端和Java技术的个人博客网站</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="陈嘉明个人博客,陈嘉明,个人博客,个人博客网站">
<meta name="description" content="陈嘉明个人博客，分享web前端技术和Java技术的个人博客网站">
<link href="${basePath}/static/css/thread_detail.css" rel="stylesheet" type="text/css">
<%@include file="../../../common/public.jsp"%>
<style type="text/css">
	 .allnotice_content img{
            max-width: 100%;
        }
      #bus_allreply_box img{
            max-width: 100%;
        }
</style>
<script type="text/javascript" src="${basePath}/static/js/thread.js"></script>

<script type="text/javascript">
	$(function(){
		var obj = $(".navs").find("ul li a");
		$(obj).removeClass('active').eq(1).addClass("active");
	})
	
	//分页
	function queryAllPerson(pageNum,pageSize){
		var opid = $("#pil_id").data("opid");
		var action = basePath+"/article-"+opid+"-"+pageNum+"-1.html";
		$("#cjmform").attr("action",action);
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
<input type="hidden" id="pil_id" data-opid="${en.id }">
<input type="hidden" id="pil_subject" data-subject="${en.subject }">
<input type="hidden" id="pil_baseid" data-baseid="${en.baseid }">
 
<form id="cjmform" action="${basePath}/article-156321-1-1.html" method="post">
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
					<!-- 回复Box start -->
					<!-- 全部回复 -->
					<div class="bus_allreply">
						<div class="allreply">
							全部回复（${total}）
 							<div class="clear"></div>
						</div>
						<div id="bus_allreply_box">
							 <c:forEach items="${replyVos}" var="replyVos">
								<!-- 回复模块 -->
								<div class="leave_message" id="pil_leave_message_box_${replyVos.id}">
	 								<div class="leave_top">
										<div class="top_img fl">
											<img src="${replyVos.headurl }"  width="60" height="60">
										</div>
										<div class="top_js fl">
											<h3>${replyVos.username }</h3>
											<span>${replyVos.signature }</span>
											<p style="widht:100%;height:100%;word-wrap: break-word">
												${replyVos.message }
											</p>
										</div>
										<div class="clear"></div>
									</div>
	
									<!-- 多次回复盒子 start -->
									<div class="leave_reply" id="pil_child_leave_message_box_${replyVos.id}">
										<c:forEach var="childs" items="${replyVos.childs}">
                                         	<c:choose>
                                            	<c:when test="${childs.first eq 2 }">
													<div class="re_autoly" id="pil_leave_message_box_${childs.id}">
														<h3>${childs.username}</h3>
														<p style="widht:100%;height:100%;word-wrap: break-word">${childs.message}</p>
														<div class="bot_all">
															<div class="bot_reply fr reply3">
																<span>回复TA</span>
															</div>
															<div class="bot_report fr">
																<a href="">举报 &nbsp;|&nbsp; ${childs.datestr}&nbsp;&nbsp;</a>
															</div>
															<div class="clear"></div>
														</div>
														<div class="leave_new open3" style="display:none;">
															<div class="bus_example">
																<div class="textarea" contenteditable="true"></div>
																<div class="re_all">
																	<a href="javascript:void(0);" class="point" 
																		onclick="repayManySubmit(this)" 
																		data-parentopid="${childs.id}"
																		data-parentboxopid="${replyVos.id}">发布</a>
																	<a href="javascript:void(0);" class="smille"></a>
																<div class="clear"></div>
																</div>
															</div>
															<div class="faceone facemany w500"></div>
														</div>
													</div>
													</c:when>
                                            		<c:otherwise>
														<!-- 多次回复 start -->
													    <div class="re_autoly" id="pil_leave_message_box_${childs.id}">
															<h3>${childs.username}<span>回复</span>${childs.tusername}</h3>
															<p style="widht:100%;height:100%;word-wrap: break-word">${childs.message}
															</p>
															<div class="bot_all">
																<div class="bot_reply reply4 fr">
																	<span>回复TA</span>
																</div>
																<div class="bot_report fr">
																	<a href="">举报 &nbsp;|&nbsp; ${childs.datestr}&nbsp;&nbsp;</a>
																</div>
																<div class="clear"></div>
															</div>
															 <div class="leave_new open4" style="display:none;">
																<div class="bus_example">
																	<div class="textarea" contenteditable="true"></div>
																	<div class="re_all">
																		<a href="javascript:void(0);" class="point"
																			onclick="repayManySubmit(this)" 
																			data-parentopid="${childs.id}"
																			data-parentboxopid="${replyVos.id}">发布</a>
																		<a href="javascript:void(0);" class="smille"></a>
																	<div class="clear"></div>
																	</div>
																</div>
																<div class="faceone facemany w500"></div>
															</div>
													   </div>
													   <!-- 多次回复 end -->
                                            		</c:otherwise>
                                        	</c:choose>
                                     	</c:forEach>
									</div>
	 								<!-- 多次回复盒子 end -->
									<div class="leave_bot">
										<div class="bot_reply fl" id="reply1">
											<!--<a href="#">-->
											<span>回复</span>
											<!--</a>-->
										</div>
										<div class="bot_report fl">
											<a href="">举报 &nbsp;|&nbsp; ${replyVos.datestr}&nbsp;&nbsp;</a>
										</div>
										<div class="clear"></div>
									</div>
									<div class="leave_zudi pil_report_post_box" style="display:none;">
										<div class="bus_example w500">
											<div class="textarea" contenteditable="true"></div>
											<a href="javascript:void(0);" class="point" 
												data-parentopid="${replyVos.id}" onclick="repayTwoSubmit(this)">发布</a>
											<a href="javascript:void(0);" class='smille'></a>
										</div>
										<div class="faceone w500"></div>
									</div>
	
									<div class="clear"></div>
								</div>
								<!-- 回复模块 end -->
							</c:forEach>
 						</div>
					</div>
 				   <c:if test="${pagehelper.total > 10}">
	                    <!-- 页码 -->
	                    <div class="fenyeqi" style="margin-top: 15px;">
	                        <ul class="fyeqi">
	                            <%@include file="/common/pagehelper.jsp"%>
	                        </ul>
	                    </div>
	                </c:if>
					<!-- 参与讨论 -->
 
					<div class="bus_discussions" id>
						<h3>参与讨论</h3>
						<!--<textarea name="content" class="tlk" placeholder="请登录后参与评论……"></textarea>-->
						<div class="send w500">
                        	<textarea name="" id="" cols="30" rows="5" placeholder="我也要说几句..."></textarea>
							<a href="javascript:void(0);" class="btn" onclick="repayOneSubmit(this)" id="repayOneSubmit">发布</a>
							<a href="javascript:void(0);" class='faces'></a>
							<a href="javascript:void(0);" class='faces_img'></a>
							<input class="upload" name="file" accept="image/*" 
							type="file" style="display: none;" onchange="uploadimage(this)">
						</div>
						<div class="face w500"></div>
 					</div>
					<!-- 回复Box end -->
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