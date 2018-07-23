package com.jxkj.cjm.controller.admin;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.jxkj.cjm.common.controller.AbstractVoBaseController;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.util.HibernateValidatorUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.common.util.TransferUtil;
import com.jxkj.cjm.model.SystemRole;
import com.jxkj.cjm.model.SystemRoleResource;
import com.jxkj.cjm.model.SystemUserRole;
import com.jxkj.cjm.model.vo.GroupSave;
import com.jxkj.cjm.model.vo.GroupUpdate;
import com.jxkj.cjm.model.vo.SystemRoleVo;
import com.jxkj.cjm.service.SystemRoleResourceService;
import com.jxkj.cjm.service.SystemRoleService;
import com.jxkj.cjm.service.SystemUserRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色 Controller
 */
@Controller
@RequestMapping("/apis/systemRole")
public class SystemRoleController extends AbstractVoBaseController<SystemRole,SystemRoleVo> {

    @Resource
    private  SystemRoleService systemRoleService;

    @Resource
    private  SystemRoleResourceService systemRoleResourceService;

    @Resource
    private  SystemUserRoleService systemUserRoleService;

    @Override
    public AjaxResult saveEntity(SystemRoleVo systemRoleVo) {
        try {
            SystemRole entity = new SystemRole();
            AjaxResult ajaxResult = preSaveEntity(entity, systemRoleVo);
            if (ajaxResult.getCode().equals(AjaxResult.FAIL_CODE)) {
                return ajaxResult;
            }

            SystemRole systemRole = new SystemRole();
            systemRole.setRolename(systemRoleVo.getRolename());
            List<SystemRole> lists = systemRoleService.selectByMap(TransferUtil.beanToMap(systemRole));
            if(lists.size() > 0){
                return AjaxResult.failAjaxResult("该角色名称已存在");
            }

            boolean ff = baseService.insert(entity);
            if (ff) {
                return AjaxResult.successAjaxResult("保存成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult("保存失败");
    }

    @Override
    public AjaxResult updateEntity(SystemRoleVo systemRoleVo) {
        try {
            SystemRole entity = entityClass.newInstance();
            AjaxResult ajaxResult = preUpdateEntity(entity, systemRoleVo);
            if (ajaxResult.getCode().equals(AjaxResult.FAIL_CODE)) {
                return ajaxResult;
            }

            Wrapper<SystemRole> wrapper = Condition.create();
            wrapper.eq("rolename",systemRoleVo.getRolename());
            wrapper.notIn("roleid",systemRoleVo.getRoleid());
            List<SystemRole> lists = systemRoleService.selectList(wrapper);
            if(lists.size() > 0){
                return AjaxResult.failAjaxResult("该角色名称已存在");
            }

            boolean ff = baseService.updateById(entity);
            if (ff) {
                return AjaxResult.successAjaxResult("修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult("修改失败");
    }

    @Override
    public AjaxResult delEntity(Long id) {
        try {

            AjaxResult ajaxResult = preDelEntity(id);
            if (ajaxResult.getCode().equals(AjaxResult.FAIL_CODE)) {
                return ajaxResult;
            }

            Wrapper<SystemRoleResource> wrapper = Condition.create();
            wrapper.eq("roleid",id);
            systemRoleResourceService.delete(wrapper);

            Wrapper<SystemUserRole> wrapper2 = Condition.create();
            wrapper2.eq("roleid",id);
            systemUserRoleService.delete(wrapper2);

            boolean ff = baseService.deleteById(id);
            if (ff) {
                return AjaxResult.successAjaxResult("删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult("删除失败");
    }

}
