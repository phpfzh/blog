## 定义 swagger 返回参数类包

格式：
@ApiModel
public class GenerateUserNameRep {
    @ApiModelProperty(value = "用户名")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

在Controller 方法定义返回即可：

@ApiOperation(value = "自动生成用户名")
@ResponseBody
@PostMapping("/api/generateUserName")
public AjaxResult<GenerateUserNameRep> generateUserName(HttpServletRequest request){
	try{
		String username = userService.generateUserName();
		if(StringUtil.isNotEmpty(username)){
			Map<String,String> ha = new HashMap<>();
			ha.put("username",username);
			return AjaxResult.successAjaxResult(ha);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return AjaxResult.failAjaxResult();
}