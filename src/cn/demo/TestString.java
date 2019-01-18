package cn.demo;

import java.util.Arrays;
import java.util.Base64;

public class TestString
{
    public static void main(String[] args)
    {
        // 字符串API
        System.out.println(123);
    }

    public static void test4()
    {
        String s = "hello";
        System.out.println(s.indexOf('e'));
        System.out.println(s.indexOf("ll"));
        System.out.println(s.isEmpty());

        // 合并
        String[] chars = new String[]{"a", "b", "c"};
        String js = String.join("-", chars);
        System.out.println(js);

        // 匹配
        String ss = "1234567";
        Boolean b = ss.matches("\\d+");
        System.out.println(b);

        // 替换
        String a = "hello99world99";
        System.out.println(a.replace("l", "w"));
        System.out.println(a.replace("ll", "ww"));
        System.out.println(a.replaceAll("\\d+", "x"));
        System.out.println(a.replaceFirst("\\d+", "x"));

        // 分割
        String s1 = "aa|bb|cc";
        String[] sArr = s1.split("\\|", 2);
        System.out.println(Arrays.toString(sArr));

        String s2 = "hello";
        System.out.println(s2.startsWith("h"));
        System.out.println(Arrays.toString(s2.toCharArray()));
        System.out.println(s2.substring(2, 4));

        System.out.println(String.valueOf(true));
    }

    public static void test3()
    {
        String s = "llo";
        char[] chars = {'h', 'e', ' ', ' ', ' ', ' ', 'w', 'o', 'r', 'l', 'd'};
        // 将当前字符串从start到end-1位置上的字符复制到字符数组chars中，并从chars的offset处开始存放
        s.getChars(0, s.length(), chars, 2);

        String ss = new String(chars);
        System.out.println(ss);
    }

    // 字符串比较
    public static void test2()
    {
        String a = "hello";
        String b = "hello";
        System.out.println(a.equals(b));

        StringBuilder c = new StringBuilder("hello");
        System.out.println(a.equals(c)); // false 比较内容和类型
        System.out.println(a.contentEquals(c)); // true
        // 比较String类型与String,StringBuilder, StringBuffer, CharBuffer
    }

    public static void test1()
    {
//        String s = "hello world";
//        String s = "北京欢迎你";
        String s = "??北京++";
        char c = s.charAt(1);
        System.out.println(c);

        String a = "hello";
        String b = "Hello";
        System.out.println(a.compareToIgnoreCase(b));

        String h = "hello";
        String w = "world";
        System.out.println(h.concat(w));

        String big = "hello world";
        String small = "wo";
        System.out.println(big.contains(small));

        String fs = "hi %s";
        System.out.println(String.format(fs, "大本"));
    }

    // 初始化
    public static void testInit()
    {
        // byte数组和string对象转化
//        String s = "hello world";
        String s = "南京了";
        byte[] bytes = s.getBytes();
        String ss = new String(bytes);
        System.out.println(ss);

        String h = "北京欢迎你";
        byte[] bytes1 = h.getBytes();
//        System.out.println(bytes1.length);
        String hs = new String(bytes1, 0, 9);
        System.out.println(hs);

//        char[] chars = new char[]{'a','b','c'};
        char[] chars = {'a', 'b', 'c'};
//        String js = new String(chars);
        String js = new String(chars, 0, 2);
        System.out.println(js);

        // byte 和 char 区别
    }

    // base64编码
    public static void testBase64()
    {
        String s = "南京了";
        byte[] bytes = s.getBytes();

        // base64位转化
        String base64 = Base64.getEncoder().encodeToString(bytes);
        System.out.println(base64);
        byte[] decode = Base64.getDecoder().decode(base64);
        System.out.println(new String(decode));
    }
}
