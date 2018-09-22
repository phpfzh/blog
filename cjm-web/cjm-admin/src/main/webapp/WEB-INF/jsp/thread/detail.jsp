<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>${forumThreadVo.subject}-最开放自由的P2P网贷交流门户 -网贷巴士</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="p2p网贷,网贷资讯,互联网金融,互联网理财">
<meta name="description" content="网贷巴士努力为投资人提供最新最有价值最客观的p2p网贷资讯 ">
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/reset2.css" />
<link rel="stylesheet" href="${basePath}/static/css/swiper-3.3.1.min.css">
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/first_week2.css"/>
<%@include file="/WEB-INF/jsp/common/public.jsp"%>
<script type="text/javascript" src="${basePath}/static/js/first_week2.js"></script>
<script type="text/javascript" src="${basePath}/static/js/platform/teahouse/teahouse.js"></script>
 <script type="text/javascript">
	$(function(){
		var obj = $(".navs").find("ul li a");
		$(obj).removeClass('active').eq(1).addClass("active");
	})
	
	//分页
	function getData(pageNum,pageSize){
		var tid = $("#wdb_tid").data("tid");
		var action = basePath+"/thread-"+tid+"-"+pageNum+"-1.html";
		$("#wdbform").attr("action",action);
  		$("#pageNum").val(pageNum);
 		$("#pageSize").val(pageSize);
 		$("#wdbform").submit();
	}
	
 </script>
  <style type="text/css">
 	.wdb_zoom{
 		max-width:650px;
 	}
 	.zoom{
 		max-width:750px;
 	}
 </style>
</head>
<body>
   <div class="bus">
		<!-- 公共头部开始 -->
		 <%@include file="../common/header.jsp"%>
		<!-- 公共头部结束 -->
		<input type="hidden" id="wdb_tid" data-tid="${forumThreadVo.tid }">
		<input type="hidden" id="wdb_subject" data-subject="${forumThreadVo.subject }">
		<input type="hidden" id="wdb_authorid" data-authorid="${forumThreadVo.authorid }">
 		<input type="hidden" id="wdb_adtemplates" data-adtemplates="4">
 		
 	    <form id="wdbform" action="${basePath}/thread-156321-1-1.html" method="post">
			 <input type="hidden" name="pageNum" id="pageNum">
			 <input type="hidden" name="pageSize" id="pageSize">
 		</form>
 		
		<div class="main">
            <div class="container">
                <p class="pt_title">
                    <a href="${basePath}/index">首页 ></a> <a href="${basePath}/forum-40-1.html">巴士茶馆 ></a> 巴士茶馆详情
                </p>
                <c:if test="${not empty adImageResult }">
 	                <div class="ap_advert advertisement">
 	                	<a href="${adImageResult.imageHyperlink}" target="_blank">
		                    <img src="${adImageResult.imageAddress }">
		                    <span class="ggtext">广告</span>
  	                	</a>
	                </div>
                </c:if>
            </div>
        </div>
        <!-- 平台内容 -->
        <div class="bus_content">
            <div class="container">
                <!-- 平台左内容 -->
                <div class="bus_condition fl">
                	<c:if test="${not empty forumThreadVo.amessage}">
 	                    <div class="notice">
	                        <a>管理员公告：</a>${forumThreadVo.amessage}
	                    </div>
                	</c:if>
                    <div class="bus_allnotice">
                        <div class="allnotice_title">
                            <h3>
                            	<c:if test="${not empty forumThreadVo.statusstr}"><span style="color:#3773e;">[${forumThreadVo.statusstr }]</span></c:if>
                                <c:if test="${not empty forumThreadVo.presubject}"><a>[${forumThreadVo.presubject }]</a></c:if>
                                ${forumThreadVo.subject}
                            </h3>
                        </div>
                        <div class="bus_icon">
                            <ul>
                                <li>
                                    <img src="${basePath}/static/images/first_week/gf.png">
                                    <span>${forumThreadVo.author}</span>
                                </li>
                                <li>
                                    <img src="${basePath}/static/images/first_week/nz.png">
                                    <span>${forumThreadVo.datelinestr}</span>
                                </li>
                                <li>
                                    <img src="${basePath}/static/images/first_week/ye.png">
                                    <span>${forumThreadVo.views}</span>
                                </li>
                                <li>
                                    <img src="${basePath}/static/images/first_week/dx.png">
                                    <span>${forumThreadVo.replies}</span>
                                </li>
                                <div class="clear"></div>
                            </ul>
                        </div>

                        <div class="allnotice_content">
             				<p style="widht:100%;height:100%;word-wrap: break-word">
             					${forumThreadVo.message}
             				</p>
                          <!--   <a class="money">打赏</a>
                            <a class="advert">购买广告位</a> -->
                        </div>
                    </div>
                    <div class="bus_reply">
                        <div class="reply_left fl">
                            <img src="${basePath}/static/images/first_week/hf1.png">
                             <a href="#wdb_comments" style="color:#ccc">回复</a>
                        </div>
                        <div class="reply_left fr">
                            <img src="${basePath}/static/images/first_week/jb.png">
                            <span>举报</span>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <!-- 全部回复 -->
                    <div class="bus_allreply">
                        <div class="allreply">
                            	全部回复（${total}）
                        </div>
                        <div id="bus_allreply_box">
	                        <!-- 回复模块 开始-->
	                        <c:forEach items="${replyVos}" var="replyVos">
  		                        <div class="leave_message" id="wdb_leave_message_box_${replyVos.id}">
		                        	<!-- 首次回复 开始 -->
	 	                            <div class="leave_top">
		                                <div class="top_img fl">
		                                    <img src="${replyVos.uheadimg }" width="60" height="60">
		                                </div>
		                                <div class="top_js fl">
		                                    <h3>${replyVos.username}</h3>
		                                    <span>${replyVos.signature}</span>
		                                    <p style="widht:100%;height:100%;word-wrap: break-word">
		                                    	${replyVos.message }
		                                    </p>
		                                </div>
		                                <div class="clear"></div>
		                            </div>
									<!-- 首次回复 结束 -->
									
									<!-- 多次回复Box 开始 -->
		                            <div class="leave_reply" id="wdb_leave_reply_box_${replyVos.id}">
		                            		<c:forEach var="childs" items="${replyVos.childs}">
		                            				<c:choose>
		                            					<c:when test="${childs.replytype eq 2 }">
		                            							<!-- 二次回复 开始 -->
							                                    <div class="re_autoly" id="wdb_re_autoly_box_${childs.id}">
							                                        <h3>${childs.username }</h3>
							                                        <p style="widht:100%;height:100%;word-wrap: break-word">${childs.message}</p>
							                                        <div class="bot_all">
							                                            <div class="bot_reply fr reply3">
							                                                <span>回复TA</span>
							                                            </div>
							                                            <div class="bot_report fr">
							                                                <a href="">举报 &nbsp;|&nbsp; ${ childs.datestr}&nbsp;&nbsp;</a>
							                                            </div>
							                                            <div class="clear"></div>
							                                        </div>
							                                        <div class="leave_new open3 wdb_many_reply_box" style="display:none;">
							                                            <div class="bus_example" data-opid="${childs.id}" data-divid="${replyVos.id}">
							                                                <div class="textarea" contenteditable="true"></div>
							                                                <div class="re_all">
							                                                    <a href="javascript:void(0)" class="point">发布</a>
							                                                    <a href="javascript:void(0)" class="smille"></a>
							                                                <div class="clear"></div>
							                                                </div>
							                                            </div>
							                                            <div class=" faceone facemany w500"></div>
							                                        </div>
							                                    </div>
							                                    <!-- 二次回复 结束 -->
		                            					</c:when>
		                            					<c:otherwise>
		                            							<!-- 多次回复 开始 -->
							                                   <div class="re_autoly" id="wdb_re_autoly_box_${childs.id}">
							                                        <h3>${childs.username}<span>回复</span>${childs.fusername }</h3>
							                                        <p style="widht:100%;height:100%;word-wrap: break-word">${childs.message }
							                                        </p>
							                                        <div class="bot_all">
							                                            <div class="bot_reply reply4 fr">
							                                                <span>回复TA</span>
							                                            </div>
							                                            <div class="bot_report fr">
							                                                <a href="javascript:void(0)">举报 &nbsp;|&nbsp;${ childs.datestr}&nbsp;&nbsp;</a>
							                                            </div>
							                                            <div class="clear"></div>
							                                        </div>
							                                         <div class="leave_new open4 wdb_many_reply_box" style="display:none;">
							                                            <div class="bus_example" data-opid="${childs.id}" data-divid="${replyVos.id}">
							                                                <div class="textarea" contenteditable="true"></div>
							                                                <div class="re_all">
							                                                    <a href="javascript:void(0)" class="point">发布</a>
							                                                    <a href="javascript:void(0)" class="smille"></a>
							                                                <div class="clear"></div>
							                                                </div>
							                                            </div>
							                                            <div class="faceone facemany w500"></div>
							                                        </div>
							                                   </div>
							                                   <!-- 多次回复 结束 -->
		                            					</c:otherwise>
		                            				</c:choose>
		                            				  
		                            		</c:forEach>
 		                            </div>
									<!-- 多次回复Box 结束 -->
		
		                            <div class="leave_bot">
		                                <div class="bot_reply fl" id="reply1">
		                                    <!--<a href="#">-->
		                                    <span>回复</span>
		                                    <!--</a>-->
		                                </div>
		                                <div class="bot_report fl">
		                                    <a href="javascript:void(0)">举报 &nbsp;|&nbsp; ${replyVos.datestr }&nbsp;&nbsp;</a>
		                                </div>
		                                <div class="clear"></div>
		                            </div>
		                            <div class="leave_zudi wdb_report_post_box" style="display:none;">
		                                <div class="bus_example w500" data-opid="${replyVos.id}">
		                                    <div class="textarea" contenteditable="true"></div>
		                                    <a href="javascript:void(0);" class="point">发布</a>
		                                    <a href="javascript:void(0);" class='smille'></a>
 		                                </div>
		                                <div class="faceone w500"></div>
		                            </div>
		
		                            <div class="clear"></div>
		                        </div>
								<!-- 回复模块 结束-->
							</c:forEach>
                          </div>
                    </div>
                    
                    <c:if test="${pagehelper.total > 10}">
                    <!-- 页码 -->
                    <div class="fenyeqi">
				        <ul class="fyeqi">
				          <%@include file="/WEB-INF/jsp/common/pagehelper.jsp"%>
				        </ul>
			     	 </div>
			     	 </c:if>
                    <!-- 参与讨论 -->
 
                    <div class="bus_discussions" id="wdb_comments">
                        <h3>参与讨论</h3>
                        <!--<textarea name="content" class="tlk" placeholder="请登录后参与评论……"></textarea>-->
                        <div class="send w500">
                            <textarea name="" id="" cols="30" rows="5" placeholder="我也要说几句..."></textarea>
                            <a href="javascript:void(0);" class="btn">发布</a>
                            <a href="javascript:void(0)" class='faces'></a>
                            <a href="javascript:void(0)" class='faces_img'></a>
                            <input class="upload" name="file" accept="image/*" type="file" style="display: none;" onchange="uploadimage(this)">
                        </div>
                        <div class="face w500"></div>
                         <!--代码部分end-->
                    </div>
                 </div>
                <!-- 平台右内容 -->
                <div class="plat_rewards fr">
                  <%--   <div class="investor_all">
                        <div class="investor">
                            <div class="invest_left fl">
                                <img src="${basePath}/static/images/first_week/mn1.png">
                            </div>
                            <div class="invest_right fr">
                                <h3>徐宇</h3>
                                <span>资源方</span>
                                <span>产品方</span>
                                <p>共发表<a>402</a>篇</p>
                            </div>
                            <div class="clear"></div>
                            <div class="my_introduce">
                                	我所有的产品都是一手单，想找我做单的看我的个人专栏，也可以电话联系我13222222123。
                            </div>
                        </div>
                    </div> --%>
                    <%-- <div class="building_product">
                        <h3>楼主产品</h3>
                        <ul>
                            <li>
                                <div class="pic_icon fl">
                                    <img src="${basePath}/static/images/first_week/bsjr.png">
                                </div>
                                <div class="pic_yq fr">
                                   	 最高预期:<a>18%</a>
                                </div>
                            </li>
                            <li>
                                <div class="pic_icon fl">
                                    <img src="${basePath}/static/images/first_week/bs_bj.png">
                                </div>
                                <div class="pic_yq fr">
                                    	最高预期:<a>18%</a>
                                </div>
                            </li>
                            <li>
                                <div class="pic_icon fl">
                                    <img src="${basePath}/static/images/first_week/td.png">
                                </div>
                                <div class="pic_yq fr">
                                   	 最高预期:<a>18%</a>
                                </div>
                            </li>
                            <a href="#" class="more_find">查看更多产品和资源</a>
                        </ul>
                    </div> --%>

	 	             <div class="millde_pic">
	                    	<c:if test="${not empty adUniversal1}">
	 	                        <div class="advertisement">
	 	                        	<a href="${adUniversal1.ad_link}" target="_blank">
	 		                            <img src="${adUniversal1.image_address}">
			                            <span class="ggtext">广告</span>
	 	                        	</a>
		                        </div>
	                    	</c:if>
	                        <c:if test="${not empty adUniversal2}">
	 	                        <div class="advertisement">
	 	                        	<a href="${adUniversal2.ad_link}" target="_blank">
	 		                            <img src="${adUniversal2.image_address}">
			                            <span class="ggtext">广告</span>
	 	                        	</a>
		                        </div>
	                    	</c:if>
		             </div>

                    <div class="evaluation">
                        <div class="evaluation_ty">
                            <h5>最新评价</h5>
                            <a href="#">更多></a>
                        </div>
                    </div>
                    <div class="evaluation_list">
                        <ul>
                            <c:forEach items="${subEvaluates }" var="subEvaluates">
 	                            <a href="javascript:void(0)">
	                                <li>
	                                    <div class="list_left fl">
	                                        <img src="${subEvaluates.logo1 }" width="120" height="46">
	                                    </div>
	                                    <div class="list_right fr">
	                                        <h3>${subEvaluates.pname }</h3>
 	                                        <c:choose>
												<c:when test="${subEvaluates.evaluationtendency == 1 }">
 													<img src="${basePath}/static/images/first_week/xl.png">
													<span>好评</span>
												</c:when>
												<c:when test="${subEvaluates.evaluationtendency == 2 }">
													<img src="${basePath}/static/images/first_week/yb.png">
													<span>一般</span>
												</c:when>
												<c:otherwise>
													<img src="${basePath}/static/images/first_week/cp.png">
													<span>差评</span>
												</c:otherwise>
											</c:choose>
	                                        <p>${subEvaluates.evaluatetime}</p>
	                                    </div>
	                                    <div class="clear"></div>
	                                    <p>${subEvaluates.evaluationcontent }</p>
	                                </li>
	                            </a>
                        	</c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
		<!--公共底部开始-->
		 <%@include file="../common/footer.jsp"%>
		<!--公共底部结束-->
	</div>
  
  <!-- 打赏弹框 -->
    <div class="register_frame">
        <div class="reward">
            <div class="reward_title">
                <div class="float_l border_l"></div>
                <p class="float_l">打赏</p>
                <img class="float_r cursor close" src="${basePath}/static/images/product_details/close.png">
                <div class="clear"></div>
            </div>
            <div class="reward_text">
                <div class="float_l p">打赏金额</div>
                <div class="float_l each">
                    <div class="label_money">
                        <div class="class class_on">50元</div>
                        <div class="class">150元</div>
                        <div class="class">200元</div>
                        <div class="class">250元</div>
                        <div class="class">300元</div>
                        <div class="class">400元</div>
                        <div class="class">500元</div>
                        <div class="class">自定义</div>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="float_l p">打赏备注</div>
                <div class="float_l textarea">
                    <textarea type="text" placeholder="打赏备注，限50字" rows="5"  maxlength="50" onchange="this.value=this.value.substring(0, 50)" onkeydown="this.value=this.value.substring(0, 50)" onkeyup="this.value=this.value.substring(0, 50)"></textarea>
                </div>
                <div class="float_l p">付款方式</div>
                <div class="float_l input">
                    <div class="label_nav">
                        <h4 class="float_l on">
                            <img class="float_l" src="${basePath}/static/images/product_details/zhifu3.png">
                            <p class="float_l">支付宝支付</p>
                            <div class="clear"></div>
                        </h4>
                        <h4 class="float_l">
                            <img class="float_l" src="${basePath}/static/images/product_details/weixin.png">
                            <p class="float_l">微信支付</p>
                            <div class="clear"></div>
                        </h4>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="clear"></div>
                <div class="label_page">
                    <div class="label_page_each">
                        <div class="scavenging">
                            <img class="float_l zhifubao" src="${basePath}/static/images/product_details/zhifubao.png">
                            <p class="float_l">支付宝扫码，支付 <span>0</span>.00 元</p>
                            <div class="clear"></div>
                            <div class="qr_code">
                                <img class="" src="">
                            </div>
                        </div>
                    </div>
                    <div class="label_page_each label_page_each2">
                        <div class="scavenging">
                            <img class="float_l zhifubao" src="${basePath}/static/images/product_details/weixin.png">
                            <p class="float_l">微信扫码，支付 <span>0</span>.00 元</p>
                            <div class="clear"></div>
                            <div class="qr_code">
                                <img class="" src="">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="explain">
                <h6>*什么是打赏?</h6>
                <p class="">打赏资金属于无偿赠与，打赏完成后，将直接进入对方的巴士账户，不可退款，请谨慎操作。</p>
            </div>
        </div>
    </div>

    <!-- 购买广告位弹框 -->
    <div class="register_frame2">
        <div class="reward">
            <div class="reward_title">
                <div class="float_l border_l"></div>
                <p class="float_l">购买广告位</p>
                <img class="float_r cursor close" src="${basePath}/static/images/product_details/close.png">
                <div class="clear"></div>
            </div>
            <div class="reward_text">
                <div class="float_l p">发帖人</div>
                <div class="float_l each"><span id="s">sdfs</span></div>
                <div class="float_l p">帖子名称</div>
                <div class="float_l each">大批同地址公司发标：银豆网意思疯狂造假，房贷标揭示！</div>
                <div class="float_l p">板块名称</div>
                <div class="float_l each">网贷巴士-新闻资讯</div>
                <div class="float_l p">广告主</div>
                <div class="float_l each">bus9999999-丛立波</div>
                <div class="clear"></div>
                <div class="label_money2">
                    <div class="class class_on">
                        <h2>
                            <span id="addayprice">50</span>
                            <span>元/天</span>
                        </h2>
                        <input type="number" value="1" min="1" max="100000" step="1">
                        <p class="riqi" id="adday">天</p>
                        <img class="xuanzhong2" src="${basePath}/static/images/product_details/xuanzhong2.png">
                        <script src="js/InputSpinner.js" type="text/javascript"></script>
                    </div>
                    <div class="class">
                        <h2><span id="adweekprice"></span><span>元/周</span></h2>
                        <input type="number" value="1" min="1" max="100000" step="1">
                        <p class="riqi">周</p>
                        <img class="xuanzhong2" src="${basePath}/static/images/product_details/xuanzhong2.png">
                    </div>
                    <div class="class">
                        <h2>300<span>元/月</span></h2>
                        <input type="number" value="1" min="1" max="100000" step="1">
                        <p class="riqi">月</p>
                        <img class="xuanzhong2" src="${basePath}/static/images/product_details/xuanzhong2.png">
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="float_l p">价格</div>
                <div class="float_l each"><p><span>¥</span>18000<span>.00</span></p></div>
                <div class="float_l p select_p">广告图设置</div>
                <div class="float_l each select">
                    <select>
                        <option disabled selected style='display:none;'>请设置pc端广告图片</option>
                        <option>1</option>
                        <option>2</option>
                    </select>
                    <select>
                        <option disabled selected style='display:none;'>请设置手机端广告图片</option>
                        <option>1</option>
                        <option>2</option>
                    </select>
                </div>
                <div class="float_l p">打赏备注</div>
                <div class="float_l textarea">
                    <textarea type="text" placeholder="打赏备注，限50字" rows="5"  maxlength="50" onchange="this.value=this.value.substring(0, 50)" onkeydown="this.value=this.value.substring(0, 50)" onkeyup="this.value=this.value.substring(0, 50)"></textarea>
                </div>
                <div class="float_l p">付款方式</div>
                <div class="float_l input">
                    <div class="label_nav2">
                        <h4 class="float_l on">
                            <img class="float_l" src="${basePath}/static/images/product_details/zhifu3.png">
                            <p class="float_l">支付宝支付</p>
                            <div class="clear"></div>
                        </h4>
                        <h4 class="float_l">
                            <img class="float_l" src="${basePath}/static/images/product_details/weixin.png">
                            <p class="float_l">微信支付</p>
                            <div class="clear"></div>
                        </h4>
                        <h4 class="float_l">
                            <img class="float_l" src="${basePath}/static/images/product_details/bao.png">
                            <p class="float_l">巴士余额</p>
                            <div class="clear"></div>
                        </h4>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="clear"></div>
                <div class="label_page2">
                    <div class="label_page_each1">
                        <div class="scavenging">
                            <img class="float_l zhifubao" src="${basePath}/static/images/product_details/zhifubao.png">
                            <p class="float_l">支付宝扫码，支付 <span>0</span>.00 元</p>
                            <div class="clear"></div>
                            <div class="qr_code">
                                <img class="" src="${basePath}/static/images/product_details/erweima.png">
                            </div>
                        </div>
                    </div>
                    <div class="label_page_each1 label_page_each2">
                        <div class="scavenging">
                            <img class="float_l zhifubao" src="${basePath}/static/images/product_details/weixin.png">
                            <p class="float_l">微信扫码，支付 <span>0</span>.00 元</p>
                            <div class="clear"></div>
                            <div class="qr_code">
                                <img class="" src="${basePath}/static/images/product_details/erweima.png">
                            </div>
                        </div>
                    </div>
                    <div class="label_page_each1 label_page_each2">
                        <div class="scavenging">
                            <div class="float_l p select_p">注册手机号</div>
                            <div class="float_l each select">13222222123</div>
                            <div class="float_l p select_p">验证码</div>
                            <div class="float_l each select">
                                <input type="text" name="" value="" placeholder="请输入验证码" />
                                <button class="fszyc" id="tourist_buts" href="#">发送验证码</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="explain">
                <h6>*购买须知</h6>
                <p class="">付款成功后，广告图会自动发布到广告位，广告费将打入发帖人账户余额，广告位到期后，系统将自动撤下广告位，若广告内容牵涉负面较多，巴士有权将广告下架，且广告费不予退还。</p>
                <h6>*注意事项</h6>
                <p class="">付款成功后，广告图会自动发布到广告位，广告费将打入发帖人账户余额，广告位到期后，系统将自动撤下广告位，若广告内容牵涉负面较多，巴士有权将广告下架，且广告费不予退还。</p>
            </div>
        </div>
    </div>

    <script>
        //生成订单
        function generateOrders(){
            $.get(
                basePath+"/admin/advertising/generateOrders",
                {
                    "tid":tid,
                    "adUserId":adUserId
                },
                function(data){

            });
        }
        // 打赏弹框
        $(function(){
            $(".money").on('click',function(){ 
                $(".register_frame").fadeIn(300)
            })
            //关闭弹框
            $(".close").on("click",function(){ 
                $(".register_frame").fadeOut(300)
            })
        })
        // 支付二维码切换
        $(".label_page .label_page_each").hide().eq(0).show()
        $(".label_nav h4").click(
            function(){
                var k=$(this).index()
                $(".label_nav h4").removeClass("on")
                $(this).addClass("on")
                $(".label_page .label_page_each").hide().eq(k).fadeIn(300)
            }
        )

        // 购买广告位弹框
        $(function(){
            $(".advert").on('click',function(){
                <%--if(${user=="" or user==null}){--%>
                    <%--$(".zhezhao").fadeIn(300);--%>
                <%--}else{--%>
                    <%--$(".register_frame2").fadeIn(300)--%>
                <%--}--%>
                /*广告价格*/
                //var tid = $("#wdb_tid").val();
                var tid = 123123;
                var adUserId = 10490;
                $.get(basePath+"/admin/advertising/getOneAdSlot",{"tid":tid,"adUserId":adUserId}, function(data){
                    //Map
                    //adPrice 价格表
                    //adImage 广告图
                    if(data.meta.code=="88"){
                        $("#s").html(data.data.adday);

                        $(".register_frame2").fadeIn(300);
                        //window.location.reload(true);
                    }else{
                        alert(data.meta.message);
                    }
                });

            })
            //关闭弹框
            $(".close").on("click",function(){
                $(".register_frame2").fadeOut(300)
            })
        })

        // 支付二维码切换
        $(".label_page2 .label_page_each1").hide().eq(0).show()
        $(".label_nav2 h4").click(
            function(){
                var k=$(this).index()
                $(".label_nav2 h4").removeClass("on")
                $(this).addClass("on")
                $(".label_page2 .label_page_each1").hide().eq(k).fadeIn(300)
            }
        )
    </script>
  
</body>
</html>