package com.ht.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController
{
    @RequestMapping("/a")
    public String a()
    {
        return "aa";
    }

    /**
     * 分类
     * blog
     * 评论
     */
    public String caogao()
    {
        return "";
    }
}
