package com.springbootdemo.filter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


public class LoginInterceptor extends HandlerInterceptorAdapter
{
    private Logger logger = LoggerFactory.getLogger(getClass());
    private int i = 1;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        logger.info("login请求前调用:" + (i++));

        if(1 == 2){
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> map = new HashMap<>();
            map.put("name","ht");
            map.put("age","111");

            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(mapper.writeValueAsString(map));
            return false;
        }

        return true;
        //return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        logger.info("login请求后调用:" + (i++));
    }
}
