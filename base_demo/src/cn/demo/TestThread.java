package cn.demo;

class RunnableDemo implements Runnable
{
    private int num = 7;

    @Override
    public void run()
    {
        while (true) {
            if (num <= 0) {
                num = 10;
                continue;
            }
            synchronized (this) {
                try {
                    System.out.println(Thread.currentThread().getName() + "get---" + num);
                    num = num - 1;
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

//        System.out.println(Thread.currentThread().getName() + "exit");
    }
}

public class TestThread
{
    public static void main(String args[])
    {
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread r1 = new Thread(runnableDemo, "a");
        Thread r2 = new Thread(runnableDemo, "b");

        r1.start();
        r2.start();
    }
}