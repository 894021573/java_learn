package cn.demo.object;

public class CloneObject
{
    public static void main(String[] args)
    {
        Student s1 = new Student("ht1", 1);
        Student s2 = s1;
        Student s3 = null;
        try {
            s3 = s1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        s1.setName("yy1");
        s1.getAddress().setName("taizhou");
        s1.getDog().setName("liuliu");
        System.out.println(s2.getName());
        System.out.println(s3.getName());
        System.out.println(s3.getAddress().getName()); // 是浅复制，只是复制了address对象的引用
        System.out.println(s3.getDog().getName()); // 是深复制，所以创建了新的dog对象
    }
}

class Student implements Cloneable
{
    private String name;
    private int age;
    private Address address = new Address();
    private Dog dog = new Dog();

    Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Dog getDog()
    {
        return dog;
    }

    public void setDog(Dog dog)
    {
        this.dog = dog;
    }

    @Override
    protected Student clone() throws CloneNotSupportedException
    {
        Student student = (Student) super.clone();
        student.setDog(this.getDog().clone()); // 深复制
        return student;
    }
}

class Address
{
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}

class Dog implements Cloneable
{
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    protected Dog clone() throws CloneNotSupportedException
    {
        return (Dog) super.clone();
    }
}
