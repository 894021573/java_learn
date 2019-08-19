package com.ht.blog.controller;

import com.ht.blog.common.help.result.ArticleCodeMsg;
import com.ht.blog.common.help.result.CommonCodeMsg;
import com.ht.blog.common.help.valid.groups.CreateAction;
import com.ht.blog.common.help.valid.groups.UpdateAction;
import com.ht.blog.entity.HArticle;
import com.ht.blog.entity.HCategory;
//import com.ht.blog.repository.HArticleRepository;
import com.ht.blog.service.ArticleService;
import com.ht.blog.service.ESArticleService;
import common.util.result.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class ArticleController
{
    @Autowired
    private ArticleService articleService;

    @Autowired
    private ESArticleService esArticleService;

    @Autowired
    public void setArticleService(ArticleService articleService)
    {
        this.articleService = articleService;
    }

    @RequestMapping(path = "/listArticle", method = RequestMethod.POST)
    public Response<Map<String, Object>> listArticle(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            HttpSession session)
    {
        int userId = 0;
        int categoryId = 0;

        String kaptcha = (String) session.getAttribute("verifyCode");

        System.out.println("yyy" + kaptcha);

        return articleService.listArticle(pageNum, pageSize, userId, categoryId);
//        return esArticleService.searchArticleFromES(title, pageNum, pageSize);
    }

    @RequestMapping(path = "/listMyArticle", method = RequestMethod.POST)
    public Response<Map<String, Object>> listArticle(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam int userId,
            @RequestParam(defaultValue = "0") int categoryId)
    {

        return articleService.listArticle(pageNum, pageSize, userId, categoryId);
    }

    @RequestMapping(path = "/addArticle", method = RequestMethod.POST)
    public Response<Map<String, Object>> addArticle(@Validated(CreateAction.class) HArticle hArticle)
    {
        return articleService.addArticle(hArticle);
    }

    @RequestMapping(path = "/editArticle", method = RequestMethod.POST)
    public Response<Map<String, Object>> editArticle(@Validated(UpdateAction.class) HArticle hArticle)
    {
        return articleService.editArticle(hArticle);
    }

    @RequestMapping(path = "/deleteArticle", method = RequestMethod.POST)
    public Response<Map<String, Object>> deleteArticle(@RequestParam int id)
    {
        return articleService.deleteArticle(id);
    }

    @RequestMapping(path = "/showArticle", method = RequestMethod.POST)
    public Response<Object> showArticle(int id)
    {
        return articleService.showArticle(id);
    }

    @RequestMapping(path = "/listCategory", method = RequestMethod.POST)
    public Response<Object> listCategory(@RequestParam int userId)
    {
        return articleService.listCategory(userId);
    }

    @RequestMapping(path = "/addCategory", method = RequestMethod.POST)
    public Response<Map<String, Object>> addCategory(@Validated(CreateAction.class) HCategory hCategory)
    {
        return articleService.addCategory(hCategory);
    }

    @RequestMapping(path = "/editCategory", method = RequestMethod.POST)
    public Response<Map<String, Object>> editCategory(@Validated(UpdateAction.class) HCategory hCategory)
    {
        return articleService.editCategory(hCategory);
    }

    @RequestMapping(path = "/deleteCategory", method = RequestMethod.POST)
    public Response<Map<String, Object>> deleteCategory(@RequestParam int id)
    {
        return articleService.deleteCategory(id);
    }

    @RequestMapping(path = "/showCategory", method = RequestMethod.POST)
    public Response<Map<String, Object>> showCategory(@RequestParam int id)
    {
        return articleService.showCategory(id);
    }
}
