package cn.xmall.service.impl;

import cn.xmall.bean.User;
import cn.xmall.dao.UserDao;
import cn.xmall.dao.impl.UserDaoImpl;
import cn.xmall.service.UserService;
import common.utils.RandomUtil;
import common.utils.ReturnMapUtil;
import common.utils.SecurityUtil;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserServiceImpl implements UserService
{
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

    @Override
    public Map<String, Object> register(User user)
    {
        UserDao userDao = new UserDaoImpl();
        User user1 = userDao.getUserByName(user.getName());
        if (user1 != null) {
            return ReturnMapUtil.setFailResult("用户已存在");
        }

        user.setPassword(SecurityUtil.md5(user.getPassword()));
        int affectNum = (new UserDaoImpl()).addUser(user);
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
        (new UserDaoImpl()).updateTime(id);
    }
}
