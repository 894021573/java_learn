package 设计模式.适配器模式;

import 设计模式.适配器模式.adapter.QQImpl;
import 设计模式.适配器模式.adapter.WeixinImpl;
import 设计模式.适配器模式.target.User;

// 第三方的qq登录和微信登录的方法名不同（第三方代码不会随便修改），但是我们希望在系统中用同样的方法名去调用
public class Demo
{
    public static void main(String[] args)
    {
        User qq = new QQImpl();
        qq.login();

        User weixin = new WeixinImpl();
        weixin.login();
    }
}
