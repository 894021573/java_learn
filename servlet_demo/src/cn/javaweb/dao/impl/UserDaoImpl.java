package cn.javaweb.dao.impl;

import cn.javaweb.bean.User;
import cn.javaweb.dao.UserDao;
import cn.javaweb.utils.DateUtil;
import cn.javaweb.utils.JDBCUtil;

public class UserDaoImpl implements UserDao
{
    @Override
    public User getUser(String name, String password)
    {
        String sql = "select * from user where name = ? and password = ? limit 1";
        User user = (new JDBCUtil()).queryOne(sql, User.class, name, password);

        return user;
    }

    @Override
    public int saveUser(User user)
    {
        String sql = "insert into user (`name`,`password`,`created_at`) values (?,?,?)";
        int affectNum = (new JDBCUtil()).update(sql, user.getName(), user.getPassword(), DateUtil.getSecondTimestamp());

        return affectNum;
    }

    public User getUserByName(String name)
    {
        String sql = "select * from user where `name` = ? limit 1";
        User user = (new JDBCUtil()).queryOne(sql, User.class, name);
        return user;
    }

    public int updateTime(int updatedAt, long id)
    {
        String sql = "update user set updated_at = ? where id = ?";
        int affectNum = (new JDBCUtil()).update(sql, updatedAt, id);
        return affectNum;
    }

    public int updateToken(String token, long id)
    {
        String sql = "update user set token = ? where id = ?";
        int affectNum = (new JDBCUtil()).update(sql, token, id);
        return affectNum;
    }

    public User getUserByToken(int userId, String token)
    {
        String sql = "select * from user where id = ? and token = ? limit 1";
        User user = (new JDBCUtil()).queryOne(sql, User.class, userId, token);

        return user;
    }
}
