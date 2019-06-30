package GC清理;

// finalize流程：当对象变成(GC Roots)不可达时，
// GC会判断该对象是否覆盖了finalize方法，若未覆盖，则直接将其回收。
// 否则，若对象未执行过finalize方法，将其放入F-Queue队列，由一低优先级线程执行该队列中对象的finalize方法。
// 执行finalize方法完毕后，GC会再次判断该对象是否可达，若不可达，则进行回收，否则，对象“复活”
// https://www.cnblogs.com/langtianya/p/4401062.html
public class Demo
{
    public static void main(String[] args)
    {
        A a = new A(); // 之后的System.gc()不会调用finalize

        new A(); // 之后的System.gc()会调用finalize
        new A(); // 之后的System.gc()会调用finalize

        System.gc();

        System.out.println("main end");
    }
}

class A
{
    protected void finalize()
    {
        System.out.println("error: checkout out");
    }
}
