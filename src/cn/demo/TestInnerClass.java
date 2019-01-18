package cn.demo;

public class TestInnerClass
{
    public static void main(String[] args)
    {
        // 内部类



        Pet pet = new Pet();
        pet.new Dog().play();
        // Pet.new Baozi().play(); // 外部无法用new访问静态类
        Pet.Baozi.play2(); // 只能用静态方式访问静态成员类

        pet.play();
    }
}

class Pet
{
    private String name;
    private static int age;

    public class Dog
    {
        private String dogName;
        // public static int age = 1; // 非静态成员类不能定义静态属性
        final static int age = 1;

        public void play()
        {
            String petName = Pet.this.name; // 获取外部类的属性
            int petAge = Pet.age; // 获取外部类的静态属性
            Baozi.play2();
            new Baozi().play();
            System.out.println("dog play");
        }

        // 非静态成员类不能定义静态方法
//        public static void play2()
//        {
//            System.out.println("static dog play");
//        }
    }

    public static class Baozi
    {
        public void play()
        {

            System.out.println("baozi play");
        }

        public static void play2()
        {
            System.out.println("static baozi play2");
        }
    }

    public void play()
    {
        this.new Dog().play();
        new Baozi().play(); // 内部可以用new访问静态成员类
        Baozi.play2();
    }

    public static void play2()
    {
        Baozi.play2();
    }
}
