package cn.demo;

import java.io.*;

public class TestFileReadAndWriter
{
    public static void main(String[] args)
    {
        try
        {
            File file = new File(".");
            FileReader fr = new FileReader(file.getCanonicalPath() + "\\sg.txt");
            FileWriter fw = new FileWriter(file.getCanonicalPath() + "\\sg_bck.txt");
//            FileWriter fw = new FileWriter(file.getCanonicalPath() + "\\sg_bck.txt",true); // 追加

//            t1(fr);
//            t2(fr);
//            t3(fr);
//            t4(fr);

//            w2(fr, fw);
            w3(fr, fw);

            fr.close();
            fw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // 读取方式1
    public static void t1(FileReader fr) throws IOException
    {
        int ch;
        while ((ch = fr.read()) != -1)
        {
            System.out.print((char) ch);
        }
    }

    // 读取方式2
    public static void t2(FileReader fr) throws IOException
    {
        char[] chars = new char[1024];
        int len;
        while ((len = fr.read(chars)) != -1)
        {
            System.out.print(new String(chars, 0, len));
//            System.out.print(new String(chars)); // 会输出空白字符
        }
    }

    // 读取方式3
    public static void t3(FileReader fr) throws IOException
    {
        char[] chars = new char[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = fr.read(chars)) != -1)
        {
            sb.append(chars);
        }

        System.out.println(sb.toString().trim());
    }

    // 读取方式4
    public static void t4(FileReader fr) throws IOException
    {
        BufferedReader bd = new BufferedReader(fr);
        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = bd.readLine()) != null)
        {
            sb.append(line);
            sb.append("\r\n"); // 不加换行符，无法读取文本中的空白字符
        }
        System.out.println(sb);
        bd.close();
    }

    // 写入1
    public static void w1(FileReader fr, FileWriter fw) throws IOException
    {
        int ch;
        while ((ch = fr.read()) != -1)
        {
            fw.write(ch);
            fw.flush();
        }
    }

    // 写入2
    public static void w2(FileReader fr, FileWriter fw) throws IOException
    {
        char[] chars = new char[1024];
        int len;
        while ((len = fr.read(chars)) != -1)
        {
            fw.write(chars, 0, len);
//            fw.write(chars); // 会输出空白字符
            fw.flush();
        }
    }

    // 写入3
    public static void w3(FileReader fr, FileWriter fw) throws IOException
    {
        BufferedReader bd = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);

        String line;
        while ((line = bd.readLine()) != null)
        {
            bw.write(line);
            bw.write("\r\n");
            bw.flush();
        }
    }
}
