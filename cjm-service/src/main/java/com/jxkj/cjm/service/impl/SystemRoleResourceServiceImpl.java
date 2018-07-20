package com.jxkj.cjm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.model.SystemRoleResource;
import com.jxkj.cjm.service.SystemRoleResourceService;
import com.jxkj.cjm.mapper.SystemRoleResourceMapper;


@Service
public class SystemRoleResourceServiceImpl extends ServiceImpl<SystemRoleResourceMapper,SystemRoleResource> implements SystemRoleResourceService {

}
