package test;

import cn.demo.TestJdbc;
import org.junit.Test;

public class JdbcTest
{
    @Test
    public void select()
    {
        TestJdbc TestJdbc = new TestJdbc();
        TestJdbc.select();
    }

    @Test
    public void update()
    {
        TestJdbc TestJdbc = new TestJdbc();
        TestJdbc.update();
    }

    @Test
    public void delete()
    {
        TestJdbc TestJdbc = new TestJdbc();
        TestJdbc.delete();
    }

    @Test
    public void transaction()
    {
        TestJdbc TestJdbc = new TestJdbc();
        TestJdbc.transaction();
    }
}
