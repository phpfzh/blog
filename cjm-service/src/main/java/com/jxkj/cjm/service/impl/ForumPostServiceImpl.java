package com.jxkj.cjm.service.impl;


import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.model.ForumPost;
import com.jxkj.cjm.service.ForumPostService;
import com.jxkj.cjm.mapper.ForumPostMapper;


@Service
public class ForumPostServiceImpl extends ServiceImpl<ForumPostMapper,ForumPost> implements ForumPostService {

}
