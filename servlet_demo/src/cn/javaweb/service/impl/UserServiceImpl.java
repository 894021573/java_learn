package cn.javaweb.service.impl;

import cn.javaweb.bean.User;
import cn.javaweb.dao.UserDao;
import cn.javaweb.dao.impl.UserDaoImpl;
import cn.javaweb.service.UserService;
import cn.javaweb.utils.DateUtil;
import cn.javaweb.utils.RandomUtil;
import cn.javaweb.utils.ReturnMapUtil;
import cn.javaweb.utils.SecurityUtil;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserServiceImpl implements UserService
{
    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    @Override
    public Map<String, Object> login(String name, String password)
    {
        User user = (new UserDaoImpl()).getUser(name, SecurityUtil.md5(password));

        if (user != null) {
            String token = this.updateToken(user.getId());
            user.setToken(token);
            this.updateTime(user.getId());

            // 结果
            Map<String, Object> resultMap = new LinkedHashMap<>();
            resultMap.put("user", user);
            return ReturnMapUtil.setSuccessResult(resultMap);
        } else {
            return ReturnMapUtil.setFailResult("用户名或者密码有误");
        }
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public Map<String, Object> register(User user)
    {
        UserDao userDao = new UserDaoImpl();
        User user1 = userDao.getUserByName(user.getName());
        if (user1 != null) {
            return ReturnMapUtil.setFailResult("用户已存在");
        }

        user.setPassword(SecurityUtil.md5(user.getPassword()));
        int affectNum = (new UserDaoImpl()).saveUser(user);
        if (affectNum > 0) {
            return ReturnMapUtil.setSuccessResult();
        } else {
            return ReturnMapUtil.setFailResult("注册失败");
        }
    }

    private String updateToken(int id)
    {
        String token = RandomUtil.getToken();
        (new UserDaoImpl()).updateToken(token, id);

        return token;
    }

    private void updateTime(int id)
    {
        int updatedAt = DateUtil.getSecondTimestamp();
        (new UserDaoImpl()).updateTime(updatedAt, id);
    }
}
