package com.ht.blog.entity;

import com.ht.blog.common.help.valid.groups.CreateAction;
import com.ht.blog.common.help.valid.groups.auth.LoginAction;
import com.ht.blog.common.help.valid.message.HCommentMessage;
import com.ht.blog.common.help.valid.message.HUserMessage;
import com.ht.blog.dao.HCommentMapper;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Component
public class HComment implements Serializable {
    private Integer id;

    @NotNull(groups = {LoginAction.class, CreateAction.class}, message = HCommentMessage.USER_ID_NOT_EMPTY)
    private Integer userId;

    @NotNull(groups = {LoginAction.class, CreateAction.class}, message = HCommentMessage.CONTENT_ID_NOT_EMPTY)
    private Integer contentId;

    @NotEmpty(groups = {LoginAction.class, CreateAction.class}, message = HCommentMessage.CONTENT_NOT_EMPTY)
    private String content;

    private Integer createdAt;

    private Integer updatedAt;

    private HUser hUser;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    public HUser gethUser()
    {
        return hUser;
    }

    public void sethUser(HUser hUser)
    {
        this.hUser = hUser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", contentId=").append(contentId);
        sb.append(", content=").append(content);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", hUser=").append(hUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}