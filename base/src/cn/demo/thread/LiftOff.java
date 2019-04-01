package cn.demo.thread;

public class LiftOff implements Runnable
{
    protected int countDown = 5;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff()
    {

    }
    public String status()
    {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "),";
    }

    public void run()
    {
        while (countDown-- > 0)
        {
            System.out.println(status());
            Thread.yield();
        }
    }

    public static void main(String[] args)
    {
        for (int i=0;i<3;i++)
        {
            LiftOff liftOff = new LiftOff();
            new Thread(liftOff).start();
        }
    }
}
