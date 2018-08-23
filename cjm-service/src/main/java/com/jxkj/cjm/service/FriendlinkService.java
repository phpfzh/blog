package com.jxkj.cjm.service;

import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.Friendlink;
import com.baomidou.mybatisplus.service.IService;
import com.jxkj.cjm.model.vo.FriendlinkVo;

public interface FriendlinkService extends IService<Friendlink>{

    public ProcessBack insertFriendlink(Long baseid,FriendlinkVo friendlinkVo);

    public ProcessBack updateFriendlink(Long baseid,FriendlinkVo friendlinkVo);


}