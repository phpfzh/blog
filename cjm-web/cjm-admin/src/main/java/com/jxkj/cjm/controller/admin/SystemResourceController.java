package com.jxkj.cjm.controller.admin;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.util.HibernateValidatorUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.common.util.TransferUtil;
import com.jxkj.cjm.model.SystemResource;
import com.jxkj.cjm.model.SystemRole;
import com.jxkj.cjm.model.SystemRoleResource;
import com.jxkj.cjm.model.SystemUserRole;
import com.jxkj.cjm.model.vo.GroupSave;
import com.jxkj.cjm.model.vo.GroupUpdate;
import com.jxkj.cjm.model.vo.SystemResourceVo;
import com.jxkj.cjm.model.vo.SystemRoleVo;
import com.jxkj.cjm.service.SystemResourceService;
import com.jxkj.cjm.service.SystemRoleResourceService;
import com.jxkj.cjm.service.SystemRoleService;
import com.jxkj.cjm.service.SystemUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(tags = "5", description = "权限资源菜单管理")
public class SystemResourceController extends BaseController<SystemResource> {

    private Lock saveLock = new ReentrantLock();//新增lock

    @Resource
    private SystemResourceService systemResourceService;

    @Resource
    private SystemRoleResourceService systemRoleResourceService;


    @ApiOperation(value = "资源菜单添加", httpMethod = "POST")
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult insertRole(@ApiParam() SystemResourceVo systemResourceVo) {
        try {
            saveLock.lock();//加锁

            HibernateValidatorUtil<SystemResourceVo> validatorUtil = new HibernateValidatorUtil<>();
            String msg = validatorUtil.valida(systemResourceVo, GroupSave.class);
            if (StringUtil.isNotEmpty(msg)) {
                return AjaxResult.failAjaxResult(msg);
            }

            SystemResource systemResource = new SystemResource();
            systemResource.setResourcename(systemResourceVo.getResourcename());
            List<SystemResource> lists = systemResourceService.selectByMap(TransferUtil.beanToMap(systemResource));
            if (lists.size() > 0) {
                return AjaxResult.failAjaxResult("该资源菜单名称已存在," + systemResourceVo.getResourcename());
            }

            systemResource.setResourceurl(systemResourceVo.getResourceurl());
            systemResource.setSort(systemResourceVo.getSort() == null ? 0 : systemResourceVo.getSort());
            systemResource.setRemark(systemResourceVo.getRemark());
            systemResource.setParentid(systemResourceVo.getParentid() == null ? 0 : systemResourceVo.getParentid());
            systemResource.setType(systemResourceVo.getType());
            systemResource.setPermission(systemResourceVo.getPermission());
            systemResource.setLink(systemResourceVo.getLink());
            systemResource.setHide(systemResourceVo.getHide());
            systemResource.setIcon(systemResourceVo.getIcon());
            systemResource.setExternallink(systemResourceVo.getExternallink());
            systemResource.setTarget(systemResourceVo.getTarget());
            boolean ff = systemResourceService.insert(systemResource);
            if (ff) {
                return AjaxResult.successAjaxResult("保存成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            saveLock.unlock();
        }
        return AjaxResult.failAjaxResult("保存失败");
    }

    @ApiOperation(value = "资源菜单修改", httpMethod = "POST")
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult updateRole(@ApiParam() SystemResourceVo systemResourceVo) {
        try {

            //验证请求参数
            HibernateValidatorUtil<SystemResourceVo> validatorUtil = new HibernateValidatorUtil<>();
            String msg = validatorUtil.valida(systemResourceVo, GroupUpdate.class);
            if (StringUtil.isNotEmpty(msg)) {
                return AjaxResult.failAjaxResult(msg);
            }

            Wrapper<SystemResource> wrapper = Condition.create();
            wrapper.eq("resourcename", systemResourceVo.getResourcename());
            wrapper.notIn("resourceid", systemResourceVo.getResourceid());
            List<SystemResource> lists = systemResourceService.selectList(wrapper);
            if (lists.size() > 0) {
                return AjaxResult.failAjaxResult("权限菜单已存在");
            }

            SystemResource systemResource = new SystemResource();
            systemResource.setResourceid(systemResourceVo.getResourceid());
            systemResource.setResourcename(systemResourceVo.getResourcename());
            systemResource.setResourceurl(systemResourceVo.getResourceurl());
            systemResource.setSort(systemResourceVo.getSort() == null ? 0 : systemResourceVo.getSort());
            systemResource.setRemark(systemResourceVo.getRemark());
            systemResource.setParentid(systemResourceVo.getParentid() == null ? 0 : systemResourceVo.getParentid());
            systemResource.setType(systemResourceVo.getType());
            systemResource.setPermission(systemResourceVo.getPermission());
            systemResource.setLink(systemResourceVo.getLink());
            systemResource.setHide(systemResourceVo.getHide());
            systemResource.setIcon(systemResourceVo.getIcon());
            systemResource.setExternallink(systemResourceVo.getExternallink());
            systemResource.setTarget(systemResourceVo.getTarget());
            boolean ff = systemResourceService.updateById(systemResource);
            if (ff) {
                return AjaxResult.successAjaxResult("修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult("修改失败");
    }

    @ApiOperation(value = "权限资源删除", httpMethod = "POST")
    @ApiImplicitParam(required = true, value = "资源id", name = "resourceid")
    @PostMapping("/del")
    @ResponseBody
    public AjaxResult delRole(String resourceid) {

        try {

            if (StringUtil.isEmpty(resourceid)) {
                return AjaxResult.failAjaxResult("'resourceid' 不能为空");
            }

            systemResourceService.deleteById(Long.parseLong(resourceid));

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
