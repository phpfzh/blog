package com.jxkj.cjm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.model.SystemRole;
import com.jxkj.cjm.service.SystemRoleService;
import com.jxkj.cjm.mapper.SystemRoleMapper;


@Service
public class SystemRoleServiceImpl extends ServiceImpl<SystemRoleMapper,SystemRole> implements SystemRoleService {

}
