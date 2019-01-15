package cn.demo;

import java.io.*;

public class TestIO
{
    public static void main(String[] args)
    {
        t10();

        // 标准输入流 打印流 转换流
        // 对象操作流
        // Properties
    }

    public static void t1()
    {
        // 字符流复制文本/图片
        try
        {
//            FileReader fileReader = new FileReader("F:\\java\\fuxi\\sg.txt");
//            FileWriter fileWriter = new FileWriter("F:\\java\\fuxi\\sg_bck2.txt");

            FileReader fileReader = new FileReader("F:\\java\\fuxi\\1.jpg");
            FileWriter fileWriter = new FileWriter("F:\\java\\fuxi\\2.jpg");

            char[] chars = new char[1024];
            int len = 0;
            while ((len = fileReader.read(chars, 0, chars.length)) != -1)
            {
                fileWriter.write(chars, 0, len);
                fileWriter.flush();
            }
            fileReader.close();
            fileWriter.close();


        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void t2()
    {
        // 字节流复制文本/图片
        try
        {
//            FileInputStream fileInputStream = new FileInputStream("F:\\java\\fuxi\\sg.txt");
//            FileOutputStream fileOutputStream = new FileOutputStream("F:\\java\\fuxi\\sg_bck2.txt");

            FileInputStream fileInputStream = new FileInputStream("F:\\java\\fuxi\\1.jpg");
            FileOutputStream fileOutputStream = new FileOutputStream("F:\\java\\fuxi\\2.jpg");

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes, 0, bytes.length)) != -1)
            {
                fileOutputStream.write(bytes, 0, len);
                fileOutputStream.flush();
            }

            fileInputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void t3()
    {
        File file = new File("sg.txt");
        InputStream inputStream = null;

        File file2 = new File("sg_bck3.txt");
        OutputStream outputStream = null;
        try
        {
            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream(file2);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        int len = 0;
        try
        {
            while ((len = bufferedReader.read()) != -1)
            {
                bufferedWriter.write(len);
                bufferedWriter.flush();
            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void t4()
    {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("sg.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
            int len = 0;
            while ((len = bufferedReader.read()) != -1)
            {
                bufferedWriter.write(len);
                bufferedWriter.flush();
            }


            bufferedReader.close();
            bufferedWriter.close();

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void t5()
    {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("sg.txt"));
            Writer writer = new OutputStreamWriter(System.out);
            int len = 0;
            while ((len = bufferedReader.read()) != -1)
            {
                writer.write(len);
                writer.flush();
            }


            bufferedReader.close();
            writer.close();

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void t6()
    {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("sg.txt"));
            OutputStream outputStream = System.out;
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                outputStream.write(line.getBytes());
                outputStream.write("\r\n".getBytes());
                outputStream.flush();
            }


            bufferedReader.close();
            outputStream.close();

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void t7()
    {
        // 字节流转换为字符流输出
        InputStream inputStream = System.in;
        try
        {
            OutputStream outputStream = new FileOutputStream("my.txt");

            int len = 0;
            while ((len = inputStream.read()) != -1)
            {
                outputStream.write(len);
                outputStream.flush();
            }

            inputStream.close();
            outputStream.close();

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void t8()
    {
        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);

        try
        {
            FileWriter fileWriter = new FileWriter("my2.txt");

            char[] chars = new char[1024];
            int len = 0;
            while ((len = reader.read(chars)) != -1)
            {
                fileWriter.write(chars, 0, len);
                fileWriter.flush();
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void t9()
    {
        try
        {
            PrintWriter printWriter = new PrintWriter("my3.txt");
            printWriter.write("hello");
            printWriter.write("你好吗");
            printWriter.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void t10()
    {
        try
        {
            PrintWriter printWriter = new PrintWriter(new File("my4.txt"));
            printWriter.println("hello");
            printWriter.println("你好吗");
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}