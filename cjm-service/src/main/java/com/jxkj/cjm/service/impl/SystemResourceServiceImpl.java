package com.jxkj.cjm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.model.SystemResource;
import com.jxkj.cjm.service.SystemResourceService;
import com.jxkj.cjm.mapper.SystemResourceMapper;


@Service
public class SystemResourceServiceImpl extends ServiceImpl<SystemResourceMapper,SystemResource> implements SystemResourceService {

}
