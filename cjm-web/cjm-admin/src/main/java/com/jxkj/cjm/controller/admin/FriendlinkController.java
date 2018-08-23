package com.jxkj.cjm.controller.admin;

import com.jxkj.cjm.common.component.CjmJwtTokenComponent;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.vo.FriendlinkVo;
import com.jxkj.cjm.service.FriendlinkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Auther: cjm
 * @Date: 2018/8/22 22:50
 * @Description:
 * @ClassName: FriendlinkController
 */
@Controller
@RequestMapping("/api/friendlink")
public class FriendlinkController extends BaseController {

    @Resource
    private FriendlinkService friendlinkService;

    @Resource
    private CjmJwtTokenComponent cjmJwtTokenComponent;

    @ResponseBody
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public AjaxResult insert(FriendlinkVo friendlinkVo){
        try{
            String baseIdStr = cjmJwtTokenComponent.getUserBaseId(request);
            ProcessBack processBack = friendlinkService.insertFriendlink(Long.valueOf(baseIdStr), friendlinkVo);
            if(processBack.getCode().equals(ProcessBack.SUCCESS_CODE)){
                return AjaxResult.successAjaxResult(processBack.getMessage());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult("保存失败");
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public AjaxResult update(FriendlinkVo friendlinkVo){
        try{
            String baseIdStr = cjmJwtTokenComponent.getUserBaseId(request);
            ProcessBack processBack = friendlinkService.updateFriendlink(Long.valueOf(baseIdStr), friendlinkVo);
            if(processBack.getCode().equals(ProcessBack.SUCCESS_CODE)){
                return AjaxResult.successAjaxResult(processBack.getMessage());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult("修改失败");
    }

    @ResponseBody
    @GetMapping("/list")
    public AjaxResult list(FriendlinkVo friendlinkVo){
        try{

        }catch(Exception e){
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult("修改失败");
    }
}
