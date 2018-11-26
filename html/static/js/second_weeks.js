$(function(){

    // 产品资源页面标签切换
    $(".label_page_undertake .label_page_each").hide().eq(0).show()
    $(".label_nav_undertake h4").click(
        function(){
            var k=$(this).index()
            $(".label_nav_undertake h4").removeClass("on")
            $(this).addClass("on")
            $(".label_page_undertake .label_page_each").hide().eq(k).fadeIn(1000)
        }
    )
    
    //侧边栏手风琴
    $(".sidebar_list_dt").on("click",function () {
        $('.sidebar_list_dd').stop();
        $(this).siblings("dt").removeAttr("id");
        if($(this).attr("id")=="open"){
            $(this).removeAttr("id").siblings("dd").slideUp();
        }else{
            $(this).attr("id","open").next().slideDown().siblings("dd").slideUp();
        }
    });

    // 个人中心页面标签
    $(".label_page .label_page_each").hide().eq(0).show()
    $(".label_nav h4").click(
        function(){
            var k=$(this).index()
            $(".label_nav h4").removeClass("on")
            $(this).addClass("on")
            $(".label_page .label_page_each").hide().eq(k).fadeIn(1000)
        }
    );

    // 五星评价
    $(".show_number li p").each(function(index, element) {
        var num=$(this).attr("tip");
        var www=num*2*12;//
        $(this).css("width",www);
        $(this).parent(".atar_Show").siblings("span").text(num+"分");
    });

    //手机号修改弹框
    $(".number").on('click',function(){
        $(".register_frame").fadeIn(300)
    })
    //手机号修改弹框关闭
    $(".close").on("click",function(){ 
        $(".register_frame").fadeOut(300)
    })

    //原手机号验证码
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
                $(obj).text("(" + countdown + ") s后重新发");
                countdown--;
            }
            setTimeout(function() {
                        settime(obj) }
                    ,1000)
        }
    }
    $("#number_buts").click(function(){
        new invokeSettime("#number_buts"); 
    }) 

    //修改手机验证码
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
                $(obj).text("(" + countdown + ") s后重新发");
                countdown--;
            }
            setTimeout(function() {
                        settime(obj) }
                    ,1000)
        }
    }
    $("#number_butss").click(function(){
        new invokeSettime("#number_butss"); 
    }) 


    // 身份证号码隐藏中间几位
    var tel = $('.id_number').html();
    var mtel = tel.substr(0, 6) + '********' + tel.substr(14);
    $('.id_number').text(mtel);

    //手机号修改弹框
    $(".password").on('click',function(){ 
        $(".register_frame2").fadeIn(300)
    })
    //手机号修改弹框关闭
    $(".close").on("click",function(){ 
        $(".register_frame2").fadeOut(300)
    })

    //查看密码
 	$(".eyes_boxs").click(function(){ if($(this).attr("data-show")==1){
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

     //修改密码手机验证码
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
                $(obj).text("(" + countdown + ") s后重新发");
                countdown--;
            }
            setTimeout(function() {
                        settime(obj) }
                    ,1000)
        }
    }
    $("#number_butsss").click(function(){
        new invokeSettime("#number_butsss"); 
    }) 
})



