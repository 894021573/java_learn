package cn.demo.thread;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestThread01
{
    Object object = new Object();

    public static void main(String[] args)
    {
//        TestThread01 testThread01 = new TestThread01();
//        Thread thread1 = testThread01.new MyThread("a");
//        Thread thread2 = testThread01.new MyThread("b");
//        Thread thread3 = testThread01.new MyThread("c");
//        thread1.start();
//        thread3.start();
//        try {
//            thread3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread2.start();
//        try {
//            thread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName() + "end");

        TestThread01 testThread01 = new TestThread01();
        Thread thread1 = testThread01.new MyThread("a");
//        thread1.setDaemon(true);
        thread1.start();

        System.out.println("end");
    }

    class MyThread extends Thread
    {
        public MyThread(String name)
        {
            super(name);
        }

        @Override
        public void run()
        {
            //synchronized (object) {
            try {
                OutputStream outputStream = new FileOutputStream("F:\\java_learn\\base_demo\\a.txt", true);
                for (int i = 0; i < 20; i++) {
                    outputStream.write(String.valueOf(i).getBytes());
                    outputStream.flush();
                    //System.out.println(Thread.currentThread().getName() + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //}
        }
    }
}


