package cn.javaweb.test;

import cn.javaweb.utils.RandomUtil;
import org.junit.Test;

public class TestRandomUtil
{
    @Test
    public void getToken()
    {
        String s = RandomUtil.getToken();
        System.out.println(s);
    }
}
