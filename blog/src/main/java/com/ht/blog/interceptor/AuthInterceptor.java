package com.ht.blog.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ht.blog.common.help.result.AuthCodeMsg;
import com.ht.blog.dao.HUserMapper;
import com.ht.blog.entity.HUser;
import common.util.DateUtil;
import common.util.ResponseUtil;
import common.util.SerializeUtil;
import common.util.result.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter
{
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HUserMapper hUserMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        logger.info("请求前调用:");

        // 验证token
        String token = request.getParameter("token");
        int userId = Integer.valueOf(request.getParameter("userId"));
        HUser hUser = hUserMapper.selectByToken(token);

        if (hUser != null) {
            System.out.println("userId" +userId);
            System.out.println("userId2" +hUser.getId());
            if (userId != hUser.getId()) {
                ResponseUtil.printJson(response, Response.error(AuthCodeMsg.TOKEN_ERROR3));
                return false;
            }

            if (hUser.getExpiredAt() <= DateUtil.getSecondTimestamp(null)) {
                ResponseUtil.printJson(response, Response.error(AuthCodeMsg.TOKEN_ERROR1));
                return false;
            }

            // 保存用户数据
            redisTemplate.opsForValue().set(hUser.getId(), hUser, 3600, TimeUnit.SECONDS);

            return true;
        } else {
            // 验证失败，直接返回
            ResponseUtil.printJson(response, Response.error(AuthCodeMsg.TOKEN_ERROR2));

            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception
    {
        logger.info("请求后调用:");
    }
}
