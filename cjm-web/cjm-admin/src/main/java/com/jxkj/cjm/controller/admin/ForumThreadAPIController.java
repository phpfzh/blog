package com.jxkj.cjm.controller.admin;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.component.CjmJwtTokenComponent;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.Meta;
import com.jxkj.cjm.common.util.IPUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.common.util.TransferUtil;
import com.jxkj.cjm.model.ForumForum;
import com.jxkj.cjm.model.ForumThread;
import com.jxkj.cjm.model.User;
import com.jxkj.cjm.model.vo.ForumForumVo;
import com.jxkj.cjm.model.vo.ForumPostVo;
import com.jxkj.cjm.model.vo.ForumThreadVo;
import com.jxkj.cjm.service.ForumForumService;
import com.jxkj.cjm.service.ForumPostService;
import com.jxkj.cjm.service.ForumThreadService;
import com.jxkj.cjm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cjm
 * @version 1.0
 * www.chenjiaming.com
 * @ClassName: ForumThreadAPIController
 * @Description: TODO  主题信息保存
 * @date 2018年6月3日
 */
@Controller
@RequestMapping("/api/forumThreadApi")
public class ForumThreadAPIController extends BaseController {

    @Resource
    private ForumThreadService forumThreadService;

    @Resource
    private ForumPostService forumPostService;

    @Resource
    private UserService userService;

    @Resource
    private ForumForumService forumForumService;

    @Resource
    private CjmJwtTokenComponent cjmJwtTokenComponent;

    /**
     * 查询板块列表信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "forumList", method = {RequestMethod.GET, RequestMethod.POST})
    public AjaxResult forumList() {
        try {
            ForumForum forumForum = new ForumForum();
            String pageNum = request.getParameter("pageNum");
            String pageSize = request.getParameter("pageSize");
            forumForum.setIsdelete(0);
            forumForum.setStatus(1);//状态1显示0不显示
             // 处理分页请求
            Map<String, Object> map = new HashMap<>();
            initPage(map, pageNum, pageSize);
            PageHelper.orderBy("sort DESC");
            List<ForumForum> lists = forumForumService.selectByMap(TransferUtil.beanToMap(forumForum));
            List<ForumForumVo> voLists = new ArrayList<>();
            for(ForumForum forumForum1 :lists ){
                ForumForumVo forumForumVo = new ForumForumVo();
                forumForumVo.setId(forumForum1.getId());
                forumForumVo.setName(forumForum1.getName());
                forumForumVo.setSort(forumForum1.getSort());
                forumForumVo.setThreads(forumForum1.getThreads());
                forumForumVo.setCommonts(forumForum1.getCommonts());
                voLists.add(forumForumVo);
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
     * 查询帖子列表信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
    public AjaxResult list() {
        try {
            ForumThread forumThread = new ForumThread();
            String fid = request.getParameter("fid");
            String pageNum = request.getParameter("pageNum");
            String pageSize = request.getParameter("pageSize");
            forumThread.setIsdelete(0);
            forumThread.setStatus(0);
            if (fid != null && StringUtil.isNotEmpty(fid)) {
                forumThread.setFid(Long.valueOf(fid));
            }

            // 处理分页请求
            Map<String, Object> map = new HashMap<>();
            initPage(map, pageNum, pageSize);
            PageHelper.orderBy("dateline DESC,replies DESC,views DESC");
            List<ForumThread> lists = forumThreadService.selectByMap(TransferUtil.beanToMap(forumThread));
            List<ForumThreadVo> voLists = new ArrayList<>();
            for (ForumThread entity1 : lists) {
                ForumThreadVo en = new ForumThreadVo();
                User user = userService.selectById(entity1.getBaseid());
                ForumForum forumForum = forumForumService.selectById(entity1.getFid());
                ForumPostVo forumPostVo = forumPostService.getForumPostByTid(entity1.getId());
                String Headurl = user.getImg() == null ? "" : user.getImg();
                String threadTypeName = "原创";
                if(entity1.getThreadtype() != null && entity1.getThreadtype().equals(2)){
                    threadTypeName = "转载";
                }else if(entity1.getThreadtype() != null && entity1.getThreadtype().equals(3)){
                    threadTypeName = "翻译";
                }
                en.setUsername(user.getUsername());//用户名
                en.setSubject(entity1.getSubject());//标题
                en.setDateline(entity1.getDateline());//时间戳
                en.setThreadtype(entity1.getThreadtype());//主题类型
                en.setFname(forumForum.getName());//板块名称
                en.setId(entity1.getId());//tid
                en.setHeadurl(Headurl);//用户头像地址
                en.setViews(entity1.getViews());//浏览数
                en.setReplies(entity1.getReplies());//回复数
                en.setFid(entity1.getFid());//板块id
                en.setBaseid(entity1.getBaseid());//用户id
                en.setThreadtypename(threadTypeName);
                if (forumPostVo != null) {
                    en.setContent(forumPostVo.getContent());
                }
                voLists.add(en);
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
     * 主题浏览
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/forumThreadView")
    public AjaxResult forumThreadView() {
        try {
            String tidStr = request.getParameter("tid");
            if (StringUtil.isEmpty(tidStr)) {
                return AjaxResult.failAjaxResult("tid 不能为空");
            }

            Long baseid = null;
            try {
                String baseIdStr = cjmJwtTokenComponent.getUserBaseId(request);
                baseid = Long.valueOf(baseIdStr);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Long tid = Long.valueOf(tidStr);
            String userip = IPUtil.getIpAdd(request);
            ForumPostVo forumPostVo = forumPostService.getForumPostByTid(tid);
            if (forumPostVo == null) {
                throw new IllegalArgumentException("未找到帖子信息");
            }

            if (forumPostVo.getIsdelete().equals(1)) {//是否删除1是0否
                AjaxResult ajaxResult = new AjaxResult();
                ajaxResult.setCode("22");
                ajaxResult.setMessage("该帖子已删除或正在审核中");
                return ajaxResult;
            }

            if(baseid != null && baseid.equals(forumPostVo.getBaseid())){
                //是作者本人则不判断是否审核状态
                forumThreadService.addForumThreadView(tid, userip, baseid);
                return AjaxResult.successAjaxResult(forumPostVo);
            }

            if (!(forumPostVo.getStatus().equals(0))) {//状态-1审核中 -2审核失败 0审核通过
                AjaxResult ajaxResult = new AjaxResult();
                ajaxResult.setCode("22");
                ajaxResult.setMessage("该帖子已删除或正在审核中");
                return ajaxResult;
            }

            forumThreadService.addForumThreadView(tid, userip, baseid);
            return AjaxResult.successAjaxResult(forumPostVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);
    }

}
