<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
			<a href="javascript:getThreadData(${threadpagehelper.firstPage}, ${threadpagehelper.pageSize});">
				<li class="return_first">
				首页
				</li>
			</a>
		<c:if test="${!threadpagehelper.isFirstPage}">
				<a href="javascript:getThreadData(${threadpagehelper.prePage}, ${threadpagehelper.pageSize});">
					<li class="next_page">
						前一页
					</li>
				</a>
		</c:if>
		<c:forEach items="${threadpagehelper.navigatepageNums}"
			var="navigatepageNum">

			<c:if test="${navigatepageNum==threadpagehelper.pageNum}">
					<a   href="javascript:getThreadData(${navigatepageNum}, ${threadpagehelper.pageSize});">
						<li class="fyactive">
							${navigatepageNum}
						</li>
					</a>
			</c:if>
			<c:if test="${navigatepageNum!=threadpagehelper.pageNum}">
					<a href="javascript:getThreadData(${navigatepageNum}, ${threadpagehelper.pageSize});">
						<li>
							${navigatepageNum}
						</li>
					</a>
			</c:if>
		</c:forEach>
		<c:if test="${!threadpagehelper.isLastPage}">
				<a href="javascript:getThreadData(${threadpagehelper.nextPage}, ${threadpagehelper.pageSize});">
					<li class="next_page">
						下一页
					</li>
				</a>
		</c:if>
				<a href="javascript:getThreadData(${threadpagehelper.lastPage}, ${threadpagehelper.pageSize});">
					<li class="return_first">
						尾页
					</li>
				</a>

