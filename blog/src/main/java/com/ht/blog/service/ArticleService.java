package com.ht.blog.service;

import com.ht.blog.entity.HArticle;
import com.ht.blog.entity.HCategory;
import com.ht.blog.entity.HUser;
import common.util.result.Response;

import java.util.List;
import java.util.Map;

public interface ArticleService
{
    Response<Map<String, Object>> listArticle(int pageNum, int pageSize, int userId, int categoryId);

    Response<Map<String, Object>> addArticle(HArticle hArticle);

    Response<Map<String, Object>> editArticle(HArticle hArticle);

    Response<Map<String, Object>> deleteArticle(int id);

    Response<Object> showArticle(int id);

    Response<Object> listCategory(int userId);

    Response<Map<String, Object>> addCategory(HCategory hCategory);

    Response<Map<String, Object>> editCategory(HCategory hCategory);

    Response<Map<String, Object>> deleteCategory(int id);
    Response<Map<String, Object>> showCategory(int id);
}
