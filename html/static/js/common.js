$(function(){
	// 用户登录
	$("#userLogin").click(function() {
		var UserLoginForwar = $("#UserLoginForwar").val();
		var username = $("#user_username").val();
 		var password = $("#user_password").val();
		var showData = $("#userLogin_eyes_box").data("show");
		if (showData == 2) {
			// 显式密码
			password = $("#user_password_text").val();
		}
		var action = basePath + "/login";
		$("#userLogin").text("登录中...");
		var callback = function(data) {
			$("#userLogin").text("登录");
			if (data.code == "88") {
				setTimeout(function() {
					// 关闭弹框
					$(".zhezhao").fadeOut(300);
					var referrerVl = document.referrer;
 					if(UserLoginForwar.length > 0){
						window.location.href = UserLoginForwar;
					}else if(referrerVl.length > 0){
						window.location.href = referrerVl;
					}else{
						window.location.href = basePath + "/";
					}
				}, 200)
			} else {
				alert(data.message);
 			}

		}
		$.post(action, {
			"username" : username,
			"password" : password
		}, callback);
	});

	// 注册 发送短信验证码
	$("#btns").click(function() {
		$("#userReg_error").text("").hide();
		var phone = $("#userReg_phone").val();
		var action = basePath + "/sendSms";
		var callback = function(data) {
			console.log(data);
			$("#userReg_error").text("").hide();
			if (data.code == "88") {
				invokeSettime("#btns");
			} else {
				$("#userReg_error").text(data.message).show();
 			}
		}
		$.post(action, {
			"mobile" : phone
		}, callback);
	});
	 
	// 注册
	$("#userReg_submit").click(function() {
		$("#userReg_error").text("").hide();
 		var phone = $("#userReg_phone").val();
		var code = $("#userReg_code").val();
		var password = $("#userReg_password").val();
		var username = $("#userReg_username").val();
		if(isEmpty(phone)){
			$("#userReg_error").text("手机号不能为空").show();
			$("#userReg_phone").focus();
 			return ;
		}
		
		if(!is_cellphoneNum(phone)){
			$("#userReg_error").text("手机号格式不正确").show();
			$("#userReg_phone").focus();
 			return ;
		} 
		
		if(isEmpty(code)){
			$("#userReg_error").text("验证码不能为空").show();
			$("#userReg_code").focus();
 			return ;
		}
		
		if(isEmpty(password)){
			$("#userReg_error").text("密码不能为空").show();
			$("#userReg_password").focus();
 			return ;
		}
		
		if(!is_password(password)){
			$("#userReg_error").text("密码需包含数字和英文,且不能少于6位").show();
			$("#userReg_password").focus();
 			return ;
		}
		
		if(isEmpty(username)){
			$("#userReg_error").text("用户名不能为空").show();
			$("#userReg_username").focus();
 			return ;
		}
		
		if(username.length < 5){
			$("#userReg_error").text("用户名不能低于5位").show();
			$("#userReg_username").focus();
 			return ;
		}
		 
		var action = basePath + "/register";
		$("#userReg_submit").text("注册中...");
		var callback = function(data) {
			$("#userReg_submit").text("注册");
			$("#userReg_error").text("").hide();
			if (data.code == "88") {
				setTimeout(function() {
					$(".zhezhao").fadeOut(300);
 					// 关闭弹框
					window.location.href = basePath + "/";
  				}, 200)
			} else {
 				$("#userReg_error").text(data.message).show();

			}
		}
		$.post(action, {
			"username" : username,
			"mobile" : phone,
			"password" : password,
			"code" : code
		}, callback);
	});
	
	// 忘记密码 发送短信验证码
	$("#btnss").click(function() {
		var phone = $("#ftp_phone").val();
		var action = basePath + "/ftpSendSms";
		var callback = function(data) {
			console.log(data);
			if (data.code == "88") {
				 invokeSettime("#btnss"); //60秒倒计时
			} else {
				alert(data.message);
			}
		}
		$.post(action, {
			"mobile" : phone
		}, callback);
	});

	// 忘记密码提交
	$("#ftp_submit").click(function() {
		var phone = $("#ftp_phone").val();
		var code = $("#ftp_code").val();
		var password = $("#ftp_password").val();
		 if(!is_password(password)){
			alert("密码需包含数字和英文,且不能少于6位");
			return ;
		}
		var action = basePath + "/ftpRevisePassword";
		$("#ftp_submit").text("修改中...");
		var callback = function(data) {
			$("#ftp_submit").text("确认");
			if (data.code == "88") {
				setTimeout(function() {
					// 关闭弹框
					$(".zhezhao").fadeOut(300);
					alert(data.message);
					window.location.href = basePath + "/";  //跳转登录弹框
				}, 200)
			} else {
				alert(data.message);
			}
		}
		$.post(action, {
			"mobile" : phone,
			"password" : password,
			"code" : code
		}, callback);
	});

    var mySwiper = new Swiper('.son1 .swiper-container',{ //轮播图
        spaceBetween :0,
        loadPrevNext: true,
        autoplay :5000,
        pagination: '.son1 .swiper-pagination',
        loop:true,
        speed:1000,
        autoplayDisableOnInteraction : false,
        prevButton:'.son1 .swiper-button-prev',
        nextButton:'.son1 .swiper-button-next',
    });

    var mySwiper = new Swiper('.son2 .swiper-container',{ //多列切换
        spaceBetween :0,
        loadPrevNext: true,
        autoplay :20000,
        loop:true,
        pagination: '.son2 .swiper-pagination',
        speed:1000,
        autoplayDisableOnInteraction : false,
        prevButton:'.yiqer .swiper-button-prev',
        nextButton:'.yiqer .swiper-button-next',
        uniqueNavElements :false,
    });
    //查看密码
    $(".eyes_box").click(function(){ if($(this).attr("data-show")==1){
        //明文
        $(this).attr("data-show","2");
        $(this).children(".kan").css("display","block");
        $(this).children(".bukan").css("display","none");
        $(this).parent("li").children(".mima_dd").hide();
        $(this).parent("li").children(".mima_wz").show();
        $(this).parent("li").children(".mima_wz").val($(this).parent("li").children(".mima_dd").val());
        return;
    }
        if($(this).attr("data-show")==2){
            //密文
            $(this).attr("data-show","1");
            $(this).children(".kan").css("display","none");
            $(this).children(".bukan").css("display","block");
            $(this).parent("li").children(".mima_dd").show(); $(this).parent("li").children(".mima_wz").hide();
            $(this).parent("li").children(".mima_dd").val($(this).parent("li").children(".mima_wz").val());
            return; }
    });

    $(".uls li").on("click",function(){
        var inx=$(this).index();
        $(this).addClass("activr").siblings().removeClass('activr');
        $('.dispno').eq(inx).addClass('xblack').siblings().removeClass('xblack')
    })
    $(".bsx").on("click",function(){
        var inx=$(this).index();
        $(this).addClass("mactiv").siblings().removeClass('mactiv');
        $('.nozshi').eq(inx).addClass('xblackx').siblings().removeClass('xblackx')
    })
    $(".fyeqi li").on("click",function(){
        $(this).addClass("fyactive").siblings().removeClass('fyactive');
        console.log(123)
    })

//登录弹窗
    $(".login").on('click',function(){
        $(".zhezhao").fadeIn(300)
    })
//关闭登录
    $(".quxiaozc").on("click",function(){
        $(".zhezhao").fadeOut(300)
    })
//立即注册
    $(".zche").on('click',function(){
        $(".zhezhao").fadeOut(100)
        $(".zhezhao1").fadeIn(100)
    })

//注册弹窗
    $(".cjm_register").on('click',function(){
        $(".zhezhao1").fadeIn(300)
    })
//关闭注册
    $(".quxiaozc").on("click",function(){
        $(".zhezhao1").fadeOut(300)
    })
//点击登录
    $(".denglxx").on('click',function(){
        $(".zhezhao1").fadeOut(100)
        $(".zhezhao").fadeIn(100)
    })

//忘记密码
    $('.wjmm').on('click',function(){
        $(".zhezhao2").fadeIn(100)
        $(".zhezhao").fadeOut(100)
    })
//关闭找回密码
    $(".quxiaozc").on("click",function(){
        $(".zhezhao2").fadeOut(300)
    })

//撸主申请验证码
    function invokeSettime(obj){
        var countdown=60;
        settime(obj);
        function settime(obj) {
            if (countdown == 0) {
                $(obj).attr("disabled",false);
                $(obj).text("获取验证码");
                countdown = 60;
                return;
            } else {
                $(obj).attr("disabled",true);
                $(obj).text("(" + countdown + ") s后重新发送");
                countdown--;
            }
            setTimeout(function() {
                    settime(obj) }
                ,1000)
        }
    }
    $("#btns").click(function(){
        new invokeSettime("#btns");
    })
//找回密码验证码
    function invokeSettime(obj){
        var countdown=60;
        settime(obj);
        function settime(obj) {
            if (countdown == 0) {
                $(obj).attr("disabled",false);
                $(obj).text("获取验证码");
                countdown = 60;
                return;
            } else {
                $(obj).attr("disabled",true);
                $(obj).text("(" + countdown + ") s后重新发送");
                countdown--;
            }
            setTimeout(function() {
                    settime(obj) }
                ,1000)
        }
    }
    $("#btnss").click(function(){
        new invokeSettime("#btnss");
    })
		//failPopupBtn("成功了");

	function gotoTop(min_height){
		//预定义返回顶部的html代码，它的css样式默认为不显示
		var gotoTop_html = '<div id="gotoTop">返回顶部</div>';
		//将返回顶部的html代码插入页面上id为page的元素的末尾
		$("#page").append(gotoTop_html);
		$("#fanhui").click(//定义返回顶部点击向上滚动的动画
			function(){$('html,body').animate({scrollTop:0},700);
			});
		//获取页面的最小高度，无传入值则默认为600像素
		min_height ? min_height = min_height : min_height = 600;
		 //为窗口的scroll事件绑定处理函数
		$(window).scroll(function(){
			//获取窗口的滚动条的垂直位置
			var s = $(window).scrollTop();
			//当窗口的滚动条的垂直位置大于页面的最小高度时，让返回顶部元素渐现，否则渐隐
			if( s > min_height){
				$("#fanhui").fadeIn(100);
			}else{
				$("#fanhui").fadeOut(200);
			};
		});
	};
	gotoTop();
 })


var UserLoginObj = {
	//显示登录框
 	loginShow:function(){
 		var url = document.location;
 		console.log(url);
 		$("#UserLoginForwar").val(url);
 		$(".zhezhao").fadeIn(300);
	}
 }

function PopupClose(callback){
    $(".popup").fadeOut(300);
    if(callback)callback;
    $("#PopupClose").attr("onclick","PopupClose()");
}

function successPopup(message){
    //替换提示错误图标
    //$("#tishi_common .tishi_text").find("img").attr("src","./static/images/fail.png");
    //替换提示成功图标
    $("#popup_common .popup_text").find("img").attr("src","./static/images/success.png");
    //替换提示文字
    $("#popup_common .popup_text .message").text(message);
    //提示弹框
    $(".popup").fadeIn(300)
}

function failPopup(message){
    //替换提示错误图标
    $("#popup_common .popup_text").find("img").attr("src","./static/images/fail.png");
    //替换提示成功图标
    //$("#tishi_common .tishi_text").find("img").attr("src","./static/images/success.png");
    //替换提示文字
    $("#popup_common .popup_text .message").text(message);
    //提示弹框
    $(".popup").fadeIn(300)
}

function PopupBtnClose(callback){
    $(".popup_xuanze").fadeOut(300);
    if(callback)callback;
    $("#PopupBtnClose").attr("onclick","PopupBtnClose()");
}

//成功通用提示框带按钮
function successPopupBtn(message){
    //替换提示错误图标
    //$("#tishi_common .tishi_text").find("img").attr("src","./static/images/fail.png");
    //替换提示成功图标
    $("#popup_common_btn .popup_text").find("img").attr("src","./static/images/success.png");
    //替换提示文字
    $("#popup_common_btn .popup_text .message").text(message);
    //提示弹框
    $(".popup_xuanze").fadeIn(300)
}

//失败通用提示框带按钮
function failPopupBtn(message){
    //替换提示错误图标
    $("#popup_common_btn .popup_text").find("img").attr("src","./static/images/fail.png");
    //替换提示成功图标
    //$("#tishi_common .tishi_text").find("img").attr("src","./static/images/success.png");
    //替换提示文字
    $("#popup_common_btn .popup_text .message").text(message);
    //提示弹框
    $(".popup_xuanze").fadeIn(300)
}

/*密码格式*/
function is_password(str){ 
    var regExp = /^(?=.*[a-zA-Z])(?=.*[\d]).{6,16}$/;
    return regExp.test(str);
}

function is_cellphoneNum(str){
    var regExp = /^(\+86)?(13|18|15|17)\d{9}(?!\d)$/;
    return regExp.test(str);
}

function isEmpty(val) {
	val = $.trim(val);
	if (val == null)
		return true;
	if (val == undefined || val == 'undefined')
		return true;
	if (val == "")
		return true;
	if (val.length == 0)
		return true;
	if (!/[^(^\s*)|(\s*$)]/.test(val))
		return true;
	return false;
}

