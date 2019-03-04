package cn.demo.auth;

import cn.demo.auth.dog.Dog;

public class Auth
{
    public static void main(String[] args)
    {
        Dog d = new Dog(); // 只能访问其他包里面的public类

//        System.out.println(d.name); // 不是一个包内，所以无法访问protected属性

        Car c = new Car();
        System.out.println(c.color); // protected属性color可以供包内其他类访问
    }
}