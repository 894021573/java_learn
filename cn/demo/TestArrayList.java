package cn.demo;

import java.util.*;
import java.util.function.Predicate;

public class TestArrayList
{
    public static void main(String[] args)
    {
        test5();
    }

    public static void test1()
    {
        // This class is roughly equivalent to Vector, except that it is unsynchronized
        // List list = Collections.synchronizedList(new ArrayList(...));
        // The iterators returned by this class's iterator and listIterator methods are fail-fast
        List list1 = new ArrayList();
        list1.add(1);
        list1.add(2);

        ArrayList list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("rm");

        list1.addAll(list2);
        System.out.println(list1);

        list1.clear();
        System.out.println(list1);

        List list3 = (List) list2.clone(); // 被clone的对象，必须声明为ArrayList类型，因为List没有clone
        System.out.println(list3);

        System.out.println(list3.contains('a')); // 'a ' 和 "a" 不一样

        System.out.println(list3.get(0));
        System.out.println(list3.indexOf('v')); // 查不到 返回-1
        System.out.println(list3.isEmpty());

        Iterator iterator = list3.iterator(); // Iterator 和 ListIterator 区别
        while (iterator.hasNext())
        {
            String o = (String) iterator.next();
            System.out.println(o);
            if (o.equals("a"))
            {
                iterator.remove(); // 移除后，list会重建索引
            }
        }

        System.out.println(list3);
    }

    public static void test2()
    {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.remove("a");
        list.remove(0);
        System.out.println(list);


        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(0);
        list2.remove(0); // 移除0索引
        list2.remove((Integer) 0); // 移除0对象
        System.out.println(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("a");
        list3.add("b");
        list3.add("c");
        List<String> rmList3 = new ArrayList<>();
        rmList3.add("b");
        rmList3.add("cc");
        System.out.println(list3.removeAll(rmList3)); // 只要有一个能被移除 就返回true
        System.out.println(list3);

        ArrayList<String> list4 = new ArrayList<>();
        list4.add("a");
        list4.add("b");
        list4.add("c");
        // 带条件移除
        list4.removeIf(new Predicate<String>()
        {
            @Override
            public boolean test(String s)
            {
                return s.equals("a");
            }
        });

        System.out.println(list4);

        list4.set(1, "d");
        System.out.println(list4);
    }

    public static void test3()
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(4);
        list.add(7);
        list.add(1);
        list.add(5);
        list.add(0);
        list.sort(new MyCompare()); // 排序

        System.out.println(list);
        Integer[] is = (Integer[]) list.toArray();
        list.trimToSize();
    }

    public static void test4()
    {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        List list2 = new ArrayList();
        list2.add(2);
        list2.add(3);

        System.out.println(list.containsAll(list2)); // 包含


        Collections.replaceAll(list, 1, "a"); // 替换
        System.out.println(list);
    }

    public static void test5()
    {
        List<String> words = new ArrayList<>();
        words.add("a");
        words.add("b");
        words.add("c");

        ListIterator listIterator = words.listIterator();
        while (listIterator.hasNext())
        {
            String s = (String) listIterator.next();
            if (s == "a")
            {
//                listIterator.remove();
                listIterator.set("aa");
            }


        }

        System.out.println(words);
    }
}

class MyCompare implements Comparator<Integer>
{

    @Override
    public int compare(Integer o1, Integer o2)
    {
//        if (o1 < o2)
//        {
//            return -1;
//        } else if (o1 > o2)
//        {
//            return 1;
//        } else
//        {
//            return 0;
//        }

        // 倒序
        if (o1 < o2)
        {
            return 1;
        } else if (o1 > o2)
        {
            return -1;
        } else
        {
            return 0;
        }
    }
}
