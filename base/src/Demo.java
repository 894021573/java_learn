public class Demo
{
    public static void main(String[] args)
    {
        int a = 1;
        double b = 1.634;
        System.out.println(a + b);

        int c = (int) b;
        System.out.println(c);

        int d = (int) Math.round(b);
        System.out.println(d);

        System.out.println(Math.round(b));
    }
}
