package com.jxkj.cjm.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.common.component.FastDFSUploadComponent;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.mapper.ForumThreadReplyAttachMapper;
import com.jxkj.cjm.model.ForumThreadReplyAttach;
import com.jxkj.cjm.service.ForumThreadReplyAttachService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ForumThreadReplyAttachServiceImpl extends ServiceImpl<ForumThreadReplyAttachMapper,ForumThreadReplyAttach> implements ForumThreadReplyAttachService {

    protected static Logger LOGGER = LoggerFactory.getLogger(ForumThreadReplyAttachServiceImpl.class);

    @Resource
    private FastDFSUploadComponent fastDFSUploadComponent;//图片上传工具类

    @Value("${cjm.fdfs.host}")
    private String fdfsurl;//图片服务器路径

    /**
     *
     * @Title: uploadImage
     * @Description: TODO(回复图片上传接口)
     * @param @param multipartFile 上传的文件
     * @param @param baseid 用户id
     * @param @return    设定文件
     * @return ProcessBack    返回类型
     * @throws
     */
    @Transactional
    public ProcessBack uploadImage(MultipartFile multipartFile, Long baseid){
        ProcessBack processBack =new ProcessBack();
        try{
            //上传原图&&缩率图
            Map<String,Object> imageUploadMap = fastDFSUploadComponent.uploadImageAndCrtThumbImage(multipartFile);
            if(imageUploadMap.get(FastDFSUploadComponent.FDFS_STATE).equals(FastDFSUploadComponent.FDFS_FAIL_STATUS)){//图片上传失败
                throw new IllegalArgumentException("图片上传失败");
            }

            String url = (String) imageUploadMap.get(FastDFSUploadComponent.FDFS_URL);//原图路径
            String thumburl = (String) imageUploadMap.get(FastDFSUploadComponent.FDFS_THUMBURL);//缩率图路径

            //保存图片回复
            ForumThreadReplyAttach forumThreadReplyAttach = new ForumThreadReplyAttach();
            forumThreadReplyAttach.setReplyid((long)0); // 回复id
            forumThreadReplyAttach.setBaseid(baseid); //用户id
            Long dateline = System.currentTimeMillis();
            forumThreadReplyAttach.setDateline(dateline); //时间撮
            forumThreadReplyAttach.setStatus(0); //状态1使用0未使用
            forumThreadReplyAttach.setAttach(url); //原图路径
            forumThreadReplyAttach.setThumbattach(thumburl); //缩率图路径
            forumThreadReplyAttach.setFilename(multipartFile.getOriginalFilename()); //文件名称
            forumThreadReplyAttach.setFilesize((int)multipartFile.getSize()); //文件大小
            forumThreadReplyAttach.setIsdelete(0);
            int count = 0;
            count = baseMapper.insert(forumThreadReplyAttach);

            if(!(count > 0)){
                if(LOGGER.isDebugEnabled()){
                    LOGGER.debug("保存的数据是："+ JSON.toJSONString(forumThreadReplyAttach));
                }
                throw new IllegalArgumentException("图片回复记录保存失败");
            }
            Map<String,Object> map = new HashMap<>();
            map.put("src", fastDFSUploadComponent.getResAccessUrl(thumburl));
            map.put("attach", "[attach]" + forumThreadReplyAttach.getId() + "[/attach]");
            processBack.setData(map);
            processBack.setCode(ProcessBack.SUCCESS_CODE);
            processBack.setMessage("图片上传成功");
            return processBack;
        }catch(RuntimeException e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
         }catch(Exception e){
            e.printStackTrace();
        }
        processBack.setCode(ProcessBack.FAIL_CODE);
        processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
        return processBack;
    }

    /**
     *
     * @Title: getPreReplyAttachByAttach
     * @Description: TODO(根据图片url 查找回复图片信息)
     * @param @param attach  图片url
     * @param @return    设定文件
     * @return PreReplyAttach    返回类型
     * @throws
     */
    public ForumThreadReplyAttach getForumThreadReplyAttachByAttach(String attach){
        if(StringUtil.isEmpty(attach)){
            throw new IllegalArgumentException("'attach' 不能为空");
        }

        try{

            Wrapper<ForumThreadReplyAttach> wrapper = Condition.create();
            wrapper.eq("attach", attach);
            wrapper.orNew().eq("thumbattach",attach);
            List<ForumThreadReplyAttach> preReplyAttachs = baseMapper.selectList(wrapper);
            if(preReplyAttachs.size() > 1){
                throw new IllegalArgumentException("回复图片信息不能超过两条,attach:"+attach);
            }

            if(!(preReplyAttachs.size() > 0)){
                throw new IllegalArgumentException("回复图片信息找不到,attach:"+attach);
            }
            return preReplyAttachs.get(0);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
