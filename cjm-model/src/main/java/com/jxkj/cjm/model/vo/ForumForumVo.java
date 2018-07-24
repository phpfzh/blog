package com.jxkj.cjm.model.vo;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 版块 vo
 */
public class ForumForumVo {
    @NotNull(message = "id不能为空", groups = GroupUpdate.class)
    private Long id;
    /**
     * 板块名称
     */
    @NotBlank(message = "版块名称不能为空", groups = {GroupSave.class, GroupUpdate.class})
    private String name;
    /**
     * 状态1显示0不显示
     */
    @NotNull(message = "是否显示不能为空", groups = {GroupUpdate.class})
    @Range(min = 0, max = 1, message = "是否显示值范围：0-1", groups = {GroupSave.class, GroupUpdate.class})
    private Integer status;
    /**
     * 是否删除1是0否
     */
    @Range(min = 0, max = 1, message = "是否删除值范围：0-1", groups = {GroupSave.class, GroupUpdate.class})
    private Integer isdelete;
    /**
     * 排序最大100
     */
    @Max(value = 100, message = "排序最大值：100", groups = {GroupSave.class, GroupUpdate.class})
    private Integer sort;
    /**
     * 主题数量
     */
    private Long threads;
    /**
     * 回复数量
     */
    private Long commonts;
    /**
     * 添加时间
     */
    private Long addtime;
    /**
     * 添加人
     */
    private Long addbaseid;
    /**
     * 修改时间
     */
    private Long updatetime;
    /**
     * 修改人
     */
    private Long updatebaseid;
    /**
     * 添加人用户名
     **/
    private String addusername;
    /**
     * 修改人用户名
     **/
    private String updateusername;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getThreads() {
        return threads;
    }

    public void setThreads(Long threads) {
        this.threads = threads;
    }

    public Long getCommonts() {
        return commonts;
    }

    public void setCommonts(Long commonts) {
        this.commonts = commonts;
    }

    public Long getAddtime() {
        return addtime;
    }

    public void setAddtime(Long addtime) {
        this.addtime = addtime;
    }

    public Long getAddbaseid() {
        return addbaseid;
    }

    public void setAddbaseid(Long addbaseid) {
        this.addbaseid = addbaseid;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }

    public Long getUpdatebaseid() {
        return updatebaseid;
    }

    public void setUpdatebaseid(Long updatebaseid) {
        this.updatebaseid = updatebaseid;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddusername() {
        return addusername;
    }

    public void setAddusername(String addusername) {
        this.addusername = addusername;
    }

    public String getUpdateusername() {
        return updateusername;
    }

    public void setUpdateusername(String updateusername) {
        this.updateusername = updateusername;
    }
}
