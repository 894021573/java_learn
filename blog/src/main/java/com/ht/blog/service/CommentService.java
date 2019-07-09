package com.ht.blog.service;

import com.ht.blog.entity.HArticle;
import com.ht.blog.entity.HComment;
import common.util.result.Response;

import java.util.Map;

public interface CommentService
{
    Response<Map<String, Object>> listComment(int articleId, int pageNum, int pageSize);

    Response<Map<String, Object>> addComment(HComment hComment);
}
