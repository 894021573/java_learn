package 设计模式.适配器模式.adapter;

import 设计模式.适配器模式.extension.QQ;
import 设计模式.适配器模式.target.User;

public class QQImpl implements User
{
    @Override
    public void login()
    {
        (new QQ()).qLogin();
    }
}
