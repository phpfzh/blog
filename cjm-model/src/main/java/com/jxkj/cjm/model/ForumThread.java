package com.jxkj.cjm.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author cjm
 * @version 1.0 www.chenjiaming.com
 * @ClassName: ForumThread
 * @Description: TODO 主题信息
 * @date 2018年6月3日
 */
@TableName("forum_thread")
public class ForumThread extends SuperEntity<ForumThread> {

    private static final long serialVersionUID = 56627677714518132L;

    /**
     * 板块id
     */
    private Long fid;
    /**
     * 用户id
     */
    private Long baseid;
    /**
     * 标题
     */
    private String subject;
    /**
     * 封面图
     */
    private String coverimg;
    /**
     * 发布时间
     */
    private Long dateline;
    /**
     * 最后回复时间
     */
    private Long lastpost;
    /**
     * 最后回复人
     */
    private Long lastposter;
    /**
     * 浏览量
     */
    private Integer views;
    /**
     * 回复数
     */
    private Integer replies;
    /**
     * 是否精华1是0否
     */
    private Integer digest;
    /**
     * 附件,0无附件 1普通附件 2有图片附件
     */
    private Integer attachment;
    /**
     * 是否被管理员改动
     */
    private Integer moderated;
    /**
     * 支持人数
     */
    private Integer likes;
    /**
     * 反对人数
     */
    private Integer unlikes;
    /**
     * 收藏次数
     */
    private Integer favtimes;
    /**
     * 分享次数
     */
    private Integer sharetimes;
    /**
     * 状态-1审核中 -2审核失败 0审核通过
     */
    private Integer status;
    /**
     * 是否删除1是0否
     **/
    private Integer isdelete;
    /**
     * 排序
     **/
    private Integer sort;
    /**
     * 主题类型 1原创2 转载 3翻译
     **/
    private Integer threadtype;
    /**
     * 管理员用户id
     */
    private Long upbaseid;
    /**
     * 管理员修改时间
     */
    private Long moderatline;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getBaseid() {
        return baseid;
    }

    public void setBaseid(Long baseid) {
        this.baseid = baseid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getDateline() {
        return dateline;
    }

    public void setDateline(Long dateline) {
        this.dateline = dateline;
    }

    public Long getLastpost() {
        return lastpost;
    }

    public void setLastpost(Long lastpost) {
        this.lastpost = lastpost;
    }

    public Long getLastposter() {
        return lastposter;
    }

    public void setLastposter(Long lastposter) {
        this.lastposter = lastposter;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getReplies() {
        return replies;
    }

    public void setReplies(Integer replies) {
        this.replies = replies;
    }

    public Integer getDigest() {
        return digest;
    }

    public void setDigest(Integer digest) {
        this.digest = digest;
    }

    public Integer getAttachment() {
        return attachment;
    }

    public void setAttachment(Integer attachment) {
        this.attachment = attachment;
    }

    public Integer getModerated() {
        return moderated;
    }

    public void setModerated(Integer moderated) {
        this.moderated = moderated;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getUnlikes() {
        return unlikes;
    }

    public void setUnlikes(Integer unlikes) {
        this.unlikes = unlikes;
    }

    public Integer getFavtimes() {
        return favtimes;
    }

    public void setFavtimes(Integer favtimes) {
        this.favtimes = favtimes;
    }

    public Integer getSharetimes() {
        return sharetimes;
    }

    public void setSharetimes(Integer sharetimes) {
        this.sharetimes = sharetimes;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getThreadtype() {
        return threadtype;
    }

    public void setThreadtype(Integer threadtype) {
        this.threadtype = threadtype;
    }

    public Long getUpbaseid() {
        return upbaseid;
    }

    public void setUpbaseid(Long upbaseid) {
        this.upbaseid = upbaseid;
    }

    public Long getModeratline() {
        return moderatline;
    }

    public void setModeratline(Long moderatline) {
        this.moderatline = moderatline;
    }

    public String getCoverimg() {
        return coverimg;
    }

    public void setCoverimg(String coverimg) {
        this.coverimg = coverimg;
    }
}
