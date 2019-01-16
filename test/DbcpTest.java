package test;

import cn.demo.TestDbcp;
import org.junit.Test;

public class DbcpTest
{
//    @Test
//    public void usePool()
//    {
//        TestDbpc testDbpc = new TestDbpc();
//        testDbpc.usePool();
//    }

    @Test
    public void usePool2()
    {
        TestDbcp testDbcp = new TestDbcp();
        testDbcp.usePool2();
    }

    @Test
    public void notUsePool()
    {
        TestDbcp testDbcp = new TestDbcp();
        testDbcp.notUsePool();
    }
}
