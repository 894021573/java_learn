package 设计模式.观察者模式.observer;

import 设计模式.观察者模式.subject.Subject;

import java.util.Map;

public interface Observer
{
    void update(Subject subject);
}
