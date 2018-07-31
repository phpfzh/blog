package com.jxkj.cjm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.model.UserAvatar;
import com.jxkj.cjm.service.UserAvatarService;
import com.jxkj.cjm.mapper.UserAvatarMapper;


@Service
public class UserAvatarServiceImpl extends ServiceImpl<UserAvatarMapper,UserAvatar> implements UserAvatarService {

}
