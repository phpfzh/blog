$(function(){

    // 骗返押金管理页面标签切换
    $(".cheat_back_page .cheat_back_each").hide().eq(0).show()
    $(".label_cheat_back h4").click(
        function(){
            var k=$(this).index()
            $(".label_cheat_back h4").removeClass("on")
            $(this).addClass("on")
            $(".cheat_back_page .cheat_back_each").hide().eq(k).fadeIn(1000)
        }
    )
    // 骗返押金管理页面支付方式切换
    $(".label_money h4").click(
        function(){
            var k=$(this).index()
            $(".label_money h4").removeClass("on")
            $(this).addClass("on")
        }
    )

    // 骗返押金管理页面验证码
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


    // 骗返押金管理页面标签切换
    $(".label_cheat_my h4").click(
        function(){
            var k=$(this).index()
            $(".label_cheat_my h4").removeClass("on")
            $(this).addClass("on")
        }
    )

    // 产品申报页面标签切换
    $(".label_declaration h4").click(
        function(){
            var k=$(this).index()
            $(".label_declaration h4").removeClass("on")
            $(this).addClass("on")
        }
    )

    // 系统清算弹框
    $(function(){
        $(".xtqs").on('click',function(){ 
            $(".register_frame").fadeIn(300)
        })
        //关闭弹框
        $(".close").on("click",function(){ 
            $(".register_frame").fadeOut(300)
        })
    })

    // 产品申报页面标签切换
    $(".attention_page .attention_each").hide().eq(0).show()
    $(".label_attention h4").click(
        function(){
            var k=$(this).index()
            $(".label_attention h4").removeClass("on")
            $(this).addClass("on")
            $(".attention_page .attention_each").hide().eq(k).fadeIn(1000)
        }
    )

    // 系统清算弹框
    $(function(){
        $(".cztankuang").on('click',function(){ 
            $(".register_frame").fadeIn(300)
        })
        //关闭弹框
        $(".close").on("click",function(){ 
            $(".register_frame").fadeOut(300)
        })
    })

    // 身份证号码隐藏中间几位
    var tel = $('.id_sfz').html();
    var mtel = tel.substr(0, 4) + '****' + tel.substr(14);
    $('.id_sfz').text(mtel);

    // 身份证号码隐藏中间几位
    var tel = $('.id_bank').html();
    var mtel = tel.substr(0, 0) + '**** **** **** **** ' + tel.substr(16);
    $('.id_bank').text(mtel);

    // 身份证号码隐藏中间几位
    var tel = $('.shengfeng').html();
    var mtel = tel.substr(0, 4) + '***********' + tel.substr(15);
    $('.shengfeng').text(mtel);


  

})

// 全选
function selectAll(){ 
    console.log(1);
    console.log($("#checkall").prop("checked"));
    if ($("#checkall").prop("checked")) { 
        console.log(2);           
        $("input[type='checkbox'][name='checkedres']").prop("checked",true);//全选
    } else { 
        console.log(3);               
        $("input[type='checkbox'][name='checkedres']").prop("checked",false);  //取消全选     
    }  
}  
//子复选框的事件  
function setSelectAll(){  
    //当没有选中某个子复选框时，SelectAll取消选中  
    if (!$("#checkedres").checked) {  
        $("#checkall").prop("checked", false);  
    }  
    var chsub = $("input[type='checkbox'][name='checkedres']").length; //获取subcheck的个数  
    var checkedsub = $("input[type='checkbox'][name='checkedres']:checked").length; //获取选中的subcheck的个数  
    if (checkedsub == chsub) {  
        $("#checkall").prop("checked", true);  
    }  
}


