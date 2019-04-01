package cn.demo.thread;

public class Racer implements Runnable
{
    private String winner;

    @Override
    public void run()
    {
        for (int i = 1; i <= 100; i++)
        {
            if (Thread.currentThread().getName() == "rabbit" && i % 10 == 0)
            {
                try
                {
                    Thread.sleep(30);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            if (Thread.currentThread().getName() == "tortoise" && i % 10 == 0)
            {
                try
                {
                    Thread.sleep(10);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "=" + i + "步");

            boolean flag = false;

            if (winner != null)
            {
                flag = true;
            } else
            {
                if (i == 100)
                {
                    winner = Thread.currentThread().getName();
                    flag = true;
                }
            }

            if (flag)
            {
                break;
            }

        }
    }

    public static void main(String[] args)
    {
        Racer racer = new Racer();
        new Thread(racer, "rabbit").start();
        new Thread(racer, "tortoise").start();
    }
}
