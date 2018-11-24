public class DemoStringBuilder
{
    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder("hello world");

        System.out.println(sb.length());
        System.out.println(sb.append(" china"));
        System.out.println(sb.append('c'));

        sb.setCharAt(4, 'i');
        System.out.println(sb);

        System.out.println(sb.insert(4, " xxx "));
        System.out.println(sb.delete(4, 7));
    }
}
