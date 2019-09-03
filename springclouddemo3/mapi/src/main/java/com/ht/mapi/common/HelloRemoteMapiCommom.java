package com.ht.mapi.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface HelloRemoteMapiCommom
{
    @RequestMapping(value = "/product/hello")
    public String hello(@RequestParam(value = "name") String name);
}
