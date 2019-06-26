package com.springbootdemo.controller;

import com.springbootdemo.bean.User;
import com.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    @Value("${spring.datasource.username}")
    private String u;

    @Value("${com.blog.name}")
    private String blogName;

    @Value("${com.blog.age}")
    private String blogAge;

    @Autowired
    private UserService userService;

    @RequestMapping("/helloUser/{id}")
    public String selectUser (@PathVariable int id){
        return userService.selectUser(id).toString();
    }

    @RequestMapping("/getUser")
    public User getUser()
    {
        User user = new User();
        user.setUername("ht");
        user.setPassword("123");
        return user;
    }

    @RequestMapping("/login")
    public String login()
    {
        System.out.println("u:" + u);
        System.out.println("blogName:" + blogName);
        System.out.println("blogAge:" + blogAge);
        System.out.println("zhongwen:" + "中文");
        return "login";
    }

    @RequestMapping("/logout")
    public String logout()
    {
        return "logout";
    }
}
