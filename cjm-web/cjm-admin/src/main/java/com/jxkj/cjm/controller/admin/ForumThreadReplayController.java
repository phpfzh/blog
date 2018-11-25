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
import com.jxkj.cjm.model.ForumThreadReplyAttach;
import com.jxkj.cjm.model.User;
import com.jxkj.cjm.model.vo.ForumForumVo;
import com.jxkj.cjm.model.vo.ForumThreadReplyAttachVo;
import com.jxkj.cjm.model.vo.ForumThreadReplyVo;
import com.jxkj.cjm.service.ForumThreadReplyAttachService;
import com.jxkj.cjm.service.ForumThreadReplyService;
import com.jxkj.cjm.service.UserService;
import org.springframework.beans.factory.annotation.Value;
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
    private ForumThreadReplyAttachService forumThreadReplyAttachService;

    @Resource
    private UserService userService;

    @Resource
    private CjmJwtTokenComponent cjmJwtTokenComponent;

    @Value("${cjm.fdfs.host}")
    private String fdfsurl;//图片服务器路径

    /**
     * 查询评论审核列表信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
    public AjaxResult list(ForumThreadReplyVo forumThreadReplyVo) {
        try {
            ForumThreadReply forumThreadReply = new ForumThreadReply();
            forumThreadReply.setStatus(-1);
            if (forumThreadReplyVo.getUsername() != null && StringUtil.isNotEmpty(forumThreadReplyVo.getUsername())) {
                Wrapper<User> userWrapper = Condition.create();
                userWrapper.eq("username", forumThreadReplyVo.getUsername().trim());
                User user = userService.selectOne(userWrapper);
                if (user != null) {
                    forumThreadReply.setBaseid(user.getId());
                }
            }

            if (forumThreadReplyVo.getTusername() != null && StringUtil.isNotEmpty(forumThreadReplyVo.getTusername())) {
                Wrapper<User> userWrapper2 = Condition.create();
                userWrapper2.eq("username", forumThreadReplyVo.getTusername().trim());
                User user2 = userService.selectOne(userWrapper2);
                if (user2 != null) {
                    forumThreadReply.setTbaseid(user2.getId());
                }
            }

            if (forumThreadReplyVo.getFirst() != null) {
                forumThreadReply.setFirst(forumThreadReplyVo.getFirst());
            }

            String pageNum = request.getParameter("pageNum");
            String pageSize = request.getParameter("pageSize");
            // 处理分页请求
            Map<String, Object> map = new HashMap<>();
            initPage(map, pageNum, pageSize);
            List<ForumThreadReply> lists = forumThreadReplyService.selectByMap(TransferUtil.beanToMap(forumThreadReply));
            List<ForumThreadReplyVo> voLists = new ArrayList<>();
            for (ForumThreadReply forumThreadReply1 : lists) {
                ForumThreadReplyVo forumThreadReplyVo1 = new ForumThreadReplyVo();
                User user = userService.selectById(forumThreadReply1.getBaseid());
                forumThreadReplyVo1.setId(forumThreadReply1.getId());
                forumThreadReplyVo1.setBaseid(forumThreadReply1.getBaseid());
                forumThreadReplyVo1.setUsername(user.getUsername());
                forumThreadReplyVo1.setTbaseid((long) 0);
                forumThreadReplyVo1.setTusername("");
                forumThreadReplyVo1.setTid(forumThreadReply1.getTid());
                forumThreadReplyVo1.setMessage(forumThreadReply1.getMessage());
                forumThreadReplyVo1.setIsdelete(forumThreadReply1.getIsdelete());
                forumThreadReplyVo1.setStatus(forumThreadReply1.getStatus());
                forumThreadReplyVo1.setFirst(forumThreadReply1.getFirst());
                forumThreadReplyVo1.setDatetime(forumThreadReply1.getDatetime());
                if (forumThreadReply1.getTbaseid() != null) {
                    User tuser = userService.selectById(forumThreadReply1.getTbaseid());
                    forumThreadReplyVo1.setTbaseid(forumThreadReply1.getTbaseid());
                    forumThreadReplyVo1.setTusername(tuser.getUsername());
                }
                List<ForumThreadReplyAttachVo> attLis = getForumThreadReplyAttachVo(forumThreadReply1.getId());
                forumThreadReplyVo1.setAttachs(attLis);
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
     * 查询评论审核列表信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delList", method = {RequestMethod.GET, RequestMethod.POST})
    public AjaxResult delList(ForumThreadReplyVo forumThreadReplyVo) {
        try {
            ForumThreadReply forumThreadReply = new ForumThreadReply();
            forumThreadReply.setIsdelete(0);
            if (forumThreadReplyVo.getUsername() != null && StringUtil.isNotEmpty(forumThreadReplyVo.getUsername())) {
                Wrapper<User> userWrapper = Condition.create();
                userWrapper.eq("username", forumThreadReplyVo.getUsername().trim());
                User user = userService.selectOne(userWrapper);
                if (user != null) {
                    forumThreadReply.setBaseid(user.getId());
                }
            }

            if (forumThreadReplyVo.getTusername() != null && StringUtil.isNotEmpty(forumThreadReplyVo.getTusername())) {
                Wrapper<User> userWrapper2 = Condition.create();
                userWrapper2.eq("username", forumThreadReplyVo.getTusername().trim());
                User user2 = userService.selectOne(userWrapper2);
                if (user2 != null) {
                    forumThreadReply.setTbaseid(user2.getId());
                }
            }

            if (forumThreadReplyVo.getFirst() != null) {
                forumThreadReply.setFirst(forumThreadReplyVo.getFirst());
            }

            if (forumThreadReplyVo.getIsdelete() != null) {
                forumThreadReply.setIsdelete(forumThreadReplyVo.getIsdelete());
            }

            if (forumThreadReplyVo.getStatus() != null) {
                forumThreadReply.setStatus(forumThreadReplyVo.getStatus());
            }

            String pageNum = request.getParameter("pageNum");
            String pageSize = request.getParameter("pageSize");
            // 处理分页请求
            Map<String, Object> map = new HashMap<>();
            initPage(map, pageNum, pageSize);
            List<ForumThreadReply> lists = forumThreadReplyService.selectByMap(TransferUtil.beanToMap(forumThreadReply));
            List<ForumThreadReplyVo> voLists = new ArrayList<>();
            for (ForumThreadReply forumThreadReply1 : lists) {
                ForumThreadReplyVo forumThreadReplyVo1 = new ForumThreadReplyVo();
                User user = userService.selectById(forumThreadReply1.getBaseid());
                forumThreadReplyVo1.setId(forumThreadReply1.getId());
                forumThreadReplyVo1.setBaseid(forumThreadReply1.getBaseid());
                forumThreadReplyVo1.setUsername(user.getUsername());
                forumThreadReplyVo1.setTbaseid((long) 0);
                forumThreadReplyVo1.setTusername("");
                forumThreadReplyVo1.setTid(forumThreadReply1.getTid());
                forumThreadReplyVo1.setMessage(forumThreadReply1.getMessage());
                forumThreadReplyVo1.setIsdelete(forumThreadReply1.getIsdelete());
                forumThreadReplyVo1.setStatus(forumThreadReply1.getStatus());
                forumThreadReplyVo1.setFirst(forumThreadReply1.getFirst());
                forumThreadReplyVo1.setDatetime(forumThreadReply1.getDatetime());
                if (forumThreadReply1.getTbaseid() != null) {
                    User tuser = userService.selectById(forumThreadReply1.getTbaseid());
                    forumThreadReplyVo1.setTbaseid(forumThreadReply1.getTbaseid());
                    forumThreadReplyVo1.setTusername(tuser.getUsername());
                }
                List<ForumThreadReplyAttachVo> attLis = getForumThreadReplyAttachVo(forumThreadReply1.getId());
                forumThreadReplyVo1.setAttachs(attLis);
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
     * 查询评论列表信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "viewList", method = {RequestMethod.GET, RequestMethod.POST})
    public AjaxResult viewList(ForumThreadReplyVo forumThreadReplyVo) {
        try {
            ForumThreadReply forumThreadReply = new ForumThreadReply();

            if (forumThreadReplyVo.getUsername() != null && StringUtil.isNotEmpty(forumThreadReplyVo.getUsername())) {
                Wrapper<User> userWrapper = Condition.create();
                userWrapper.eq("username", forumThreadReplyVo.getUsername().trim());
                User user = userService.selectOne(userWrapper);
                if (user != null) {
                    forumThreadReply.setBaseid(user.getId());
                }
            }

            if (forumThreadReplyVo.getTusername() != null && StringUtil.isNotEmpty(forumThreadReplyVo.getTusername())) {
                Wrapper<User> userWrapper2 = Condition.create();
                userWrapper2.eq("username", forumThreadReplyVo.getTusername().trim());
                User user2 = userService.selectOne(userWrapper2);
                if (user2 != null) {
                    forumThreadReply.setTbaseid(user2.getId());
                }
            }

            if (forumThreadReplyVo.getFirst() != null) {
                forumThreadReply.setFirst(forumThreadReplyVo.getFirst());
            }

            if (forumThreadReplyVo.getIsdelete() != null) {
                forumThreadReply.setIsdelete(forumThreadReplyVo.getIsdelete());
            }

            if (forumThreadReplyVo.getStatus() != null) {
                forumThreadReply.setStatus(forumThreadReplyVo.getStatus());
            }

            String pageNum = request.getParameter("pageNum");
            String pageSize = request.getParameter("pageSize");
            // 处理分页请求
            Map<String, Object> map = new HashMap<>();
            initPage(map, pageNum, pageSize);
            List<ForumThreadReply> lists = forumThreadReplyService.selectByMap(TransferUtil.beanToMap(forumThreadReply));
            List<ForumThreadReplyVo> voLists = new ArrayList<>();
            for (ForumThreadReply forumThreadReply1 : lists) {
                ForumThreadReplyVo forumThreadReplyVo1 = new ForumThreadReplyVo();
                User user = userService.selectById(forumThreadReply1.getBaseid());
                forumThreadReplyVo1.setId(forumThreadReply1.getId());
                forumThreadReplyVo1.setBaseid(forumThreadReply1.getBaseid());
                forumThreadReplyVo1.setUsername(user.getUsername());
                forumThreadReplyVo1.setTbaseid((long) 0);
                forumThreadReplyVo1.setTusername("");
                forumThreadReplyVo1.setTid(forumThreadReply1.getTid());
                forumThreadReplyVo1.setMessage(forumThreadReply1.getMessage());
                forumThreadReplyVo1.setIsdelete(forumThreadReply1.getIsdelete());
                forumThreadReplyVo1.setStatus(forumThreadReply1.getStatus());
                forumThreadReplyVo1.setFirst(forumThreadReply1.getFirst());
                forumThreadReplyVo1.setDatetime(forumThreadReply1.getDatetime());
                if (forumThreadReply1.getTbaseid() != null) {
                    User tuser = userService.selectById(forumThreadReply1.getTbaseid());
                    forumThreadReplyVo1.setTbaseid(forumThreadReply1.getTbaseid());
                    forumThreadReplyVo1.setTusername(tuser.getUsername());
                }

                List<ForumThreadReplyAttachVo> attLis = getForumThreadReplyAttachVo(forumThreadReply1.getId());
                forumThreadReplyVo1.setAttachs(attLis);

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
            forumThreadReplyVo.setUserip(userip);
            Long baseId = Long.valueOf(baseIdStr);
            User user = userService.selectById(baseId);
            ProcessBack processBack = forumThreadReplyService.insertForumThreadReplay(user,forumThreadReplyVo);
            if (processBack.getCode().equals(ProcessBack.FAIL_CODE)) {
                return AjaxResult.failAjaxResult(processBack.getMessage());
            }

            return AjaxResult.successAjaxResult("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);
    }

    //删除
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

    //审核
    @PostMapping("/auditForumThreadReplay")
    @ResponseBody
    public AjaxResult auditForumThreadReplay() {
        try {
            String baseidStr = cjmJwtTokenComponent.getUserBaseId(request);
            String repayIds = request.getParameter("repayIds");
            String status = request.getParameter("status");
            String remark = request.getParameter("remark");

            Long baseid = Long.valueOf(baseidStr);
            ProcessBack processBack = forumThreadReplyService.auditBatchForumThreadReplay(baseid, repayIds, status, remark);
            if (processBack.getCode().equals(ProcessBack.FAIL_CODE)) {
                return AjaxResult.failAjaxResult(processBack.getMessage());
            }

            return AjaxResult.successAjaxResult("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);

    }

    //批量删除
    @PostMapping("/delBatchForumThreadReplay")
    @ResponseBody
    public AjaxResult delBatchForumThreadReplay() {
        try {
            String repayIds = request.getParameter("repayIds");
            ProcessBack processBack = forumThreadReplyService.delBatchForumThreadReplay(repayIds);
            if (processBack.getCode().equals(ProcessBack.FAIL_CODE)) {
                return AjaxResult.failAjaxResult(processBack.getMessage());
            }

            return AjaxResult.successAjaxResult("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);
    }


    private List<ForumThreadReplyAttachVo> getForumThreadReplyAttachVo(Long replyId) {
        ForumThreadReplyAttach attach = new ForumThreadReplyAttach();
        attach.setIsdelete(0);
        attach.setReplyid(replyId);
        attach.setStatus(1);
        List<ForumThreadReplyAttach> ForumThreadReplyAttachList = forumThreadReplyAttachService.selectByMap(TransferUtil.beanToMap(attach));
        List<ForumThreadReplyAttachVo> replyAttachVos = new ArrayList<>();
        for (ForumThreadReplyAttach forumThreadReplyAttach : ForumThreadReplyAttachList) {
            ForumThreadReplyAttachVo forumThreadReplyAttachVo = new ForumThreadReplyAttachVo();
            forumThreadReplyAttachVo.setThumbattach(this.fdfsurl + forumThreadReplyAttach.getThumbattach());
            forumThreadReplyAttachVo.setAttach(this.fdfsurl + forumThreadReplyAttach.getAttach());
            replyAttachVos.add(forumThreadReplyAttachVo);
        }
        return replyAttachVos;
    }
}
