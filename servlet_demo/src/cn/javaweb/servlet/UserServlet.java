package cn.javaweb.servlet;

import cn.javaweb.bean.User;

import cn.javaweb.service.UserService;
import cn.javaweb.service.impl.UserServiceImpl;
import cn.javaweb.utils.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class UserServlet extends BaseServlet
{
    // 登录
    public void login(HttpServletRequest req, HttpServletResponse resp)
    {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String code = req.getParameter("code");

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        UserService userService = new UserServiceImpl();
        Map<String, Object> map = userService.login(user.getName(), user.getPassword());

        ResponseUtil.responseJson(resp, map);
    }

    // 注册
    public void register(HttpServletRequest req, HttpServletResponse resp)
    {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        UserService userService = new UserServiceImpl();
        Map<String, Object> map = userService.register(user);

        ResponseUtil.responseJson(resp, map);
    }

    public void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getRequestDispatcher("/web_content/update.jsp").forward(req, resp);
    }
}