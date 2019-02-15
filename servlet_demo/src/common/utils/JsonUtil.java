package common.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil
{
    public static String toJson(Object object)
    {
        // Gson gson = new Gson();
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation() // 过滤注解
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES) // 驼峰转下划线
                .create();

        return gson.toJson(object);
    }
}
