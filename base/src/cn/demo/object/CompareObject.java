package cn.demo.object;

import java.util.Objects;

/**
 * 对象比较
 * 1.重写equals
 * 2.重写hashcode
 * 3.用ide自动生成这两个方法
 */
public class CompareObject
{
    public static void main(String[] args)
    {
        Cat c1 = new Cat("a");
        Cat c2 = new Cat("b");
        System.out.println(c1.equals(c2)); // 不相等，比较的是引用
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());

        Cat c3 = new Cat("a");
        System.out.println(c1.equals(c3));
        c1.setAge(100);
        System.out.println(c1.equals(c3));
        c3.setAge(100);
        System.out.println(c1.equals(c3));
        System.out.println(c1 == c3);
        System.out.println(c1.hashCode());
        System.out.println(c3.hashCode());
    }
}

class Cat
{
    private String name;
    private int age;

    Cat(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        Cat cat = (Cat) o;
        return getAge() == cat.getAge() &&
                getName().equals(cat.getName());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getName(), getAge());
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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
