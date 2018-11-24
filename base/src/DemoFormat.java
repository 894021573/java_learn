import java.util.Date;

public class DemoFormat
{
    public static void main(String[] args)
    {
        double d = 1.234567;
        System.out.printf("%4.3f is double", d);

        String m = String.format("%4.3f is double", d);
        System.out.println(m);

        String m2 = String.format("time is %s", new Date());
        System.out.println(m2);
    }
}
