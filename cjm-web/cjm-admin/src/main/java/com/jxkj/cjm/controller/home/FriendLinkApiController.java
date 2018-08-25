package com.jxkj.cjm.controller.home;

import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.model.vo.FriendlinkVo;
import com.jxkj.cjm.service.FriendlinkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: cjm
 * @Date: 2018/8/25 12:13
 * @Description:
 * @ClassName: FriendLinkApiController
 */
@Controller
@RequestMapping("/friendlink")
public class FriendLinkApiController extends BaseController {
    @Resource
    private FriendlinkService friendlinkService;

    @RequestMapping("list")
    @ResponseBody
    public AjaxResult list(Integer type) {
        try {
            List<FriendlinkVo> vos = friendlinkService.getIndexFriendlinkVosByType(type);
            return AjaxResult.successAjaxResult("查询成功", vos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult("查询失败");
    }
}
