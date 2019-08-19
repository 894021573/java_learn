package com.ht.blog.vo.listArticle;

import java.util.List;

public class ESListArticleVo
{
    private int pageNum;
    private int pageSize;
    private long total;
    private List<ESArticleVo> list;

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

    public List<ESArticleVo> getList()
    {
        return list;
    }

    public void setList(List<ESArticleVo> list)
    {
        this.list = list;
    }
}
