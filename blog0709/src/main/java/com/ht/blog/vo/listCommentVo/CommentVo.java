package com.ht.blog.vo.listCommentVo;

import com.ht.blog.vo.listArticle.CategoryVo;

public class CommentVo
{
    private Integer id;

    private String content;

    private Integer createdAt;

    private UserVo userVo;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Integer getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt)
    {
        this.createdAt = createdAt;
    }

    public UserVo getUserVo()
    {
        return userVo;
    }

    public void setUserVo(UserVo userVo)
    {
        this.userVo = userVo;
    }
}
