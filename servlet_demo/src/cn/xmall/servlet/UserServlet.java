package cn.xmall.servlet;

import cn.xmall.bean.User;

import cn.xmall.service.UserService;
import cn.xmall.service.impl.UserServiceImpl;
import common.utils.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
}
