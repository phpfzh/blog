package com.jxkj.cjm.service.impl;


import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.controller.BaseController;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.common.util.*;
import com.jxkj.cjm.mapper.*;
import com.jxkj.cjm.model.*;
import com.jxkj.cjm.model.vo.ForumPostVo;
import com.jxkj.cjm.model.vo.ForumThreadTagVo;
import com.jxkj.cjm.model.vo.ForumThreadVo;
import com.jxkj.cjm.model.vo.GroupUpdate;
import com.jxkj.cjm.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.common.constat.ForumThreadOperation_Constat;
import com.jxkj.cjm.common.response.Meta;


@Service
public class ForumThreadServiceImpl extends ServiceImpl<ForumThreadMapper, ForumThread> implements ForumThreadService {

    @Resource
    private ForumPostMapper forumPostMapper;

    @Resource
    private ForumForumService forumForumService;

    @Resource
    private ForumAttachmentService forumAttachmentService;

    @Resource
    private ForumThreadService forumThreadService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private ForumThreadOperationMapper forumThreadOperationMapper;

    @Resource
    private ForumThreadViewcountMapper forumThreadViewcountMapper;//主题浏览临时记录

    @Resource
    private ForumThreadViewRecordMapper forumThreadViewRecordMapper;//主题浏览记录

    @Resource
    private ForumThreadTagLinkMapper forumThreadTagLinkMapper;//类型关联

    @Resource
    private ForumThreadTagUserMapper forumThreadTagUserMapper;//用户tag 关联

    @Resource
    private ForumThreadTagMapper forumThreadTagMapper;//tag 表

    @Resource
    private ForumThreadCoverimgService forumThreadCoverimgService;

    @Resource
    private ForumPostService forumPostService;

    @Resource
    private ForumThreadTagService forumThreadTagService;

    @Value("${cjm.fdfs.host}")
    private String fdfsurl;//图片服务器路径

    private Lock saveLock = new ReentrantLock();

    /**
     * Title: insertForumThread
     * TODO:(保存主题信息)
     *
     * @param baseid     用户id
     * @param threadtype 主题类型
     * @param subject    主题
     * @param content    内容
     * @param userip     用户iP
     * @return
     */
    @Transactional
    public int insertForumThread(Long baseid, String coverimg, String fid, String threadtype,
                                 String subject, String content, String userip, String usesig, String tags, Meta meta) {
        try {

            saveLock.lock();

            //验证参数是否为空
            String str = checkInsertForumThread(baseid, fid, threadtype, subject, content);
            if (StringUtil.isNotEmpty(str)) {//验证不通过
                meta.setMessage(str);
                return 2;
            }

            //判断是否有图片
            AttachUtil attachUtil = new AttachUtil();
            //替换video 里面的花括号 正则不能替换
            content = attachUtil.replaceVideoDataSetup(content);
            Map<String, String> map = attachUtil.getImgSrcList(content);

            Long dateline = System.currentTimeMillis();
            Integer attachment = 0;//附件,0无附件 1普通附件 2有图片附件
            if (!map.isEmpty()) {//有上传图片
                attachment = 2;
            }

            if (StringUtil.isNotEmpty(coverimg)) {
                coverimg = coverimg.substring(this.fdfsurl.length());
                System.out.println(coverimg);
                forumThreadCoverimgService.updateStatus(coverimg);
            }

            //保存主题信息
            ForumThread forumThread = new ForumThread();
            forumThread.setFid(Long.valueOf(fid));  //板块id
            forumThread.setBaseid(baseid);  //用户id
            forumThread.setSubject(subject);  //标题
            forumThread.setDateline(dateline);  //发布时间
            forumThread.setViews(0);  //浏览量
            forumThread.setReplies(0);  //回复数
            forumThread.setDigest(0);  //是否精华1是0否
            forumThread.setAttachment(attachment);  //附件,0无附件 1普通附件 2有图片附件
            forumThread.setModerated(0);  //是否被管理员改动
            forumThread.setLikes(0);  //支持人数
            forumThread.setUnlikes(0);  //反对人数
            forumThread.setFavtimes(0);  //收藏次数
            forumThread.setSharetimes(0);  //分享次数
            forumThread.setStatus(0);  //状态-1审核中 -2审核失败 0审核通过
            forumThread.setIsdelete(0);  //是否删除1是0否
            forumThread.setSort(0);  //排序
            forumThread.setCoverimg(coverimg);
            forumThread.setThreadtype(Integer.valueOf(threadtype));  //主题类型 1原创2 转载 3翻译
            int count = 0;
            count = baseMapper.insert(forumThread);
            if (!(count > 0)) {
                throw new IllegalArgumentException("主题信息保存失败,主题信息：" + JSON.toJSONString(forumThread));
            }

            Integer usesigIn = 0;
            if (StringUtil.isNotEmpty(usesig) && usesig.contains("1")) {
                usesigIn = 1;
            }

            //保存主题内容
            ForumPost forumPost = new ForumPost();
            forumPost.setFid(Long.valueOf(fid)); //板块id
            forumPost.setTid(forumThread.getId()); //主题id
            forumPost.setBaseid(baseid); //用户id
            forumPost.setSubject(subject); //主题标题
            forumPost.setContent(content); //内容
            forumPost.setStatus(0); //状态-1审核中 -2审核失败 0审核通过
            forumPost.setDateline(dateline); //添加时间
            forumPost.setIsdelete(0); //是否删除1是0否
            forumPost.setUseip(userip); //用户ip
            forumPost.setAttachment(map.size()); //附件个数
            forumPost.setUsesig(usesigIn); //是否带签名1是0否
            int countPost = 0;
            countPost = forumPostMapper.insert(forumPost);
            if (!(countPost > 0)) {
                throw new IllegalArgumentException("主题内容信息保存失败,主题内容信息：" + JSON.toJSONString(forumPost));
            }

            //替换成attach标签
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Long aid = forumAttachmentService.getForumAttachmentUnusedAidByAttach(entry.getValue());
                if (aid == null) {
                    throw new IllegalArgumentException("未找到附件临时信息,url:" + entry.getValue());
                }

                int cc = forumAttachmentService.insertForumAttachmentByAidAndTid(aid, forumThread.getId(), forumPost.getId(), "");
                if (!(cc > 0)) {
                    throw new IllegalArgumentException("附件信息保存失败,url:" + entry.getValue());
                }
                content = content.replaceFirst(entry.getKey(), "[attach]" + aid + "[/attach]");
            }

            forumPost.setContent(content);
            int postUpdate = 0;
            postUpdate = forumPostMapper.updateById(forumPost);
            if (!(postUpdate > 0)) {
                throw new IllegalArgumentException("主题内容信息更新失败,主题内容信息:" + JSON.toJSONString(forumPost));
            }

            //保存tags
            String[] tagss = tags.split(",");
            for (String s : tagss) {
                ForumThreadTag forumThreadTag = getForumThreadTag(s);
                if (forumThreadTag == null) {
                    ForumThreadTag forumThreadTag1 = new ForumThreadTag();
                    forumThreadTag1.setName(s.trim());
                    Long dateLine = System.currentTimeMillis();
                    forumThreadTag1.setDateline(dateLine);
                    forumThreadTag1.setIsdelete(0);
                    forumThreadTagMapper.insert(forumThreadTag1);

                    insertForumThreadTagLink(forumThreadTag1.getId(), forumThread.getId());
                    insertForumThreadTagUser(forumThreadTag1.getId(), baseid);
                    continue;//跳出不继续执行下面代码
                }

                insertForumThreadTagLink(forumThreadTag.getId(), forumThread.getId());
                insertForumThreadTagUser(forumThreadTag.getId(), baseid);
            }
            return 1;
        } catch (RuntimeException e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            saveLock.unlock();
        }
    }

    /**
     * @param forumThreadVo
     * @param baseid        用户id
     * @param adminBaseid   管理员用户id
     * @return
     */
    public ProcessBack updateForumThread(ForumThreadVo forumThreadVo, Long baseid, Long adminBaseid) {
        ProcessBack processBack = new ProcessBack();
        try {

            if (baseid == null) {
                if (adminBaseid == null) {
                    throw new IllegalArgumentException("baseid 和adminBaseid 不能同时为空");
                }
            }

            if (adminBaseid == null) {
                if (baseid == null) {
                    throw new IllegalArgumentException("baseid 和adminBaseid 不能同时为空");
                }
            }

            //验证
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<ForumThreadVo>> constraintViolations = validator.validate(forumThreadVo, GroupUpdate.class);
            if (constraintViolations.iterator().hasNext() && constraintViolations.iterator().next().getMessage() != null) {
                processBack.setCode(ProcessBack.FAIL_CODE);
                processBack.setMessage(constraintViolations.iterator().next().getMessage());
                return processBack;
            }

            //判断是否有图片
            AttachUtil attachUtil = new AttachUtil();
            //替换video 里面的花括号 正则不能替换
            String content = attachUtil.replaceVideoDataSetup(forumThreadVo.getContent());
            Map<String, String> map = attachUtil.getImgSrcList(content);
            Integer attachment = 0;//附件,0无附件 1普通附件 2有图片附件
            if (!map.isEmpty()) {//有上传图片
                attachment = 2;
            }

            Long updateLine = System.currentTimeMillis();
            ForumThread forumThread = new ForumThread();
            forumThread.setId(forumThreadVo.getId());
            forumThread.setSubject(forumThreadVo.getSubject());
            forumThread.setFid(forumThreadVo.getFid());
            forumThread.setThreadtype(forumThreadVo.getThreadtype());
            forumThread.setAttachment(attachment);
            forumThread.setStatus(0);
            if (adminBaseid != null) {//管理员修改
                forumThread.setUpbaseid(adminBaseid);
                forumThread.setModeratline(updateLine);
                forumThread.setModerated(1);
            }
            int count = 0;
            count = baseMapper.updateById(forumThread);
            if (!(count > 0)) {
                throw new IllegalArgumentException("ForumThread 主题更新失败");
            }

            ForumPost forumPost1 = new ForumPost();
            forumPost1.setTid(forumThread.getId());
            ForumPost forumPost = forumPostMapper.selectOne(forumPost1);
            if (forumPost == null) {
                throw new IllegalArgumentException("主题内容信息找不到,tid:" + forumThread.getId());
            }

            List<Long> oldAids = new ArrayList<>();//记录原附件aid

            //替换成attach标签
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Long aid = forumAttachmentService.getForumAttachmentUnusedAidByAttach(entry.getValue());
                if (aid != null) {//新添加了图片
                    int cc = forumAttachmentService.insertForumAttachmentByAidAndTid(aid, forumThread.getId(), forumPost.getId(), "");
                    if (!(cc > 0)) {
                        throw new IllegalArgumentException("附件信息保存失败,url:" + entry.getValue());
                    }
                    content = content.replaceFirst(entry.getKey(), "[attach]" + aid + "[/attach]");
                } else {
                    //老图片找到aid 替换即可
                    Long aid2 = forumAttachmentService.getForumAttachmentAidByAttach(entry.getValue(), forumThread.getId());
                    if (aid2 != null) {
                        content = content.replaceFirst(entry.getKey(), "[attach]" + aid2 + "[/attach]");
                        oldAids.add(aid2);
                    }
                }
            }

            //判断修改删除的附件
            List<String> attachs = attachUtil.getAttachAidByContent(forumPost.getContent());
            for (String str : attachs) {
                Long aid = Long.valueOf(str);
                if (!oldAids.contains(aid)) {//修改删了附件，标记为已删除
                    forumAttachmentService.deleteForumAttachmentByAid(aid);
                }
            }
            forumPost.setUsesig(forumThreadVo.getUsesig());
            forumPost.setContent(content);
            forumPost.setStatus(0);
            forumPost.setFid(forumThread.getFid());
            forumPost.setAttachment(map.size());
            if (baseid != null) {
                forumPost.setUpdateline(updateLine);
            }
            int postCount = 0;
            postCount = forumPostMapper.updateById(forumPost);
            if (!(postCount > 0)) {
                throw new IllegalArgumentException("ForumPost 主题内容信息更新失败");
            }

            if (forumThreadVo.getTags() != null && StringUtil.isNotEmpty(forumThreadVo.getTags())) {
                //保存tags
                String[] tagss = forumThreadVo.getTags().split(",");
                for (String s : tagss) {
                    ForumThreadTag forumThreadTag = getForumThreadTag(s);
                    if (forumThreadTag == null) {
                        ForumThreadTag forumThreadTag1 = new ForumThreadTag();
                        forumThreadTag1.setName(s.trim());
                        Long dateLine = System.currentTimeMillis();
                        forumThreadTag1.setDateline(dateLine);
                        forumThreadTag1.setIsdelete(0);
                        forumThreadTag1.setCount(1);
                        forumThreadTagMapper.insert(forumThreadTag1);

                        insertForumThreadTagLink(forumThreadTag1.getId(), forumThread.getId());
                        if (baseid != null) {
                            insertForumThreadTagUser(forumThreadTag1.getId(), baseid);
                        }
                        continue;//跳出不继续执行下面代码
                    }

                    insertForumThreadTagLink(forumThreadTag.getId(), forumThread.getId());
                    if (baseid != null) {
                        insertForumThreadTagUser(forumThreadTag.getId(), baseid);
                    }
                }
            } else {
                //标签去掉
                ForumThreadTagLink forumThreadTagLink = new ForumThreadTagLink();
                forumThreadTagLink.setTid(forumThread.getId());
                forumThreadTagLinkMapper.deleteByMap(TransferUtil.beanToMap(forumThreadTagLink));
            }

            processBack.setCode(ProcessBack.SUCCESS_CODE);
            processBack.setMessage("修改成功");
            return processBack;

        } catch (Exception e) {
            e.printStackTrace();
        }
        processBack.setCode(ProcessBack.FAIL_CODE);
        processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
        return processBack;
    }

    /**
     * 添加主题浏览量
     *
     * @param tid 主题id
     * @param ip  ip地址
     */
    public void addForumThreadView(Long tid, String ip, Long baseid) {
        try {
            if (tid == null) {
                throw new IllegalArgumentException("tid 不能为空");
            }

            if (ip == null) {
                throw new IllegalArgumentException("ip 不能为空");
            }

            Date date = new Date();
            String dateStr = DateUtils.formatYY_MM_DD(date);
            ForumThreadViewRecord forumThreadViewRecord = new ForumThreadViewRecord();
            forumThreadViewRecord.setTid(tid);
            forumThreadViewRecord.setIp(ip);
            forumThreadViewRecord.setDatestr(dateStr);
            ForumThreadViewRecord viewRecord = forumThreadViewRecordMapper.selectOne(forumThreadViewRecord);

            if (viewRecord == null) {
                ForumThreadViewcount forumThreadViewcount = new ForumThreadViewcount();
                forumThreadViewcount.setTid(tid);
                ForumThreadViewcount forumThreadViewcount1 = forumThreadViewcountMapper.selectOne(forumThreadViewcount);
                if (forumThreadViewcount1 == null) {
                    ForumThreadViewcount forumThreadViewcount2 = new ForumThreadViewcount();
                    forumThreadViewcount2.setTid(tid);
                    forumThreadViewcount2.setCount(1);
                    forumThreadViewcountMapper.insert(forumThreadViewcount2);
                } else {
                    forumThreadViewcount1.setCount(forumThreadViewcount1.getCount() + 1);
                    forumThreadViewcountMapper.updateById(forumThreadViewcount1);
                }

                Long dateline = System.currentTimeMillis();
                forumThreadViewRecord.setDateline(dateline);
                if (baseid != null) {
                    forumThreadViewRecord.setBaseid(baseid);
                }
                forumThreadViewRecordMapper.insert(forumThreadViewRecord);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Title: auditBatchForumThread
     * TODO:(批量审核主题 )
     *
     * @param tids   主题id集合
     * @param status 审核通过1 审核失败0
     * @param baseid 审核用户
     * @return
     */
    @Transactional
    public int auditBatchForumThread(String tids, String status, Long baseid, String userip, Meta meta) {
        try {

            if (StringUtil.isEmpty(tids)) {
                meta.setMessage("'tids' 不能为空");
                return 2;
            }

            if (StringUtil.isEmpty(status)) {
                meta.setMessage("'status' 不能为null");
                return 2;
            }

            String[] tid = tids.split(",");

            for (String string : tid) {
                int count = auditForumThread(string, status, baseid, userip, meta);
                if (count != 1) {
                    throw new IllegalArgumentException("主题审核操作失败");
                }
            }
            return 1;
        } catch (RuntimeException e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Title: auditForumThread
     * TODO:(审核主题 )
     *
     * @param tid    主题id
     * @param status 审核通过1 审核失败0
     * @param baseid 审核用户
     * @return
     */
    @Transactional
    public int auditForumThread(String tid, String status, Long baseid, String userip, Meta meta) {
        try {

            if (StringUtil.isEmpty(tid)) {
                meta.setMessage("'tid' 不能为null");
                return 2;
            }

            if (StringUtil.isEmpty(status)) {
                meta.setMessage("'status' 不能为null");
                return 2;
            }

            Long tidL = Long.valueOf(tid);

            ForumThread forumThread = new ForumThread();
            forumThread.setId(tidL);
            forumThread.setModerated(1);
            forumThread.setStatus(-2);//状态-1审核中 -2审核失败 0审核通过
            forumThread.setIsdelete(1);

            ForumPost entity = new ForumPost();
            entity.setTid(tidL);
            ForumPost forumPost = forumPostMapper.selectOne(entity);
            if (forumPost == null) {
                throw new IllegalArgumentException("主题内容信息找不到,tid:" + tidL);
            }

            forumPost.setStatus(-2);//状态-1审核中 -2审核失败 0审核通过
            forumPost.setIsdelete(1);//是否删除 1是0否
            if (status.equals("1")) {//审核通过
                forumThread.setStatus(0);//状态-1审核中 -2审核失败 0审核通过
                forumThread.setIsdelete(0);//是否删除 1是0否
                forumPost.setStatus(0);//状态-1审核中 -2审核失败 0审核通过
                forumPost.setIsdelete(0);//是否删除 1是0否
                int count = 0;
                count = baseMapper.updateById(forumThread);
                if (!(count > 0)) {
                    throw new IllegalArgumentException("主题更新失败");
                }

                int postCount = 0;
                postCount = forumPostMapper.updateById(forumPost);
                if (!(postCount > 0)) {
                    //添加操作日志
                    insertForumThreadOperation(tidL, 0, ForumThreadOperation_Constat.AUDITFA, baseid, userip);
                    throw new IllegalArgumentException("主题内容更新失败");
                } else {
                    insertForumThreadOperation(tidL, 1, ForumThreadOperation_Constat.AUDITFA, baseid, userip);
                }

                return 1;
            }

            int count = 0;
            count = baseMapper.updateById(forumThread);

            if (!(count > 0)) {
                throw new IllegalArgumentException("主题更新失败");
            }

            int postCount = 0;
            postCount = forumPostMapper.updateById(forumPost);
            if (!(postCount > 0)) {
                //添加操作日志
                insertForumThreadOperation(tidL, 0, ForumThreadOperation_Constat.AUDITFA, baseid, userip);
                throw new IllegalArgumentException("主题内容更新失败");
            } else {
                insertForumThreadOperation(tidL, 1, ForumThreadOperation_Constat.AUDITFA, baseid, userip);
            }

            return 1;
        } catch (RuntimeException e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Title: delForumThread
     * TODO:(删除主题)
     *
     * @param tid    主题id
     * @param status 状态0删除 1恢复
     * @param baseid 操作用户
     * @param userip 操作ip
     * @param meta
     * @return
     */
    @Transactional
    public int delForumThread(String tid, String status, Long baseid, String userip, Meta meta) {
        try {

            if (StringUtil.isEmpty(tid)) {
                meta.setMessage("'tid' 不能为空");
                return 2;
            }

            if (StringUtil.isEmpty(status)) {
                meta.setMessage("'status' 不能为空");
                return 2;
            }

            Long tidL = Long.valueOf(tid);

            ForumThread forumThread = new ForumThread();
            forumThread.setId(tidL);
            forumThread.setModerated(1);
            forumThread.setStatus(-2);//状态-1审核中 -2审核失败 0审核通过
            forumThread.setIsdelete(1);

            ForumPost entity = new ForumPost();
            entity.setTid(tidL);
            ForumPost forumPost = forumPostMapper.selectOne(entity);
            if (forumPost == null) {
                throw new IllegalArgumentException("主题内容信息找不到,tid:" + tidL);
            }
            forumPost.setStatus(-2);//状态-1审核中 -2审核失败 0审核通过
            forumPost.setIsdelete(1);
            if (status.equals("1")) {//恢复
                forumThread.setStatus(0);//状态-1审核中 -2审核失败 0审核通过
                forumThread.setIsdelete(0);
                forumPost.setStatus(0);//状态-1审核中 -2审核失败 0审核通过
                forumPost.setIsdelete(0);
                int count = 0;
                count = baseMapper.updateById(forumThread);
                if (!(count > 0)) {
                    throw new IllegalArgumentException("主题更新失败");
                }

                int postCount = 0;
                postCount = forumPostMapper.updateById(forumPost);
                if (!(postCount > 0)) {
                    //添加操作日志
                    insertForumThreadOperation(tidL, 0, ForumThreadOperation_Constat.UPD, baseid, userip);
                    throw new IllegalArgumentException("主题内容更新失败");
                } else {
                    insertForumThreadOperation(tidL, 1, ForumThreadOperation_Constat.UPD, baseid, userip);
                }

                return 1;
            }

            int count = 0;
            count = baseMapper.updateById(forumThread);

            if (!(count > 0)) {
                throw new IllegalArgumentException("主题更新失败");
            }

            int postCount = 0;
            postCount = forumPostMapper.updateById(forumPost);
            if (!(postCount > 0)) {
                insertForumThreadOperation(tidL, 0, ForumThreadOperation_Constat.DEL, baseid, userip);
                throw new IllegalArgumentException("主题内容更新失败");
            }
            insertForumThreadOperation(tidL, 1, ForumThreadOperation_Constat.DEL, baseid, userip);
            return 1;
        } catch (RuntimeException e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Title: delForumThread
     * TODO:(批量删除主题)
     *
     * @param tids   主题id
     * @param status 状态0删除 1恢复
     * @param baseid 操作用户
     * @param userip 操作ip
     * @param meta
     * @return
     */
    @Transactional
    public int delBatchForumThread(String tids, String status, Long baseid, String userip, Meta meta) {
        try {

            if (StringUtil.isEmpty(tids)) {
                meta.setMessage("'tids' 不能为空");
                return 2;
            }

            if (StringUtil.isEmpty(status)) {
                meta.setMessage("'status' 不能为null");
                return 2;
            }

            String[] tid = tids.split(",");

            for (String string : tid) {
                int count = delForumThread(string, status, baseid, userip, meta);
                if (count != 1) {
                    throw new IllegalArgumentException("主题删除操作失败");
                }
            }
            return 1;
        } catch (RuntimeException e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param pageNum     页码
     * @param pageSize    条数
     * @param forumThread 查询条件
     * @return
     */
    public ProcessBack getForumThreads(String pageNum, String pageSize, String orderType, ForumThread forumThread) {
        ProcessBack processBack = new ProcessBack();
        try {
            PageHelper.orderBy(null);
            if (orderType != null && StringUtil.isNotEmpty(orderType)) {
                if (orderType.equals("views")) {//
                    PageHelper.orderBy("views DESC,replies DESC,dateline DESC");
                } else if (orderType.equals("replies")) {
                    PageHelper.orderBy("replies DESC,views DESC,dateline DESC");
                } else {
                    PageHelper.orderBy("dateline DESC,replies DESC,views DESC");
                }
            } else {
                PageHelper.orderBy("dateline DESC,replies DESC,views DESC");
            }
            // 处理分页请求
            Integer num = 1;
            Integer size = 20;

            if (pageNum != null && !"".equals(pageNum)) {
                num = Integer.parseInt(pageNum);
            }
            if (pageSize != null && !"".equals(pageSize)) {
                size = Integer.parseInt(pageSize);
            }
            //String sortString = "id.desc";
            //	Order.formString(sortString);
            PageHelper.startPage(num, size);
            List<ForumThread> lists = baseMapper.selectByMap(TransferUtil.beanToMap(forumThread));
            List<ForumThreadVo> voLists = new ArrayList<>();
            for (ForumThread entity1 : lists) {
                ForumThreadVo en = new ForumThreadVo();
                User user = userMapper.selectById(entity1.getBaseid());
                ForumForum forumForum = forumForumService.selectById(entity1.getFid());
                ForumPostVo forumPostVo = forumPostService.getForumPostByTid(entity1.getId());
                List<ForumThreadTagVo> threadTagVos = forumThreadTagService.getForumThreadTagsByTid(forumThread.getId());

                String threadTypeName = "原创";
                if (entity1.getThreadtype() != null && entity1.getThreadtype().equals(2)) {
                    threadTypeName = "转载";
                } else if (entity1.getThreadtype() != null && entity1.getThreadtype().equals(3)) {
                    threadTypeName = "翻译";
                }

                String datelineStr = "";
                if(entity1.getDateline() != null){
                    datelineStr = DateUtils.formatDate(entity1.getDateline());
                }
                en.setDatelinestr(datelineStr);
                en.setStaticlink(entity1.getStaticlink());//静态化url
                en.setListtags(threadTagVos);//标签
                en.setUsername(user.getUsername());//用户名
                en.setSubject(entity1.getSubject());//标题
                en.setDateline(entity1.getDateline());//时间戳
                en.setThreadtype(entity1.getThreadtype());//主题类型
                en.setFname(forumForum.getName());//板块名称
                en.setId(entity1.getId());//tid
                en.setHeadurl(forumPostVo.getHeadurl());//用户头像地址
                en.setViews(entity1.getViews());//浏览数
                en.setReplies(entity1.getReplies());//回复数
                en.setFid(entity1.getFid());//板块id
                en.setBaseid(entity1.getBaseid());//用户id
                en.setThreadtypename(threadTypeName);
                String comme = entity1.getCoverimg();
                if (StringUtil.isEmpty(comme)) {
                    comme = getDefaultCoverimg();
                }
                en.setCoverimg(this.fdfsurl + comme);
                /*if (forumPostVo != null) {
                    en.setContent(forumPostVo.getContent());
                }*/
                voLists.add(en);
            }

            PageInfo<ForumThread> pagehelper = new PageInfo<ForumThread>(lists);
            pagehelper.setNavigateFirstPage(1);
            Integer lastPageNum = 0;
            if (pagehelper.getTotal() % size == 0) {
                lastPageNum = (int) pagehelper.getTotal() / size;
            } else {
                lastPageNum = (int) pagehelper.getTotal() / size + 1;
            }
            pagehelper.setNavigateLastPage(lastPageNum);

            Map<String,Object> map = new HashMap<>();
            map.put("voLists",voLists);
            map.put("pagehelper",pagehelper);
            processBack.setCode(ProcessBack.SUCCESS_CODE);
            processBack.setMessage("查询成功");
            processBack.setData(map);
            return processBack;
        }catch (Exception e){
            e.printStackTrace();
        }
        processBack.setCode(ProcessBack.FAIL_CODE);
        processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
        return processBack;
    }

    /**
     *  查询点击排行主题数
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<ForumThreadVo> getForumThreadsByViewOrder(String pageNum,String pageSize){
             // 处理分页请求
            Integer num = 1;
            Integer size = 10;
             if (pageNum != null && !"".equals(pageNum)) {
                num = Integer.parseInt(pageNum);
            }
            if (pageSize != null && !"".equals(pageSize)) {
                size = Integer.parseInt(pageSize);
            }
            ForumThread forumThread= new ForumThread();
            forumThread.setIsdelete(0);
            forumThread.setStatus(0);
            PageHelper.orderBy("views DESC,replies DESC,dateline DESC");
            PageHelper.startPage(num, size);
            List<ForumThread> lists = baseMapper.selectByMap(TransferUtil.beanToMap(forumThread));
            List<ForumThreadVo> voLists = new ArrayList<>();
            for (ForumThread entity1 : lists) {
                ForumThreadVo en = new ForumThreadVo();
                en.setSubject(entity1.getSubject());//标题
                en.setId(entity1.getId());//tid
                en.setStaticlink(entity1.getStaticlink());
                voLists.add(en);
            }
            return voLists;
    }

    /**
     * 根据tid 查询主题详情信息
     * @param tid
     * @return
     */
    public ProcessBack getSingleForumThreadByTid(Long tid, Long baseid,HttpServletRequest request){
        ProcessBack processBack = new ProcessBack();
        try{

            if (tid == null) {
                throw new IllegalArgumentException("tid 不能为空");
            }

            ForumThread forumThread = baseMapper.selectById(tid);
            if (forumThread == null) {
                throw new IllegalArgumentException("未找到主题信息");
            }
            String userip = "";
            try {
                userip = IPUtil.getIpAdd(request);
            } catch (Exception e) {
                e.printStackTrace();
            }

            ForumPostVo forumPostVo = forumPostService.getForumPostByTid(tid);
            if (forumPostVo == null) {
                throw new IllegalArgumentException("未找到帖子信息");
            }

            ForumForum forumForum = forumForumService.selectById(forumThread.getFid());
            List<ForumThreadTagVo> threadTagVos = forumThreadTagService.getForumThreadTagsByTid(forumThread.getId());


            ForumThreadVo en = new ForumThreadVo();
            String threadTypeName = "原创";
            if (forumThread.getThreadtype() != null && forumThread.getThreadtype().equals(2)) {
                threadTypeName = "转载";
            } else if (forumThread.getThreadtype() != null && forumThread.getThreadtype().equals(3)) {
                threadTypeName = "翻译";
            }

            Wrapper<ForumThread> forumThreadWrapper = Condition.create();
            forumThreadWrapper.eq("baseid", forumThread.getBaseid());
            forumThreadWrapper.eq("isdelete", 0);
            int count = baseMapper.selectCount(forumThreadWrapper);//查询作者总主题数
            String datelineStr = "";
            if(forumThread.getDateline() != null){
                datelineStr = DateUtils.formatDate(forumThread.getDateline());
            }
            en.setUsesig(forumPostVo.getUsesig());
            en.setDatelinestr(datelineStr);
            en.setStaticlink(forumThread.getStaticlink());//静态化url
            en.setViews(forumThread.getViews());//浏览数
            en.setCount(count);//作者总主题数
            en.setReplies(forumThread.getReplies());//回复数
            en.setThreadtype(forumThread.getThreadtype());//主题类型
            en.setId(forumThread.getId());//tid
            en.setFid(forumThread.getFid());//板块id
            en.setFname(forumForum.getName());//版块名称
            en.setPid(forumPostVo.getId());//帖子id
            en.setUsername(forumPostVo.getUsername());//用户名
            en.setSubject(forumPostVo.getSubject());//标题
            en.setDateline(forumPostVo.getDateline());//时间戳
            en.setHeadurl(forumPostVo.getHeadurl());//用户头像地址
            en.setFname(forumPostVo.getFname());//板块名称
            en.setBaseid(forumPostVo.getBaseid());//用户id
            en.setThreadtypename(threadTypeName);
            en.setIsdelete(forumThread.getIsdelete());
            en.setStatus(forumThread.getStatus());
            en.setContent(forumPostVo.getContent());
            en.setListtags(threadTagVos);
            String comme = forumThread.getCoverimg();
            if (StringUtil.isEmpty(comme)) {
                comme = getDefaultCoverimg();
            }

            en.setCoverimg(this.fdfsurl + comme);
            forumThreadService.addForumThreadView(tid, userip, baseid);
            processBack.setMessage("查询成功");
            processBack.setCode(ProcessBack.SUCCESS_CODE);
            processBack.setData(en);
            return processBack;
        }catch(Exception e){
            e.printStackTrace();
        }
        processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
        processBack.setCode(ProcessBack.FAIL_CODE);
        return processBack;
    }

    //添加操作日志
    private int insertForumThreadOperation(Long tid, Integer status, String type, Long baseid, String userip) {
        PreForumThreadOperation forumThreadOperation = new PreForumThreadOperation();
        Long dateline = System.currentTimeMillis();
        forumThreadOperation.setTid(tid);
        forumThreadOperation.setStatus(status);
        forumThreadOperation.setType(type);
        forumThreadOperation.setDateline(dateline);
        forumThreadOperation.setBaseid(baseid);
        forumThreadOperation.setUsername(getUserNameByBaseId(baseid));
        forumThreadOperation.setUserip(userip);
        int count = 0;
        count = forumThreadOperationMapper.insert(forumThreadOperation);
        return count;

    }

    private String getUserNameByBaseId(Long baseid) {
        if (baseid != null) {
            User user = userMapper.selectById(baseid);
            if (user != null && user.getUsername() != null) {
                return user.getUsername();
            }
        }
        return null;
    }

    /**
     * Title: checkInsertForumThread
     * TODO:(校颜参数)
     *
     * @param baseid     用户id
     * @param fid        板块id
     * @param threadtype 主题类型
     * @param subject    标题
     * @param content    内容
     * @return
     */
    private String checkInsertForumThread(Long baseid, String fid, String threadtype,
                                          String subject, String content) {
        if (baseid == null) {
            return "'baseid' 用户不能为空";
        }

        if (StringUtil.isEmpty(subject)) {
            return "'subject' 主题不能为空";
        }

        if (StringUtil.isEmpty(fid)) {
            return "'fid' 板块不能为空";
        }

        if (StringUtil.isEmpty(content)) {
            return "'content' 内容不能为空";
        }

        if (StringUtil.isEmpty(threadtype)) {
            return "'threadtype' 类型不能为空";
        }

        if (!(threadtype.contains("1")
                || threadtype.contains("2")
                || threadtype.contains("3"))) {
            return "'threadtype' 类型值范围在1-3";
        }
        return "";
    }

    //查询tag 对象
    private ForumThreadTag getForumThreadTag(String name) {
        if (StringUtil.isEmpty(name)) {
            return null;
        }

        ForumThreadTag forumThreadTag = new ForumThreadTag();
        forumThreadTag.setName(name.trim());
        forumThreadTag.setIsdelete(0);
        return forumThreadTagMapper.selectOne(forumThreadTag);
    }

    private void insertForumThreadTagLink(Long tagid, Long tid) {
        ForumThreadTagLink forumThreadTagLink = new ForumThreadTagLink();
        forumThreadTagLink.setTagid(tagid);
        forumThreadTagLink.setTid(tid);
        List<ForumThreadTagLink> tagLinks = forumThreadTagLinkMapper.selectByMap(TransferUtil.beanToMap(forumThreadTagLink));
        if (!(tagLinks.size() > 0)) {
            forumThreadTagLinkMapper.insert(forumThreadTagLink);
        }
    }

    private void insertForumThreadTagUser(Long tagid, Long baseid) {
        ForumThreadTagUser forumThreadTagUser = new ForumThreadTagUser();
        forumThreadTagUser.setTagid(tagid);
        forumThreadTagUser.setBaseid(baseid);
        List<ForumThreadTagUser> tagLinks = forumThreadTagUserMapper.selectByMap(TransferUtil.beanToMap(forumThreadTagUser));
        if (!(tagLinks.size() > 0)) {
            forumThreadTagUserMapper.insert(forumThreadTagUser);
        }
    }

    /**
     * 把前端数据复制到持久化实体类上
     *
     * @param entity   持久化实体类
     * @param entityVo 前端接收数据实体类
     */
    private ForumThread copyEntityByEntityVo(ForumThread entity, ForumThreadVo entityVo) throws IllegalAccessException {
        Field[] entityFields = entity.getClass().getDeclaredFields();
        Field[] entityVoFields = entityVo.getClass().getDeclaredFields();
        for (Field field : entityVoFields) {
            field.setAccessible(true); // 设置些属性是可以访问的
            String name = field.getName();
            Object val = field.get(entityVo);
            Type tpye = field.getGenericType();
            if (!tpye.toString().contains("class")) {//判断是否是属性
                continue;
            }

            if (val == null || "".equals(val)) {
                continue;
            }

            for (Field field1 : entityFields) {
                if (field1.getName().equals(name)) {
                    field1.setAccessible(true); // 设置些属性是可以访问的
                    field1.set(entity, val);
                    break;
                } else if (name.equals("id")) {
                    try {
                        Class<?> cd = entity.getClass().getSuperclass();
                        Field field2 = cd.getDeclaredField("id");
                        field2.setAccessible(true); // 设置些属性是可以访问的
                        field2.set(entity, val);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        System.out.println(JSON.toJSONString(entity));
        return entity;
    }

    /**
     * 获取默认封面图片
     *
     * @return
     */
    private String getDefaultCoverimg() {
        String coverimg = "group1/M00/00/01/rBKphltr9JqAM-ouAABQzi7kwNo368.jpg";
        return coverimg;
    }
}
