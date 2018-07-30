package com.jxkj.cjm.model;


import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 主题类型实体类
 */
@TableName("forum_thread_tag")
public class ForumThreadTag extends SuperEntity<ForumThreadTag> {

    private static final long serialVersionUID = 84579181089860371L;

    /**
     * 名称
     */
    private String name;
    /**
     * 添加时间
     */
    private Long dateline;
    /**
     * 是否删除
     */
    private Integer isdelete;
    /**
     * 主题数
     */
    private Integer   count;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDateline() {
        return this.dateline;
    }

    public void setDateline(Long dateline) {
        this.dateline = dateline;
    }

    public Integer getIsdelete() {
        return this.isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
