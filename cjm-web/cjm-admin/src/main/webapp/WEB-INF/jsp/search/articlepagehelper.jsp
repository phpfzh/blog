<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
			<a href="javascript:getArticleData(${articlepagehelper.firstPage}, ${articlepagehelper.pageSize});">
				<li class="return_first">
				首页
				</li>
			</a>
		<c:if test="${!articlepagehelper.isFirstPage}">
				<a href="javascript:getArticleData(${articlepagehelper.prePage}, ${articlepagehelper.pageSize});">
					<li class="next_page">
						前一页
					</li>
				</a>
		</c:if>
		<c:forEach items="${articlepagehelper.navigatepageNums}"
			var="navigatepageNum">

			<c:if test="${navigatepageNum==articlepagehelper.pageNum}">
					<a   href="javascript:getArticleData(${navigatepageNum}, ${articlepagehelper.pageSize});">
						<li class="fyactive">
							${navigatepageNum}
						</li>
					</a>
			</c:if>
			<c:if test="${navigatepageNum!=articlepagehelper.pageNum}">
					<a href="javascript:getArticleData(${navigatepageNum}, ${articlepagehelper.pageSize});">
						<li>
							${navigatepageNum}
						</li>
					</a>
			</c:if>
		</c:forEach>
		<c:if test="${!articlepagehelper.isLastPage}">
				<a href="javascript:getArticleData(${articlepagehelper.nextPage}, ${articlepagehelper.pageSize});">
					<li class="next_page">
						下一页
					</li>
				</a>
		</c:if>
				<a href="javascript:getArticleData(${articlepagehelper.lastPage}, ${articlepagehelper.pageSize});">
					<li class="return_first">
						尾页
					</li>
				</a>

