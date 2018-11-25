//评论表情包下拉
$(function () {
        var lanren = {
            face: function (_this) {
                var target = $(_this).html();
                if (target.length < 5) {
                    $(_this).html("<img src='static/images/face/" + target + ".gif' />")
                }
            },
            faceimg: '',
            imgs: function (min, max) {
                for (i = min; i < max; i++) { //通过循环创建60个表情，可扩展
                    lanren.faceimg +=
                        '<li><a href="javascript:void(0)"><img src="static/images/face/' +
                        (i + 1) + '.gif" face="[emt]' + (i + 1) +
                        '[/emt]"/></a></li>';
                };
            },
            cur: 0
        }

        $('.list li emt').each(function () {
            lanren.face(this);
        });
        
        //图片上传
        $(".faces_img").click(function () {
            $(this).parent().find(".upload").click(); //隐藏了input:file样式后，点击头像就可以本地上传
         });
         
        $('.send .faces').on('click', function () {
            if (lanren.cur == 0) {
                $(this).addClass('on');
                lanren.cur = 1;
                $('.face').show(0);
            } else if (lanren.cur == 1) {
                $(this).removeClass('on');
                $('.face').hide(0);
                lanren.cur = 0;
            }
        })

        lanren.imgs(0, 60);
        $('.face').append(lanren.faceimg);
        //回复主题选择表情
        $('.face li img').on('click', function () {
            var target = $(this).attr('face');
            var htmls = $('.send textarea').val();
            $('.send textarea').val(htmls + target);
            $(this).parents('.face').hide(0);
            $('.send .faces').removeClass('on');
            lanren.cur = 0;
        })
})
 

//首次表情包下拉
$(function () {
        var lanren = {
            face: function (_this) {
                var target = $(_this).html();
                if (target.length < 5) {
                    $(_this).html("<img src='static/images/face/" + target + ".gif' />")
                }
            },
            faceimg: '',
            imgs: function (min, max) {
                for (i = min; i < max; i++) { //通过循环创建60个表情，可扩展
                    lanren.faceimg +=
                        '<li><a href="javascript:void(0)"><img src="static/images/face/' +
                        (i + 1) + '.gif" faceone="[emt]' + (i + 1) +
                        '[/emt]"/></a></li>';
                };
            },
            cur: 0
        }

        $('.list li emt').each(function () {
            lanren.face(this);
        });
         
        $('.send .faces').on('click', function () {
            if (lanren.cur == 0) {
                $(this).addClass('on');
                lanren.cur = 1;
                $('.face').show(0);
            } else if (lanren.cur == 1) {
                $(this).removeClass('on');
                $('.face').hide(0);
                lanren.cur = 0;
            }
        })
   
        //首次回复显示
        $(".leave_message .leave_bot .bot_reply").click(function () {
            //opene();
            $(this).toggleClass("hover");
            var text = $(this).find("span").text();
            if (text == "收起回复") {
                $(this).find("span").text("回复");
            } else if (text == "回复") {
                $(this).find("span").text("收起回复");
            }
            //显示回复框
             var $leavemessage = $(this).parent(".leave_bot").parent(".leave_message");
             $($leavemessage).find(".pil_report_post_box").toggle();
        });
        
        //控制表情框显示
        $('.bus_example .smille').on('click', function () {
            if (lanren.cur == 0) {
                $(this).addClass('on');
                lanren.cur = 1;
                $('.faceone').show(0);
            } else if (lanren.cur == 1) {
                $(this).removeClass('on');
                $('.faceone').hide(0);
                lanren.cur = 0;
            }
        })
        
        //首次回复选择表情
        lanren.imgs(0, 60);
        $('.faceone').append(lanren.faceimg);
        $('.faceone li img').on('click', function () {
            var target = $(this).attr('faceone');
            var $leavezudi = $(this).parents(".leave_zudi");
            //$($leavezudi).css({"color":"red","background":"red"})
            var htmls = $($leavezudi).find('.bus_example .textarea').text();
            $($leavezudi).find('.bus_example .textarea').text(htmls + target);
            $(this).parents('.faceone').hide(0);
            $($leavezudi).find('.bus_example .smille').removeClass('on');
            lanren.cur = 0;
        })
 })

//多次回复表情包下拉
$(function () {
           //显示多次回复框
         $("#bus_allreply_box .bot_all .bot_reply span").on("click",function(){
         	 var  $reautoly = $(this).parents(".re_autoly");
        	 //$($reautoly).css({"color":"red","background":"red"})
        	 $($reautoly).find(".leave_new").toggle();
         });
        
        //多次回复选择表情
         $('.facemany li img').on('click', function () {
            var target = $(this).attr('faceone');
            var $leavenew  = $(this).parents(".leave_new");
            //$($leavenew).css({"color":"red","background":"red"})
            var htmls = $($leavenew).find('.bus_example .textarea').text();
            $($leavenew).find('.bus_example .textarea').text(htmls + target);
            $(this).parents('.faceone').hide(0);
            $($leavenew).find('.bus_example .smille').removeClass('on');
            lanren.cur = 0;
        })
        
        //多次回复发布
        $('.wdb_many_reply_box .bus_example a.point').on('click', function () {
        	if(!wdbUserLonged){
          		//用户登录
         		UserLoginObj.loginShow();
        		return;
        	}
         	var $busexample = $(this).parents(".bus_example");
        	//$($busexample).css({"color":"red","background":"red"})
            var content = $($busexample).find('.textarea').text();
            if (!content) {
                alert('发布内容不能为空');
                $($busexample).find('.textarea').focus();
                return false;
            }
            var divid = $($busexample).data("divid");
            var parentid = $($busexample).data("opid");
            var dataObj = {};
            dataObj.cid = $("#wdb_tid").data("tid");
            dataObj.message = content;
            dataObj.typeid = 1;
            dataObj.parentid = parentid;
            
            var action = basePath+"/user/preReplay/save";
            var callback = function(data){
            	if(data == "logout"){
            		//登录
            		UserLoginObj.loginShow();
            		return;
            	}
             	alert(data.meta.message);
             	if(data.meta.code == "88"){
             		$($busexample).find('.textarea').text('');
             		var toHtml = "";
             		if(data.data.fusername != null){
             			toHtml = joinManyHtml(data.data);
             		}else{
             			toHtml = joinReplyHtml(data.data);
             		}
              		$("#wdb_leave_reply_box_"+divid).prepend(toHtml);
            		$('#wdb_re_autoly_box_'+data.data.id)[0].scrollIntoView(true);
            	}
            }
            $.post(action,dataObj,callback);
        });        
})

//回复主题
function repayOneSubmit(obj){
	if(!cjmUserLonged){
  		//用户登录
 		UserLoginObj.loginShow();
		return;
	}
	
    var content = $('.send textarea').val();
    if (!content) {
    	failPopup('发布内容不能为空');
        return false;
    }
    
    var dataObj = {};
    dataObj.tid = $("#pil_id").data("opid");
    dataObj.message = content;
    dataObj.replytype = 1;
    var action = basePath+"/user/forumThreadReply/save";
    var callback = function(data){
     	if(data == "logout"){
      		//登录
     		UserLoginObj.loginShow();
    		return;
    	}
    	console.log(JSON.stringify(data))
      	if(data.code == "88"){
     		successPopup("回复正在审核中...")
    		$('.send textarea').val('');
    		var toHtml = joinCommontHtml(data.data);
    		$("#bus_allreply_box").prepend(toHtml);
    		$('#pil_leave_message_box_'+data.data.id)[0].scrollIntoView(true);
    	}else{
    		failPopup(data.message);
    	}
    }
    $.post(action,dataObj,callback);
}

//回复评论
function repayTwoSubmit(obj){
     if(!cjmUserLonged){
  		//用户登录
 		UserLoginObj.loginShow();
		return;
	}
     
	var $busexample = $(obj).parents(".bus_example");
	//$($busexample).css({"color":"red","background":"red"})
    var content = $($busexample).find('.textarea').text();
    if (!content) {
    	failPopup('发布内容不能为空');
        $($busexample).find('.textarea').focus();
        return false;
    }
    var parentid = $(obj).data("parentopid");
    var dataObj = {};
    dataObj.tid = $("#pil_id").data("opid");
    dataObj.message = content;
    dataObj.replytype = 1;
    dataObj.parentid = parentid;
    
    var action = basePath+"/user/forumThreadReply/save";
    var callback = function(data){
    	if(data == "logout"){
    		//登录
    		UserLoginObj.loginShow();
    		return;
    	}
    	console.log(JSON.stringify(data))
      	if(data.code == "88"){
     		successPopup("回复正在审核中...");
     		$($busexample).find('.textarea').text('');
    		var toHtml = joinReplyHtml(data.data);
    		$("#pil_child_leave_message_box_"+parentid).prepend(toHtml);
    		$('#pil_leave_message_box_'+data.data.id)[0].scrollIntoView(true);
    	}else{
    		failPopup(data.message);
    	}
    }
    $.post(action,dataObj,callback);
}

//多次回复
function repayManySubmit(obj){
     if(!cjmUserLonged){
  		//用户登录
 		UserLoginObj.loginShow();
		return;
	}
     
	var $busexample = $(obj).parents(".bus_example");
	//$($busexample).css({"color":"red","background":"red"})
    var content = $($busexample).find('.textarea').text();
    if (!content) {
    	failPopup('发布内容不能为空');
        $($busexample).find('.textarea').focus();
        return false;
    }
    var parentid = $(obj).data("parentopid");
    var parentboxopid = $(obj).data("parentboxopid");
    var dataObj = {};
    dataObj.tid = $("#pil_id").data("opid");
    dataObj.message = content;
    dataObj.replytype = 1;
    dataObj.parentid = parentid;
    
    var action = basePath+"/user/forumThreadReply/save";
    var callback = function(data){
    	if(data == "logout"){
    		//登录
    		UserLoginObj.loginShow();
    		return;
    	}
    	console.log(JSON.stringify(data))
      	if(data.code == "88"){
     		successPopup("回复正在审核中...");
     		$($busexample).find('.textarea').text('');
    		var toHtml = joinManyHtml(data.data,parentboxopid);
    		$("#pil_child_leave_message_box_"+parentboxopid).prepend(toHtml);
    		$('#pil_leave_message_box_'+data.data.id)[0].scrollIntoView(true);
    	}else{
    		failPopup(data.message);
    	}
    }
    $.post(action,dataObj,callback);
}


//图片上传
function uploadimage(fileThis){
	var fileObj = $(fileThis)[0].files[0];
	if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
          return;
    }
 
	var formFile = new FormData();
	formFile.append("upfile", fileObj); //加入文件对象
	var action = basePath+"/user/forumThreadReply/uploadimage";
		$.ajax({
        url: action,
        data: formFile,
        type: "Post",
        cache: false,//上传文件无需缓存
        processData: false,//// 告诉jQuery不要去处理发送的数据
        contentType: false, //告诉jQuery不要去设置Content-Type请求头
        success: function (data) {
        	if(data == "logout"){
        		//登录
        		UserLoginObj.loginShow();
        		return;
        	}
        	console.log(JSON.stringify(data))
         	if(data.code == "88"){
        		 var htmls = $('.send textarea').val();
                 $('.send textarea').val(htmls + data.data.attach);
        	}else{
         		failPopup(data.message);
        	}
         }
    })
}

function joinManyHtml(valObj,parentboxopid){
	var html = "<div class='re_autoly' id='pil_leave_message_box_"+valObj.id+"'>"+
               "     <h3>"+valObj.username+"<span>回复</span>"+valObj.fusername+"</h3>"+
               "     <p style='widht:100%;height:100%;word-wrap: break-word'>"+valObj.message+""+
               "     </p>"+
               "     <div class='bot_all'>"+
               "         <div class='bot_reply reply4 fr'>"+
               "             <span>回复TA</span>"+
               "         </div>"+
               "         <div class='bot_report fr'>"+
               "             <a href='javascript:void(0)'>举报 &nbsp;|&nbsp;"+valObj.datestr+"&nbsp;&nbsp;</a>"+
               "         </div>"+
               "         <div class='clear'></div>"+
               "     </div>"+
               "      <div class='leave_new open4' style='display:none;'>"+
               "         <div class='bus_example'>"+
               "             <div class='textarea' contenteditable='true'></div>"+
               "             <div class='re_all'>"+
               "                 <a href='javascript:void(0)' class='point' onclick='repayManySubmit(this)'  data-parentopid='"+valObj.id+"' data-parentboxopid='"+parentboxopid+"'>发布</a>"+
               "                 <a href='javascript:void(0)' class='smille'></a>"+
               "             <div class='clear'></div>"+
               "             </div>"+
               "         </div>"+
               "         <div class='faceone facemany w500'></div>"+
               "     </div>"+
               "</div>";
	return html;
}

function joinReplyHtml(valObj){
	var html = "<div class='re_autoly' id='pil_child_leave_message_box_"+valObj.id+"'>"+
               "     <h3>"+valObj.username+"</h3>"+
               "     <p style='widht:100%;height:100%;word-wrap: break-word'>"+valObj.message+"</p>"+
               "     <div class='bot_all'>"+
               "         <div class='bot_reply fr reply3'>"+
               "             <span>回复TA</span>"+
               "         </div>"+
               "         <div class='bot_report fr'>"+
               "             <a href=''>举报 &nbsp;|&nbsp; "+valObj.datestr+"&nbsp;&nbsp;</a>"+
               "         </div>"+
               "         <div class='clear'></div>"+
               "     </div>"+
               "     <div class='leave_new open3' style='display:none;'>"+
               "         <div class='bus_example'>"+
               "             <div class='textarea' contenteditable='true'></div>"+
               "             <div class='re_all'>"+
               "                 <a href='javascript:void(0)' class='point' data-parentopid='"+valObj.id+"' onclick='repayTwoSubmit(this)'>发布</a>"+
               "                 <a href='javascript:void(0)' class='smille'></a>"+
               "             <div class='clear'></div>"+
               "             </div>"+
               "         </div>"+
               "         <div class='faceone w500'></div>"+
               "     </div>"+
               " </div>";
	return html;
}


function joinCommontHtml(valObj){
	var toHtml =  "<div class='leave_message' id='pil_leave_message_box_"+valObj.id+"'>"+
	"    <!-- 首次回复 开始 -->"+
	"    <div class='leave_top'>"+
	"		<div class='top_img fl'>"+
	"		    <img src='"+valObj.headurl+"' width='60' height='60'>"+
	"		</div>"+
	"		<div class='top_js fl'>"+
	"		    <h3>"+valObj.username+"</h3>"+
	"		    <span>"+valObj.signature+"</span>"+
	"		    <p style='widht:100%;height:100%;word-wrap: break-word'>"+valObj.message+"</p>"+
		"		</div>"+
	"		<div class='clear'></div>"+
	" </div>"+
	"<!-- 首次回复 开始 -->"+
		"<div class='leave_bot'>"+
	"	<div class='bot_reply fl'>"+
	"	    <!--<a href='#'>-->"+
	"	    <span>回复</span>"+
	"	    <!--</a>-->"+
	"	</div>"+
	"	<div class='bot_report fl'>"+
	"	    <a href='javascript:void(0)'>举报 &nbsp;|&nbsp; "+valObj.datestr+"&nbsp;&nbsp;</a>"+
	"	</div>"+
	"	<div class='clear'></div>"+
	"   </div>"+
	"    <div class='leave_zudi' style='display:none;'>"+
	"	<div class='bus_example w500'>"+
	"	    <div class='textarea' contenteditable='true'></div>"+
	"	    <a href='javascript:void(0);' class='point' onclick='repayTwoSubmit(this)' data-parentopid='"+valObj.id+"'>发布</a>"+
	"	    <a href='javascript:void(0);' class='smille'></a>"+
	"	</div>"+
	"	<div class='faceone w500'>"+
	"	</div>"+
		"  </div>"+
		"    <div class='clear'></div>"+
	"</div>";
	return toHtml;
}

//var objUrl = getObjectURL(this.files[0]); //获取图片的路径，该路径不是图片在本地的路径
function getObjectURL(file) {
	alert(JSON.stringify(file))
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

