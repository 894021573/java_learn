package 异常处理;

public class Demo
{
    public static void main(String[] args)
    {
//        a(); // 异常没有捕获，程序报错，终止
//        b(); // 异常在方法体内捕获，方法体内代码继续执行，方法体外代码也继续执行

        try {
            c(); // 异常在方法体内没有捕获，则向上抛出（方法体内的代码不再继续执行），被捕获后，方法体外的代码继续执行；方法体内的代码
        } catch (ArithmeticException e) {
            System.out.println("c error");
        }

        System.out.println("main end");
    }

    public static void a()
    {
        int i = 1 / 0;
        System.out.println("a error");
    }

    public static void b()
    {
        try {
            int i = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("b error");
        }
        System.out.println("b end");
    }

    public static void c()
    {
        int i = 1 / 0;
        System.out.println("c end");
    }
}
