import java.util.Scanner;

public class DemoInOut
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("what is your name?");
        String name = in.nextLine();

        System.out.println("how old are you?");
        int age = in.nextInt();

        System.out.println("how old are say?");
        while (!in.hasNext(":q")) // hasNext 默认会阻塞，需要设置结束符
        {
            System.out.println(in.next());
        }
    }
}
