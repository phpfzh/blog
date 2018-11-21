package com.jxkj.cjm.service;

import com.baomidou.mybatisplus.service.IService;
import com.jxkj.cjm.model.ForumPost;
import com.jxkj.cjm.model.vo.ForumPostVo;

public interface ForumPostService extends IService<ForumPost>{

    /**
     * 查询主题信息
     * @param tid  主题id
     * @return
     */
    public ForumPostVo getForumPostByTid(Long tid);

}