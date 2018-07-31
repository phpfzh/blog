package com.jxkj.cjm.model.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
}
