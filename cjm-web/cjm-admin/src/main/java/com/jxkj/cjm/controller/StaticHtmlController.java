package com.jxkj.cjm.controller;

import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.common.util.StaticHtmlUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.model.ForumThread;
import com.jxkj.cjm.model.vo.ForumThreadVo;
import com.jxkj.cjm.service.ForumThreadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: cjm
 * @Date: 2018/8/19 12:32
 * @Description:静态化Controller
 * @ClassName: StaticHtmlController
 */
@Controller
@RequestMapping("/static")
public class StaticHtmlController extends BaseController {

    @Resource
    private ForumThreadService forumThreadService;

    @ResponseBody
    @RequestMapping("/staticHtml")
    public AjaxResult staticHtml(Long tid) {
        try {

            ProcessBack processBack = forumThreadService.getSingleForumThreadByTid(tid, null, request);
            if (processBack.getCode().equals(ProcessBack.FAIL_CODE)) {
                throw new IllegalArgumentException(processBack.getMessage());
            }

            ForumThreadVo en = (ForumThreadVo) processBack.getData();
            request.setAttribute("en", en);
            String temppath = "/WEB-INF/jsp/template/article.jsp";
            String pathName = StaticHtmlUtil.staticContent(tid, en.getStaticlink(), temppath, request, response);
            System.out.println("静态化后路径是："+pathName);
            if(StringUtil.isEmpty(pathName)){
                throw new IllegalArgumentException("静态化调用出问题了");
            }
            ForumThread forumThread = new ForumThread();
            forumThread.setId(en.getId());
            forumThread.setStaticlink(pathName);
            forumThreadService.updateById(forumThread);
            return AjaxResult.successAjaxResult("静态化成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult("静态化失败");
    }

    @ResponseBody
    @RequestMapping("/batchStaticHtml")
    public AjaxResult batchStaticHtml(String tids) {
        try {
            if(StringUtil.isEmpty(tids)){
                return AjaxResult.failAjaxResult("tids 不能为空");
            }
            String[] tidss = tids.split(",");
            for(String s:tidss){
                Long tid = Long.valueOf(s);
                ProcessBack processBack = forumThreadService.getSingleForumThreadByTid(tid, null, request);
                if (processBack.getCode().equals(ProcessBack.FAIL_CODE)) {
                    throw new IllegalArgumentException(processBack.getMessage());
                }

                ForumThreadVo en = (ForumThreadVo) processBack.getData();
                request.setAttribute("en", en);
                String temppath = "/WEB-INF/jsp/template/article.jsp";
                String pathName = StaticHtmlUtil.staticContent(tid, en.getStaticlink(), temppath, request, response);
                System.out.println("静态化后路径是："+pathName);
                if(StringUtil.isEmpty(pathName)){
                    throw new IllegalArgumentException("静态化调用出问题了");
                }
                ForumThread forumThread = new ForumThread();
                forumThread.setId(en.getId());
                forumThread.setStaticlink(pathName);
                forumThreadService.updateById(forumThread);
            }
             return AjaxResult.successAjaxResult("静态化成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult("静态化失败");
    }

}
