package com.jxkj.cjm.controller.admin;

import com.jxkj.cjm.common.component.CjmJwtTokenComponent;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.common.util.IPUtil;
import com.jxkj.cjm.model.vo.ForumThreadReplyVo;
import com.jxkj.cjm.service.ForumThreadReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 主题评论/回复
 */
@Controller
@RequestMapping("/api/forumThreadReplay")
public class ForumThreadReplayController extends BaseController {

    @Resource
    private ForumThreadReplyService forumThreadReplyService;

    @Resource
    private CjmJwtTokenComponent cjmJwtTokenComponent;

    /**
     * 评论保存
     *
     * @return
     */
    @PostMapping("/insertReplay")
    @ResponseBody
    public AjaxResult insertForumThreadReplay(ForumThreadReplyVo forumThreadReplyVo) {
        try {
            String baseIdStr = cjmJwtTokenComponent.getUserBaseId(request);
            String userip = IPUtil.getIpAdd(request);
            Long baseId = Long.valueOf(baseIdStr);
            ProcessBack processBack = forumThreadReplyService.insertForumThreadReplay(baseId, userip, forumThreadReplyVo);
            if (processBack.getCode().equals(ProcessBack.FAIL_CODE)) {
                return AjaxResult.failAjaxResult(processBack.getMessage());
            }

            return AjaxResult.successAjaxResult("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);
    }

    @PostMapping("/delReplay")
    @ResponseBody
    public AjaxResult delReplay(Long repayId){
        try {
             ProcessBack processBack = forumThreadReplyService.delForumThreadReplay(repayId);
            if (processBack.getCode().equals(ProcessBack.FAIL_CODE)) {
                return AjaxResult.failAjaxResult(processBack.getMessage());
            }

            return AjaxResult.successAjaxResult("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);
    }
}
