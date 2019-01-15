package cn.demo;

public class TestObject
{
    public static void main(String[] args)
    {
        Dog d1 = new Dog("liuliu");
        Dog d2 = new Dog("liuliu");

        System.out.println(d1.equals(d2));
    }
}

class Dog
{
    private String name;

    Dog(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj)
    {
        Dog dog = (Dog) obj;
        return this.name.equals(dog.getName());
    }

    public String getName()
    {
        return name;
    }
}
