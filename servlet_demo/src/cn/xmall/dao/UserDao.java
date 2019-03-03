package cn.xmall.dao;

import cn.xmall.bean.User;

import java.sql.SQLException;

public interface UserDao
{
    User getUser(String name, String password);

    int addUser(User user) throws SQLException;

    User getUserByName(String name);

    User getUserByToken(int userId, String token);
}
