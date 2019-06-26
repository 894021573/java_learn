package blog.controller;

import util.MD5Util;

public class Test
{
    public static void main(String[] args)
    {
        String s = MD5Util.getMD5("123456");
        System.out.println(s);
    }
}
