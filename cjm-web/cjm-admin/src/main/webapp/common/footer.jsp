<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/cjm.tld" prefix="cjm"%>
<cjm:getFooter friendLinksVar="friendLinksVar" />
<div id="footer">
    <div class="footer">
        <div class="main_box">
            <div class="friendlink_box">
                <div class="yqilj">友情连接：</div>
                <div class="yright">
                	<c:forEach items="${friendLinksVar }" var="friendLinksVar">
 	                    <div><a href="${friendLinksVar.link }" target="_blank">${friendLinksVar.name}</a></div>
                	</c:forEach>
                </div>
            </div>
         </div>
        <div class="common_box">
             <div>Java交流1群：335618459</div>
        </div>
        <p class="dpi">我的邮箱:<a href="http://cjm@chenjiaming.com">cjm@chenjiaming.com</a></p>
        <p class="dpi">©2015-2018 版权所有：一叶知秋</p>
        <p class="dpi">备案号：(粤ICP备15009341号-1)</p>
    </div>
</div>
<!--通用弹框开始-->
<%@include file="/common/commonpopup.jsp" %>
<!--通用弹框结束-->
<div id="fanhui" style="display: none;"></div>