package com.jxkj.cjm.controller.home;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.component.CjmJwtTokenComponent;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.util.IPUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.common.util.TransferUtil;
import com.jxkj.cjm.model.*;
import com.jxkj.cjm.model.vo.ForumForumVo;
import com.jxkj.cjm.model.vo.ForumPostVo;
import com.jxkj.cjm.model.vo.ForumThreadTagVo;
import com.jxkj.cjm.model.vo.ForumThreadVo;
import com.jxkj.cjm.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

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
    private ForumThreadTagService forumThreadTagService;

    @Resource
    private ForumThreadTagLinkService forumThreadTagLinkService;

    @Resource
    private CjmJwtTokenComponent cjmJwtTokenComponent;

    @Value("${cjm.fdfs.host}")
    private String fdfsurl;//图片服务器路径

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
            for (ForumForum forumForum1 : lists) {
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
            String orderType = request.getParameter("orderType");
            forumThread.setIsdelete(0);
            forumThread.setStatus(0);
            if (fid != null && StringUtil.isNotEmpty(fid)) {
                forumThread.setFid(Long.valueOf(fid));
            }
            PageHelper.orderBy(null);
            if (orderType != null && StringUtil.isNotEmpty(orderType)) {
                if (orderType.equals("views")) {//
                    PageHelper.orderBy("views DESC,replies DESC,dateline DESC");
                } else if (orderType.equals("replies")) {
                    PageHelper.orderBy("replies DESC,views DESC,dateline DESC");
                } else {
                    PageHelper.orderBy("dateline DESC,replies DESC,views DESC");
                }
            } else {
                PageHelper.orderBy("dateline DESC,replies DESC,views DESC");
            }
            // 处理分页请求
            Map<String, Object> map = new HashMap<>();
            initPage(map, pageNum, pageSize);
            List<ForumThread> lists = forumThreadService.selectByMap(TransferUtil.beanToMap(forumThread));
            List<ForumThreadVo> voLists = new ArrayList<>();
            for (ForumThread entity1 : lists) {
                ForumThreadVo en = new ForumThreadVo();
                User user = userService.selectById(entity1.getBaseid());
                ForumForum forumForum = forumForumService.selectById(entity1.getFid());
                ForumPostVo forumPostVo = forumPostService.getForumPostByTid(entity1.getId());
                String threadTypeName = "原创";
                if (entity1.getThreadtype() != null && entity1.getThreadtype().equals(2)) {
                    threadTypeName = "转载";
                } else if (entity1.getThreadtype() != null && entity1.getThreadtype().equals(3)) {
                    threadTypeName = "翻译";
                }
                en.setUsername(user.getUsername());//用户名
                en.setSubject(entity1.getSubject());//标题
                en.setDateline(entity1.getDateline());//时间戳
                en.setThreadtype(entity1.getThreadtype());//主题类型
                en.setFname(forumForum.getName());//板块名称
                en.setId(entity1.getId());//tid
                en.setHeadurl(forumPostVo.getHeadurl());//用户头像地址
                en.setViews(entity1.getViews());//浏览数
                en.setReplies(entity1.getReplies());//回复数
                en.setFid(entity1.getFid());//板块id
                en.setBaseid(entity1.getBaseid());//用户id
                en.setThreadtypename(threadTypeName);
                String comme = entity1.getCoverimg();
                if (StringUtil.isEmpty(comme)) {
                    comme = getDefaultCoverimg();
                }
                en.setCoverimg(this.fdfsurl + comme);
                /*if (forumPostVo != null) {
                    en.setContent(forumPostVo.getContent());
                }*/
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
     * 查询标签列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "hotTagList", method = {RequestMethod.POST, RequestMethod.GET})
    public AjaxResult hotTagList() {
        try {

            ForumThreadTag forumThread = new ForumThreadTag();
            String pageNum = request.getParameter("pageNum");
            String pageSize = request.getParameter("pageSize");
            Map<String, Object> map = new HashMap<>();
            initPage(map, pageNum, pageSize);
            PageHelper.orderBy("count DESC");
            List<ForumThreadTag> lists = forumThreadTagService.selectByMap(TransferUtil.beanToMap(forumThread));
            List<ForumThreadTagVo> voLists = new ArrayList<>();
            for (ForumThreadTag forumThreadTag : lists) {
                ForumThreadTagVo forumThreadTagVo = new ForumThreadTagVo();
                forumThreadTagVo.setId(forumThreadTag.getId());
                forumThreadTagVo.setName(forumThreadTag.getName());
                forumThreadTagVo.setCount(forumThreadTag.getCount());
                voLists.add(forumThreadTagVo);
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
     * 查询标签列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "tagList", method = {RequestMethod.POST, RequestMethod.GET})
    public AjaxResult tagList() {
        try {

            String pageNum = request.getParameter("pageNum");
            String pageSize = request.getParameter("pageSize");
            String tagid = request.getParameter("tagid");
            if (tagid == null || StringUtil.isEmpty(tagid)) {
                return AjaxResult.failAjaxResult("tagid 不能为空");
            }

            Map<String, Object> map = new HashMap<>();
            Wrapper<ForumThreadTagLink> threadTagLinkWrapper = Condition.create();
            threadTagLinkWrapper.eq("tagid", tagid);
            List<ForumThreadTagLink> threadTagLinkLists = forumThreadTagLinkService.selectList(threadTagLinkWrapper);
            if (!(threadTagLinkLists.size() > 0)) {
                Map<String, Object> ha = new HashMap<>();
                ha.put("list", new ArrayList<>());
                ha.put("total", 0);
                return AjaxResult.successAjaxResult(ha);
            }

            Set<Long> tids = new HashSet<>();
            for (ForumThreadTagLink forumThreadTagLink : threadTagLinkLists) {
                tids.add(forumThreadTagLink.getTid());
            }
            initPage(map, pageNum, pageSize);
            Wrapper<ForumThread> forumThreadWrapper = Condition.create();
            forumThreadWrapper.eq("status", 0);
            forumThreadWrapper.eq("isdelete", 0);
            forumThreadWrapper.in("id", tids);
            List<ForumThread> lists = forumThreadService.selectList(forumThreadWrapper);
            List<ForumThreadVo> voLists = new ArrayList<>();
            for (ForumThread entity1 : lists) {
                ForumThreadVo en = new ForumThreadVo();
                User user = userService.selectById(entity1.getBaseid());
                ForumForum forumForum = forumForumService.selectById(entity1.getFid());
                //   ForumPostVo forumPostVo = forumPostService.getForumPostByTid(entity1.getId());
                String Headurl = user.getImg() == null ? "" : user.getImg();
                String threadTypeName = "原创";
                if (entity1.getThreadtype() != null && entity1.getThreadtype().equals(2)) {
                    threadTypeName = "转载";
                } else if (entity1.getThreadtype() != null && entity1.getThreadtype().equals(3)) {
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
                /*if (forumPostVo != null) {
                    en.setContent(forumPostVo.getContent());
                }*/
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

            ForumThread forumThread = forumThreadService.selectById(Long.valueOf(tidStr));
            if (forumThread == null) {
                throw new IllegalArgumentException("未找到主题信息");
            }

            Long tid = Long.valueOf(tidStr);
            String userip = "";
            try {
                userip =  IPUtil.getIpAdd(request);
            }catch(Exception e){
                e.printStackTrace();
            }

            ForumPostVo forumPostVo = forumPostService.getForumPostByTid(tid);
            if (forumPostVo == null) {
                throw new IllegalArgumentException("未找到帖子信息");
            }

            ForumForum forumForum = forumForumService.selectById(forumThread.getFid());
            List<ForumThreadTagVo> threadTagVos = forumThreadTagService.getForumThreadTagsByTid(forumThread.getId());
            if (forumPostVo.getIsdelete().equals(1)) {//是否删除1是0否
                AjaxResult ajaxResult = new AjaxResult();
                ajaxResult.setCode("22");
                ajaxResult.setMessage("该帖子已删除或正在审核中");
                return ajaxResult;
            }

            ForumThreadVo en = new ForumThreadVo();
            String threadTypeName = "原创";
            if (forumThread.getThreadtype() != null && forumThread.getThreadtype().equals(2)) {
                threadTypeName = "转载";
            } else if (forumThread.getThreadtype() != null && forumThread.getThreadtype().equals(3)) {
                threadTypeName = "翻译";
            }

            Wrapper<ForumThread> forumThreadWrapper = Condition.create();
            forumThreadWrapper.eq("baseid", forumThread.getBaseid());
            forumThreadWrapper.eq("isdelete", 0);
            int count = forumThreadService.selectCount(forumThreadWrapper);

            en.setViews(forumThread.getViews());//浏览数
            en.setCount(count);//作者总主题数
            en.setReplies(forumThread.getReplies());//回复数
            en.setThreadtype(forumThread.getThreadtype());//主题类型
            en.setId(forumThread.getId());//tid
            en.setFid(forumThread.getFid());//板块id
            en.setFname(forumForum.getName());//版块名称
            en.setPid(forumPostVo.getId());//帖子id
            en.setUsername(forumPostVo.getUsername());//用户名
            en.setSubject(forumPostVo.getSubject());//标题
            en.setDateline(forumPostVo.getDateline());//时间戳
            en.setHeadurl(forumPostVo.getHeadurl());//用户头像地址
            en.setFname(forumPostVo.getFname());//板块名称
            en.setBaseid(forumPostVo.getBaseid());//用户id
            en.setThreadtypename(threadTypeName);
            en.setContent(forumPostVo.getContent());
            en.setListtags(threadTagVos);
            String comme = forumThread.getCoverimg();
            if (StringUtil.isEmpty(comme)) {
                comme = getDefaultCoverimg();
            }

            en.setCoverimg(this.fdfsurl + comme);
            if (baseid != null && baseid.equals(forumPostVo.getBaseid())) {
                //是作者本人则不判断是否审核状态
                forumThreadService.addForumThreadView(tid, userip, baseid);
                return AjaxResult.successAjaxResult(en);
            }

            if (!(forumPostVo.getStatus().equals(0))) {//状态-1审核中 -2审核失败 0审核通过
                AjaxResult ajaxResult = new AjaxResult();
                ajaxResult.setCode("22");
                ajaxResult.setMessage("该帖子已删除或正在审核中");
                return ajaxResult;
            }

            forumThreadService.addForumThreadView(tid, userip, baseid);
            return AjaxResult.successAjaxResult(en);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);
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
