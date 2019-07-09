package com.ht.blog.service;

import com.ht.blog.entity.HArticle;
import com.ht.blog.entity.HUser;
import common.util.result.Response;

import java.util.List;
import java.util.Map;

public interface ArticleService
{
    Response<Map<String, Object>> listArticle(int pageNum, int pageSize,int userId);

    Response<Map<String, Object>> addArticle(HArticle hArticle);

    Response<Object> showArticle(int id);

    Response<Object> listCategory();
}
