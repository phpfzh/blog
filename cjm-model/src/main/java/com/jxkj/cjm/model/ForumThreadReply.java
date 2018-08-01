package com.jxkj.cjm.model;


import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 主题评论/回复
 */
@TableName("forum_thread_reply")
public class ForumThreadReply extends SuperEntity<ForumThreadReply> {

    private static final long serialVersionUID = 120809287784457L;

    /**
     * 是否首次评论主题 1 首次评论  0回复
     */
    private Integer first;
    /**
     * 父回复id
     */
    private Long parentid;
    /**
     * 首次回复标识码
     */
    private String firstmark;
    /**
     * 主题id
     */
    private Long tid;
    /**
     * 用户id
     */
    private Long baseid;
    /**
     * 回复目标用户id
     */
    private Long tbaseid;
    /**
     * 时间
     */
    private Long datetime;
    /**
     * 内容
     */
    private String message;
    /**
     * 用户ip
     */
    private String userip;
    /**
     * 是否通过审核 -1审核中 -2 审核失败 0审核通过
     */
    private Integer status;
    /**
     * 点赞数
     */
    private Integer like;
    /**
     * 反对数
     */
    private Integer hate;
    /**
     * 是否删除
     */
    private Integer isdelete;
    /**
     * 操作人
     */
    private Long opermanid;
    /**
     * 操作时间
     */
    private Long operdatetime;
    /**
     * 操作备注
     */
    private String remark;


    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
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

    public Long getBaseid() {
        return baseid;
    }

    public void setBaseid(Long baseid) {
        this.baseid = baseid;
    }

    public Long getTbaseid() {
        return tbaseid;
    }

    public void setTbaseid(Long tbaseid) {
        this.tbaseid = tbaseid;
    }

    public Long getDatetime() {
        return datetime;
    }

    public void setDatetime(Long datetime) {
        this.datetime = datetime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getHate() {
        return hate;
    }

    public void setHate(Integer hate) {
        this.hate = hate;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Long getOpermanid() {
        return opermanid;
    }

    public void setOpermanid(Long opermanid) {
        this.opermanid = opermanid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFirstmark() {
        return firstmark;
    }

    public void setFirstmark(String firstmark) {
        this.firstmark = firstmark;
    }

    public Long getOperdatetime() {
        return operdatetime;
    }

    public void setOperdatetime(Long operdatetime) {
        this.operdatetime = operdatetime;
    }
}
