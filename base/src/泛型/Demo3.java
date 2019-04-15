package 泛型;

import java.util.List;

public class Demo3
{
    public static void main(String[] args)
    {
        Room<Man> room1 = new Room<>();
        room1.echoName1(new Man());

        Room<Children> room2 = new Room<>();
        room2.echoName2(new Man(), new Worman());

        Room room3 = new Room();
        room3.echoName3(new Man(), new Worman(), new Children());
    }
}

// 泛型方法能使方法独立于类而产生变化
class Room<T>
{
    // 泛型方法：泛型参数位于权限修饰符和返回声明之间，可在方法的任意地方使用
    public <E> void echoName1(E e)
    {
        System.out.println(e);
    }

    // 泛型方法：此处的T和类后面的T没关系
    public <E, T> void echoName2(E e, T t)
    {
        System.out.println(e);
        System.out.println(t);
    }

    // 泛型方法和可变参数
    public <R> void echoName3(R... args)
    {
        for (R r : args) {
            System.out.println(r);
        }
    }

//    public static void echoName4(T t) 不能这样写
    // 静态方法无法访问类上定义的泛型；如果静态方法操作的引用数据类型不确定的时候，必须要将泛型定义在方法上
    // 如果static方法要使用泛型能力，就必须使其成为泛型方法
    public static <T> void echoName4(T t)
    {

    }

    /**
     * 泛型通配符
     * 这不是泛型方法
     * ?是一种类型实参，相当于所有类的父类
     */
    public void echoName5(List<?> list)
    {
        for (int i = 0; i < list.size(); i++) {
            Object t = list.get(i);
            System.out.println(t);
        }
    }
}

class Man
{

}

class Worman
{

}

class Children
{

}
