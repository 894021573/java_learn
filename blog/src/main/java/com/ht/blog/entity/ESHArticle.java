package com.ht.blog.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

import lombok.Data;

@Data
@Document(indexName = "article_info", type = "doc")
public class ESHArticle implements Serializable
{
    @Id
    private Integer id;

    private Integer userId;

    private Integer categoryId;

    private String title;

    private String content;

    private Integer viewNum;

    private Integer commentNum;

    private Integer createdAt;

    private Integer updatedAt;

    private HUser hUser;

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
        this.title = title;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
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

    public Integer getCreatedAt()
    {
        return createdAt;
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
}