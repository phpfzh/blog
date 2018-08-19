<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!--头部开始-->
<div id="header">
    <div id="header_box">
        <div class="nav">
            <div class="img">
                <a href="#">
                    <img src="${basePath}/static/images/logo.png">
                </a>
            </div>
            <ul>
                <li>
                    <a href="${basePath}">首页</a>
                </li>
                <li>
                    <a href="javascript:void(0)">Java</a>
                </li>
                <li>
                    <a href="javascript:void(0)">Golang</a>
                </li>
                <li>
                    <a href="javascript:void(0)">前端</a>
                </li>
                <li>
                    <a href="javascript:void(0)">关于我</a>
                </li>
                <li>
                    <a href="javascript:void(0)">其他</a>
                </li>
            </ul>
        </div>
        <div class="login">
            <ul>
                <li>
                     <a href="#">
                         登录
                     </a>
                 </li>
                 <li>
                     <a href="#">
                         注册
                     </a>
                 </li>


            </ul>

            <!--登录后-->
           <%-- <div class="logined">
                <a href="#" class="ulogo">
                    <img src="${basePath}/static/images/logo.png">
                </a>
                <a href="#" class="logout">
                    退出
                </a>
            </div>--%>

        </div>
    </div>
</div>
<!--头部结束-->