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
        <div class="nav_right">
            <div class="search_box">
                <div class="input">
                    <input type="text" name="subject" id="subject" value="" placeholder="搜索内容"/>
                    <a href="Javascript:void(0)" target="_blank"></a>
                </div>
            </div>
            <div class="logo_box">

               <span class="login"> 登录 &nbsp;</span>
                <span class="register"> 注册 </span>

                   <%--<a href="javascript:void(0)" class="head_img">
                        <img src="/static/images/logo.png">
                   </a>
                   <span class="logout"> 退出 </span>--%>
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
                    <input name="" class="phone" type="text" placeholder="请输入手机号/用户名" >
                </li>
                <li>
                    <input name="" type="password" class="input_text_password  mima_dd " placeholder="请输入密码" >
                    <input name="" type="text" class="input_text_password  mima_wz" style="display:none;" placeholder="请输入密码" >
                    <a class="eyes_box " data-show="1" href="javascript:void(0);">
                        <i class="bukan"><img src="/static/images/bukanmima.png"/></i>
                        <i class="kan"><img src="/static/images/kanmimma.png"/></i>
                    </a>
                </li>
                <li class="wjma">
                    <div><a class="wjmm" href="###">忘记密码？</a> <span>还没有账号？<a class="zche" href="###">立即注册</a></span></div>
                </li>
                <li class="wjma">
                    <button type="button">登录</button>
                </li>
            </ul>
            <div class="dldibu">
                <div></div>
                <div>
                    <p>第三方登录</p>
                    <a href="###"><img src="/static/images/qq.png"/></a>
                    <a class="weixdl" href="###"><img src="/static/images/weixin.png"/></a>
                    <a href="###"><img src="/static/images/weibo.png"/></a>
                </div>
                <div></div>
            </div>
        </div>
    </div>
    <!--注册弹窗-->
    <div class="zhezhao1">
        <div class="bodys2">
            <div class="dchu">
                <div><a class="denglxx" href="###">登录</a></div>
                <div><a class="dlactiv" href="###">注册</a></div>
                <span class="quxiaozc">×</span>
            </div>
            <!---------------------------------------->
            <ul class="zhucexs">
                <li>
                    <input name="" class="yhuname" type="text" placeholder="请输入手机号/用户名" >
                </li>
                <li>
                    <input name="" class="yhuname" type="text" placeholder="请输入手机号" >
                    <button class="fszyc" id="btns" href="###">发送验证码</button>
                </li>
                <li>
                    <input name="" type="password" class="input_text_password hder mima_dd " placeholder="输入密码(数字，字母皆可，最低6位)" >
                    <input name="" type="text" class="input_text_password hder mima_wz" style="display:none;" placeholder="输入密码(数字，字母皆可，最低6位)" >
                    <a class="eyes_box " data-show="1" href="javascript:void(0);">
                        <i class="bukan"><img src="/static/images/bukanmima.png"/></i>
                        <i class="kan"><img src="/static/images/kanmimma.png"/></i>
                    </a>
                </li>
                <li>
                    <input type="text" class="bashiss" name=""  placeholder="输入用户名" value="BUS999-巴士FAN" />
                    <p>*默认用户名可修改，汉字，字母数字皆可，5-10位</p>
                </li>
                <li class="zcmim">
                    <button type="button">注册</button>
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
                                <i class="bukan"><img src="/static/images/bukanmima.png"/></i>
                                <i class="kan"><img src="/static/images/kanmimma.png"/></i>
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