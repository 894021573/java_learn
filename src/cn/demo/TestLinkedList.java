package cn.demo;

import java.util.LinkedList;
import java.util.List;

public class TestLinkedList
{
    public static void main(String[] args)
    {
        t1();
    }

    public static void t1()
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("hello");
        list.add("world");
        list.add(list.size(), "like");
        list.add(list.size(), "apple");
        list.addFirst("first");
        list.addLast("last");
        System.out.println(list);

        System.out.println(list.contains("last"));
        System.out.println(list.element()); // 返回第一个，如果链表空，异常
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.indexOf("last"));
        list.offer("haha"); // 添加到最后
        list.offerFirst("offer first");
        list.offerLast("offer last");
        System.out.println(list);
        System.out.println(list.peek()); // 返回第一个，如果链表空，返回null

        list.poll(); // 删除第一个
        System.out.println(list); // 删除最后一个
        list.pollLast();
        System.out.println(list);

        list.pop(); // 删除第一个
        System.out.println(list);
        list.push("push"); // 添加第一个
        System.out.println(list);

        // remove
        // set
    }
}
