package com.jxkj.cjm.controller.admin;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.common.util.TransferUtil;
import com.jxkj.cjm.model.SystemRole;
import com.jxkj.cjm.model.SystemRoleResource;
import com.jxkj.cjm.model.SystemUserRole;
import com.jxkj.cjm.model.vo.GroupSave;
import com.jxkj.cjm.model.vo.GroupUpdate;
import com.jxkj.cjm.model.vo.SystemRoleVo;
import com.jxkj.cjm.model.vo.UserLoginVo;
import com.jxkj.cjm.service.SystemRoleResourceService;
import com.jxkj.cjm.service.SystemRoleService;
import com.jxkj.cjm.service.SystemUserRoleService;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

/**
 * 角色 Controller
 */
@Controller
@RequestMapping("/api/systemRole")
@Api(tags="2",description = "角色管理")
public class SystemRoleController extends BaseController<SystemRole>{

    @Resource
    private  SystemRoleService systemRoleService;

    @Resource
    private  SystemRoleResourceService systemRoleResourceService;

    @Resource
    private  SystemUserRoleService systemUserRoleService;

    @ApiOperation(value = "角色添加",httpMethod ="POST")
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult insertRole(@ApiParam() SystemRoleVo systemRoleVo){
        try{

             //验证请求参数
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<SystemRoleVo>> constraintViolations = validator.validate(systemRoleVo, GroupSave.class);
            if(constraintViolations.iterator().hasNext() && constraintViolations.iterator().next().getMessage() != null){
                 return AjaxResult.failAjaxResult(constraintViolations.iterator().next().getMessage());
            }

            SystemRole systemRole = new SystemRole();
            systemRole.setRolename(systemRoleVo.getRolename());
            List<SystemRole> lists = systemRoleService.selectByMap(TransferUtil.beanToMap(systemRole));
            if(lists.size() > 0){
                return AjaxResult.failAjaxResult("该角色名称已存在");
            }

            boolean ff = systemRoleService.insert(systemRole);
            if(ff){
                return AjaxResult.successAjaxResult("保存成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
         return AjaxResult.failAjaxResult("保存失败");
    }

    @ApiOperation(value = "角色修改",httpMethod ="POST")
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult updateRole(@ApiParam() SystemRoleVo systemRoleVo){
        try{
            //验证请求参数
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<SystemRoleVo>> constraintViolations = validator.validate(systemRoleVo, GroupUpdate.class);
            if(constraintViolations.iterator().hasNext() && constraintViolations.iterator().next().getMessage() != null){
                return AjaxResult.failAjaxResult(constraintViolations.iterator().next().getMessage());
            }

            Wrapper<SystemRole> wrapper = Condition.create();
            wrapper.eq("rolename",systemRoleVo.getRolename());
            wrapper.notIn("roleid",systemRoleVo.getRoleid());
            List<SystemRole> lists = systemRoleService.selectList(wrapper);
            if(lists.size() > 0){
                return AjaxResult.failAjaxResult("该角色名称已存在");
            }

            SystemRole systemRole = new SystemRole();
            systemRole.setRoleid(systemRoleVo.getRoleid());
            systemRole.setRolename(systemRoleVo.getRolename());
            boolean ff = systemRoleService.updateById(systemRole);
            if(ff){
                return AjaxResult.successAjaxResult("修改成功");
            }
         }catch (Exception e){
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult("修改失败");
    }

    @ApiOperation(value = "角色删除",httpMethod ="POST")
    @ApiImplicitParam(required = true,value = "角色id",name = "roleid")
    @PostMapping("/del")
    @ResponseBody
    public AjaxResult delRole(String roleid){

            try{

                if(StringUtil.isEmpty(roleid)){
                    return AjaxResult.failAjaxResult("'roleid' 不能为空");
                }

                systemRoleService.deleteById(Long.parseLong(roleid));

                Wrapper<SystemRoleResource> wrapper = Condition.create();
                wrapper.eq("roleid",roleid);
                systemRoleResourceService.delete(wrapper);

                Wrapper<SystemUserRole> wrapper2 = Condition.create();
                wrapper2.eq("roleid",roleid);
                systemUserRoleService.delete(wrapper2);
                return AjaxResult.successAjaxResult("删除成功");
            }catch(Exception e){
                e.printStackTrace();
            }
            return  AjaxResult.failAjaxResult("删除失败");
    }
}
