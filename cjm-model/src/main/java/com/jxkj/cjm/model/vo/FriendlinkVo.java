package com.jxkj.cjm.model.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Auther: cjm
 * @Date: 2018/8/22 22:48
 * @Description:
 * @ClassName: FriendlinkVo
 */
public class FriendlinkVo {

    @NotNull(message = "主键id不能为空", groups = {GroupUpdate.class})
    private Long id;
    /** 链接 */
    @NotBlank(message = "链接不能为空", groups = {GroupSave.class, GroupUpdate.class})
    private String link;
    /** 保存时间 */
    private Long dateline;
    /** 用户id */
    private Long baseid;
    /**  名称 */
    @NotBlank(message = "名称不能为空", groups = {GroupSave.class, GroupUpdate.class})
    private String name;
    /** 排序 */
    private Integer sort;
    /** 类型1友情链接 2 常用站点 */
    private Integer type;
    /**  备注信息 */
    private String remark;


    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getDateline() {
        return this.dateline;
    }

    public void setDateline(Long dateline) {
        this.dateline = dateline;
    }

    public Long getBaseid() {
        return this.baseid;
    }

    public void setBaseid(Long baseid) {
        this.baseid = baseid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
