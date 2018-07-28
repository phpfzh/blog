package com.jxkj.cjm.model.vo;

public class ForumPostVo {
    /**
     * 板块id
     */
    private Long fid;
    /**
     * 主题id
     */
    private Long tid;
    /**
     * 用户id
     */
    private Long baseid;
    /**
     * 主题标题
     */
    private String subject;
    /**
     * 内容
     */
    private String content;
    /**
     * 状态-1审核中 -2审核失败 0审核通过
     */
    private Integer status;
    /**
     * 添加时间
     */
    private Long addtime;
    /**
     * 修改时间
     */
    private Long updatetime;
    /**
     * 修改用户id
     */
    private Long updatebaseid;
    /**
     * 是否删除1是0否
     */
    private Integer isdelete;
    /**
     * 用户ip
     */
    private String useip;
    /**
     * 附件个数
     */
    private Integer attachment;
    /**
     * 是否带签名1是0否
     */
    private Integer usesig;

    /**
     * 作者用户名
     */
    private String username;
    /**
     * 修改人用户名
     */
    private String upusername;
    /**
     * 作者头像地址
     */
    private String headurl;
    /**
     * 版块名称
     */
    private String fname;


    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getAddtime() {
        return addtime;
    }

    public void setAddtime(Long addtime) {
        this.addtime = addtime;
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

    public String getUseip() {
        return useip;
    }

    public void setUseip(String useip) {
        this.useip = useip;
    }

    public Integer getAttachment() {
        return attachment;
    }

    public void setAttachment(Integer attachment) {
        this.attachment = attachment;
    }

    public Integer getUsesig() {
        return usesig;
    }

    public void setUsesig(Integer usesig) {
        this.usesig = usesig;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getUpusername() {
        return upusername;
    }

    public void setUpusername(String upusername) {
        this.upusername = upusername;
    }
}
