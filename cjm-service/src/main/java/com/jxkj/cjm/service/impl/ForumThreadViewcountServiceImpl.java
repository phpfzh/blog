package com.jxkj.cjm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.model.ForumThreadViewcount;
import com.jxkj.cjm.service.ForumThreadViewcountService;
import com.jxkj.cjm.mapper.ForumThreadViewcountMapper;


@Service
public class ForumThreadViewcountServiceImpl extends ServiceImpl<ForumThreadViewcountMapper,ForumThreadViewcount> implements ForumThreadViewcountService {

}
