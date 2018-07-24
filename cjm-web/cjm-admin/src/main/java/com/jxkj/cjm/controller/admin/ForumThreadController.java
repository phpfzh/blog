package com.jxkj.cjm.controller.admin;

import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.controller.AbstractVoBaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.util.TransferUtil;
import com.jxkj.cjm.model.ForumForum;
import com.jxkj.cjm.model.ForumThread;
import com.jxkj.cjm.model.User;
import com.jxkj.cjm.model.vo.ForumThreadVo;
import com.jxkj.cjm.service.ForumForumService;
import com.jxkj.cjm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/forumThread")
public class ForumThreadController extends AbstractVoBaseController<ForumThread,ForumThreadVo>{

    @Resource
    private UserService userService;

    @Resource
    private ForumForumService forumForumService;

    @ResponseBody
    @RequestMapping(value = "viewList",method = {RequestMethod.GET,RequestMethod.POST})
    public AjaxResult viewList(ForumThreadVo forumThreadVo){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            ForumThread forumThread = new ForumThread();
            forumThread = copyEntityByEntityVo(forumThread, forumThreadVo);
            // 处理分页请求
            String pageNum = request.getParameter("pageNum");
            String pageSize = request.getParameter("pageSize");
            Map<String, Object> map = new HashMap<>();
            initPage(map, pageNum, pageSize);
            List<ForumThread> lists = baseService.selectByMap(TransferUtil.beanToMap(forumThread));
            List<ForumThreadVo> voLists = new ArrayList<>();
            for (ForumThread entity1 : lists) {
                ForumThreadVo en = new ForumThreadVo();
                User user = userService.selectById(entity1.getBaseid());
                ForumForum forumForum = forumForumService.selectById(entity1.getFid());
                en.setUsername(user.getUsername());
                en.setSubject(entity1.getSubject());
                en.setDateline(entity1.getDateline());
                en.setStatus(entity1.getStatus());
                en.setThreadtype(entity1.getThreadtype());
                en.setFname(forumForum.getName());
                en.setId(entity1.getId());
                voLists.add(en);
            }

            PageInfo<Object> pagehelper = initPagehelper(map, lists);

            Map<String, Object> ha = new HashMap<>();
            ha.put("list", voLists);
            ha.put("total", pagehelper.getTotal());
            ha.put("entity", forumThreadVo);
            ajaxResult.setMessage(AjaxResult.SUCCESS_MESSAGE);
            ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
            ajaxResult.setData(ha);
            return ajaxResult;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        ajaxResult.setMessage(AjaxResult.MESSAGE);
        ajaxResult.setCode(AjaxResult.FAIL_CODE);
        return ajaxResult;
    }

    @Override
    public AjaxResult preList(ForumThread forumThread, ForumThreadVo forumThreadVo) {
        AjaxResult ajaxResult = new AjaxResult();
        try {
            forumThreadVo.setStatus(-1);//状态-1审核中 -2审核失败 0审核通过
            forumThread = copyEntityByEntityVo(forumThread, forumThreadVo);
            // 处理分页请求
            String pageNum = request.getParameter("pageNum");
            String pageSize = request.getParameter("pageSize");
            Map<String, Object> map = new HashMap<>();
            initPage(map, pageNum, pageSize);
            List<ForumThread> lists = baseService.selectByMap(TransferUtil.beanToMap(forumThread));
            List<ForumThreadVo> voLists = new ArrayList<>();
            for (ForumThread entity1 : lists) {
                ForumThreadVo en = new ForumThreadVo();
                User user = userService.selectById(entity1.getBaseid());
                ForumForum forumForum = forumForumService.selectById(entity1.getFid());
                en.setUsername(user.getUsername());
                en.setSubject(entity1.getSubject());
                en.setDateline(entity1.getDateline());
                en.setStatus(entity1.getStatus());
                en.setThreadtype(entity1.getThreadtype());
                en.setFname(forumForum.getName());
                en.setId(entity1.getId());
                voLists.add(en);
            }

            PageInfo<Object> pagehelper = initPagehelper(map, lists);

            Map<String, Object> ha = new HashMap<>();
            ha.put("list", voLists);
            ha.put("total", pagehelper.getTotal());
            ha.put("entity", forumThreadVo);
            ajaxResult.setMessage(AjaxResult.SUCCESS_MESSAGE);
            ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
            ajaxResult.setData(ha);
            return ajaxResult;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        ajaxResult.setMessage(AjaxResult.MESSAGE);
        ajaxResult.setCode(AjaxResult.FAIL_CODE);
        return ajaxResult;
    }

    @Override
    public AjaxResult saveEntity(ForumThreadVo forumThreadVo) {
        return null;
    }

    @Override
    public AjaxResult updateEntity(ForumThreadVo forumThreadVo) {
        return null;
    }

    @Override
    public AjaxResult delEntity(Long id) {
        return null;
    }
}
