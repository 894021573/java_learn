package cn.javaweb.test;

import cn.javaweb.bean.User;
import cn.javaweb.service.UserService;
import cn.javaweb.service.impl.UserServiceImpl;
import cn.javaweb.utils.DateUtil;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class TestUserService
{
    private UserService userService = new UserServiceImpl();

    @Test
    public void login()
    {
        Map<String, Object> map = userService.login("xin3", "333");
        assertEquals((int) map.get("code"), 0);
    }

    @Test
    public void register()
    {
        User user = new User();
        user.setName(String.valueOf(DateUtil.getSecondTimestamp()));
        user.setPassword("333");

        Map<String, Object> map = userService.register(user);
        assertEquals((int) map.get("code"), 0);
    }
}
