package cn.demo.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 * 泛型类 泛型接口 泛型方法 泛型数组
 */
public class Generic
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("d");

        Generic generic = new Generic();
        generic.test(list);

        // 泛型类
        GenericClass g1 = new GenericClass<Dog>(new Dog());
        Dog dog = (Dog) g1.getKey();
        dog.play();

        GenericClass g2 = new GenericClass<Cat>(new Cat());
        Cat cat = (Cat) g2.getKey();
        cat.play();

        // 类中的泛型方法
        Fruit<Apple> fruit = new Fruit();
        fruit.show(new Apple());
//        fruit.show(new Pear()); // 报错
        fruit.show1(new Pear());
        fruit.show2(new Pear());
        fruit.show3("a", 1, true);

        // 泛型数组
//        List<String>[] ls1 = new ArrayList<String>[10]; // 不能创建一个确切的泛型数组
        List<?>[] ls2 = new ArrayList<?>[10]; // 这样可以
    }

    /**
     * 泛型方法
     * 1.public 和 返回值之间的 T 不能少
     * 2.T 可以在泛型方法中的任意地方使用
     */
    public static <T> void test(List<T> list)
    {
        for (int i = 0; i < list.size(); i++) {
            T t = (T) list.get(i);
            System.out.println(t);
        }
    }

    /**
     * 泛型通配符
     * 这不是泛型方法
     * ?是一种类型实参，相当于所有类的父类
     */
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

// 泛型类
class GenericClass<T>
{
    private T key;

    public GenericClass(T key)
    {
        this.key = key;
    }

    public T getKey()
    {
        return key;
    }
}

abstract class Pet
{
    public abstract void play();
}

class Dog extends Pet
{
    @Override
    public void play()
    {
        System.out.println("dog play");
    }
}

class Cat extends Pet
{
    @Override
    public void play()
    {
        System.out.println("cat play");
    }
}

// 类中的泛型方法
class Fruit<T>
{
    // 普通方法
    public void show(T t)
    {
        System.out.println(t);
    }

    // 泛型方法1
    public <E> void show1(E e)
    {
        System.out.println(e);
    }

    // 泛型方法2 此处的 T 和 类名后面的T 不是一个T
    public <T> void show2(T t)
    {
        System.out.println(t);
    }

    // 泛型方法和可变参数
    public <T> void show3(T... args)
    {
        for (T t : args) {
            System.out.println(t);
        }
    }

    // 静态方法，要使用泛型能力，必须使其成为泛型方法，因此这个方法有误
//    public static void show4(T t)
//    {
//        System.out.println(t);
//    }

    // 静态方法，要使用泛型能力，必须使其成为泛型方法
    public static <T> void show5(T t)
    {
        System.out.println(t);
    }
}

class Apple
{
    @Override
    public String toString()
    {
        return "apple";
    }
}

class Pear
{
    @Override
    public String toString()
    {
        return "pear";
    }
}


