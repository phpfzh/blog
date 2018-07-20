package com.jxkj.cjm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.model.SystemUserRole;
import com.jxkj.cjm.service.SystemUserRoleService;
import com.jxkj.cjm.mapper.SystemUserRoleMapper;


@Service
public class SystemUserRoleServiceImpl extends ServiceImpl<SystemUserRoleMapper,SystemUserRole> implements SystemUserRoleService {

}
