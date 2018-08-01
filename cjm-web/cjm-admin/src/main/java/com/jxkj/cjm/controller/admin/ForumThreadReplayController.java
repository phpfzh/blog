package com.jxkj.cjm.controller.admin;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.component.CjmJwtTokenComponent;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.common.util.IPUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.common.util.TransferUtil;
import com.jxkj.cjm.model.ForumForum;
import com.jxkj.cjm.model.ForumThreadReply;
import com.jxkj.cjm.model.User;
import com.jxkj.cjm.model.vo.ForumForumVo;
import com.jxkj.cjm.model.vo.ForumThreadReplyVo;
import com.jxkj.cjm.service.ForumThreadReplyService;
import com.jxkj.cjm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主题评论/回复
 */
@Controller
@RequestMapping("/api/forumThreadReplay")
public class ForumThreadReplayController extends BaseController {

    @Resource
    private ForumThreadReplyService forumThreadReplyService;


    @Resource
    private UserService userService;

    @Resource
    private CjmJwtTokenComponent cjmJwtTokenComponent;

    /**
     * 查询评论列表信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
    public AjaxResult list(ForumThreadReplyVo forumThreadReplyVo) {
        try {
            ForumThreadReply forumThreadReply = new ForumThreadReply();

            if (forumThreadReplyVo.getUsername() != null && StringUtil.isNotEmpty(forumThreadReplyVo.getUsername())) {
                Wrapper<User> userWrapper = Condition.create();
                userWrapper.eq("username",forumThreadReplyVo.getUsername().trim());
                User user = userService.selectOne(userWrapper);
                if(user != null){
                    forumThreadReply.setBaseid(user.getId());
                }
            }

            if (forumThreadReplyVo.getTusername() != null && StringUtil.isNotEmpty(forumThreadReplyVo.getTusername())) {
                Wrapper<User> userWrapper2 = Condition.create();
                userWrapper2.eq("username",forumThreadReplyVo.getTusername().trim());
                User user2 = userService.selectOne(userWrapper2);
                if(user2 != null){
                    forumThreadReply.setTbaseid(user2.getId());
                }
            }

            String pageNum = request.getParameter("pageNum");
            String pageSize = request.getParameter("pageSize");
            // 处理分页请求
            Map<String, Object> map = new HashMap<>();
            initPage(map, pageNum, pageSize);
            List<ForumThreadReply> lists = forumThreadReplyService.selectByMap(TransferUtil.beanToMap(forumThreadReply));
            List<ForumThreadReplyVo> voLists = new ArrayList<>();
            for(ForumThreadReply forumThreadReply1:lists){
                ForumThreadReplyVo forumThreadReplyVo1 = new ForumThreadReplyVo();
                User user = userService.selectById(forumThreadReply1.getBaseid());
                forumThreadReplyVo1.setBaseid(forumThreadReply1.getBaseid());
                forumThreadReplyVo1.setUsername(user.getUsername());
                forumThreadReplyVo1.setTbaseid((long)0);
                forumThreadReplyVo1.setTusername("");
                forumThreadReplyVo1.setTid(forumThreadReply1.getTid());
                forumThreadReplyVo1.setMessage(forumThreadReply1.getMessage());
                forumThreadReplyVo1.setIsdelete(forumThreadReply1.getIsdelete());
                forumThreadReplyVo1.setStatus(forumThreadReply1.getStatus());
                forumThreadReplyVo1.setFirst(forumThreadReply1.getFirst());
                if(forumThreadReply1.getTbaseid() != null){
                    User tuser = userService.selectById(forumThreadReply1.getTbaseid());
                    forumThreadReplyVo1.setTbaseid(forumThreadReply1.getTbaseid());
                    forumThreadReplyVo1.setTusername(tuser.getUsername());
                }
                voLists.add(forumThreadReplyVo1);
            }
            PageInfo<Object> pagehelper = initPagehelper(map, lists);
            Map<String, Object> ha = new HashMap<>();
            ha.put("list", voLists);
            ha.put("total", pagehelper.getTotal());
            return AjaxResult.successAjaxResult(ha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);
    }


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
    public AjaxResult delReplay(Long repayId) {
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
