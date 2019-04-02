package 设计模式;

public class ADemo
{
    public static void main(String[] args)
    {
        Mobile mobile = new Mobile();
        Dog dog = new Dog();
        Cat cat = new Cat();

        mobile.addObserver(dog);
        mobile.addObserver(cat);

        mobile.setFood("狗粮");
        mobile.setToy("绳子");

        mobile.removeObserver(cat);

        mobile.noticeObserver();

        dog.display();
        cat.display();
    }
}
