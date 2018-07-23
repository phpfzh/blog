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
@RequestMapping("/api/systemRole")
public class SystemRoleController extends AbstractVoBaseController<SystemRole,SystemRoleVo> {

    @Resource
    private  SystemRoleService systemRoleService;

    @Resource
    private  SystemRoleResourceService systemRoleResourceService;

    @Resource
    private  SystemUserRoleService systemUserRoleService;

    @Override
    public AjaxResult valiPreSaveEntity(SystemRole systemRole, AjaxResult ajaxResult) {
        SystemRole systemRole2 = new SystemRole();
        systemRole2.setRolename(systemRole.getRolename());
        List<SystemRole> lists = systemRoleService.selectByMap(TransferUtil.beanToMap(systemRole2));
        if(lists.size() > 0){
            ajaxResult.setMessage("该角色名称已存在");
            ajaxResult.setCode(AjaxResult.FAIL_CODE);
            return ajaxResult;
        }

        return super.valiPreSaveEntity(systemRole,ajaxResult);
    }

    @Override
    public AjaxResult valiPreUpdateEntity(SystemRole systemRole, AjaxResult ajaxResult) {
        Wrapper<SystemRole> wrapper = Condition.create();
        wrapper.eq("rolename",systemRole.getRolename());
        wrapper.notIn("roleid",systemRole.getRoleid());
        List<SystemRole> lists = systemRoleService.selectList(wrapper);
        if(lists.size() > 0){
            ajaxResult.setMessage("该角色名称已存在");
            ajaxResult.setCode(AjaxResult.FAIL_CODE);
            return ajaxResult;
        }

        return super.valiPreUpdateEntity(systemRole, ajaxResult);
    }

    @Override
    public AjaxResult delEntity(Long id) {
        try {

            if(id == null){
                return AjaxResult.failAjaxResult("id 不能为空");
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
