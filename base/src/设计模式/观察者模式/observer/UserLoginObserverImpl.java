package 设计模式.观察者模式.observer;

import 设计模式.观察者模式.subject.Subject;
import 设计模式.观察者模式.subject.UserSubjectImpl;

import java.util.Map;

public class UserLoginObserverImpl implements Observer
{
    public UserLoginObserverImpl(Subject subject)
    {
        subject.registerObserver(this);
    }

    @Override
    public void update(Subject userSubject)
    {
        UserSubjectImpl userSubjectImpl = (UserSubjectImpl)userSubject;
        System.out.println("用户登录：" + userSubjectImpl.getId() + userSubjectImpl.getName() + userSubjectImpl.getScore());
    }
}
