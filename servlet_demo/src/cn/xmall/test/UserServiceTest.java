package cn.xmall.test;

import cn.xmall.bean.User;
import cn.xmall.service.UserService;
import cn.xmall.service.impl.UserServiceImpl;
import common.utils.DateUtil;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class UserServiceTest
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
