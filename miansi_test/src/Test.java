import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Test
{
    public static void main(String[] args)
    {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog());

        Dog dog = list.get(0);
        System.out.println(dog.name);
    }


}


class Dog
{
    public String name = "ll";

    public Dog(String name)
    {
        this.name = name;
    }

    public Dog()
    {

    }

    public void play()
    {
        System.out.println(this.name + " play");
    }
}

