package com.jxkj.cjm.service;

import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.ForumThreadReplyAttach;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.multipart.MultipartFile;

public interface ForumThreadReplyAttachService extends IService<ForumThreadReplyAttach>{
    /**
     *
     * @Title: uploadImage
     * @Description: TODO(图片上传接口)
     * @param @param multipartFile 上传的文件
     * @param @param baseid 用户id
     * @param @return    设定文件
     * @return ProcessBack    返回类型
     * @throws
     */
    public ProcessBack uploadImage(MultipartFile multipartFile, Long baseid);

    /**
     *
     * @Title: getForumThreadReplyAttachByAttach
     * @Description: TODO(根据图片url 查找回复图片信息)
     * @param @param attach  图片url
     * @param @return    设定文件
     * @return ForumThreadReplyAttach    返回类型
     * @throws
     */
    public ForumThreadReplyAttach getForumThreadReplyAttachByAttach(String attach);
}