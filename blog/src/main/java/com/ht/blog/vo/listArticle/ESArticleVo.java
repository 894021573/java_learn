package com.ht.blog.vo.listArticle;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "list_article", type = "doc")
public class ESArticleVo
{
    private Integer id;

    private Integer categoryId;

    private String categoryName;

    private String title;

    private String content;

    private Integer viewNum;

    private Integer commentNum;

    private Integer createdAt;

    private UserVo userVo;

    private CategoryVo categoryVo;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
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

    public UserVo getUserVo()
    {
        return userVo;
    }

    public void setUserVo(UserVo userVo)
    {
        this.userVo = userVo;
    }

    public CategoryVo getCategoryVo()
    {
        return categoryVo;
    }

    public void setCategoryVo(CategoryVo categoryVo)
    {
        this.categoryVo = categoryVo;
    }
}
