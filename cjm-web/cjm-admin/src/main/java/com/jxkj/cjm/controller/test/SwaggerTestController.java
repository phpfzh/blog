package com.jxkj.cjm.controller.test;

import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.controller.apidoc.UserRegRep;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(description="测试即可")
@Controller
@RequestMapping("/swagger/test")
public class SwaggerTestController {

    @ApiOperation(value="测试接口")
    @ApiImplicitParam(name = "id", value = "d", required = true, dataType = "String")
    @ResponseBody
    @GetMapping("/test")
    public AjaxResult<UserRegRep> test(String id){
         return AjaxResult.successAjaxResult();
    }
}
