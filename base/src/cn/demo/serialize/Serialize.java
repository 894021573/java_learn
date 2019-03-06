package cn.demo.serialize;

import java.io.*;

/**
 * 序列化
 * 1.要继承Serialize接口
 * 2.要使父类也被序列化，父类也要继承Serialize接口
 * 3.transient
 * 4.不保存静态变量？经测试可以保存
 */
public class Serialize
{
    public static void main(String[] args)
    {
        User user = new User();
        user.setName("aa");
        user.setAge(10);
        user.setPassword("123");
        User.setSex(2);
        System.out.println(user);

        // 序列化
        try {
            ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("objfile"));
            objectOutput.writeObject(user);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        ObjectInput objectInput = null;
        try {
            objectInput = new ObjectInputStream(new FileInputStream("objfile"));
            User newUser = (User) objectInput.readObject();
            System.out.println(newUser);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class User implements Serializable
{
//    private static final long serialVersionUID = 1L;

    public static int sex = 1;
    private String name;
    int age;
    private transient String password; // 序列化的时候会被抛弃

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

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public static int getSex()
    {
        return sex;
    }

    public static void setSex(int sex)
    {
        User.sex = sex;
    }

    @Override
    public String toString()
    {
        return "name=" + this.getName() + ";age=" + this.getAge() + ";password=" + this.getPassword() + ";sex=" + User.getSex();
    }
}
