$(function () {

    //菜单展开/收起
    function opene() {
        $(".find_fication li").each(function (index) {
            if (index > 2) {
                $(this).slideToggle(300);
            }
        })
    }
    $(".plat_condition .find_button").click(function () {
        opene();
        $(this).toggleClass("hover");
        var text = $(this).find("a").text();
        if (text == "展开全部筛选条件") {
            $(this).find("a").text("收起全部筛选条件");
        } else if (text == "收起全部筛选条件") {
            $(this).find("a").text("展开全部筛选条件");
        }
    });


    //tab切换代码
    $(".comcate_news .news_bd").hide().eq(0).show()
    $(".comcate_title li").click(
        function () {
            var k = $(this).index()
            $(".comcate_title li").removeClass("morenew")
            $(this).addClass("morenew")
            $(".comcate_news .news_bd").hide().eq(k).fadeIn(500)
        }
    )
 
   $(".leave_message .bot_all .bot_reply").click(function () {
        opene();
        $(this).toggleClass("hover");
        var text = $(this).find("span").text();
        if (text == "收起回复") {
            $(this).find("span").text("回复TA");
        } else if (text == "回复TA") {
            $(this).find("span").text("收起回复");
        }
    });
 
    // 基本资料填写页面上传图片和发送验证码js代码

        $(".del").on("click", function () {
            $("input").attr("value", "");
            console.log(123)
            $(this).parent().find(".pic").attr("src", "images/first_week/touming.png")
            $(this).css('display', "none")
            $(this).parent().find(".chkan").css('display', "none")
        })
        $(".chkan").on("click", function () {
            $(this).parent().find(".nban").css("display", "block")
        })
        $(".nban").on("click", function () {
            $(this).css("display", "none")
        })
        //撸主申请验证码
        function invokeSettime(obj) {
            var countdown = 60;
            settime(obj);

            function settime(obj) {
                if (countdown == 0) {
                    $(obj).attr("disabled", false);
                    $(obj).text("获取验证码");
                    countdown = 60;
                    return;
                } else {
                    $(obj).attr("disabled", true);
                    $(obj).text("(" + countdown + ") s后重新发送");
                    countdown--;
                }
                setTimeout(function () {
                    settime(obj)
                }, 1000)
            }
        }
        $("#btn").click(function () {
            new invokeSettime("#btn");
        })

        //上传图片js
        $(function () {
            $(".pic").click(function () {
                $(this).parent().find(".upload").click(); //隐藏了input:file样式后，点击头像就可以本地上传

                $(this).parent().find(".upload").on("change", function () {
                    var objUrl = getObjectURL(this.files[0]); //获取图片的路径，该路径不是图片在本地的路径
                    if (objUrl) {
                        setTimeout(() => {
                            $(this).parent().find(".del").css("display", "block");
                            $(this).parent().find(".chkan").css('display', "block");
                        }, 1500);
                        $(this).parent().find(".pic").attr("src", objUrl); //将图片路径存入src中，显示出图片
                        $(this).parent().find(".pid").attr("src", objUrl);
                    }
                });
            });
        });

        function getObjectURL(file) {
            var url = null;
            if (window.createObjectURL != undefined) { // basic
                url = window.createObjectURL(file);
            } else if (window.URL != undefined) { // mozilla(firefox)
                url = window.URL.createObjectURL(file);
            } else if (window.webkitURL != undefined) { // webkit or chrome
                url = window.webkitURL.createObjectURL(file);
            }
            return url;
        }


        // 打赏弹框金额选择
        $(".label_money .class").click(
            function(){
                var k=$(this).index()
                $(".label_money .class").removeClass("class_on")
                $(this).addClass("class_on")
            }
        )
 
        // 购买广告位数量加减
        $("input[type='number']").InputSpinner()
        $("input.small").InputSpinner({groupClass: "input-group-sm"})
        $("input.large").InputSpinner({groupClass: "input-group-lg"})


        // 打赏弹框金额选择
        $(".label_money2 .class").click(
            function(){
                var k=$(this).index()
                $(".label_money2 .class").removeClass("class_on")
                $(this).addClass("class_on")
            }
        )

        // 验证码
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
    $("#tourist_buts").click(function(){
        new invokeSettime("#tourist_buts"); 
    }) 

    

})