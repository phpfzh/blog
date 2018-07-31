package com.jxkj.cjm.model;


import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 用户头像历史记录表
 */
@TableName("user_avatar")
public class UserAvatar extends SuperEntity<UserAvatar> {

    private static final long serialVersionUID = 40725549582486042L;

    /**
     * 用户id
     */
    private Long baseid;
    /**
     * 是否删除1是0否
     */
    private Integer status;
    /**
     * 大图
     */
    private String bigattach;
    /**
     * 小图
     */
    private String smallattach;
    /**
     * 中等图
     */
    private String middleattach;
    /**
     * 上传时间
     */
    private Long dateline;


    public Long getBaseid() {
        return this.baseid;
    }

    public void setBaseid(Long baseid) {
        this.baseid = baseid;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBigattach() {
        return this.bigattach;
    }

    public void setBigattach(String bigattach) {
        this.bigattach = bigattach;
    }

    public String getSmallattach() {
        return this.smallattach;
    }

    public void setSmallattach(String smallattach) {
        this.smallattach = smallattach;
    }

    public String getMiddleattach() {
        return this.middleattach;
    }

    public void setMiddleattach(String middleattach) {
        this.middleattach = middleattach;
    }

    public Long getDateline() {
        return this.dateline;
    }

    public void setDateline(Long dateline) {
        this.dateline = dateline;
    }

}
