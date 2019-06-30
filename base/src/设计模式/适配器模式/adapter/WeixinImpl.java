package 设计模式.适配器模式.adapter;

import 设计模式.适配器模式.extension.WeiXin;
import 设计模式.适配器模式.target.User;

public class WeixinImpl implements User
{
    @Override
    public void login()
    {
        (new WeiXin()).wLogin();
    }
}
