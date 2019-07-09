package com.ht.blog.configurer;

import com.ht.blog.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@Component
public class WebConfig extends WebMvcConfigurationSupport
{
    // 注册拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(authInterceptor())
                .addPathPatterns("/addArticle", "/editArticle", "/deleteArticle", "/addComment", "/listMyArticle", "/addCategory","/editCategory","/deleteCategory","/showCategory");

        super.addInterceptors(registry);
    }

    @Bean
    AuthInterceptor authInterceptor()
    {
        return new AuthInterceptor();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        super.addResourceHandlers(registry);
    }
}
