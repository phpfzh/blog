<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/cjm.tld" prefix="cjm"%>
<cjm:getNavigation navigationVar="navigationVar" pageSize="7"/>
<script type="text/javascript" src="${basePath}/static/js/geettest/gt.js"></script> 
<script type="text/javascript">
var cjmUserLonged = false;
if(${not empty user}){
	cjmUserLonged = true;
}
//按回车登录
$(function () {
    $(document).keydown(function (e) {
       if (e.keyCode == 13) {
      	 //搜索
      	 var subject = $("#SearchSubject").val();
      	 if(!isEmpty(subject)){
      		searchSubmit();
	        $("#SearchSubject").val('');
      	 }

      	 //登录
      	var username = $("#user_username").val();
       	var password = $("#user_password").val();
       	if(!isEmpty(username) && !isEmpty(password) && !cjmUserLonged){
	         $("#userLogin").click();
      	 }
       }
   });
});
function searchSubmit(obj) {
    var SearchSubject = $("#SearchSubject").val();
    $("#SearchSubjectF").val(SearchSubject);
    $("#SubmitSearchForm").submit();
}

</script>

<form id="SubmitSearchForm" method="post" action="${basePath}/search/list">
        <input name="subject" id = "SearchSubjectF" style="display: none"/>
</form>

<!--头部开始-->
<div id="header">
    <div id="header_box">
        <div class="cjm_nav">
            <div class="img">
                <a href="#">
                    <img src="./static/images/logo.png">
                </a>
            </div>
            <ul>
                <li>
                    <a href="${basePath}">首页</a>
                </li>
                 <c:forEach items="${navigationVar }" var="navigationVar"> 
 	                <li>
	                    <a href="${basePath}/articlelist-${navigationVar.id}-1.html" target="_blank">${navigationVar.name }</a>
	                </li>
                </c:forEach>
             </ul>
        </div>
        <div class="cjm_nav_right">
            <div class="search_box">
                <div class="input">
                    <input type="text" name="subject" id="SearchSubject" value="" placeholder="搜索内容"/>
                    <a href="Javascript:searchSubmit(this)" target="_blank"></a>
                </div>
            </div>
            <div class="logo_box">
 				   <c:choose>
				   		<c:when test="${not empty user}">
				   			<a href="javascript:void(0)" class="head_img">
		                        <img src="./static/images/logo.png">
		                   </a>
		                   <a href="${basePath}/logout">
 		                  	 <span class="logout">退出 </span>
 		                   </a>
				   		</c:when>
				   		<c:otherwise>
				   			    <span class="login"> 登录 &nbsp;</span>
                				<span class="cjm_register"> 注册 </span>
				   		</c:otherwise>
				   </c:choose>
             </div>
         </div>
    </div>
    <!--登录注册弹窗-->
    <div class="zhezhao">
        <div class="bodys">
            <div class="dchu">
                <div><a class="dlactiv" href="###">登录</a></div>
                <div><a class="zche" href="###">注册</a></div>
                <span class="quxiaozc">×</span>
            </div>
            <!---------------------------------------->
            <ul class="denglfuo">
                <li>
                    <input name="" id="user_username" class="phone" type="text" placeholder="请输入手机号/用户名" >
                </li>
                <li>
                    <input name="" id="user_password" type="password" class="input_text_password  mima_dd " placeholder="请输入密码" >
                    <input name="" id="user_password_text" type="text" class="input_text_password  mima_wz" style="display:none;" placeholder="请输入密码" >
                    <a class="eyes_box " data-show="1" href="javascript:void(0);">
                        <i class="bukan"><img src="./static/images/bukanmima.png"/></i>
                        <i class="kan"><img src="./static/images/kanmimma.png"/></i>
                    </a>
                </li>
                <li class="wjma">
                    <div><a class="wjmm" href="###">忘记密码？</a> <span>还没有账号？<a class="zche" href="###">立即注册</a></span></div>
                </li>
                <li class="wjma">
                    <button type="button" id="userLogin">登录</button>
                </li>
            </ul>
            <div class="dldibu">
                <div></div>
                <div>
                    <p>第三方登录</p>
                    <a href="###"><img src="./static/images/qq.png"/></a>
                    <a class="weixdl" href="###"><img src="./static/images/weixin.png"/></a>
                    <a href="###"><img src="./static/images/weibo.png"/></a>
                </div>
                <div></div>
            </div>
        </div>
    </div>
    <!--注册弹窗-->
    <div class="zhezhao1">
        <div class="bodys2">
            <div class="dchu">
                <div><a class="denglxx" href="javascript:void(0)">登录</a></div>
                <div><a class="dlactiv" href="javascript:void(0)">注册</a></div>
                <span class="quxiaozc">×</span>
            </div>
            <!---------------------------------------->
            <div id="userReg_error" style="color:red;text-align: center;margin:15px auto;width:400px;display:none;">
	          	用户名注册后不可修改，汉字，字母数字皆可，5-10位
	       </div>
            <ul class="zhucexs">
                <li>
                    <input name="" class="yhuname" type="text" id="userReg_phone" placeholder="请输入手机号" >
                </li>
                 <li>
		  	         <div id="captcha1">
			            <p id="wait1">正在加载验证码......</p>
			           <!--  <input id="record"/> --><!-- 测试推荐码使用 -->
			        </div>
		         </li>
                <li>
                    <input name="" class="yhuname" type="text" id="userReg_code" placeholder="请输入短信验证码" >
                    <button class="fszyc" id="btns">发送验证码</button>
                </li>
                <li>
                    <input name="" type="password" id="userReg_password" class="input_text_password hder mima_dd " placeholder="输入密码(数字，字母皆可，最低6位)" >
                    <input name="" type="text" id="userReg_password_text"  class="input_text_password hder mima_wz" style="display:none;" placeholder="输入密码(数字，字母皆可，最低6位)" >
                    <a class="eyes_box" id="eyes_box_reg" data-show="1" href="javascript:void(0);">
                        <i class="bukan"><img src="./static/images/bukanmima.png"/></i>
                        <i class="kan"><img src="./static/images/kanmimma.png"/></i>
                    </a>
                </li>
                <li>
                    <input type="text" class="bashiss" name="" id="userReg_username" placeholder="输入用户名"/>
                    <p>*用户名注册后不可修改，汉字，字母数字皆可，5-10位</p>
                </li>
                <li class="zcmim">
                    <button type="button" id="userReg_submit">注册</button>
                </li>
            </ul>

        </div>
    </div>
    <!--忘记密码弹窗-->
    <div class="zhezhao2">
        <div class="bodys3">
            <div class="dchu heitad">
                <p class="wjimx">忘记密码</p>
                <span class="quxiaozc">×</span>
            </div>
            <!---------------------------------------->

            <ul class="zhaohui">
                <li>
                    <span>输入手机号码</span>
                    <div>
                        <input type="text" name="" value="" placeholder="请输入您的手机号码" />
                    </div>
                    <p class="tishiwben">*输入手机号不存在</p>
                </li>
                <li>
                    <span>验证码</span>
                    <div>
                        <input type="text" name="" value="" placeholder="请输入验证码" />
                        <button class="fszyc" id="btnss" href="###">发送验证码</button>
                    </div>
                </li>
                <li>
                    <span>设置新密码</span>
                    <ul>
                        <li>
                            <input name="" type="password" class="input_text_password  mima_dd " placeholder="数字，字母皆可至少6位" >
                            <input name="" type="text" class="input_text_password  mima_wz" style="display:none;" placeholder="数字，字母皆可至少6位" >
                            <a class="eyes_box " data-show="1" href="javascript:void(0);">
                                <i class="bukan"><img src="./static/images/bukanmima.png"/></i>
                                <i class="kan"><img src="./static/images/kanmimma.png"/></i>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
            <div class="isOk">
                <button type="button">确认</button>
            </div>
        </div>
    </div>
</div>
<!--头部结束-->