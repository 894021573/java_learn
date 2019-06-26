package com.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@MapperScan("com.springbootdemo.mapper") //扫描的mapper
@SpringBootApplication
@RestController
@ServletComponentScan(basePackages = "com.springbootdemo")
public class DemoApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/") String home() {
        return"Hello World!";
    }

    @RequestMapping("/h2") String h2() {
        return"H2!";
    }
}
