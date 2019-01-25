package cn.javaweb.utils;

import java.util.HashMap;
import java.util.Map;

public class ReturnMapUtil
{
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_FAIL = 1;

    public static final String MESSAGE_SUCCESS = "success";
    public static final String MESSAGE_FAIL = "fail";

    public static Map<String, Object> setSuccessResult()
    {
        return setMap(CODE_SUCCESS, new Object(), MESSAGE_SUCCESS);
    }

    public static Map<String, Object> setSuccessResult(Object object)
    {
        return setMap(CODE_SUCCESS, object, MESSAGE_SUCCESS);
    }

    public static Map<String, Object> setSuccessResult(Object object, String message)
    {
        return setMap(CODE_SUCCESS, object, MESSAGE_SUCCESS);
    }

    public static Map<String, Object> setFailResult()
    {
        return setMap(CODE_FAIL, new Object(), MESSAGE_FAIL);
    }

    public static Map<String, Object> setFailResult(int code, String message)
    {
        return setMap(code, new Object(), message);
    }

    public static Map<String, Object> setFailResult(String message)
    {
        return setMap(CODE_FAIL, new Object(), message);
    }

    private static Map<String, Object> setMap(int code, Object object, String message)
    {
        Map<String, Object> map = new HashMap<>();

        map.put("code", code);
        map.put("data", object);
        map.put("message", message);

        return map;
    }
}
