package com.ht.blog.service;

import com.ht.blog.vo.listArticle.ESArticleVo;
import common.util.result.Response;

import java.util.List;
import java.util.Map;

public interface ESArticleService
{
    List<ESArticleVo> listArticleToES();
    Response<Map<String, Object>> searchArticleFromES(String title, Integer currentPage, Integer pageSize);
    Response<Map<String, Object>> deleteArticleIndex();
}
