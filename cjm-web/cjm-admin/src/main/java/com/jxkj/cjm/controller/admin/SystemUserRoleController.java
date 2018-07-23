package com.jxkj.cjm.controller.admin;

import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.util.HibernateValidatorUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.common.util.TransferUtil;
import com.jxkj.cjm.model.SystemUserRole;
import com.jxkj.cjm.model.vo.SystemUserRoleVo;
import com.jxkj.cjm.service.SystemUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户角色关联 Controller
 */

@Controller
@RequestMapping("/api/userRole")
@Api(tags="3",description = "用户角色管理")
public class SystemUserRoleController extends BaseController<SystemUserRole> {


    @Resource
    private  SystemUserRoleService systemUserRoleService;

    @ApiOperation(value = "用户角色添加",httpMethod ="POST")
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult insertUserRole(@ApiParam() SystemUserRoleVo systemUserRoleVo){
        try{

             HibernateValidatorUtil<SystemUserRoleVo> validatorUtil = new HibernateValidatorUtil<>();
             String msg = validatorUtil.valida(systemUserRoleVo);
             if(StringUtil.isNotEmpty(msg)){
                  return AjaxResult.failAjaxResult(msg);
             }

             SystemUserRole systemUserRole = new SystemUserRole();
             systemUserRole.setRoleid(systemUserRoleVo.getRoleid());
             systemUserRole.setUserid(systemUserRoleVo.getUserid());
             List<SystemUserRole> lists = systemUserRoleService.selectByMap(TransferUtil.beanToMap(systemUserRole));
             if(lists.size() > 0){
                 return  AjaxResult.failAjaxResult("该用户角色已存在");
             }

             boolean fal = systemUserRoleService.insert(systemUserRole);
             if(fal){
                 return  AjaxResult.successAjaxResult("保存成功");
             }
        }catch (Exception e){
            e.printStackTrace();
        }
         return  AjaxResult.failAjaxResult("保存失败");
    }


    @ApiOperation(value = "用户角色删除",httpMethod ="POST")
    @PostMapping("/del")
    @ResponseBody
    public AjaxResult delUserRole(@ApiParam() SystemUserRoleVo systemUserRoleVo){
        try{

            HibernateValidatorUtil<SystemUserRoleVo> validatorUtil = new HibernateValidatorUtil<>();
            String msg = validatorUtil.valida(systemUserRoleVo);
            if(StringUtil.isNotEmpty(msg)){
                return AjaxResult.failAjaxResult(msg);
            }

            SystemUserRole systemUserRole = new SystemUserRole();
            systemUserRole.setRoleid(systemUserRoleVo.getRoleid());
            systemUserRole.setUserid(systemUserRoleVo.getUserid());
            systemUserRoleService.deleteByMap(TransferUtil.beanToMap(systemUserRole));
            return  AjaxResult.successAjaxResult("删除成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return  AjaxResult.failAjaxResult("删除失败");
    }
}
