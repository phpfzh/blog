package com.jxkj.cjm.controller;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.common.util.DateUtils;
import com.jxkj.cjm.common.util.IPUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.model.ForumForum;
import com.jxkj.cjm.model.ForumThread;
import com.jxkj.cjm.model.vo.ForumPostVo;
import com.jxkj.cjm.model.vo.ForumThreadTagVo;
import com.jxkj.cjm.model.vo.ForumThreadVo;
import com.jxkj.cjm.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Auther: cjm
 * @Date: 2018/8/18 17:14
 * @Description:
 * @ClassName: IndexHomeController
 */
@Controller
public class IndexHomeController extends BaseController {

    @Resource
    private ForumThreadService forumThreadService;

    @Resource
    private ForumPostService forumPostService;

    @Resource
    private ForumForumService forumForumService;

    @Resource
    private ForumThreadTagService forumThreadTagService;

    @Value("${cjm.fdfs.host}")
    private String fdfsurl;//图片服务器路径

    @RequestMapping(value = "/")
    public String home(Model model) {
        ForumThread forumThread = new ForumThread();
        String fid = request.getParameter("fid");
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        String orderType = request.getParameter("orderType");
        forumThread.setIsdelete(0);
        forumThread.setStatus(0);
        PageInfo pagehelper = null;
        List<ForumThreadVo> voLists = null;
        if (fid != null && StringUtil.isNotEmpty(fid)) {
            forumThread.setFid(Long.valueOf(fid));
        }

        ProcessBack processBack = forumThreadService.getForumThreads(pageNum, pageSize, orderType, forumThread);
        if (processBack.getCode().equals(ProcessBack.SUCCESS_CODE)) {
            Map<String, Object> map = (Map<String, Object>) processBack.getData();
            pagehelper = (PageInfo) map.get("pagehelper");
            voLists = (List<ForumThreadVo>) map.get("voLists");
        }

        //点击排行
        List<ForumThreadVo> hotVoLists = forumThreadService.getForumThreadsByViewOrder("1", "10");
        model.addAttribute("pagehelper", pagehelper);
        model.addAttribute("voLists", voLists);
        model.addAttribute("hotVoLists", hotVoLists);
        return "index";
    }

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(Model model) {
        ForumThread forumThread = new ForumThread();
        String fid = request.getParameter("fid");
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        String orderType = request.getParameter("orderType");
        forumThread.setIsdelete(0);
        forumThread.setStatus(0);
        PageInfo pagehelper = null;
        List<ForumThreadVo> voLists = null;
        if (fid != null && StringUtil.isNotEmpty(fid)) {
            forumThread.setFid(Long.valueOf(fid));
        }

        ProcessBack processBack = forumThreadService.getForumThreads(pageNum, pageSize, orderType, forumThread);
        if (processBack.getCode().equals(ProcessBack.SUCCESS_CODE)) {
            Map<String, Object> map = (Map<String, Object>) processBack.getData();
            pagehelper = (PageInfo) map.get("pagehelper");
            voLists = (List<ForumThreadVo>) map.get("voLists");
        }

        //点击排行
        List<ForumThreadVo> hotVoLists = forumThreadService.getForumThreadsByViewOrder("1", "10");
        model.addAttribute("pagehelper", pagehelper);
        model.addAttribute("voLists", voLists);
        model.addAttribute("hotVoLists", hotVoLists);
        return "index";
    }

    /**
     * 详情页
     *
     * @return
     */
    @RequestMapping(value = "/article/{tid}", method = RequestMethod.GET)
    public String article(Model model, @PathVariable("tid") Long tid) {
        try {
            Long baseid = null;//获取当前用户
            ProcessBack processBack = forumThreadService.getSingleForumThreadByTid(tid, baseid, request);
            if (processBack.getCode().equals(ProcessBack.FAIL_CODE)) {
                model.addAttribute("message", "文章已删除或正在审核中");
                return "articleerror";
            }

            ForumThreadVo en = (ForumThreadVo) processBack.getData();
            if (en.getIsdelete().equals(1)) {//是否删除1是0否
                model.addAttribute("message", "文章已删除或正在审核中");
                return "articleerror";
            }
            model.addAttribute("en", en);
            if (baseid != null && baseid.equals(en.getBaseid())) {
                //是作者本人则不判断是否审核状态
                return "article";
            }

            if (!(en.getStatus().equals(0))) {//状态-1审核中 -2审核失败 0审核通过
                model.addAttribute("message", "文章已删除或正在审核中");
                return "articleerror";
            }
            return "article";
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("message", "文章已删除或正在审核中");
        return "articleerror";
    }

    /**
     * 获取默认封面图片
     *
     * @return
     */
    private String getDefaultCoverimg() {
        String coverimg = "group1/M00/00/01/rBKphltr9JqAM-ouAABQzi7kwNo368.jpg";
        return coverimg;
    }
}
