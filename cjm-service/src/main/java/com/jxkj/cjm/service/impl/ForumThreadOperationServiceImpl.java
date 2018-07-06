package com.jxkj.cjm.service.impl;


import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.model.PreForumThreadOperation;
import com.jxkj.cjm.service.ForumThreadOperationService;
import com.jxkj.cjm.mapper.ForumThreadOperationMapper;


@Service
public class ForumThreadOperationServiceImpl extends ServiceImpl<ForumThreadOperationMapper,PreForumThreadOperation> implements ForumThreadOperationService {

}
