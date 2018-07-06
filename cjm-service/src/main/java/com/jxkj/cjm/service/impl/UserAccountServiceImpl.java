package com.jxkj.cjm.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.mapper.UserAccountMapper;
import com.jxkj.cjm.model.UserAccount;
import com.jxkj.cjm.service.UserAccountService;
 
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper,UserAccount> implements UserAccountService {

}
