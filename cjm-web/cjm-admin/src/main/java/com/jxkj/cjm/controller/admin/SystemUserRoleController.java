package com.jxkj.cjm.controller.admin;

import com.alibaba.fastjson.JSON;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.util.HibernateValidatorUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.common.util.TransferUtil;
import com.jxkj.cjm.model.SystemUserRole;
import com.jxkj.cjm.model.vo.SystemUserRoleVo;
import com.jxkj.cjm.service.SystemUserRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 用户角色关联 Controller
 */

@Controller
@RequestMapping("/api/userRole")
public class SystemUserRoleController{

    @Resource
    private  SystemUserRoleService systemUserRoleService;

    @PostMapping("/save")
    @ResponseBody
    public AjaxResult insertUserRole(SystemUserRoleVo systemUserRoleVo){
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


    @PostMapping("/del")
    @ResponseBody
    public AjaxResult delUserRole(SystemUserRoleVo systemUserRoleVo){
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
