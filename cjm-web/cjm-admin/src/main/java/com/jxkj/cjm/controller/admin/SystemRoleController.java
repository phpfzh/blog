package com.jxkj.cjm.controller.admin;

import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.common.util.TransferUtil;
import com.jxkj.cjm.model.SystemRole;
import com.jxkj.cjm.model.vo.GroupSave;
import com.jxkj.cjm.model.vo.SystemRoleVo;
import com.jxkj.cjm.model.vo.UserLoginVo;
import com.jxkj.cjm.service.SystemRoleService;
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

    @ApiOperation(value = "角色添加",httpMethod ="POST")
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult inserRole(@ApiParam() SystemRoleVo systemRoleVo){
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
         return AjaxResult.failAjaxResult("保存失败");
    }
}
