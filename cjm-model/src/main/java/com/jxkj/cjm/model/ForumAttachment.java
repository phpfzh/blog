package com.jxkj.cjm.model;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 */
@TableName("forum_attachment")
public class ForumAttachment extends SuperEntity<ForumAttachment> {

    private static final long serialVersionUID = 87772905028286596L;

    /**
     * 主题id
     */
    private Long tid;
    /**
     * 帖子id
     */
    private Long pid;
    /**
     * 用户id
     */
    private Long baseid;
    /**
     * 附件表id
     */
    private Integer tableid;
    /**
     * 下载次数
     */
    private Integer downloads;

    @TableField(exist = false)
    private Integer isimage;
    @TableField(exist = false)
    private String attachment;
    @TableField(exist = false)
    private String thumbattachment;
    @TableField(exist = false)
    private String waterattachment;

    public Long getTid() {
        return this.tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getPid() {
        return this.pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getBaseid() {
        return this.baseid;
    }

    public void setBaseid(Long baseid) {
        this.baseid = baseid;
    }

    public Integer getTableid() {
        return this.tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    public Integer getDownloads() {
        return this.downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Integer getIsimage() {
        return isimage;
    }

    public void setIsimage(Integer isimage) {
        this.isimage = isimage;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getThumbattachment() {
        return thumbattachment;
    }

    public void setThumbattachment(String thumbattachment) {
        this.thumbattachment = thumbattachment;
    }

    public String getWaterattachment() {
        return waterattachment;
    }

    public void setWaterattachment(String waterattachment) {
        this.waterattachment = waterattachment;
    }


}
