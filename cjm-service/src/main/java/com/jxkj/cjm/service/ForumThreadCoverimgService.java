package com.jxkj.cjm.service;

import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.model.ForumThreadCoverimg;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.multipart.MultipartFile;

public interface ForumThreadCoverimgService extends IService<ForumThreadCoverimg>{
    //上传主题封面图
    public ProcessBack uploadCoverimg(MultipartFile multipartFile);

    public ProcessBack updateStatus(String coverimg);

}