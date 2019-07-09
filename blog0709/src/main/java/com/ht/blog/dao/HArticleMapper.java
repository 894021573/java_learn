package com.ht.blog.dao;

import com.ht.blog.entity.HArticle;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface HArticleMapper
{
    int insert(HArticle record);

    int update(HArticle record);

    int delete(int id);

    List<HArticle> selectAll(int pageNum, int pageSize, int userId, int categoryId);

    Integer count(@Param("userId") int userId, @Param("categoryId") int categoryId);

    HArticle selectById(int id);

    int incViewNum(int id);

    int incCommentNum(int id);
}