package 初始化;

public class Test
{
    public static void main(String[] args)
    {
        User user = new User();
        System.out.println(user);

        User user2 = new User("hello");
        System.out.println(user2);

        User user3 = new User("world",999);
        System.out.println(user3);
    }
}

class User
{
    protected String name = "ht";
    protected int age = 100;

    {
        String name = "static name";

        System.out.println("static init name is " + name);
    }

    User()
    {
        System.out.println("init");
    }

    User(String name)
    {
        this();
        this.name = name;
//        this(); // 对this的调用必须是构造器中的第一个语句
    }

    User(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String toString()
    {
        return "name is " + this.name + ";age is " + this.age;
    }
}
