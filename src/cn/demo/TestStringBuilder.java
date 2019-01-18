package cn.demo;

public class TestStringBuilder
{
    public static void main(String[] args)
    {
        TestStringBuilder.test1();
    }

    public static void test1()
    {
        StringBuilder sb = new StringBuilder("hello");
        StringBuilder r1 = sb.append(true);
        System.out.println(r1); // hellotrue

        char[] chars = new char[]{'w', 'o', 'r', 'l', 'd'};
        System.out.println(sb.append(chars));

        char[] chars1 = new char[]{'北', '京'};
        System.out.println(sb.append(chars1));

        System.out.println(sb.capacity());

        System.out.println(sb.charAt(14));

        System.out.println(sb.delete(5, 9));
        System.out.println(sb.deleteCharAt(10));

        System.out.println(sb.capacity());
        sb.ensureCapacity(100);
        System.out.println(sb.capacity());

        System.out.println(sb.insert(5, " "));
        System.out.println(sb.length());
        System.out.println(sb.replace(6, 11, "ht"));
        System.out.println(sb.reverse());
        System.out.println(sb.toString());
        System.out.println(sb.capacity());
        sb.trimToSize();
        System.out.println(sb.capacity());
        sb.trimToSize();
    }
}
