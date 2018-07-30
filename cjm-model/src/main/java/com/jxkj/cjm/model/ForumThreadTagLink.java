package com.jxkj.cjm.model;


import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 主题类型关联实体类
 */
@TableName("forum_thread_tag_link")
public class ForumThreadTagLink {

    private static final long serialVersionUID = 36965101045963581L;

    /**
     * 主题类型id
     */
    private Long tagid;
    /**
     * 主题id
     */
    private Long tid;


    public Long getTagid() {
        return this.tagid;
    }

    public void setTagid(Long tagid) {
        this.tagid = tagid;
    }

    public Long getTid() {
        return this.tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

}
