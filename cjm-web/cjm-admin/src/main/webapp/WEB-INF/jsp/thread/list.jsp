<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>主题列表页-陈嘉明个人博客-分享web前端和Java技术的个人博客网站</title>
<meta name="keywords" content="陈嘉明,陈嘉明个人博客,个人博客,个人博客网站">
<meta name="description" content="陈嘉明个人博客，分享web前端技术和Java技术的个人博客网站">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/public.jsp"%>
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/reset2.css" />
<link rel="stylesheet" href="${basePath}/static/css/swiper-3.3.1.min.css">
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/thread.css"/>
<script src="${basePath}/static/js/first_week2.js"></script>
</head>
<body>
<%@include file="/common/header.jsp" %>
<div class="clear"></div>
<div class="thread" id="post_main">
	<div class="main">
		<div class="container">
			<p class="pt_title">
				首页 >
				<a href=""> 巴士茶馆</a>
			</p>

			<div class="pt_advert advertisement" style="margin-bottom: 20px;">
				<img src="${basePath}/static/images/first_week/gg_a.png">
				<span class="ggtext">广告</span>
			</div>

		</div>
	</div>
	<!-- 帖子内容  开始-->
	<div class="thread_content">
		<div class="container">
			<!-- 热门帖子 -->
			<div class="thread_condition fl">
				<div class="hot_posts">
					<div class="posts_title">
						<h5>热门帖子</h5>
						<div class="clear"></div>
					</div>
					<div class="hot_profit">
						<div class="profit_left fl">
							<img src="${basePath}/static/images/first_week/zhiying2.png">
						</div>
						<div class="profit_right fr">
							<ul>
								<a href="#">
									<li>
										<h3>小米把香港IPO价格定在每股17港元 净筹资量数？</h3>
										<span>2018-06-25</span>
										<div class="clear"></div>
									</li>
								</a>
								<a href="#">
									<li>
										<h3>小米把香港IPO价格定在每股17港元 净筹资量数？</h3>
										<span>2018-06-25</span>
										<div class="clear"></div>
									</li>
								</a>
								<a href="#">
									<li>
										<h3>小米把香港IPO价格定在每股17港元 净筹资量数？</h3>
										<span>2018-06-25</span>
										<div class="clear"></div>
									</li>
								</a>
								<a href="#">
									<li>
										<h3>小米把香港IPO价格定在每股17港元 净筹资量数？</h3>
										<span>2018-06-25</span>
										<div class="clear"></div>
									</li>
								</a>
								<a href="#">
									<li>
										<h3>小米把香港IPO价格定在每股17港元 净筹资量数？</h3>
										<span>2018-06-25</span>
										<div class="clear"></div>
									</li>
								</a>
							</ul>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
			<!--热门帖子结束-->

			<!--我要发帖开始-->
			<div class="plat_rewards fr">
				<div class="rewards_post">
					<div class="posting_top">
						<img src="${basePath}/static/images/first_week/cb.png">
						<p>本板块为平台曝光专用区，供 投友发布对网贷行业平台的曝 光、质疑、预警等内容。
						</p>
					</div>
					<p>1.本版块对用户级别无要求，注册即可发贴及回复；</p>
					<p>2.本版块所有发帖主题须与内容匹配，发帖人须对帖 子负责，网贷天眼社区管理员将对所有主题审核。
					</p>
					<div class="posting_us">
						<a href="#">我要发帖</a>
					</div>
				</div>
			</div>
			<!--我要发帖结束-->
		</div>

		<div class="container">
			<!-- 平台左内容 -->
			<div class="thread_condition fl">
 				<!-- 巴士茶馆 -->
				<div class="thread_comcate">
					<div class="posts_title2">
						<h5>巴士茶馆</h5>
						<a href="#">我要发帖</a>
						<div class="clear"></div>
					</div>
					<!-- tab切换代码 -->
					<div class="comcate_top">
						<div class="comcate_title">
							<ul id="tab">

								<li class="morenew">最新</li>
								<li>最热</li>
								<li>精华 </li>
								<li> 曝光</li>
								<li>交流 </li>
								<div class="clear"></div>
							</ul>
						</div>
						<div class="comcate_news" id="content">
							<ul class="news_bd">
								<a href="#">
									<li>
										<div class="thread_news ">
											<h3><span>[陆金所]</span> 被人爆料过的老贴，别在老发了，不听劝阻，只能封你账号和IP了！</h3>
										</div>
										<div class="thread_data">
											<div class="find fl">
												<p>
													<img src="${basePath}/static/images/first_week/gf.png">
													<span>官方</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/nz.png">
													<span>2018-06-25&nbsp;&nbsp;10:56</span>
												</p>
											</div>
											<div class="find_right fr">
												<p>
													<img src="${basePath}/static/images/first_week/ye.png">
													<span>12345</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/dx.png">
													<span>1234556</span>
												</p>
											</div>
											<div class="clear"></div>
										</div>
									</li>
								</a>
								<a href="#">
									<li>
										<div class="thread_news ">
											<h3>[网贷天眼] 这是哪个平台？小牛在线？小牛钱罐子？小牛普惠？警察怎么上门了</h3>
										</div>
										<div class="thread_data">
											<div class="find fl">
												<p>
													<img src="${basePath}/static/images/first_week/gf.png">
													<span>官方</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/nz.png">
													<span>2018-06-25&nbsp;&nbsp;10:56</span>
												</p>
											</div>
											<div class="find_right fr">
												<p>
													<img src="${basePath}/static/images/first_week/ye.png">
													<span>12345</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/dx.png">
													<span>1234556</span>
												</p>
											</div>
											<div class="clear"></div>
										</div>
									</li>
								</a>
								<a href="#">
									<li>
										<div class="thread_news ">
											<h3>[金钱贷] 巨如集团老板失联：因非吸被列在逃人员曾获媒体评选年度经济人物</h3>
										</div>
										<div class="thread_data">
											<div class="find fl">
												<p>
													<img src="${basePath}/static/images/first_week/gf.png">
													<span>官方</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/nz.png">
													<span>2018-06-25&nbsp;&nbsp;10:56</span>
												</p>
											</div>
											<div class="find_right fr">
												<p>
													<img src="${basePath}/static/images/first_week/ye.png">
													<span>12345</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/dx.png">
													<span>1234556</span>
												</p>
											</div>
											<div class="clear"></div>
										</div>
									</li>
								</a>
								<a href="#">
									<li>
										<div class="thread_news ">
											<h3>[网贷天眼] 这是哪个平台？小牛在线？小牛钱罐子？小牛普惠？警察怎么上门了</h3>
										</div>
										<div class="thread_data">
											<div class="find fl">
												<p>
													<img src="${basePath}/static/images/first_week/gf.png">
													<span>官方</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/nz.png">
													<span>2018-06-25&nbsp;&nbsp;10:56</span>
												</p>
											</div>
											<div class="find_right fr">
												<p>
													<img src="${basePath}/static/images/first_week/ye.png">
													<span>12345</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/dx.png">
													<span>1234556</span>
												</p>
											</div>
											<div class="clear"></div>
										</div>
									</li>
								</a>
								<a href="#">
									<li>
										<div class="thread_news ">
											<h3>[金钱贷] 巨如集团老板失联：因非吸被列在逃人员曾获媒体评选年度经济人物</h3>
										</div>
										<div class="thread_data">
											<div class="find fl">
												<p>
													<img src="${basePath}/static/images/first_week/gf.png">
													<span>官方</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/nz.png">
													<span>2018-06-25&nbsp;&nbsp;10:56</span>
												</p>
											</div>
											<div class="find_right fr">
												<p>
													<img src="${basePath}/static/images/first_week/ye.png">
													<span>12345</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/dx.png">
													<span>1234556</span>
												</p>
											</div>
											<div class="clear"></div>
										</div>
									</li>
								</a>
								<a href="#">
									<li>
										<div class="thread_news ">
											<h3>[陆金所] 被人爆料过的老贴，别在老发了，不听劝阻，只能封你账号和IP了！</h3>
										</div>
										<div class="thread_data">
											<div class="find fl">
												<p>
													<img src="${basePath}/static/images/first_week/gf.png">
													<span>官方</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/nz.png">
													<span>2018-06-25&nbsp;&nbsp;10:56</span>
												</p>
											</div>
											<div class="find_right fr">
												<p>
													<img src="${basePath}/static/images/first_week/ye.png">
													<span>12345</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/dx.png">
													<span>1234556</span>
												</p>
											</div>
											<div class="clear"></div>
										</div>
									</li>
								</a>
								<a href="#">
									<li>
										<div class="thread_news ">
											<h3>[金钱贷] 巨如集团老板失联：因非吸被列在逃人员曾获媒体评选年度经济人物</h3>
										</div>
										<div class="thread_data">
											<div class="find fl">
												<p>
													<img src="${basePath}/static/images/first_week/gf.png">
													<span>官方</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/nz.png">
													<span>2018-06-25&nbsp;&nbsp;10:56</span>
												</p>
											</div>
											<div class="find_right fr">
												<p>
													<img src="${basePath}/static/images/first_week/ye.png">
													<span>12345</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/dx.png">
													<span>1234556</span>
												</p>
											</div>
											<div class="clear"></div>
										</div>
									</li>
								</a>
							</ul>
							<ul class="news_bd">
								<a href="#">
									<li>
										<div class="thread_news ">
											<h3>[陆金所] 被人爆料过的老贴，别在老发了，不听劝阻，只能封你账号和IP了！</h3>
										</div>
										<div class="thread_data">
											<div class="find fl">
												<p>
													<img src="${basePath}/static/images/first_week/gf.png">
													<span>官方</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/nz.png">
													<span>2018-06-25&nbsp;&nbsp;10:56</span>
												</p>
											</div>
											<div class="find_right fr">
												<p>
													<img src="${basePath}/static/images/first_week/ye.png">
													<span>12345</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/dx.png">
													<span>1234556</span>
												</p>
											</div>
											<div class="clear"></div>
										</div>
									</li>
								</a>
							</ul>
							<ul class="news_bd">
								<a href="#">
									<li>
										<div class="thread_news ">
											<h3>[陆金所] 被人爆料过的老贴，别在老发了，不听劝阻，只能封你账号和IP了！</h3>
										</div>
										<div class="thread_data">
											<div class="find fl">
												<p>
													<img src="${basePath}/static/images/first_week/gf.png">
													<span>官方</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/nz.png">
													<span>2018-06-25&nbsp;&nbsp;10:56</span>
												</p>
											</div>
											<div class="find_right fr">
												<p>
													<img src="${basePath}/static/images/first_week/ye.png">
													<span>12345</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/dx.png">
													<span>1234556</span>
												</p>
											</div>
											<div class="clear"></div>
										</div>
									</li>
								</a>
							</ul>
							<ul class="news_bd">
								<a href="#">
									<li>
										<div class="thread_news ">
											<h3>[陆金所] 被人爆料过的老贴，别在老发了，不听劝阻，只能封你账号和IP了！</h3>
										</div>
										<div class="thread_data">
											<div class="find fl">
												<p>
													<img src="${basePath}/static/images/first_week/gf.png">
													<span>官方</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/nz.png">
													<span>2018-06-25&nbsp;&nbsp;10:56</span>
												</p>
											</div>
											<div class="find_right fr">
												<p>
													<img src="${basePath}/static/images/first_week/ye.png">
													<span>12345</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/dx.png">
													<span>1234556</span>
												</p>
											</div>
											<div class="clear"></div>
										</div>
									</li>
								</a>
							</ul>
							<ul class="news_bd">
								<a href="#">
									<li>
										<div class="thread_news ">
											<h3>[陆金所] 被人爆料过的老贴，别在老发了，不听劝阻，只能封你账号和IP了！</h3>
										</div>
										<div class="thread_data">
											<div class="find fl">
												<p>
													<img src="${basePath}/static/images/first_week/gf.png">
													<span>官方</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/nz.png">
													<span>2018-06-25&nbsp;&nbsp;10:56</span>
												</p>
											</div>
											<div class="find_right fr">
												<p>
													<img src="${basePath}/static/images/first_week/ye.png">
													<span>12345</span>
												</p>
												<p>
													<img src="${basePath}/static/images/first_week/dx.png">
													<span>1234556</span>
												</p>
											</div>
											<div class="clear"></div>
										</div>
									</li>
								</a>
							</ul>
						</div>
					</div>
				</div>
				<!-- 页码 -->
				<div class="fenyeqi">
					<ul>


					</ul>
				</div>
			</div>
			<!-- 平台右内容 -->
			<div class="plat_rewards fr">
 				<div class="millde_pic">
					<div class="advertisement">
						<img src="${basePath}/static/images/first_week/sq.png">
						<span>广告</span>
					</div>
					<div class="advertisement">
						<img src="${basePath}/static/images/first_week/zu.png">
						<span>广告</span>
					</div>
				</div>
				<!-- <div class="advertisement">
                    <img src="images/first_week/sq.png">
                    <span class="ggtext">广告</span>
                </div>  -->
				<div class="evaluation">
					<div class="evaluation_ty">
						<h5>最新评价</h5>
						<a href="#">更多></a>
					</div>
				</div>
				<div class="evaluation_list">
					<ul>
						<a href="#">
							<li>
								<div class="list_left fl">
									<img src="${basePath}/static/images/first_week/bsjr.png">
								</div>
								<div class="list_right fr">
									<h3>粤盛金融</h3>
									<img src="${basePath}/static/images/first_week/xl.png">
									<span>好评</span>
									<p>08-07-02 11:56:56</p>
								</div>
								<div class="clear"></div>
								<p>有银行存管，平台活动多，项目真实，在悦享投资我放心，给予了很多机会…</p>
							</li>
						</a>
						<a href="#">
							<li>
								<div class="list_left fl">
									<img src="${basePath}/static/images/first_week/bs_bj.png">
								</div>
								<div class="list_right fr">
									<h3>百金贷</h3>
									<img src="${basePath}/static/images/first_week/cp.png">
									<span class="bad">差评</span>

									<p>08-07-02 11:56:56</p>
								</div>

								<div class="clear"></div>
								<p>有银行存管，平台活动多，项目真实，在悦享投资我放心，给予了很多机会…</p>
							</li>
						</a>
						<a href="#">
							<li>
								<div class="list_left fl">
									<img src="${basePath}/static/images/first_week/td.png">
								</div>
								<div class="list_right fr">
									<h3>团贷网</h3>
									<img src="${basePath}/static/images/first_week/yb.png">
									<span class="yiban">一般</span>

									<p>08-07-02 11:56:56</p>
								</div>
								<div class="clear"></div>
								<p>有银行存管，平台活动多，项目真实，在悦享投资我放心，给予了很多机会…</p>
							</li>
						</a>

						<a href="#">
							<li>
								<div class="list_left fl">
									<img src="${basePath}/static/images/first_week/bs_bj.png">
								</div>
								<div class="list_right fr">
									<h3>百金贷</h3>
									<img src="${basePath}/static/images/first_week/yb.png">
									<span class="yiban">一般</span>
									<p>08-07-02 11:56:56</p>
								</div>
								<div class="clear"></div>
								<p>有银行存管，平台活动多，项目真实，在悦享投资我放心，给予了很多机会…</p>
							</li>
						</a>
					</ul>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<!-- 帖子内容  开始-->

</div>



<!--公共底部开始-->
 <%@include file="/common/footer.jsp"%>
<!--公共底部结束-->
 </body>
</html>