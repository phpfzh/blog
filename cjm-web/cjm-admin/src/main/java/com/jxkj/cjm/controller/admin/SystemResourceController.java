package com.jxkj.cjm.controller.admin;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.jxkj.cjm.common.controller.AbstractVoBaseController;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.util.HibernateValidatorUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.common.util.TransferUtil;
import com.jxkj.cjm.model.SystemResource;
import com.jxkj.cjm.model.SystemRoleResource;
import com.jxkj.cjm.model.vo.GroupSave;
import com.jxkj.cjm.model.vo.GroupUpdate;
import com.jxkj.cjm.model.vo.SystemResourceVo;
import com.jxkj.cjm.service.SystemResourceService;
import com.jxkj.cjm.service.SystemRoleResourceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源管理 Controller
 */
@Controller
@RequestMapping("/api/resource")
public class SystemResourceController extends AbstractVoBaseController<SystemResource,SystemResourceVo> {

    private Lock saveLock = new ReentrantLock();//新增lock

    @Resource
    private SystemResourceService systemResourceService;

    @Resource
    private SystemRoleResourceService systemRoleResourceService;

    @Override
    public AjaxResult valiPreSaveEntity(SystemResource systemResource, AjaxResult ajaxResult) {
        SystemResource systemResource2 = new SystemResource();
        systemResource2.setResourcename(systemResource.getResourcename());
        List<SystemResource> lists = systemResourceService.selectByMap(TransferUtil.beanToMap(systemResource2));
        if (lists.size() > 0) {
            ajaxResult.setCode(AjaxResult.FAIL_CODE);
            ajaxResult.setMessage("该资源菜单名称已存在," + systemResource.getResourcename());
            return ajaxResult;
        }

        systemResource.setSort(systemResource.getSort() == null ? 0 : systemResource.getSort());
        systemResource.setParentid(systemResource.getParentid() == null ? 0 : systemResource.getParentid());

        return super.valiPreSaveEntity(systemResource, ajaxResult);
    }

    @Override
    public AjaxResult valiPreUpdateEntity(SystemResource systemResource, AjaxResult ajaxResult) {
        Wrapper<SystemResource> wrapper = Condition.create();
        wrapper.eq("resourcename", systemResource.getResourcename());
        wrapper.notIn("resourceid", systemResource.getResourceid());
        List<SystemResource> lists = systemResourceService.selectList(wrapper);
        if (lists.size() > 0) {
            ajaxResult.setCode(AjaxResult.FAIL_CODE);
            ajaxResult.setMessage("该资源菜单名称已存在," + systemResource.getResourcename());
            return ajaxResult;
        }

        systemResource.setSort(systemResource.getSort() == null ? 0 : systemResource.getSort());
        systemResource.setParentid(systemResource.getParentid() == null ? 0 : systemResource.getParentid());

        return super.valiPreUpdateEntity(systemResource, ajaxResult);
    }


    @Override
    public AjaxResult delEntity(Long resourceid) {
        try {

            if (StringUtil.isEmpty(resourceid)) {
                return AjaxResult.failAjaxResult("'resourceid' 不能为空");
            }

            systemResourceService.deleteById(resourceid);

            Wrapper<SystemRoleResource> wrapper = Condition.create();
            wrapper.eq("resourceid", resourceid);
            systemRoleResourceService.delete(wrapper);

            return AjaxResult.successAjaxResult("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult("删除失败");
    }

}
