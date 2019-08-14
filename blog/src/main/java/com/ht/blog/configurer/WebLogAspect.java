package com.ht.blog.configurer;

import com.ht.blog.dao.HWebLogMapper;
import com.ht.blog.entity.HUser;
import com.ht.blog.entity.HWebLog;
import com.ht.blog.service.AuthService;
import com.ht.blog.service.WebLogService;
import common.util.DateUtil;
import common.util.result.Response;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

@Aspect
@Component
public class WebLogAspect
{

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    private static final ThreadLocal threadLocal = new ThreadLocal();

    @Autowired
    private WebLogService webLogService;

    @Autowired
    private HWebLog hWebLog;

    public static void setWebLogId(int id)
    {
        threadLocal.set(id);
    }

    public static Integer getWebLogId()
    {
        return (Integer) threadLocal.get();
    }

    @Pointcut("execution(public * com.ht.blog.controller.*.*(..))")
    public void webLog()
    {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable
    {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String ip = request.getRemoteAddr();

        // 记录下请求内容
        logger.info("URL : " + url);
        logger.info("HTTP_METHOD : " + method);
        logger.info("IP : " + ip);
        Enumeration<String> enu = request.getParameterNames();
        StringBuilder requestParam = new StringBuilder();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            logger.info("name:{},value:{}", name, request.getParameter(name));
            requestParam.append("name:");
            requestParam.append(name);
            requestParam.append(",value:");
            requestParam.append(request.getParameter(name));
            requestParam.append(";");
        }

        hWebLog.setUrl(url);
        hWebLog.setMethod(method);
        hWebLog.setIp(ip);
        hWebLog.setRequest(requestParam.toString());
        hWebLog.setCreatedAt(DateUtil.getSecondTimestamp(null));

        Response<Map<String, Object>> response = webLogService.insertLog(hWebLog);
        Integer id = (Integer) response.getData().get("id");
        setWebLogId(id);
//        hWebLogMapper.insert(hWebLog);
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable
    {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
//        logger.info("RESPONSE id : " + getWebLogId());

//        System.out.println(ret.toString());
        webLogService.updateResponse(ret.toString(), getWebLogId());
    }
}