package cn.demo.exception;

/**
 * finally 块中不要 做业务上的 return 和throw，只释放资源
 */
public class Finally
{
    public static void main(String[] args)
    {
        int i = fo();
        System.out.println(i);

        int j = go();
        System.out.println(j);

        try {
            ho();
        } catch (ArithmeticException ae) {
            System.out.println(ae.getMessage());
        }


        System.out.println("main end");
    }

    public static int fo()
    {
        try {
            return 1;
        } finally {
            System.out.println("fo finally"); // 先执行，再return
        }
    }

    public static int go()
    {
        try {
            return 2;
        } finally {
            return 3; // finally中的return会代替上面的return
            // System.out.println("go finally"); // return 后不能再输出
        }
    }

    public static int ho()
    {
        try {
            int a = 1 / 0;
        } catch (ArithmeticException ae) {
            throw new ArithmeticException("ho error");
        } finally {
            throw new ArithmeticException("finally error"); // finally中的异常会代替上面的异常
        }
    }
}
