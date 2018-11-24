public class DemoBlock
{
    public static void main(String[] args)
    {
        int n = 1;
        {
            int m = 2; // m 只在块作用域中有效
            System.out.println(m);
        }
        System.out.println(n);
    }
}
