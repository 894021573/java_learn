package cn.demo.inner_class;

/**
 * 《Think in java》中有这样一句话：使用内部类最吸引人的原因是：每个内部类都能独立地继承一个（接口的）实现，所以无论外围类是否已经继承了某个（接口的）实现，对于内部类都没有影响
 *  接口只是解决了部分问题，而内部类使得多重继承的解决方案变得更加完整
 *  内部类：成员内部类 静态内部类 局部内部类 匿名内部类
 */
public class InnerClass
{
    public static void main(String[] args)
    {
        // 内部类
        Pet pet = new Pet();
        pet.new Dog().play();
        // Pet.new Baozi().play(); // 外部无法用new访问内部静态类
        Pet.Baozi.play2(); // 只能用静态方式访问内部静态类

        pet.play();

        pet.eat("gouliang");
    }
}

class Pet
{
    private String name;
    private static int age;

    // 内部类
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

    // 内部静态类
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

    // 在内部访问内部类和内部静态类
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

    // java 8：如果局部变量被匿名内部类访问，那么该局部变量相当于自动使用了final修饰。此外，Java 8的λ表达式也与此类似只能访问final外部变量但不要求用final修饰，不过，变量同样不能被重新赋值。
    // 匿名内部类对象可以访问同一个方法中被定义为final类型的局部变量。定义为final后，编译程序的实现方法：对于匿名内部类对象要访问的所有final类型局部变量，都拷贝成为该对象中的一个数据成员。这样，即使栈中局部变量已死亡，但被定义为final类型的局部变量的值永远不变，因而匿名内部类对象在局部变量死亡后，照样可以访问final类型的局部变量，因为它自己拷贝了一份，且与原局部变量的值始终一致
    public void eat(final String name)
    {
        // 局部内部类
        class InnerEat
        {
            public void eat()
            {
                System.out.println(name);
            }

            public String eatA()
            {
                return name;
            }
        }

        InnerEat innerEat = new InnerEat();
        innerEat.eat();
        System.out.println(innerEat.eatA() + "===");
    }
}
