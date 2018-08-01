package com.jxkj.cjm.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.common.util.AttachUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.mapper.ForumThreadMapper;
import com.jxkj.cjm.mapper.ForumThreadReplyAttachMapper;
import com.jxkj.cjm.model.ForumThread;
import com.jxkj.cjm.model.ForumThreadReplyAttach;
import com.jxkj.cjm.model.vo.ForumThreadReplyVo;
import com.jxkj.cjm.model.vo.GroupSave;
import com.jxkj.cjm.service.ForumThreadReplyAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.model.ForumThreadReply;
import com.jxkj.cjm.service.ForumThreadReplyService;
import com.jxkj.cjm.mapper.ForumThreadReplyMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


@Service
public class ForumThreadReplyServiceImpl extends ServiceImpl<ForumThreadReplyMapper, ForumThreadReply> implements ForumThreadReplyService {

    private Lock saveLock = new ReentrantLock();

    @Value("${cjm.fdfs.host}")
    private String fdfsurl;//图片服务器路径

    @Resource
    private ForumThreadReplyAttachService forumThreadReplyAttachService;

    @Resource
    private ForumThreadMapper forumThreadMapper;

    @Transactional
    @Override
    public ProcessBack insertForumThreadReplay(Long baseid, String userip, ForumThreadReplyVo forumThreadReplyVo) {
        ProcessBack processBack = new ProcessBack();
        try {
            saveLock.lock();

            if (baseid == null) {
                throw new IllegalArgumentException("baseid 不能为空");
            }

            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<ForumThreadReplyVo>> constraintViolations = validator.validate(forumThreadReplyVo, GroupSave.class);
            if (constraintViolations.iterator().hasNext() && constraintViolations.iterator().next().getMessage() != null) {
                processBack.setCode(ProcessBack.FAIL_CODE);
                processBack.setMessage(constraintViolations.iterator().next().getMessage());
                return processBack;
            }

            ForumThreadReply parentForumThreadReply = null;
            if (forumThreadReplyVo.getParentid() != null) {
                parentForumThreadReply = baseMapper.selectById(forumThreadReplyVo.getParentid());
                if (parentForumThreadReply == null) {
                    processBack.setCode(ProcessBack.FAIL_CODE);
                    processBack.setMessage("parentid 错误");
                    return processBack;
                }
            }

            ForumThread forumThread = forumThreadMapper.selectById(forumThreadReplyVo.getTid());
            if (forumThread == null) {
                processBack.setCode(ProcessBack.FAIL_CODE);
                processBack.setMessage("主题信息找不到");
                return processBack;
            }

            String firstmark = StringUtil.getNo();
            Long dateLine = System.currentTimeMillis();
            ForumThreadReply forumThreadReply = new ForumThreadReply();
            forumThreadReply.setFirst(1);//是否首次评论主题 1 首次评论  0回复
            forumThreadReply.setTbaseid(forumThreadReplyVo.getTbaseid());
            forumThreadReply.setParentid((long) 0);
            forumThreadReply.setFirstmark(firstmark);
            forumThreadReply.setTid(forumThreadReplyVo.getTid());
            forumThreadReply.setBaseid(baseid);
            forumThreadReply.setDatetime(dateLine);
            forumThreadReply.setMessage(forumThreadReplyVo.getMessage());
            forumThreadReply.setUserip(userip);
            forumThreadReply.setStatus(-1);//是否通过审核 -1审核中 -2 审核失败 0审核通过
            forumThreadReply.setLike(0);
            forumThreadReply.setHate(0);
            forumThreadReply.setIsdelete(0);

            if (parentForumThreadReply != null) {
                if (forumThreadReplyVo.getTbaseid() == null) {
                    processBack.setCode(ProcessBack.FAIL_CODE);
                    processBack.setMessage("回复目标用户tbaseid不能为空");
                    return processBack;
                }

                forumThreadReply.setFirst(0);//是否首次评论主题 1 首次评论  0回复
                forumThreadReply.setTbaseid(forumThreadReplyVo.getTbaseid());
                forumThreadReply.setParentid(parentForumThreadReply.getId());
                forumThreadReply.setFirstmark(parentForumThreadReply.getFirstmark());
            } else {
                forumThreadReply.setTbaseid(forumThread.getBaseid());//首次评论主题
            }

            int count = 0;
            count = baseMapper.insert(forumThreadReply);
            if (!(count > 0)) {
                throw new IllegalArgumentException("保存失败");
            }

            if (forumThreadReplyVo.getImgs() != null && StringUtil.isNotEmpty(forumThreadReplyVo.getImgs())) {
                String[] imgs = forumThreadReplyVo.getImgs().split(",");
                for (String s : imgs) {
                    String attach = s.substring(this.fdfsurl.length());
                    ForumThreadReplyAttach forumThreadReplyAttach = forumThreadReplyAttachService.getForumThreadReplyAttachByAttach(attach);
                    if (forumThreadReplyAttach != null) {
                        forumThreadReplyAttach.setBaseid(baseid);
                        forumThreadReplyAttach.setReplyid(forumThreadReply.getId());
                        forumThreadReplyAttach.setStatus(1);
                        forumThreadReplyAttach.setIsdelete(0);
                        forumThreadReplyAttachService.updateById(forumThreadReplyAttach);
                    }
                }
            }

            processBack.setCode(ProcessBack.SUCCESS_CODE);
            processBack.setMessage("保存成功");
            return processBack;
        } catch (RuntimeException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            saveLock.unlock();
        }

        processBack.setCode(ProcessBack.FAIL_CODE);
        processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
        return processBack;
    }

    @Transactional
    @Override
    public ProcessBack delForumThreadReplay(Long repayId) {
        ProcessBack processBack = new ProcessBack();
        try {

            if (repayId == null) {
                processBack.setCode(ProcessBack.FAIL_CODE);
                processBack.setMessage("repayId 不能为空");
                return processBack;
            }

            Wrapper<ForumThreadReplyAttach> forumThreadReplyAttachWrapper = Condition.create();
            forumThreadReplyAttachWrapper.eq("replyid", repayId);
            List<ForumThreadReplyAttach> lists = forumThreadReplyAttachService.selectList(forumThreadReplyAttachWrapper);
            for (ForumThreadReplyAttach forumThreadReplyAttach : lists) {
                forumThreadReplyAttach.setIsdelete(1);
                forumThreadReplyAttachService.updateById(forumThreadReplyAttach);
            }
            int count = 0;
            count = baseMapper.deleteById(repayId);
            if (!(count > 0)) {
                throw new IllegalArgumentException("删除失败");
            }

            processBack.setCode(ProcessBack.SUCCESS_CODE);
            processBack.setMessage("删除成功");
            return processBack;

        } catch (RuntimeException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
        } catch (Exception e) {
            e.printStackTrace();
        }
        processBack.setCode(ProcessBack.FAIL_CODE);
        processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
        return processBack;
    }

    @Override
    @Transactional
    public ProcessBack auditBatchForumThreadReplay(Long baseid, String repayIds, String status, String remark) {
        ProcessBack processBack = new ProcessBack();
        try {

            if (StringUtil.isEmpty(repayIds)) {
                processBack.setCode(ProcessBack.FAIL_CODE);
                processBack.setMessage("repayIds 不能为空");
                return processBack;
            }

            if (StringUtil.isEmpty(status)) {
                processBack.setCode(ProcessBack.FAIL_CODE);
                processBack.setMessage("status 不能为空");
                return processBack;
            }

            String[] strs = repayIds.split(",");
            Long dateline = System.currentTimeMillis();
            for (String s : strs) {
                Long res = Long.valueOf(s);
                ForumThreadReply forumThreadReply = baseMapper.selectById(res);
                if (forumThreadReply != null) {
                    forumThreadReply.setStatus(-2);//默认审核不通过
                    forumThreadReply.setOpermanid(baseid);
                    forumThreadReply.setOperdatetime(dateline);
                    forumThreadReply.setRemark(remark);
                    if (status.equals("1")) {//审核通过
                        forumThreadReply.setStatus(0);
                        forumThreadReply.setIsdelete(0);
                    }
                    int count = 0;
                    count = baseMapper.updateById(forumThreadReply);
                    if (!(count > 0)) {
                        throw new IllegalArgumentException("更新失败");
                    }
                }
            }
            processBack.setCode(ProcessBack.SUCCESS_CODE);
            processBack.setMessage("操作成功");
            return processBack;
        } catch (RuntimeException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
        } catch (Exception e) {
            e.printStackTrace();
        }
        processBack.setCode(ProcessBack.FAIL_CODE);
        processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
        return processBack;
    }

    @Override
    @Transactional
    public ProcessBack delBatchForumThreadReplay(String repayIds) {
        ProcessBack processBack = new ProcessBack();
        try {

            if (StringUtil.isEmpty(repayIds)) {
                processBack.setCode(ProcessBack.FAIL_CODE);
                processBack.setMessage("repayIds 不能为空");
                return processBack;
            }

            String[] strs = repayIds.split(",");
            for (String s : strs) {
                Long repayId = Long.valueOf(s);
                Wrapper<ForumThreadReplyAttach> forumThreadReplyAttachWrapper = Condition.create();
                forumThreadReplyAttachWrapper.eq("replyid", repayId);
                List<ForumThreadReplyAttach> lists = forumThreadReplyAttachService.selectList(forumThreadReplyAttachWrapper);
                for (ForumThreadReplyAttach forumThreadReplyAttach : lists) {
                    forumThreadReplyAttach.setIsdelete(1);
                    forumThreadReplyAttachService.updateById(forumThreadReplyAttach);
                }
                int count = 0;
                count = baseMapper.deleteById(repayId);
                if (!(count > 0)) {
                    throw new IllegalArgumentException("删除失败");
                }
            }
            processBack.setCode(ProcessBack.SUCCESS_CODE);
            processBack.setMessage("操作成功");
            return processBack;
        } catch (RuntimeException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
        } catch (Exception e) {
            e.printStackTrace();
        }
        processBack.setCode(ProcessBack.FAIL_CODE);
        processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
        return processBack;
    }
}
