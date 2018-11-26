package com.jxkj.cjm.service;

import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.ForumThreadReply;
import com.jxkj.cjm.model.User;
import com.baomidou.mybatisplus.service.IService;
import com.jxkj.cjm.model.vo.ForumThreadReplyVo;

public interface ForumThreadReplyService extends IService<ForumThreadReply>{
	//保存回复
    public ProcessBack insertForumThreadReplay(User user,ForumThreadReplyVo forumThreadReplyVo);
    //修改回复
    public ProcessBack updateForumThreadReplay(User user,ForumThreadReplyVo forumThreadReplyVo);
    //删除回复
    public ProcessBack delForumThreadReplay(Long repayId);
    //批量审核回复
    public ProcessBack auditBatchForumThreadReplay(Long baseid,String repayIds,String status,String remark);
    //批量删除回复
    public ProcessBack delBatchForumThreadReplay(String repayIds);
    //前端数据转换
    public String parseAttach(String text);
    //查询回复总数
    public int findForumThreadReplyTotal(ForumThreadReplyVo replyVo);
    //查询回复
    public ProcessBack findPrePortalReplys(String pageNum,String pageSize,ForumThreadReplyVo replyVo);


}