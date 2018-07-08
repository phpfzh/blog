package com.jxkj.cjm.model.apidoc;

import com.jxkj.cjm.model.vo.UserRegVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 * @Auther: cjm
 * @Date: 2018/7/8 16:38
 * @Description:
 * @ClassName: Test
 */
@ApiModel(description = "返回描述",parent=AjaxResult.class)
public class Test extends AjaxResult{

        @ApiModelProperty()
       private UserRegVo data;


    public UserRegVo getData() {
        return data;
    }

    public void setData(UserRegVo data) {
        this.data = data;
    }
}
