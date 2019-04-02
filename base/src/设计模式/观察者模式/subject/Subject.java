package 设计模式.观察者模式.subject;

import 设计模式.观察者模式.observer.Observer;

public interface Subject
{
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void noticeObserver();
}
