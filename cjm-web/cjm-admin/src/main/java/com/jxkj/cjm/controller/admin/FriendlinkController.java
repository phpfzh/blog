package com.jxkj.cjm.controller.admin;

import com.jxkj.cjm.common.component.CjmJwtTokenComponent;
import com.jxkj.cjm.common.controller.AbstractVoBaseController;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.Friendlink;
import com.jxkj.cjm.model.vo.FriendlinkVo;
import com.jxkj.cjm.service.FriendlinkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Auther: cjm
 * @Date: 2018/8/22 22:50
 * @Description:
 * @ClassName: FriendlinkController
 */
@Controller
@RequestMapping("/api/friendlink")
public class FriendlinkController extends AbstractVoBaseController<Friendlink,FriendlinkVo> {

    @Resource
    private FriendlinkService friendlinkService;

    @Resource
    private CjmJwtTokenComponent cjmJwtTokenComponent;

    @Override
    public AjaxResult preSaveEntity(Friendlink friendlink, FriendlinkVo friendlinkVo) {
        String baseIdStr = cjmJwtTokenComponent.getUserBaseId(request);
        friendlinkVo.setBaseid(Long.valueOf(baseIdStr));
        if(friendlinkVo.getType() == null){
            friendlinkVo.setType(1);
        }
        Long dateline = System.currentTimeMillis();
        friendlinkVo.setDateline(dateline);
        return super.preSaveEntity(friendlink, friendlinkVo);
    }

    @Override
    public AjaxResult preUpdateEntity(Friendlink friendlink, FriendlinkVo friendlinkVo) {
        String baseIdStr = cjmJwtTokenComponent.getUserBaseId(request);
        friendlinkVo.setUpdateid(Long.valueOf(baseIdStr));

        Long dateline = System.currentTimeMillis();
        friendlinkVo.setUpdateline(dateline);
        return super.preUpdateEntity(friendlink, friendlinkVo);
    }

}
