package cn.javaweb.dao.impl;

import cn.javaweb.bean.User;
import cn.javaweb.dao.UserDao;
import cn.javaweb.utils.DateUtil;

import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao
{
    @Override
    public User getUser(String name, String password)
    {
        return this.findOne("name = ? and password = ?", name, password);
    }

    @Override
    public int saveUser(User user)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("name", user.getName());
        map.put("password", user.getPassword());
        map.put("created_at", DateUtil.getSecondTimestamp());

        return this.save(map);
    }

    public User getUserByName(String name)
    {
        return this.findOne("name = ?", name);
    }

    public int updateTime(long id)
    {
        return this.update("updated_at = ?", "id = ?", DateUtil.getSecondTimestamp(), id);
    }

    public int updateToken(String token, long id)
    {
        return this.update("token = ?", "id = ?", token, id);
    }

    public User getUserByToken(int userId, String token)
    {
        return this.findOne("id = ? and token = ?", userId, token);
    }
}
