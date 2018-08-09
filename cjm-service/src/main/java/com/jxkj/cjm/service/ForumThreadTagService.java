package com.jxkj.cjm.service;

import com.jxkj.cjm.model.ForumThreadTag;
import com.baomidou.mybatisplus.service.IService;
import com.jxkj.cjm.model.vo.ForumThreadTagVo;

import java.util.List;

public interface ForumThreadTagService extends IService<ForumThreadTag>{

    public List<ForumThreadTagVo> getForumThreadTagsByTid(Long tid);
}