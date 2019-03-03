package cn.xmall.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

public class BaseServlet extends HttpServlet
{
    public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        System.out.println("============================");
        String methodName = req.getParameter("method");

        // POST 提交，除了method参数外，其他参数不能放在url中
        if (req.getMethod().equals("POST")) {
            Enumeration<String> names = req.getParameterNames();
            while (names.hasMoreElements()) {
                String name = names.nextElement();
                if (name.equals("method")) {
                    continue;
                }
                if (req.getQueryString().contains(name)) {
                    throw new RuntimeException("has a not expect param :" + name);
                }
            }
        }

        Method method = null;
        try {
            method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
//            System.out.println("class_name" + this.getClass().getName());
//            System.out.println("method_name" + method.getName());
        }
    }
}
