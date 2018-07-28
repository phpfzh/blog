package com.jxkj.cjm.model;


import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 主题浏览记录表
 */
@TableName("forum_thread_view_record")
public class ForumThreadViewRecord extends SuperEntity<ForumThreadViewRecord> {

    private static final long serialVersionUID = 70344990718934476L;

    /**
     * 主题id
     */
    private Long tid;
    /**
     * 浏览时间 2018-07-27
     */
    private String datestr;
    /**
     * 浏览ip
     */
    private String ip;
    /**
     * 保存时间
     */
    private Long dateline;
    /**
     * 浏览用户id
     */
    private Long baseid;


    public Long getTid() {
        return this.tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getDatestr() {
        return this.datestr;
    }

    public void setDatestr(String datestr) {
        this.datestr = datestr;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

}
