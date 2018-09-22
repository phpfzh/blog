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
 *  搜索Controller
 * @Auther: cjm
 * @Date: 2018/9/16 21:52
 * @Description:
 * @ClassName: SearchController
 */
@Controller
@RequestMapping("/search")
public class SearchController extends BaseController {

    @Resource
    private ForumThreadService forumThreadService;

    @RequestMapping("list")
    public String list(Model model, SearchParamsVo searchParamsVo){
        if(StringUtil.isNotEmpty(searchParamsVo.getSubject())){
            System.out.println(JSON.toJSONString(searchParamsVo));
            //查询主题信息
            ForumThreadVo forumThreadvo = new ForumThreadVo();
            forumThreadvo.setIslikesubject(1);//是否模糊查询主题名称
            forumThreadvo.setSubject(searchParamsVo.getSubject());
            forumThreadvo.setStatus(0);
            ProcessBack processBack = forumThreadService.getForumThreadsByWarpper(forumThreadvo, searchParamsVo.getPageNumThread(),
                    searchParamsVo.getPageSizeThread());
            if(processBack.getCode().equals(ProcessBack.SUCCESS_CODE)){
                Map<String,Object> map = (Map<String, Object>) processBack.getData();
                List<ForumThreadVo> vos = (List<ForumThreadVo>) map.get("vos");
                PageInfo<ForumThread> pagehelper = (PageInfo<ForumThread>) map.get("pagehelper");
                model.addAttribute("threadvos", vos);
                model.addAttribute("threadpagehelper", pagehelper);
            }
        }
        model.addAttribute("vo", searchParamsVo);
        return "search/search";
    }
}
