package com.jxkj.cjm.service.impl;


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
import java.util.Set;


@Service
public class FriendlinkServiceImpl extends ServiceImpl<FriendlinkMapper, Friendlink> implements FriendlinkService {

    public ProcessBack insertFriendlink(Long baseid, FriendlinkVo friendlinkVo) {
        ProcessBack processBack = new ProcessBack();
        try {

            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<FriendlinkVo>> constraintViolations = validator.validate(friendlinkVo, GroupSave.class);
            if (constraintViolations.iterator().hasNext() && constraintViolations.iterator().next().getMessage() != null) {
                processBack.setCode(ProcessBack.FAIL_CODE);
                processBack.setMessage(constraintViolations.iterator().next().getMessage());
                return processBack;
            }

            if (friendlinkVo.getType() == null) {
                friendlinkVo.setType(1);//默认友情链接
            }

            if (friendlinkVo.getSort() == null) {
                friendlinkVo.setSort(1);//默认友情链接
            }

            Long dateLine = System.currentTimeMillis();
            Friendlink friendlink = new Friendlink();
            friendlink.setName(friendlinkVo.getName());
            friendlink.setType(friendlinkVo.getType());
            friendlink.setBaseid(baseid);
            friendlink.setDateline(dateLine);
            friendlink.setLink(friendlinkVo.getLink());
            friendlink.setRemark(friendlinkVo.getRemark());
            friendlink.setSort(friendlinkVo.getSort());
            int count = 0;
            count = baseMapper.insert(friendlink);
            if (count > 0) {
                processBack.setCode(ProcessBack.SUCCESS_CODE);
                processBack.setMessage("添加成功");
                return processBack;
            }

            processBack.setCode(ProcessBack.FAIL_CODE);
            processBack.setMessage("保存失败");
            return processBack;
        } catch (Exception e) {
            e.printStackTrace();
        }
        processBack.setCode(ProcessBack.FAIL_CODE);
        processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
        return processBack;
    }

    public ProcessBack updateFriendlink(Long baseid, FriendlinkVo friendlinkVo) {
        ProcessBack processBack = new ProcessBack();
        try {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<FriendlinkVo>> constraintViolations = validator.validate(friendlinkVo, GroupSave.class);
            if (constraintViolations.iterator().hasNext() && constraintViolations.iterator().next().getMessage() != null) {
                processBack.setCode(ProcessBack.FAIL_CODE);
                processBack.setMessage(constraintViolations.iterator().next().getMessage());
                return processBack;
            }

            Long dateLine = System.currentTimeMillis();
            Friendlink friendlink = new Friendlink();
            friendlink.setId(friendlinkVo.getId());
            friendlink.setName(friendlinkVo.getName());
            friendlink.setType(friendlinkVo.getType());
            friendlink.setUpdateid(baseid);
            friendlink.setUpdateline(dateLine);
            friendlink.setLink(friendlinkVo.getLink());
            friendlink.setRemark(friendlinkVo.getRemark());
            friendlink.setSort(friendlinkVo.getSort());
            int count = 0;
            count = baseMapper.updateById(friendlink);
            if (count > 0) {
                processBack.setCode(ProcessBack.SUCCESS_CODE);
                processBack.setMessage("修改成功");
                return processBack;
            }

            processBack.setCode(ProcessBack.FAIL_CODE);
            processBack.setMessage("修改失败");
            return processBack;

        } catch (Exception e) {
            e.printStackTrace();
        }
        processBack.setCode(ProcessBack.FAIL_CODE);
        processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
        return processBack;
    }

}
