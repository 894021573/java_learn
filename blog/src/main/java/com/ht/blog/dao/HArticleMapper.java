package com.ht.blog.dao;

import com.ht.blog.entity.HArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HArticleMapper
{
    int insert(HArticle record);

    List<HArticle> selectAll(int pageNum, int pageSize, int userId);

    Integer count(@Param("userId")int userId);

    HArticle selectById(int id);
}