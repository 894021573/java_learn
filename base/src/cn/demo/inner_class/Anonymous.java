package cn.demo.inner_class;

/**
 * 匿名类
 */
class Bird
{
    String name;

    Bird(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void fly()
    {
    }
}

public class Anonymous
{
    public static void main(String[] args)
    {
        fo(
                // 1.匿名类必须继承一个类或者实现一个接口，且只能一个。本身不能是抽象类
                // 2.匿名类中不能有构造函数
                // 3.不能有任何静态成员或者方法，因为是通过new创建的
                // 4.属于局部内部类
                new Bird("a")
                {
                    public void fly()
                    {
                        System.out.println(this.getName() + " fly");
                    }
                }
        );
    }

    public static void fo(Bird bird)
    {
        bird.fly();
    }
}
