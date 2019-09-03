package com.ht.springcloudconsumer.controller;

import com.ht.springcloudconsumer.api.HelloRemote;
import com.ht.springcloudconsumer.common.HelloReomteCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    HelloRemote helloRemote;

    @Resource
    HelloReomteCommon helloReomteCommon;

    @GetMapping("/hello")
    public String index1()
    {
        return restTemplate.getForObject("http://HTPRODUCT/product/hello?name=neo", String.class);
    }

    @GetMapping("/feignHello")
    public String feignIndex1(@RequestParam String name)
    {
        return helloRemote.hello(name + "-feign");
    }

    @GetMapping("/feignHelloApi")
    public String feignIndexApi(@RequestParam String name)
    {
        return helloReomteCommon.hello(name + "-feignapi");
    }

    @GetMapping("/list")
    public Map<String,Integer> index2()
    {
        System.out.println(22);
        return restTemplate.getForObject("http://HTPRODUCT/product/list", HashMap.class);
    }
}
