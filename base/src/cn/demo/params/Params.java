package cn.demo.params;

/**
 * 可变参数
 */
public class Params
{
    public static void main(String[] args)
    {
        fo(1, 2, 3);
        fo(1.1, 2.2, 3.3);
        fo(1.1f, 2.2f, 3.3f);
        fo(new Integer(11), new Integer(22)); // 可变参数和自动包装可以共处
        fo(); // 自动去找一个用，不报错
    }

    public static void fo(double... args)
    {
        for (double i : args)
        {
            System.out.println(i);
        }
    }

    public static void fo(int... args)
    {
        for (int i : args)
        {
            System.out.println(i);
        }
    }

    public static void fo(float... args)
    {
        for (float i : args)
        {
            System.out.println(i);
        }
    }
}
