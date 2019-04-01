package cn.demo.thread;

import java.util.ArrayList;
import java.util.concurrent.*;

class TaskWithResult implements Callable<String>
{
    private int id;

    public TaskWithResult(int id)
    {
        this.id = id;
    }

    public String call()
    {
        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return "result of TaskWithResult" + id;
    }
}

public class CallableDemo
{
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        ExecutorService executorService = Executors.newCachedThreadPool();


        Future<String> future = executorService.submit(new TaskWithResult(1));
        Thread.sleep(4000);

        if (future.isDone())
        {
            System.out.println(future.get());
        }
        executorService.shutdown();

        System.out.println("main");
    }
}
