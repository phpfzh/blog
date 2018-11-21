package com.jxkj.cjm.controller;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.model.ForumThread;
import com.jxkj.cjm.model.vo.ForumThreadVo;
import com.jxkj.cjm.model.vo.SearchParamsVo;
import com.jxkj.cjm.service.ForumThreadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *  主题Controller
 * @Auther: cjm
 * @Date: 2018/9/16 23:52
 * @Description:
 * @ClassName: ThreadController
 */
@Controller
@RequestMapping("/thread")
public class ThreadController extends BaseController {

    @Resource
    private ForumThreadService forumThreadService;

    @RequestMapping("list")
    public String list(Model model, SearchParamsVo searchParamsVo){
         if(searchParamsVo.getFid() != null && searchParamsVo.getFid() > 0){
            System.out.println(JSON.toJSONString(searchParamsVo));
            //查询主题信息
            ForumThreadVo forumThreadvo = new ForumThreadVo();
            forumThreadvo.setStatus(0);
            forumThreadvo.setFid(searchParamsVo.getFid());
            ProcessBack processBack = forumThreadService.getForumThreadsByWarpper(forumThreadvo, searchParamsVo.getPageNumThread(),
                    searchParamsVo.getPageSizeThread());
            if(processBack.getCode().equals(ProcessBack.SUCCESS_CODE)){
                Map<String,Object> map = (Map<String, Object>) processBack.getData();
                List<ForumThreadVo> vos = (List<ForumThreadVo>) map.get("vos");
                PageInfo<ForumThread> pagehelper = (PageInfo<ForumThread>) map.get("pagehelper");
                model.addAttribute("vos", vos);
                model.addAttribute("pagehelper", pagehelper);
            }
        }
        model.addAttribute("vo", searchParamsVo);
        return "article/list";
    }
    
    /**
     * 详情页
     *
     * @return
     */
    @RequestMapping(value = "/detail", method = {RequestMethod.GET,RequestMethod.POST})
    public String detail(Model model) {
        try {
        	String tid = request.getParameter("tid");
        	String pageNum = request.getParameter("pageNum");
        	String pageSize = request.getParameter("pageSize");
            Long baseid = 1L;//获取当前用户
            ProcessBack processBack = forumThreadService.getSingleForumThreadByTid(Long.valueOf(tid), baseid, request);
            if (processBack.getCode().equals(ProcessBack.FAIL_CODE)) {
                model.addAttribute("message", "文章已删除或正在审核中");
                return "article/detailerror";
            }

            ForumThreadVo en = (ForumThreadVo) processBack.getData();
            if (en.getIsdelete().equals(1)) {//是否删除1是0否
                model.addAttribute("message", "文章已删除或正在审核中");
                return "article/detailerror";
            }
            model.addAttribute("en", en);
            if (baseid != null && baseid.equals(en.getBaseid())) {
                //是作者本人则不判断是否审核状态
                return "article/detail";
            }

            if (!(en.getStatus().equals(0))) {//状态-1审核中 -2审核失败 0审核通过
                model.addAttribute("message", "文章已删除或正在审核中");
                return "article/detailerror";
            }
            return "article/detail";
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("message", "文章已删除或正在审核中");
        return "article/articleerror";
    }
 }
