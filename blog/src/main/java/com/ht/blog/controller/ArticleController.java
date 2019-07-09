package com.ht.blog.controller;

import com.ht.blog.common.help.valid.groups.CreateAction;
import com.ht.blog.common.help.valid.groups.auth.LoginAction;
import com.ht.blog.entity.HArticle;
import com.ht.blog.entity.HUser;
import com.ht.blog.service.ArticleService;
import com.ht.blog.service.AuthService;
import common.util.result.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ArticleController
{
    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService)
    {
        this.articleService = articleService;
    }

    @RequestMapping(path = "/listArticle", method = RequestMethod.POST)
    public Response<Map<String, Object>> listArticle(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize)
    {
        int userId = 0;
        return articleService.listArticle(pageNum, pageSize, userId);
    }

    @RequestMapping(path = "/listMyArticle", method = RequestMethod.POST)
    public Response<Map<String, Object>> listArticle(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam int userId)
    {
        return articleService.listArticle(pageNum, pageSize, userId);
    }

    @RequestMapping(path = "/addArticle", method = RequestMethod.POST)
    public Response<Map<String, Object>> addArticle(@Validated(CreateAction.class) HArticle hArticle)
    {
        return articleService.addArticle(hArticle);
    }

    @RequestMapping(path = "/showArticle", method = RequestMethod.POST)
    public Response<Object> showArticle(int id)
    {
        return articleService.showArticle(id);
    }

    @RequestMapping(path = "/listCategory", method = RequestMethod.POST)
    public Response<Object> listCategory()
    {
        return articleService.listCategory();
    }
}
