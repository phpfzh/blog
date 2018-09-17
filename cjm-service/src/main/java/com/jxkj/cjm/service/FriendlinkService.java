package com.jxkj.cjm.service;

import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.Friendlink;
import com.baomidou.mybatisplus.service.IService;
import com.jxkj.cjm.model.vo.FriendlinkVo;

import java.util.List;

public interface FriendlinkService extends IService<Friendlink>{

    /**
     * 首页友情链接查询全部
     * @param type
     * @return
     */
    public List<FriendlinkVo> getIndexFriendlinkVosByType(Integer type);

}