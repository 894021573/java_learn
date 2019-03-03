package cn.demo;

import java.util.ArrayList;
import java.util.List;

public class Generic
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("d");

        Generic generic = new Generic();
        generic.test(list);
    }

    public static <T> void test(List list)
    {
        for (int i = 0; i < list.size(); i++) {
            T t = (T) list.get(i);
            System.out.println(t);
        }
    }

    public void test2(List<?> list)
    {
        for (int i = 0; i < list.size(); i++) {
            Object t = list.get(i);
            System.out.println(t);
        }
    }

    public void test3(List<?> list)
    {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
