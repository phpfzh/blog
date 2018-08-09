package com.jxkj.cjm.service.impl;


import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.jxkj.cjm.common.util.TransferUtil;
import com.jxkj.cjm.mapper.ForumThreadTagLinkMapper;
import com.jxkj.cjm.model.ForumThreadTagLink;
import com.jxkj.cjm.model.vo.ForumThreadTagVo;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jxkj.cjm.model.ForumThreadTag;
import com.jxkj.cjm.service.ForumThreadTagService;
import com.jxkj.cjm.mapper.ForumThreadTagMapper;

import javax.annotation.Resource;
import java.util.*;


@Service
public class ForumThreadTagServiceImpl extends ServiceImpl<ForumThreadTagMapper, ForumThreadTag> implements ForumThreadTagService {

    @Resource
    private ForumThreadTagLinkMapper forumThreadTagLinkMapper;

    public List<ForumThreadTagVo> getForumThreadTagsByTid(Long tid) {
        if (tid != null) {
            ForumThreadTagLink forumThreadTagLink = new ForumThreadTagLink();
            forumThreadTagLink.setTid(tid);
            List<ForumThreadTagLink> lis = forumThreadTagLinkMapper.selectByMap(TransferUtil.beanToMap(forumThreadTagLink));
            if (lis.size() > 0) {
                Set<Long> ids = new HashSet<>();
                for (ForumThreadTagLink forumThreadTagLink1 : lis) {
                    ids.add(forumThreadTagLink1.getTagid());
                }

                Wrapper<ForumThreadTag> threadTagWrapper = Condition.create();
                threadTagWrapper.in("id", ids);
                List<ForumThreadTag> threadTags = baseMapper.selectList(threadTagWrapper);
                List<ForumThreadTagVo> forumThreadTagVos = new ArrayList<>();
                for (ForumThreadTag forumThreadTag : threadTags) {
                    ForumThreadTagVo forumThreadTagVo = new ForumThreadTagVo();
                    forumThreadTagVo.setName(forumThreadTag.getName());
                    forumThreadTagVo.setId(forumThreadTag.getId());
                    forumThreadTagVos.add(forumThreadTagVo);
                }
                return forumThreadTagVos;
            }
        }
        return new ArrayList<>(0);
    }
}
