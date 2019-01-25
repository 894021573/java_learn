package cn.javaweb.service.impl;

import cn.javaweb.bean.User;
import cn.javaweb.dao.UserDao;
import cn.javaweb.dao.impl.UserDaoImpl;
import cn.javaweb.service.CommonService;

public class CommonServiceImpl implements CommonService
{
    public boolean isValidUser(int userId, String token)
    {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUserByToken(userId, token);
        return user != null;
    }
}
