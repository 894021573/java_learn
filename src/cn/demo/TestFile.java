package cn.demo;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TestFile
{
    public static void main(String[] args)
    {
        t6();
    }

    public static void t1()
    {
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
    }

    public static void t2()
    {
        // 构造方法
        File parentFile = new File("F:\\java\\fuxi\\img");
        File file1 = new File(parentFile, "1.txt");
        File file2 = new File("F:\\java\\fuxi\\img", "1.txt");
        File file3 = new File("F:\\java\\fuxi\\img\\1.txt");

        try
        {
            System.out.println(file3.getCanonicalPath());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void t3()
    {
        // createNewFile
        // mkdir
        // mkdirs
        // delete

        File file1 = new File("F:\\java\\fuxi\\img\\2.txt");
        try
        {
            file1.createNewFile();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        File file2 = new File("F:\\java\\fuxi\\img\\sub_img");
        file2.mkdir();

        File file3 = new File("F:\\java\\fuxi\\img\\sub_img\\a\\b\\c");
        file3.mkdirs();

        File file4 = new File("F:\\java\\fuxi\\img\\sub_img\\a\\b\\c");
        System.out.println(file4.delete()); // 不能删除非空目录

        File file5 = new File("F:\\java\\fuxi\\img\\2.txt");
        System.out.println(file5.delete());
    }

    public static void t4()
    {
        // exists
        // isAbsolute
        // isDirectory
        // isFile
        // isHidden
        File file1 = new File("F:\\java\\fuxi\\img\\sub_img");
        System.out.println(file1.exists());


        File file2 = new File("F:\\java\\fuxi\\img\\1.txt");
        System.out.println(file2.exists());

        File file3 = new File("F1:\\java\\fuxi\\img");
        System.out.println(file3.isAbsolute()); // 是否绝对路径

        File file4 = new File("F:\\java\\fuxi\\img\\1.txt");
        System.out.println(file4.isFile());
        System.out.println(file4.isDirectory());
        System.out.println(file4.isHidden());
    }

    public static void t5()
    {
        // getAbsoluteFile
        // getAbsolutePath
        // getParent
        // getParentFile
        // getName
        // getPath
        // lastModified
        // length
        // renameTo 重命名
        File file1 = new File("F:\\java\\fuxi\\img\\1.txt");
        System.out.println(file1.getAbsoluteFile()); // 返回File对象
        System.out.println(file1.getAbsolutePath()); // 返回String
        System.out.println(file1.getParentFile());
        System.out.println(file1.getParent());
        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.lastModified());
        System.out.println(file1.length());
        System.out.println(file1.renameTo(new File("F:\\java\\fuxi\\img\\2.txt")));
    }

    public static void t6()
    {
        File file1 = new File("F:\\java\\fuxi\\img22");
        System.out.println(Arrays.toString(file1.listFiles()));
        System.out.println(Arrays.toString(file1.listRoots())); // 获取计算机中的所有盘符
    }
}
