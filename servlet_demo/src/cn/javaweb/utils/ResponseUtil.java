package cn.javaweb.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil
{
    public static void responseJson(HttpServletResponse resp, Map object)
    {
        resp.setContentType("text/json;charset=utf-8");
        try {
            PrintWriter printWriter = resp.getWriter();
            printWriter.println(JsonUtil.toJson(object));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void responseXML(HttpServletResponse resp, Map object)
    {

    }
}
