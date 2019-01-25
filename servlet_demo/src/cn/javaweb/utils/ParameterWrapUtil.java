package cn.javaweb.utils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import java.io.UnsupportedEncodingException;

public class ParameterWrapUtil extends ServletRequestWrapper
{
    public ParameterWrapUtil(ServletRequest request)
    {
        super(request);
    }

    // 处理中文乱码
    @Override
    public String getParameter(String name)
    {
        String oldSrting = super.getParameter(name);
        String newString = null;

        try {
            newString = new String(oldSrting.getBytes("iso8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return newString;
    }
}
