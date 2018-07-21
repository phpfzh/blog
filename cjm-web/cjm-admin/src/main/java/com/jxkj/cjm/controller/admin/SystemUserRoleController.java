package com.jxkj.cjm.controller.admin;

import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.model.SystemUserRole;
import com.jxkj.cjm.model.vo.SystemUserRoleVo;
import com.jxkj.cjm.service.SystemUserRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 用户角色关联 Controller
 */

@Controller
@RequestMapping("/api/userRole")
public class SystemUserRoleController extends BaseController<SystemUserRole> {


    @Resource
    private  SystemUserRoleService systemUserRoleService;

    public AjaxResult insertUserRole(SystemUserRoleVo SystemUserRoleVo){
        return  null;
    }

}
