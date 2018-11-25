package com.jxkj.cjm.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.common.util.AttachUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.mapper.ForumForumMapper;
import com.jxkj.cjm.mapper.ForumPostMapper;
import com.jxkj.cjm.mapper.UserMapper;
import com.jxkj.cjm.model.ForumAttachment;
import com.jxkj.cjm.model.ForumForum;
import com.jxkj.cjm.model.ForumPost;
import com.jxkj.cjm.model.User;
import com.jxkj.cjm.model.vo.ForumPostVo;
import com.jxkj.cjm.service.ForumAttachmentService;
import com.jxkj.cjm.service.ForumPostService;


@Service
public class ForumPostServiceImpl extends ServiceImpl<ForumPostMapper, ForumPost> implements ForumPostService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ForumForumMapper forumForumMapper;

    @Resource
    private ForumAttachmentService forumAttachmentService;

    @Value("${cjm.fdfs.host}")
    private String fdfsurl;//图片服务器路径

    /**
     * @param tid      主题id
     * @return ForumPostVo
     */
    public ForumPostVo getForumPostByTid(Long tid) {
         try {
              if (tid == null) {
                  throw new IllegalArgumentException("tid 不能为空");
             }

            ForumPost forumPost = new ForumPost();
            forumPost.setTid(tid);

            ForumPost forumPost1 = baseMapper.selectOne(forumPost);
            if (forumPost1 == null) {
                throw new IllegalArgumentException("'ForumPost' 信息找不到");
             }

            ForumPostVo forumPostVo = copyForumPostVoByForumPost(forumPost1);
            if (forumPostVo == null) {
                throw new IllegalArgumentException("copy 出异常了....");
            }
            return forumPostVo;
        } catch (Exception e) {
            e.printStackTrace();
              return null;
        }
    }


    //返回数据
    private ForumPostVo copyForumPostVoByForumPost(ForumPost forumPost) {
        try {
            ForumPostVo forumPostVo = new ForumPostVo();
            forumPostVo.setId(forumPost.getId());
            forumPostVo.setFid(forumPost.getFid());  //板块id
            forumPostVo.setTid(forumPost.getTid());  //主题id
            forumPostVo.setBaseid(forumPost.getBaseid());  //用户id
            forumPostVo.setSubject(forumPost.getSubject());  //主题标题
            forumPostVo.setContent(forumPost.getContent());  //内容
            forumPostVo.setStatus(forumPost.getStatus());  //状态-1审核中 -2审核失败 0审核通过
            forumPostVo.setDateline(forumPost.getDateline());  //添加时间
            forumPostVo.setUpdateline(forumPost.getUpdateline());  //修改时间
            forumPostVo.setUseip(forumPost.getUseip());  //用户ip
            forumPostVo.setAttachment(forumPost.getAttachment());  //附件个数
            forumPostVo.setIsdelete(forumPost.getIsdelete());  //是否删除1是0否
            forumPostVo.setUsesig(forumPost.getUsesig());  //是否带签名1是0否

            //默认值“”
            forumPostVo.setUsername("");  //作者用户名
            forumPostVo.setHeadurl(this.fdfsurl+"group1/M00/00/01/rBKphltr9kqAGgL-AAA0itDQK1w032.jpg");  //作者头像地址
            forumPostVo.setFname("");  //版块名称
            forumPostVo.setUpusername("");  //修改人用户名

            User user = userMapper.selectById(forumPostVo.getBaseid());
            if (user != null && user.getUsername() != null) {
                forumPostVo.setUsername(user.getUsername());  //作者用户名
            }

            ForumForum forumForum = forumForumMapper.selectById(forumPostVo.getFid());
            if (forumForum != null && forumForum.getName() != null) {
                forumPostVo.setFname(forumForum.getName());  //版块名称
            }

            if (user != null && user.getImg() != null && StringUtil.isNotEmpty(user.getImg())) {
                forumPostVo.setHeadurl(this.fdfsurl+user.getImg());  //作者头像地址
            }

            //转换 content
            String content = parseAttach(forumPostVo.getContent());
            forumPostVo.setContent(content);
            return forumPostVo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param @param  text
     * @param @return 设定文件
     * @return String    返回类型
     * @throws
     * @Title: parseAttach
     * @Description: TODO(返回给前端前进行attach 解析)
     */
    private String parseAttach(String text) {
        AttachUtil btoHtmlUtil = new AttachUtil();
        if (StringUtil.isEmpty(text)) {
            return text;
        }

        List<String> attachs = btoHtmlUtil.getAttachAidByContent(text);
        if (!(attachs.size() > 0)) {
            return text;
        }

        for (String str : attachs) {
            Long aid = Long.valueOf(str);
            ForumAttachment preForumAttachment = forumAttachmentService.getForumAttachmentByAid(aid);
            if (preForumAttachment != null) {
                 if (preForumAttachment.getIsimage() != null && preForumAttachment.getIsimage() == 0) {//附件

                } else if (preForumAttachment.getIsimage() != null && preForumAttachment.getIsimage() == 2) {//视频
                     String attachment = preForumAttachment.getAttachment();
                     String con = "<video controls='controls'> "+
                             "<source src='"+attachment+"' type='video/mp4' /> "+
                             " 您的设备不支持视频标签 "+
                             " </video> ";
                     text = text.replaceFirst("\\[attach]" + str + "\\[/attach]", con);
                } else {//图片
                    String attachment = preForumAttachment.getAttachment();
                    //替换
                    text = text.replaceFirst("\\[attach]" + str + "\\[/attach]", "<img id='aimg_" + str + "' aid='" + str + "' src='" + attachment + "' class='zoom'>");
                }
            }
        }
        return text;
    }

}

