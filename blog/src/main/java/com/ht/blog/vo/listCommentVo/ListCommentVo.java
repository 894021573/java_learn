package com.ht.blog.vo.listCommentVo;

import com.ht.blog.vo.listArticle.ArticleVo;

import java.util.List;

public class ListCommentVo
{
    private int pageNum;
    private int pageSize;
    private long total;
    private List<CommentVo> list;

    public int getPageNum()
    {
        return pageNum;
    }

    public void setPageNum(int pageNum)
    {
        this.pageNum = pageNum;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public long getTotal()
    {
        return total;
    }

    public void setTotal(long total)
    {
        this.total = total;
    }

    public List<CommentVo> getList()
    {
        return list;
    }

    public void setList(List<CommentVo> list)
    {
        this.list = list;
    }
}
