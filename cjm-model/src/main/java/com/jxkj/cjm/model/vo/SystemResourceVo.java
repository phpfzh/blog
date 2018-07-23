package com.jxkj.cjm.model.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Auther: cjm
 * @Date: 2018/7/22 16:46
 * @Description:
 * @ClassName: SystemResourceVo
 */
public class SystemResourceVo {
    /**
     * 资源ID
     */
    @NotNull(message = "资源主键id不能为空", groups = {GroupUpdate.class})
    private Long resourceid;
    /**
     * 资源url
     */
    @NotBlank(message = "资源url不能为空", groups = {GroupSave.class, GroupUpdate.class})
    @Length(max = 100, message = "资源url不能超过100字符", groups = {GroupSave.class, GroupUpdate.class})
    private String resourceurl;
    /**
     * 资源名称
     */
    @NotBlank(message = "资源名称不能为空", groups = {GroupSave.class, GroupUpdate.class})
    @Length(max = 100, message = "资源名称不能超过100字符", groups = {GroupSave.class, GroupUpdate.class})
    private String resourcename;
    /**
     * 排序编号
     */
    private Integer sort;
    /**
     * 备注
     */
    @Length(max = 1000, message = "备注不能超过100字符", groups = {GroupSave.class, GroupUpdate.class})
    private String remark;
    /**
     * 父资源ID
     */
    private Long parentid;
    /**
     * 类型 （1为菜单 2 按钮）
     */
    @Range(min = 1, max = 2, message = "类型值范围是1-2", groups = {GroupSave.class, GroupUpdate.class})
    private Integer type;
    /**
     * 权限
     */
    @NotBlank(message = "权限名称不能为空", groups = {GroupSave.class, GroupUpdate.class})
    private String permission;
    /**
     * 路由url
     */
    @Length(max = 100, message = "前端路由url不能超过100字符", groups = {GroupSave.class, GroupUpdate.class})
    private String link;
    /**
     * 是否隐藏
     */
    @NotNull(message = "是否隐藏不能为空", groups = {GroupSave.class, GroupUpdate.class})
    private Boolean hide;
    /**
     * icon 图标
     */
    private String icon;
    /**
     * 外部链接
     */
    @Length(max = 100, message = "外部链接不能超过100字符", groups = {GroupSave.class, GroupUpdate.class})
    private String externallink;
    /**
     * 链接打开方式  '_blank' | '_self' | '_parent' | '_top'
     */
    private String target;

    public Long getResourceid() {
        return resourceid;
    }

    public void setResourceid(Long resourceid) {
        this.resourceid = resourceid;
    }

    public String getResourceurl() {
        return resourceurl;
    }

    public void setResourceurl(String resourceurl) {
        this.resourceurl = resourceurl;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boolean getHide() {
        return hide;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getExternallink() {
        return externallink;
    }

    public void setExternallink(String externallink) {
        this.externallink = externallink;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
