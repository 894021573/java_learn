package com.ht.blog.entity;

import com.ht.blog.common.help.valid.groups.CreateAction;
import com.ht.blog.common.help.valid.groups.UpdateAction;
import com.ht.blog.common.help.valid.message.HArticleMessage;
import com.ht.blog.dao.HArticleMapper;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Component
public class HArticle implements Serializable
{
    private Integer id;

    // @NotEmpty支持的是字符串类型字段
    @NotNull(groups = {CreateAction.class}, message = HArticleMessage.USER_ID_NOT_EMPTY)
    private Integer userId;

    @NotNull(groups = {CreateAction.class, UpdateAction.class}, message = HArticleMessage.CATEGOTY_ID_NOT_EMPTY)
    private Integer categoryId;

    @NotEmpty(groups = {CreateAction.class, UpdateAction.class}, message = HArticleMessage.TITLE_NOT_EMPTY)
    private String title;

    @NotEmpty(groups = {CreateAction.class, UpdateAction.class}, message = HArticleMessage.CONTENT_NOT_EMPTY)
    private String content;

    private Integer viewNum;

    private Integer commentNum;

    private Integer createdAt;

    private Integer updatedAt;

    private HUser hUser;
    private HCategory hCategory;

    private static final long serialVersionUID = 1L;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title == null ? null : title.trim();
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content == null ? null : content.trim();
    }

    public Integer getCreatedAt()
    {
        return createdAt;
    }

    public Integer getViewNum()
    {
        return viewNum;
    }

    public void setViewNum(Integer viewNum)
    {
        this.viewNum = viewNum;
    }

    public Integer getCommentNum()
    {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum)
    {
        this.commentNum = commentNum;
    }

    public void setCreatedAt(Integer createdAt)
    {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt)
    {
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

    public HCategory gethCategory()
    {
        return hCategory;
    }

    public void sethCategory(HCategory hCategory)
    {
        this.hCategory = hCategory;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", title=").append(title);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", content=").append(content);
        sb.append(", viewNum=").append(viewNum);
        sb.append(", commentNum=").append(commentNum);
        sb.append(", user=").append(hUser);
        sb.append(", category=").append(hCategory);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}