$(function(){

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
 })

function PopupClose(callback){
    $(".popup").fadeOut(300);
    if(callback)callback;
    $("#PopupClose").attr("onclick","PopupClose()");
}

function successPopup(message){
    //替换提示错误图标
    //$("#tishi_common .tishi_text").find("img").attr("src",basePath+"/static/images/ten/shibai.png");
    //替换提示成功图标
    $("#popup_common .popup_text").find("img").attr("src",basePath+"/static/images/ten/chenggong.png");
    //替换提示文字
    $("#popup_common .popup_text .message").text(message);
    //提示弹框
    $(".popup").fadeIn(300)
}

function failPopup(message){
    //替换提示错误图标
    $("#popup_common .popup_text").find("img").attr("src",basePath+"/static/images/ten/shibai.png");
    //替换提示成功图标
    //$("#tishi_common .tishi_text").find("img").attr("src",basePath+"/static/images/ten/chenggong.png");
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
    //$("#tishi_common .tishi_text").find("img").attr("src",basePath+"/static/images/ten/shibai.png");
    //替换提示成功图标
    $("#popup_common_btn .popup_text").find("img").attr("src",basePath+"/static/images/ten/chenggong.png");
    //替换提示文字
    $("#popup_common_btn .popup_text .message").text(message);
    //提示弹框
    $(".popup_xuanze").fadeIn(300)
}

//失败通用提示框带按钮
function failPopupBtn(message){
    //替换提示错误图标
    $("#popup_common_btn .popup_text").find("img").attr("src",basePath+"/static/images/ten/shibai.png");
    //替换提示成功图标
    //$("#tishi_common .tishi_text").find("img").attr("src",basePath+"/static/images/ten/chenggong.png");
    //替换提示文字
    $("#popup_common_btn .popup_text .message").text(message);
    //提示弹框
    $(".popup_xuanze").fadeIn(300)
}