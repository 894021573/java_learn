package com.ht.blog.controller;

import com.ht.blog.common.help.valid.groups.CreateAction;
import com.ht.blog.entity.HArticle;
import com.ht.blog.entity.HComment;
import com.ht.blog.entity.HUser;
import com.ht.blog.service.ArticleService;
import com.ht.blog.service.CommentService;
import common.util.SerializeUtil;
import common.util.result.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CommentController
{
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CommentService commentService;

    @RequestMapping(path = "/addComment", method = RequestMethod.POST)
    public Response<Map<String, Object>> addArticle(@Validated(CreateAction.class) HComment hComment)
    {
//        HUser hUser = (HUser)redisTemplate.opsForValue().get(hComment.getUserId());
//        System.out.println(hUser.getNickname());

        return commentService.addComment(hComment);
    }

    @RequestMapping(path = "/listComment", method = RequestMethod.POST)
    public Response<Map<String, Object>> listComment(
            @RequestParam int articleId,
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize)
    {
        return commentService.listComment(articleId, pageNum, pageSize);
    }
}
