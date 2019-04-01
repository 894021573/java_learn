package cn.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheThreadPool
{
    public static void main(String[] args)
    {
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newSingleThreadExecutor(); // 串行
        for (int i=0;i<2;i++)
        {
            executorService.execute(new LiftOff());
        }
        // shutdown 防止新任务被提交
        executorService.shutdown();

        // 在shutdown之后运行 会报错
//        for (int i=0;i<2;i++)
//        {
//            executorService.execute(new LiftOff());
//        }
    }
}
