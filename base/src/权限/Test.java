package 权限;

import 权限.user.User;

/**
                类内部  本包 子类  外部包
     public       √    √   √    √
     protected    √    √   √    ×
     default      √    √   ×    ×
     private      √    ×   ×    ×
 */
public class Test
{
    public static void main(String[] args)
    {
        User user = new User();

        System.out.println(user.name);
//        System.out.println(user.age); // 非同一包内的非public属性，不能访问

        Address address = new Address();
        System.out.println(address.name); // 同一包内的非public属性，可以访问
    }
}
