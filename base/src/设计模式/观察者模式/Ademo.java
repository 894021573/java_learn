package 设计模式.观察者模式;

import 设计模式.观察者模式.observer.UserLoginObserverImpl;
import 设计模式.观察者模式.observer.UserRegisterObserverImpl;
import 设计模式.观察者模式.subject.UserSubjectImpl;

public class Ademo
{
    public static void main(String[] args)
    {
        // 主题
        UserSubjectImpl userSubject = new UserSubjectImpl();

        // 注册观察者
        UserLoginObserverImpl userLoginObserver = new UserLoginObserverImpl(userSubject);
        UserRegisterObserverImpl userRegisterObserver = new UserRegisterObserverImpl(userSubject);

        // 主题数据变化
        userSubject.setId(1);
        userSubject.setName("ht");
        userSubject.setScore(100);

        // 通知观察者
        userSubject.noticeObserver();
    }
}
