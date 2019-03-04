package test;

import cn.demo.TestC3P0;
import org.junit.Test;

public class C3p0Test
{
    @Test
    public void usePool()
    {
        TestC3P0 testC3P0 = new TestC3P0();
        testC3P0.usePool();
    }
}
