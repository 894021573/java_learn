package cn.demo.enuma;


public class Enum
{
    public static void main(String[] args)
    {
        // 遍历枚举类型
        System.out.println(Color.RED);
        for (Color c : Color.values())
        {
            System.out.println("c" + c.ordinal());
        }

        // 和switch搭配
        Color c = Color.RED;
        switch (c)
        {
            case RED:
                System.out.println("is red");
                break;
            case GREEN:
                System.out.println("is green");
                break;
            case BLUE:
                System.out.println("is blue");
                break;
            default:
        }
    }
}

enum Color
{
    RED, GREEN, BLUE;
}

