package cn.demo;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestSystem
{
    public static void main(String[] args)
    {
        t1();
    }

    public static void t1()
    {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};

        System.arraycopy(a, 0, b, 1, 2);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        System.out.println(System.currentTimeMillis());

        Map<String, String> map = System.getenv();
        for (Map.Entry<String, String> entry : map.entrySet())
        {
            System.out.println("key=" + entry.getKey() + ";value=" + entry.getValue());
        }

        Properties properties = System.getProperties();
        Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entrySet)
        {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
