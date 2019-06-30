package 异常处理;

// 总结：finally 块中不要 做业务上的 return 和throw，只释放资源
public class Demo2
{
    public static void main(String[] args)
    {
        int a = a();
        System.out.println(a);

        try {
            b();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int a()
    {
        int i = 1;
        try {
            if (i == 0) {
                return i;
            }
            throw new Exception("a error");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("a finally"); // 不管return在哪，都是先执行此处，再return出去
            //return 888; // 此处return，则函数体会结束，且代替上面的return值
        }
        return 999;
    }

    public static void b() throws Exception
    {
        try {
            throw new Exception("b error");
        } catch (Exception e) {
            System.out.println("===" + e.getMessage());
        } finally {
            throw new Exception("b finally error"); // finally会代替上面的异常被抛出
        }
    }
}
