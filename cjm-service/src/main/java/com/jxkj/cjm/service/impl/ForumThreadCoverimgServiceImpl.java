package com.jxkj.cjm.service.impl;

import com.alibaba.fastjson.JSON;
import com.jxkj.cjm.common.component.FastDFSUploadComponent;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.ForumThreadReplyAttach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.model.ForumThreadCoverimg;
import com.jxkj.cjm.service.ForumThreadCoverimgService;
import com.jxkj.cjm.mapper.ForumThreadCoverimgMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;


@Service
public class ForumThreadCoverimgServiceImpl extends ServiceImpl<ForumThreadCoverimgMapper, ForumThreadCoverimg> implements ForumThreadCoverimgService {

    @Resource
    private FastDFSUploadComponent fastDFSUploadComponent;//图片上传工具类

    @Value("${cjm.fdfs.host}")
    private String fdfsurl;//图片服务器路径

    @Override
    @Transactional
    public ProcessBack uploadCoverimg(MultipartFile multipartFile) {
        ProcessBack processBack = new ProcessBack();
        try {
            //上传原图&&缩率图
            Map<String, Object> imageUploadMap = fastDFSUploadComponent.uploadFile(multipartFile);
            if (imageUploadMap.get(FastDFSUploadComponent.FDFS_STATE).equals(FastDFSUploadComponent.FDFS_FAIL_STATUS)) {//图片上传失败
                throw new IllegalArgumentException("图片上传失败");
            }

            String url = (String) imageUploadMap.get(FastDFSUploadComponent.FDFS_URL);//原图路径
            //保存图片回复
            ForumThreadCoverimg forumThreadCoverimg = new ForumThreadCoverimg();
            Long dateline = System.currentTimeMillis();
            forumThreadCoverimg.setDateline(dateline); //时间撮
            forumThreadCoverimg.setStatus(0); //状态1使用0未使用
            forumThreadCoverimg.setUrl(url); //原图路径
            int count = 0;
            count = baseMapper.insert(forumThreadCoverimg);

            processBack.setData(fastDFSUploadComponent.getResAccessUrl(url));
            processBack.setCode(ProcessBack.SUCCESS_CODE);
            processBack.setMessage("图片上传成功");
            return processBack;
        } catch (RuntimeException e) {
            e.printStackTrace();
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
    public ProcessBack updateStatus(String coverimg){
        ProcessBack processBack = new ProcessBack();
        try {
            if(coverimg == null){
                throw new IllegalArgumentException("coverimg 不能为空");
            }

            if(coverimg.contains(this.fdfsurl)){
                coverimg = coverimg.substring(this.fdfsurl.length());
            }

            ForumThreadCoverimg forumThreadCoverimg = new ForumThreadCoverimg();
            forumThreadCoverimg.setUrl(coverimg);
            ForumThreadCoverimg forumThreadCoverimg2 = baseMapper.selectOne(forumThreadCoverimg);
            if(forumThreadCoverimg2 == null){
                 throw new IllegalArgumentException("未找到主题封面临时记录信息，url:"+coverimg);
            }

            forumThreadCoverimg2.setStatus(1);//状态1使用0未使用
            baseMapper.updateById(forumThreadCoverimg2);

            processBack.setCode(ProcessBack.SUCCESS_CODE);
            processBack.setMessage("更新成功");
            return processBack;
        } catch (RuntimeException e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
        } catch (Exception e) {
            e.printStackTrace();
        }
        processBack.setCode(ProcessBack.FAIL_CODE);
        processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
        return processBack;
    }
}
