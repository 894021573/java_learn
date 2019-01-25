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
        PrintWriter printWriter = null;
        try {
            printWriter = resp.getWriter();

//            Gson gson = new Gson();


            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation() // 过滤注解
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES) // 驼峰转下划线
                    .create();

            Map<String, Object> map = new HashMap<>();
            map.put("code", object.get("code"));
            map.put("data", object.get("data"));
            map.put("message", object.get("message"));
            printWriter.println(gson.toJson(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void responseXML(HttpServletResponse resp, Map object)
    {

    }
}
