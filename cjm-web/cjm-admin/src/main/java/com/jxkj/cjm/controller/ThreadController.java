package com.jxkj.cjm.controller;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.ForumThread;
import com.jxkj.cjm.model.ForumThreadReply;
import com.jxkj.cjm.model.vo.ForumThreadReplyVo;
import com.jxkj.cjm.model.vo.ForumThreadVo;
import com.jxkj.cjm.model.vo.SearchParamsVo;
import com.jxkj.cjm.service.ForumThreadReplyService;
import com.jxkj.cjm.service.ForumThreadService;

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
    
    @Resource
    private ForumThreadReplyService forumThreadReplyService;

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
        	System.out.println(pageSize);
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
            
            //回复记录
            ForumThreadReplyVo replyVo = new ForumThreadReplyVo();
    		replyVo.setFirst(1);//回复类型 1 首次回复主题 2 二次回复 3多次回复
    		replyVo.setTid(Long.valueOf(tid));//帖子id
    		replyVo.setReplytype(1);//1帖子
    		replyVo.setStatus(0);//0审核通过 -1 审核中 -2 审核失败
    		ProcessBack processBackReply = forumThreadReplyService.findPrePortalReplys(pageNum, "10", replyVo);
    		if(processBackReply.getCode().equals(ProcessBack.SUCCESS_CODE)){
    			Map<String,Object> maps = (Map<String, Object>) processBackReply.getData();
    			List<ForumThreadReplyVo> vos = (List<ForumThreadReplyVo>) maps.get("vos");
    			for(ForumThreadReplyVo preReplyVo : vos){
    				ForumThreadReplyVo replyVo2 = new ForumThreadReplyVo();
    				replyVo2.setNotequalrt(1);//回复类型 不等于1
    				replyVo2.setTid(Long.valueOf(tid));//帖子id
    				replyVo2.setReplytype(1);//1帖子
    				replyVo2.setStatus(0);//0审核通过 -1 审核中 -2 审核失败
    				replyVo2.setFirstmark(preReplyVo.getFirstmark());//首次回复标识
    	    		ProcessBack processBack2 = forumThreadReplyService.findPrePortalReplys("1", "100", replyVo2);
    	    		if(processBack2.getCode().equals(ProcessBack.SUCCESS_CODE)){
    	    			Map<String,Object> maps2 = (Map<String, Object>) processBack2.getData();
    	    			List<ForumThreadReplyVo> vos2 = (List<ForumThreadReplyVo>) maps2.get("vos");
    	    			preReplyVo.setChilds(vos2);
    	    		}

    			}
    			PageInfo<ForumThreadReply> pagehelper = (PageInfo<ForumThreadReply>) maps.get("pagehelper");
    			model.addAttribute("replyVos", vos);
    			model.addAttribute("pagehelper", pagehelper);
     		}

    		//回复总数
    		ForumThreadReplyVo totalReplyVo = new ForumThreadReplyVo();
    		totalReplyVo.setStatus(0);// 0审核通过 -1 审核中 -2 审核失败
    		totalReplyVo.setReplytype(1);//1帖子
    		totalReplyVo.setTid(Long.valueOf(tid));
    		int total = forumThreadReplyService.findForumThreadReplyTotal(totalReplyVo);
    		model.addAttribute("total", total);
            return "article/detail";
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("message", "文章已删除或正在审核中");
        return "article/articleerror";
    }
 }
