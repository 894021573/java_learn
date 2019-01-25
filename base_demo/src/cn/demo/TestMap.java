package cn.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestMap
{
    public static void main(String[] args)
    {
        t3();
    }

    public static void t1()
    {
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, "ht");
        map.put(2, "wqj");
        map.put(3, new MyDog());
        System.out.println(map);

        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("wqj"));
        map.clear();
        System.out.println(map);
    }

    public static void t2()
    {
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, "ht");
        map.put(2, "wqj");
        map.put(3, new MyDog());

        // 遍历1 最常见
        Set<Map.Entry<Integer, Object>> entries = map.entrySet();
        for (Map.Entry<Integer, Object> entry : entries)
        {
            System.out.println("key=" + entry.getKey() + ";value=" + entry.getValue());
        }
        System.out.println("======");

        // 遍历2 比1快
        for (Integer integer : map.keySet())
        {
            System.out.println("key=" + integer);
        }
        for (Object object : map.values())
        {
            System.out.println("value=" + object);
        }
        System.out.println("======");

        // 遍历3 最慢
        for (Integer integer : map.keySet())
        {
            System.out.println("key=" + integer + ";value=" + map.get(integer));
        }

        System.out.println("======");

        // 遍历4 可以remove
        Iterator<Map.Entry<Integer, Object>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext())
        {
            Map.Entry<Integer, Object> entry = entryIterator.next();
            if (entry.getValue() == "wqj")
            {
                entryIterator.remove(); // 删除
            } else
            {
                System.out.println("key=" + entry.getKey() + ";value=" + entry.getValue());
            }

        }
        System.out.println(map);
        System.out.println("======");
    }

    public static void t3()
    {
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, "ht");
        map.put(2, "wqj");
        map.put(3, new MyDog());

        Map<Integer, Object> map2 = new HashMap<>();
        map.put(4, "aa");
        map.put(5, "bb");
        map.putAll(map2);
        System.out.println(map);

        System.out.println(map.putIfAbsent(1, "ht111")); // 如果key有对应的value，则返回value
        System.out.println(map.putIfAbsent(6, "ht666")); // 如果key没有对应的value，则赋值，返回null
        System.out.println(map.putIfAbsent(7, null)); // 如果key没有对应的value，则赋值，返回null。如果value是null，肯定会被修改
        System.out.println(map);

        map.put(6, null);
        System.out.println(map);

        // 移除
        System.out.println(map.remove(5, "cc"));
        System.out.println(map);

        System.out.println(map.remove(5, "bb"));
        System.out.println(map);

        // 替换
        System.out.println(map.replace(1, "yyf")); // 返回被替换的元素
        System.out.println(map);

        System.out.println(map.replace(11, "yyf")); // 返回被替换的元素，没有则返回null
        System.out.println(map);

        // replaceAll()
    }
}


class MyDog
{

}