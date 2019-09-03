package com.ht.springcloudclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController
{
    @RequestMapping("/hello")
    public String index1(@RequestParam String name)
    {
        return "hello " + name + "，this is first messge";
    }

    @RequestMapping("/list")
    public Map<String, Integer> index2()
    {

        Map<String, Integer> hashmap = new HashMap<>();
        hashmap.put("common", 1);
        return hashmap;
    }
}
