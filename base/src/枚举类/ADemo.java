package 枚举类;

public class ADemo
{
    public static void main(String[] args)
    {
        for (Color c : Color.values()) {
            System.out.println(c.toString() + c.ordinal());
        }

        System.out.println(Color.valueOf("RED") == Color.RED);
        System.out.println(Color.RED.getMsg());
        System.out.println(Color.RED.name());

        System.out.println(Color.getColor(1).name());
    }
}
