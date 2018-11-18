package com.jxkj.cjm.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.common.util.IPUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.model.ForumThread;
import com.jxkj.cjm.model.vo.ForumThreadVo;
import com.jxkj.cjm.model.vo.FriendlinkVo;
import com.jxkj.cjm.service.ForumForumService;
import com.jxkj.cjm.service.ForumPostService;
import com.jxkj.cjm.service.ForumThreadService;
import com.jxkj.cjm.service.ForumThreadTagService;
import com.jxkj.cjm.service.FriendlinkService;

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
    private FriendlinkService friendlinkService;

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

        //友情链接
        List<FriendlinkVo> friendlinkVos = friendlinkService.getIndexFriendlinkVosByType(1);
        //常用站点
        List<FriendlinkVo> linkVos = friendlinkService.getIndexFriendlinkVosByType(2);

        model.addAttribute("pagehelper", pagehelper);
        model.addAttribute("voLists", voLists);
        model.addAttribute("hotVoLists", hotVoLists);
        model.addAttribute("friendlinkVos", friendlinkVos);
        model.addAttribute("linkVos", linkVos);
        return "index";
    }
      
    /**
     * 添加浏览数
     * @param model
     * @param tid
     */
    @RequestMapping(value = "/viewCountAdd", method = RequestMethod.GET)
    public void article(Long tid) {
        String userip = "";
        try {
            userip = IPUtil.getIpAdd(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //添加主题浏览记录
        forumThreadService.addForumThreadView(tid, userip, null);
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
