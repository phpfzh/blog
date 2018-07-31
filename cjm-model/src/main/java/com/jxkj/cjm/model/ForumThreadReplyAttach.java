package com.jxkj.cjm.model;


import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 主题回复图片
 */
@TableName("forum_thread_reply_attach")
public class ForumThreadReplyAttach extends SuperEntity<ForumThreadReplyAttach> {

    private static final long serialVersionUID = 91028077301503172L;

    /**
     * 主题评论表id
     */
    private Long replyid;
    /**
     * 用户id
     */
    private Long baseid;
    /**
     * 上传时间
     */
    private Long dateline;
    /**
     * 状态 1使用0未使用   默认0
     */
    private Integer status;
    /**
     * 图片路径
     */
    private String attach;
    /**
     * 缩率图片路径
     */
    private String thumbattach;
    /**
     * 文件名
     */
    private String filename;
    /**
     * 文件大小
     */
    private Integer filesize;
    /**
     * 是否删除  1是0否
     */
    private Integer isdelete;


    public Long getReplyid() {
        return this.replyid;
    }

    public void setReplyid(Long replyid) {
        this.replyid = replyid;
    }

    public Long getBaseid() {
        return this.baseid;
    }

    public void setBaseid(Long baseid) {
        this.baseid = baseid;
    }

    public Long getDateline() {
        return this.dateline;
    }

    public void setDateline(Long dateline) {
        this.dateline = dateline;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAttach() {
        return this.attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getThumbattach() {
        return this.thumbattach;
    }

    public void setThumbattach(String thumbattach) {
        this.thumbattach = thumbattach;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getFilesize() {
        return this.filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public Integer getIsdelete() {
        return this.isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

}
