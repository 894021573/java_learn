package cn.demo.constructor;

public class Test
{
    public static void main(String[] args)
    {
        Dog dog = new Dog("liuliu ", 3);
        dog.play("baobao");
    }
}

class Dog
{
    Dog(String name)
    {
        System.out.println("print name " + name);
    }

    Dog(String name, int age)
    {
        this(name);
        System.out.println("pring age" + age);
//        this(name); 报错：对this的调用必须是构造器中的第一个语句
    }

    public void play(String name)
    {
//        this(name); // 报错：对this的调用必须是构造器中的第一个语句
    }
}


