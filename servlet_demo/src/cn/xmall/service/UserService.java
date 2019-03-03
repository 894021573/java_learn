package cn.xmall.service;

import cn.xmall.bean.User;

import java.util.Map;

public interface UserService
{
    /**
     * 登录
     *
     * @param name
     * @param password
     * @return
     */
    Map<String, Object> login(String name, String password);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    Map<String, Object> register(User user);
}
