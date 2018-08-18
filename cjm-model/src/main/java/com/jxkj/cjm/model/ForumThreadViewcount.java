package com.jxkj.cjm.model;


import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 *
 */
@TableName("forum_thread_viewcount")
public class ForumThreadViewcount extends Model<ForumThreadViewcount> {

    private static final long serialVersionUID = 20606936668597457L;

    /**
     * 主题id
     */
    @TableId(type=IdType.INPUT)
    private Long tid;
    /**
     * 浏览数
     */
    private Integer count;


    public Long getTid() {
        return this.tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    protected Serializable pkVal() {
        return this.tid;
    }
}
