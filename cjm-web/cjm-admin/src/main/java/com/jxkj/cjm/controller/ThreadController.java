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
import org.springframework.web.bind.annotation.RequestMapping;

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
        if(StringUtil.isNotEmpty(searchParamsVo.getSubject())){
            System.out.println(JSON.toJSONString(searchParamsVo));
            //查询主题信息
            ForumThreadVo forumThreadvo = new ForumThreadVo();
            forumThreadvo.setSubject(searchParamsVo.getSubject());
            forumThreadvo.setStatus(0);
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
        return "thread/list";
    }
}
