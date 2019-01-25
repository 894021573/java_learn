package cn.javaweb.dao;

import cn.javaweb.bean.User;

import java.sql.SQLException;

public interface UserDao
{
    User getUser(String name, String password);

    int saveUser(User user) throws SQLException;

    User getUserByName(String name);

    User getUserByToken(int userId, String token);
}
