package com.jxkj.cjm.controller.admin;

import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.component.CjmJwtTokenComponent;
import com.jxkj.cjm.common.controller.AbstractVoBaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.Meta;
import com.jxkj.cjm.common.util.IPUtil;
import com.jxkj.cjm.common.util.TransferUtil;
import com.jxkj.cjm.model.ForumForum;
import com.jxkj.cjm.model.ForumThread;
import com.jxkj.cjm.model.User;
import com.jxkj.cjm.model.vo.ForumThreadVo;
import com.jxkj.cjm.service.ForumForumService;
import com.jxkj.cjm.service.ForumThreadService;
import com.jxkj.cjm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Resource
    private CjmJwtTokenComponent cjmJwtTokenComponent;

    @Resource
    private ForumThreadService forumThreadService;

    //查询列表
    @ResponseBody
    @RequestMapping(value = "viewList",method = {RequestMethod.GET,RequestMethod.POST})
    public AjaxResult viewList(ForumThreadVo forumThreadVo){
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
            return AjaxResult.successAjaxResult(ha);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);
    }

    //删除列表
    @ResponseBody
    @RequestMapping(value = "delList",method = {RequestMethod.GET,RequestMethod.POST})
    public AjaxResult delList(ForumThreadVo forumThreadVo){
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
            return AjaxResult.successAjaxResult(ha);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);
    }

    @Override
    public AjaxResult preList(ForumThread forumThread, ForumThreadVo forumThreadVo) {
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
            return AjaxResult.successAjaxResult(ha);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);
    }

    /**
     *
     * Title: auditForumThread
     * TODO:(审核主题)
     * @param forumThread
     * @return
     */
    @ResponseBody
    @PostMapping("/auditForumThread")
    public AjaxResult auditForumThread(ForumThread forumThread){
         try{
            String baseId = cjmJwtTokenComponent.getUserBaseId(request);
            String status = request.getParameter("status");//审核状态 状态-1审核中 -2审核失败 0审核通过
            String tid = request.getParameter("tid");//主题id
            String userip = IPUtil.getIpAdd(request);
            Meta meta = new Meta();
            int count = forumThreadService.auditForumThread(tid, status, Long.valueOf(baseId), userip, meta);
            if(count == 2){//校验不通过
                 return AjaxResult.failAjaxResult(meta.getMessage());
            }else if(count == 1){
                 return AjaxResult.successAjaxResult("操作成功");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
         return AjaxResult.failAjaxResult("因网络响应不及时,操作失败");
    }

    /**
     *
     * Title: auditBatchForumThread
     * TODO:(批量审核主题信息)
     * @param forumThread
     * @return
     */
    @ResponseBody
    @PostMapping("/auditBatchForumThread")
    public AjaxResult auditBatchForumThread(ForumThread forumThread){
         try{
            String baseId = cjmJwtTokenComponent.getUserBaseId(request);
            String status = request.getParameter("status");
            String tids = request.getParameter("tids");
            String userip = IPUtil.getIpAdd(request);
            Meta meta = new Meta();
            int count = forumThreadService.auditBatchForumThread(tids, status, Long.valueOf(baseId), userip, meta);
            if(count == 2){//校验不通过
                 return AjaxResult.failAjaxResult(meta.getMessage());
            }else if(count == 1){
                 return AjaxResult.successAjaxResult("操作成功");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);
    }

    /**
     *
     * Title: delForumThread
     * TODO:(删除主题)
     * @param forumThread
     * @return
     */
    @ResponseBody
    @PostMapping("/delForumThread")
    public AjaxResult delForumThread(ForumThread forumThread){
        try{
            String baseId = cjmJwtTokenComponent.getUserBaseId(request);
            String status = request.getParameter("status");
            String tid = request.getParameter("tid");
            String userip = IPUtil.getIpAdd(request);
            Meta meta = new Meta();
            int count = forumThreadService.delForumThread(tid, status, Long.valueOf(baseId), userip, meta);
            if(count == 2){//校验不通过
                 return  AjaxResult.failAjaxResult(meta.getMessage());
            }else if(count == 1){
                 return AjaxResult.successAjaxResult("操作成功");
            }
         }catch(Exception e){
            e.printStackTrace();
        }
         return AjaxResult.failAjaxResult(AjaxResult.MESSAGE);
    }

    /**
     *
     * Title: delBatchForumThread
     * TODO:(批量删除主题信息)
     * @param forumThread
     * @return
     */
    @ResponseBody
    @PostMapping("/delBatchForumThread")
    public AjaxResult delBatchForumThread(ForumThread forumThread){
         try{
            String baseId = cjmJwtTokenComponent.getUserBaseId(request);
            String status = request.getParameter("status");
            String tids = request.getParameter("tids");
            String userip = IPUtil.getIpAdd(request);
            Meta meta = new Meta();
            int count = forumThreadService.delBatchForumThread(tids, status, Long.valueOf(baseId), userip, meta);
            if(count == 2){//校验不通过
                 return AjaxResult.failAjaxResult(meta.getMessage());
            }else if(count == 1){
                 return AjaxResult.successAjaxResult("操作成功");
            }
         }catch(Exception e){
            e.printStackTrace();
        }
         return AjaxResult.failAjaxResult("因网络响应不及时,操作失败");
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
