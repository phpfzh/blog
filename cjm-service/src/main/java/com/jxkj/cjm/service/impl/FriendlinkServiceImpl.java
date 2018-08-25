package com.jxkj.cjm.service.impl;


import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.vo.FriendlinkVo;
import com.jxkj.cjm.model.vo.GroupSave;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.model.Friendlink;
import com.jxkj.cjm.service.FriendlinkService;
import com.jxkj.cjm.mapper.FriendlinkMapper;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class FriendlinkServiceImpl extends ServiceImpl<FriendlinkMapper, Friendlink> implements FriendlinkService {

    @Override
    public List<FriendlinkVo> getIndexFriendlinkVosByType(Integer type){
        Wrapper<Friendlink> wrapper = Condition.create();
        wrapper.eq("type",type);
        wrapper.orderBy("sort",false);
        wrapper.orderBy("dateline",true);
        List<Friendlink> lists = baseMapper.selectList(wrapper);
        List<FriendlinkVo> vos = new ArrayList<>();
        for (Friendlink friendlink:lists){
            FriendlinkVo vo = new FriendlinkVo();
            vo.setType(friendlink.getType());
            vo.setLink(friendlink.getLink());
            vo.setName(friendlink.getName());
            vo.setSort(friendlink.getSort());
            vos.add(vo);
         }
         return  vos;
    }
}
