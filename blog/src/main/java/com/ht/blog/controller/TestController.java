package com.ht.blog.controller;

import com.ht.blog.entity.ESHArticle;
import com.ht.blog.service.ESArticleService;
import com.ht.blog.vo.listArticle.ESArticleVo;
import common.util.result.Response;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TestController
{
    @Autowired
    private ESArticleService esArticleService;

    public static void main(String[] args)
    {
        System.out.println(111);
    }

    @RequestMapping("/a")
    public List<ESArticleVo> a()
    {
        return esArticleService.listArticleToES();
    }

    @RequestMapping("/b")
    public Response<Map<String, Object>> search(@RequestParam(defaultValue = "SpringBoot") String title, @RequestParam(defaultValue = "0") Integer currentPage, @RequestParam(defaultValue = "10") Integer pageSize)
    {
        return esArticleService.searchArticleFromES(title, currentPage, pageSize);
    }

    @RequestMapping("/c")
    public Response<Map<String, Object>> deleteIndex()
    {
        return esArticleService.deleteArticleIndex();
    }
}
