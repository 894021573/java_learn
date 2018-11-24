public class DemoString
{
    public static void main(String[] args)
    {
        // 字符串操作

        String greeting = "hello";
        String s = greeting.substring(0, 3);
        System.out.println(s);

        boolean b = "hello".equals(greeting);
        boolean b1 = "hello" == greeting;
        boolean b2 = "hel" == s;
        int b3 = "hel".compareTo(s);

        System.out.println(b); // true
        System.out.println(b1); // true
        System.out.println(b2); // false
        System.out.println(b3); // 0

        String str = null;
        if (str == null || str.length() == 0)
        {
            System.out.println("str is empty");
        }

        String hel = "hello world";
        System.out.println(hel.charAt(4));
        System.out.println(hel.indexOf("o", 8)); // 从第8个位置开始寻找第一个o出现的位置
        System.out.println(hel.lastIndexOf("w", 5)); // 从倒数第五个开始，往后匹配，最后一个w出现的位置

        String oldStr = "old china";
        System.out.println(oldStr.replace("old", "new"));

        String lowerStr = "LOWER".toLowerCase();
        System.out.println(lowerStr);
        System.out.println("upper".toUpperCase());
        System.out.println("   trim   1".trim());
    }
}
