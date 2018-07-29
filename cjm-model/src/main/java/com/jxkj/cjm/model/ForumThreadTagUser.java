package com.jxkj.cjm.model;


import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 主题类型关联实体类
 */
@TableName("forum_thread_tag_user")
public class ForumThreadTagUser {

    private static final long serialVersionUID = 36965101045963581L;

    /**
     * 主题类型id
     */
    private Long tagid;
    /**
     * 主题id
     */
    private Long baseid;

    public Long getTagid() {
        return tagid;
    }

    public void setTagid(Long tagid) {
        this.tagid = tagid;
    }

    public Long getBaseid() {
        return baseid;
    }

    public void setBaseid(Long baseid) {
        this.baseid = baseid;
    }
}
