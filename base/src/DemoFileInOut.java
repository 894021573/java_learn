import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class DemoFileInOut
{
    public static void main(String[] args) throws IOException
    {
        System.out.println(System.getProperty("user.dir"));

        // 读取文件
        Scanner s = new Scanner(Paths.get("./test/files/1.txt"));
        while (s.hasNextLine())
        {
            System.out.println(s.nextLine());
        }

        // 输出到文件
        PrintWriter out = new PrintWriter("./test/files/2.txt");
        String ss = "hello world";
        char[] c = ss.toCharArray();
        out.print(c);
        out.flush(); // 数据少，需要等缓存区慢才会输出。使用flush强制输出
    }
}
