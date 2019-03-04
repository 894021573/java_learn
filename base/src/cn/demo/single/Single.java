package cn.demo.single;

public class Single
{
    public static void main(String[] args)
    {
        Dog d1 = Dog.makeDog();
        Dog d2 = Dog.makeDog();
        System.out.println(d1 == d2);
    }
}

class Dog
{
    private static Dog dog = new Dog();

    private Dog()
    {
    }

    public static Dog makeDog()
    {
        return dog;
    }
}
