package cn.demo.exception;

/**
 * 异常处理流程
 * 方法体内处理了的异常，不需要再用throws抛出
 * Throwable
 *      --- Error JVM的错误
 *      --- Exception 不期望发生的事件
 */
public class Exception
{
    public static void main(String[] args)
    {
        try {
            fo();
        } catch (ArithmeticException ae) {
            System.out.println("ArithmeticException"); // 处理了异常
        }
        bo();

        System.out.println("main end"); // 执行
    }

    public static void fo()
    {
        int a = 1 / 0; // 出现了异常，但没有处理，就调到上层的异常处理
        System.out.println("fo end"); // 此处不再执行
    }

    public static void bo()
    {
        try {
            int a = 1 / 0;
        } catch (ArithmeticException ae) {
            System.out.println("ArithmeticException in bo"); // 处理了异常
        }

        System.out.println("bo end"); // 处理完后，此处继续执行
    }
}
