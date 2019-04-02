package 设计模式.观察者模式.observer;

import 设计模式.观察者模式.subject.Subject;

import java.util.Map;

public class UserRegisterObserverImpl implements Observer
{
    public UserRegisterObserverImpl(Subject subject)
    {
        subject.registerObserver(this);
    }

    @Override
    public void update(Map<String, Object> map)
    {
        System.out.println("用户注册：" + map.get("id") + map.get("name") + map.get("score"));
    }
}
