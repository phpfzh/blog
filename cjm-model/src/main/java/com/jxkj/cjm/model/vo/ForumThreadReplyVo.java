package com.jxkj.cjm.model.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ForumThreadReplyVo {

    @NotNull(message = "id 不能为空",groups = {GroupUpdate.class})
    private Long id;
    /**
     * 父回复id
     */
    private Long parentid;
    /**
     * 主题id
     */
    @NotNull(message = "主题id 不能为空",groups = {GroupUpdate.class,GroupSave.class})
    private Long tid;
    /**
     * 内容
     */
    @NotBlank(message = "内容不能为空",groups = {GroupUpdate.class,GroupSave.class})
    private String message;
    /**
     * 回复目标用户id
     */
    private Long tbaseid;
    /**
     * 回复图片
     */
    private String imgs;
    /**
     * 用户id
     */
    private Long baseid;
    /**
     * 评论/回复用户名
     */
    private String username;
    /**
     * 评论/回复目标用户名
     */
    private String tusername;
    /**
     * 评论/回复用户头像
     */
    private String headurl;
    /**
     * 评论/回复目标用户头像
     */
    private String theadurl;

    private List<ForumThreadReplyVo> childreplys;
    /**
     * 是否通过审核 -1审核中 -2 审核失败 0审核通过
     */
    private Integer status;

    /**
     * 是否删除
     */
    private Integer isdelete;

    /**
     * 时间
     */
    private Long datetime;

    /**
     * 是否首次评论主题 1 首次评论  0回复
     */
    private Integer first;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTbaseid() {
        return tbaseid;
    }

    public void setTbaseid(Long tbaseid) {
        this.tbaseid = tbaseid;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public Long getBaseid() {
        return baseid;
    }

    public void setBaseid(Long baseid) {
        this.baseid = baseid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTusername() {
        return tusername;
    }

    public void setTusername(String tusername) {
        this.tusername = tusername;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    public String getTheadurl() {
        return theadurl;
    }

    public void setTheadurl(String theadurl) {
        this.theadurl = theadurl;
    }

    public List<ForumThreadReplyVo> getChildreplys() {
        return childreplys;
    }

    public void setChildreplys(List<ForumThreadReplyVo> childreplys) {
        this.childreplys = childreplys;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Long getDatetime() {
        return datetime;
    }

    public void setDatetime(Long datetime) {
        this.datetime = datetime;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }
}
