package cn.demo.thread;

public class Thread02
{
    private static boolean ready;
    private static int number;

    private static class ReadThread extends Thread
    {
        public void run()
        {
            try
            {
                Thread.sleep(10000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            while (!ready)
            {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args)
    {
        new ReadThread().start();
        ready = true;
        number = 50;
    }
}
