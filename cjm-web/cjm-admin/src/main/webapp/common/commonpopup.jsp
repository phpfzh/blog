<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="popup" id="popup_common">
    <div class="reward">
        <div class="reward_title">
            <div class="float_l border_l"></div>
            <p class="float_l">提示</p>
            <a onclick="PopupClose()" id="PopupClose">
                <img class="float_r cursor" src="${basePath}/static/images/close.png">
            </a>
            <div class="clear"></div>
        </div>
        <div class="popup_text">
            <img class="" src="${basePath}/static/images/ten/chenggong.png">
            <p class="message lan">提交申请成功！</p>
            <div class="clear"></div>
        </div>
        <%-- <div class="tishi_text">
            <img class="float_l" src="${basePath}/static/images/ten/shibai.png">
            <p class="float_l hong">您已经提交过申请了！</p>
            <div class="clear"></div>
        </div> --%>
    </div>
</div>


<div class="popup_xuanze" id="popup_common_btn">
    <div class="reward">
        <div class="reward_title">
            <div class="float_l border_l"></div>
            <p class="float_l">提示</p>
            <a onclick="PopupBtnClose()" id="PopupBtnClose">
                <img class="float_r cursor close" src="${basePath}/static/images/close.png">
            </a>
            <div class="clear"></div>
        </div>
        <div class="popup_text">
            <img class="" src="${basePath}/static/images/ten/chenggong.png">
            <p class="lan message">发布成功，帖子正在审核</p>
            <div class="clear"></div>
        </div>
        <!-- <div class="tishi_text">
				<img class="" src="${basePath}/static/images/ten/shibai.png">
				<p class="hong">您已经提交过申请了！</p>
				<div class="clear"></div>
			</div> -->
        <a href="javascript:void(0)" class="float_l queren" id="popup_common_btn_confirm" onclick="commonBtnConfirm()">确认</a>
        <a href="javascript:void(0)" class="float_l qvxiao" id="popup_common_btn_cancel" onclick="PopupBtnClose()">取消</a>
    </div>
</div>