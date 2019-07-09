package com.ht.blog.dao;

import com.ht.blog.entity.HComment;

import java.util.List;

public interface HCommentMapper
{
    int insert(HComment record);

    List<HComment> selectAll(int articleId, int pageNum, int pageSize);

    Integer count(int articleId);
}