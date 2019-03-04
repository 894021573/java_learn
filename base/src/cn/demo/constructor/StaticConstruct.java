package cn.demo.constructor;

/**
 * 静态初始化和非静态初始化
 */
public class StaticConstruct
{
    public static void main(String[] args)
    {
        Cat cat = new Cat();
        System.out.println(cat.getAge());
    }
}

class Cat
{
    private int age = 3;
    static String name = "kafei";

    static
    {
        // 在初始化前执行
        int age = 4;
        System.out.println("static init");
        System.out.println(name);
    }

    {
        // 在初始化前执行
        System.out.println("obj init");
    }

    Cat()
    {
        System.out.println("Cat init");
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
