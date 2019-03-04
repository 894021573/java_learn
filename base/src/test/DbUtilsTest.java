package test;


import cn.demo.TestDbUtils;
import org.junit.Test;

public class DbUtilsTest
{
    @Test
    public void selectArray()
    {
        TestDbUtils TestDbUtils = new TestDbUtils();
        TestDbUtils.selectArray();
    }

    @Test
    public void selectArrayList()
    {
        TestDbUtils TestDbUtils = new TestDbUtils();
        TestDbUtils.selectArrayList();
    }

    @Test
    public void selectBean()
    {
        TestDbUtils TestDbUtils = new TestDbUtils();
        TestDbUtils.selectBean();
    }

    @Test
    public void selectBeanList()
    {
        TestDbUtils TestDbUtils = new TestDbUtils();
        TestDbUtils.selectBeanList();
    }

    @Test
    public void selectColumnList()
    {
        TestDbUtils TestDbUtils = new TestDbUtils();
        TestDbUtils.selectColumnList();
    }

    @Test
    public void selectScalarHandler()
    {
        TestDbUtils TestDbUtils = new TestDbUtils();
        TestDbUtils.selectScalarHandler();
    }
}
