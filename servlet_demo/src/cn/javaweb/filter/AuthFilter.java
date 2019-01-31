package cn.javaweb.filter;


import cn.javaweb.service.CommonService;
import cn.javaweb.service.impl.CommonServiceImpl;
import cn.javaweb.utils.ResponseUtil;
import cn.javaweb.utils.ReturnMapUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter
{
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        System.out.println("before filter222");

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String currentURL = httpRequest.getServletPath();

        String noValidatePath = this.filterConfig.getInitParameter("noValidatePath");
        String[] noValidatePaths = noValidatePath.split(" ");

        boolean isValidate = true;
        for (int i = 0; i < noValidatePaths.length; i++) {
            if (noValidatePaths[i].equals(currentURL)) {
                isValidate = false;
                break;
            }
        }

        if (isValidate) { // 需要验证
            CommonService commonService = new CommonServiceImpl();
            int userId = Integer.valueOf(httpRequest.getParameter("user_id"));
            String token = httpRequest.getParameter("token");

            if (!commonService.isValidUser(userId, token)) { // 验证失败
                ResponseUtil.responseJson((HttpServletResponse) servletResponse, ReturnMapUtil.setFailResult("无效用户"));
            } else { // 验证成功
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else { // 不需要验证
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy()
    {

    }
}
