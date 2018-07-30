package com.jxkj.cjm.model.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ForumThreadVo {

    /**
     * 主键id
     **/
    @NotNull(message = "主题id 不能为空",groups = {GroupUpdate.class})
    private Long id;
    /**
     * 板块id
     */
    @NotNull(message = "板块id不能为空",groups ={ GroupUpdate.class})
    private Long fid;
    /**
     * 帖子id
     */
    private Long pid;
    /**
     * 用户id
     */
    private Long baseid;
    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空",groups = {GroupUpdate.class})
    @Length(message = "标题不能超100字符",max = 100,groups = {GroupUpdate.class})
    private String subject;
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
    @NotNull(message = "主题类型不能为空",groups ={ GroupUpdate.class})
    @Range(message = "主题类型值范围在1-3",min = 1,max = 3)
    private Integer threadtype;
    /**
     * 用户名
     */
    private String username;
    /**
     * 版块名称
     */
    private String fname;
    /**
     * 用户头像地址
     */
    private String headurl;
    /**
     * 内容
     */
    @NotBlank(message = "主题内容不能为空",groups = {GroupUpdate.class})
    private String content;
    /**
     * 主题类型名称
     */
    private String  threadtypename;

    /**
     * 主题tags
     */
    private String tags;
    /**
     * 主题总数
     */
    private Integer count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThreadtypename() {
        return threadtypename;
    }

    public void setThreadtypename(String threadtypename) {
        this.threadtypename = threadtypename;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
