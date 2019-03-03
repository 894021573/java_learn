package cn.xmall.test;

import common.utils.RandomUtil;
import org.junit.Test;

public class RandomUtilTest
{
    @Test
    public void getToken()
    {
        String s = common.utils.RandomUtil.getToken();
        System.out.println(s);
    }
}
