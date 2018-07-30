package com.jxkj.cjm.model.vo;

public class ForumThreadTagVo {
    private Long id;
    /**
     * 名称
     */
    private String name;

    /**
     * 主题数
     */
    private Integer   count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
