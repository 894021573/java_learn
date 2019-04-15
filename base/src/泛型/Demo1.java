package 泛型;
// 参考：https://www.cnblogs.com/coprince/p/8603492.html

// 泛型类
public class Demo1
{
    public static void main(String[] args)
    {
        Student student = new Student();
        student.setObj(new Dog());
        System.out.println(student.getObj());

        Student<Dog> student1 = new Student();
//        student1.setObj(new Cat()); // 不能是cat
    }
}

// 泛型类的类型参数只能是类类型，不能是简单类型
class Student<T>
{
    private T obj;

    public void setObj(T obj)
    {
        this.obj = obj;
    }

    public T getObj()
    {
        return this.obj;
    }
}

class Dog
{

}

class Cat
{

}
