package com.ht.springcloudconsumer.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// common包下是把feign独立出一个项目的效用方式，如果两处的applicationname相同，启动会报错，提示不能注册相同的
// 因此为了测试common包下的feign使用方法，此处暂时改为htproduct2
@FeignClient("htproduct2")
public interface HelloRemote
{
    @RequestMapping(value = "/product/hello")
    public String hello(@RequestParam(value = "name") String name);
}
