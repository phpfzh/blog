package com.jxkj.cjm.controller.admin;

import com.jxkj.cjm.common.controller.AbstractVoBaseController;
import com.jxkj.cjm.model.SystemUserRole;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/file/test")
public class TestCl extends AbstractVoBaseController<SystemUserRole,Long>{

    @ResponseBody
    @RequestMapping("/test")
    public String tets(){
        String s = "HHHH";
        return s;
    }

}
