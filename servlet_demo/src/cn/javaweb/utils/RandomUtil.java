package cn.javaweb.utils;

import java.util.UUID;

public class RandomUtil
{
    public static String getToken()
    {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
