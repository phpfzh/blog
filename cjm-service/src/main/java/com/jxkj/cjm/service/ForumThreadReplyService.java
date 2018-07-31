package com.jxkj.cjm.service;

import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.ForumThreadReply;
import com.baomidou.mybatisplus.service.IService;
import com.jxkj.cjm.model.vo.ForumThreadReplyVo;

public interface ForumThreadReplyService extends IService<ForumThreadReply>{
    public ProcessBack insertForumThreadReplay(Long baseid,String userip,ForumThreadReplyVo forumThreadReplyVo);

    public ProcessBack delForumThreadReplay(Long repayId);
}